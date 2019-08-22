/**
 * 
 */
package com.learning.task.taskapplication.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.task.taskapplication.dto.TaskSearchCriteria;
import com.learning.task.taskapplication.model.Task;
import com.learning.task.taskapplication.repository.TaskCustomDao;

/**
 * @author viswa
 *
 */
@Repository
public class TaskCustomDaoImpl implements TaskCustomDao {
	
	@Autowired
	EntityManager em; 
	
	/* (non-Javadoc)
	 * @see com.learning.task.taskapplication.repository.TaskCustomDao#filterByCriteria(com.learning.task.taskapplication.dto.TaskSearchCriteria)
	 */
	@Override
	public List<Task> filterByCriteria(TaskSearchCriteria taskSearchCriteria) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Task> cq = cb.createQuery(Task.class);
		Root<Task> task = cq.from(Task.class);
		List<Predicate> predicates = new ArrayList<>();
		
		if (taskSearchCriteria.getTaskName() != null)
			predicates.add(cb.like(task.get("task"), "%"+taskSearchCriteria.getTaskName() + "%"));
		if (taskSearchCriteria.getParentTaskName() != null)
			predicates.add(cb.like(task.get("parentTask.name"), "%"+taskSearchCriteria.getParentTaskName()+"%"));
		if (taskSearchCriteria.getStartDate() != null)
			predicates.add(cb.greaterThanOrEqualTo(task.get("startDate"), taskSearchCriteria.getStartDate()));
		if (taskSearchCriteria.getEndDate() != null)
			predicates.add(cb.lessThanOrEqualTo(task.get("endDate"), taskSearchCriteria.getEndDate()));
		if (taskSearchCriteria.getPriorityFrom() != null && taskSearchCriteria.getPriorityTo() != null)
			predicates.add(cb.between(task.get("priority"), Integer.parseInt(taskSearchCriteria.getPriorityFrom()), Integer.parseInt(taskSearchCriteria.getPriorityTo())));
		
		cq.where(predicates.toArray(new Predicate[0]));
		
		
		return em.createQuery(cq).getResultList();
	}

}
