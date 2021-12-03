package com.doc.manage.repository;

import com.doc.manage.model.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    Optional<Task> findByExecutor(Integer executor);

}
