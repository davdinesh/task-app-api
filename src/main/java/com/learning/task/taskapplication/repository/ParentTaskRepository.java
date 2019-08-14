/**
 * 
 */
package com.learning.task.taskapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.task.taskapplication.model.ParentTask;

/**
 * @author viswa
 *
 */
@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {

}
