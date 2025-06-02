package com.grepp.curdsample.dto;

import com.grepp.curdsample.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private String code;

    private String title;
    private String description;

    private Integer priority;

    private boolean completeStatus;

    private LocalDate startTime;
    private LocalDate endTime;

    public static TaskDto from(Task task) {

        TaskDto taskDto = new TaskDto();

        taskDto.code = task.getCode();
        taskDto.title = task.getTitle();
        taskDto.description = task.getDescription();
        taskDto.priority = task.getPriority();
        taskDto.completeStatus = task.isCompleteStatus();
        taskDto.startTime = task.getStartTime();
        taskDto.endTime = task.getEndTime();

        return taskDto;

    }


}
