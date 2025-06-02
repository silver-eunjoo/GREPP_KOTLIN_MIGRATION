package com.grepp.curdsample.dao;

import com.grepp.curdsample.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
