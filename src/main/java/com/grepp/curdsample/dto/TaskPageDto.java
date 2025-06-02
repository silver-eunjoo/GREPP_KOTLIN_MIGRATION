package com.grepp.curdsample.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
//public record TaskPageDto(boolean hasNext, List<TaskDto> tasks) {
public class TaskPageDto {

    private boolean hasNext;
    private List<TaskDto> data;

}
