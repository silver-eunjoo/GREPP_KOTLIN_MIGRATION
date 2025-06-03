package com.est.curdsample.dao;

import com.est.curdsample.domain.Task;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByCode(String code);
    @Query("select t from Task t where t.endTime = CURRENT_DATE order by t.priority desc limit 10")
    List<Task> findTenTasksDueToToday();
}
