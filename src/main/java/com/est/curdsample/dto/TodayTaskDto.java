package com.est.curdsample.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodayTaskDto {

    List<TaskDto> uncompletedTasks = new ArrayList<>();
    List<TaskDto> completedTasks = new ArrayList<>();

    public static TodayTaskDto from(List<TaskDto> tasks) {
        Map<Boolean, List<TaskDto>> result = tasks.stream()
                .collect(
                        Collectors.partitioningBy(TaskDto::getCompleteStatus)
                );
        return new TodayTaskDto(
                result.get(false),
                result.get(true)
        );
    }

}