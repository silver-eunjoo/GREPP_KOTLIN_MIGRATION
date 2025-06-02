package com.grepp.curdsample.dao;

import com.grepp.curdsample.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByCode(String code);
}
