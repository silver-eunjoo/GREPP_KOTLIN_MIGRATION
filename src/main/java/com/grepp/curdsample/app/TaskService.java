package com.grepp.curdsample.app;

import com.grepp.curdsample.dao.TaskRepository;
import com.grepp.curdsample.domain.Task;
import com.grepp.curdsample.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public TaskDto saveTask(TaskDto taskDto) {
        taskDto.setCode(genCode());
        Task task = Task.of(taskDto);
        taskRepository.save(task);
        return taskDto;
    }

    private Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    private Task findByCode(String code) {
        return taskRepository.findByCode(code).orElse(null);
    }

    private String genCode() {
        return UUID.randomUUID().toString();
    }

    /**
     * 할일의 코드를 이용해서 {@link TaskDto}를 반환하는 메서드입니다.
     *
     * @param code 할일을 식별하기 위한 코드
     * @return {@link TaskDto}
     */
    public TaskDto getByCode(String code) {
        Task findTask = findByCode(code);
        return TaskDto.from(findTask);
    }

    @Transactional
    public String removeByCode(String code) {

        Task findTask = findByCode(code);
        taskRepository.delete(findTask);

        return code;
    }

    @Transactional
    public TaskDto update(TaskDto taskDto) {

        Task findTask = findByCode(taskDto.getCode());
        findTask.update(taskDto);

        return taskDto;
    }


}
