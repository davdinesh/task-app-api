/**
 * 
 */
package com.learning.task.taskapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.task.taskapplication.dto.TaskSearchCriteria;
import com.learning.task.taskapplication.model.ParentTask;
import com.learning.task.taskapplication.model.Task;
import com.learning.task.taskapplication.repository.ParentTaskRepository;
import com.learning.task.taskapplication.repository.TaskRepository;

/**
 * @author viswa
 *
 */
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins="http://localhost:4200")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ParentTaskRepository parentTaskRepository;
	
	@GetMapping("/")
	public List<Task> fetchAllTasks() {
		return taskRepository.findAll();
	}
	
	@GetMapping("/parentTasks")
	public List<ParentTask> fetchAllParentTasks() {
		return parentTaskRepository.findAll();
	}
	
	@GetMapping("/{taskId}")
	public Task fetchTaskById(@PathVariable long taskId) {
		Task task = taskRepository.getOne(taskId);
		if (task == null) {
			return null;
		}
		
		return task;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		Task savedTask = taskRepository.save(task);
		return new ResponseEntity<Task>(savedTask,HttpStatus.CREATED);
	}
	
	@PostMapping("/filterCriteria")
	public ResponseEntity<List<Task>> filterByCriteria(@RequestBody TaskSearchCriteria taskSearchCriteria) {
		List<Task> tasks = taskRepository.filterByCriteria(taskSearchCriteria);
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}
	
	@PutMapping("/update/{taskId}")
	public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable long taskId) {
		
		Task existingTask = taskRepository.getOne(taskId);
		if (existingTask == null) {
			return ResponseEntity.notFound().build();
		}
		existingTask.setTask(task.getTask());
		existingTask.setParentTask(task.getParentTask());
		existingTask.setStartDate(task.getStartDate());
		existingTask.setEndDate(task.getEndDate());
		existingTask.setPriority(task.getPriority());
		Task savedTask = taskRepository.save(existingTask);
		
		return new ResponseEntity<Task>(savedTask,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{taskId}")
	public void deleteTask(@PathVariable long taskId) {
		taskRepository.deleteById(taskId);
	}
	
}
