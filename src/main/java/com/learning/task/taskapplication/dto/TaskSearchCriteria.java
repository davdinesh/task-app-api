package com.learning.task.taskapplication.dto;

import java.sql.Date;

public class TaskSearchCriteria {
	
	private String taskName;
	
	private String parentTaskName;
	
	private Date startDate;
	
	private Date endDate;
	
	private String priorityFrom;
	
	private String priorityTo;

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the parentTaskName
	 */
	public String getParentTaskName() {
		return parentTaskName;
	}

	/**
	 * @param parentTaskName the parentTaskName to set
	 */
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the priorityFrom
	 */
	public String getPriorityFrom() {
		return priorityFrom;
	}

	/**
	 * @param priorityFrom the priorityFrom to set
	 */
	public void setPriorityFrom(String priorityFrom) {
		this.priorityFrom = priorityFrom;
	}

	/**
	 * @return the priorityTo
	 */
	public String getPriorityTo() {
		return priorityTo;
	}

	/**
	 * @param priorityTo the priorityTo to set
	 */
	public void setPriorityTo(String priorityTo) {
		this.priorityTo = priorityTo;
	}
	
	

}
