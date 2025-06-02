package com.grepp.curdsample.app;

import com.grepp.curdsample.dao.TaskRepository;
import com.grepp.curdsample.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public TaskDto saveTask(TaskDto taskDto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
