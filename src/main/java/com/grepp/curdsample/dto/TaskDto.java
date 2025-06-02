package com.grepp.curdsample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
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

}
