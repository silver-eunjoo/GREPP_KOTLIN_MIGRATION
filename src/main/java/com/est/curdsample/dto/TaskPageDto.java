package com.est.curdsample.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

public record TaskPageDto(boolean hasNext, List<TaskDto> data) {
}

//@Data
//@Builder
//public class TaskPageDto {
//
//    private boolean hasNext;
//    private List<TaskDto> data;
//
//}