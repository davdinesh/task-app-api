/**
 * 
 */
package com.learning.task.taskapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.task.taskapplication.model.Task;

/**
 * @author viswa
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>,TaskCustomDao {

}
