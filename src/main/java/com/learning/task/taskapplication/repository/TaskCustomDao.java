/**
 * 
 */
package com.learning.task.taskapplication.repository;

import java.util.List;

import com.learning.task.taskapplication.dto.TaskSearchCriteria;
import com.learning.task.taskapplication.model.Task;

/**
 * @author viswa
 *
 */
public interface TaskCustomDao {
	
	public List<Task> filterByCriteria(TaskSearchCriteria taskSearchCriteria);

}
