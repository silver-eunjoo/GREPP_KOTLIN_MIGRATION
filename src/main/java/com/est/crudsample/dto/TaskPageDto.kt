package com.est.crudsample.dto

data class TaskPageDto(
    val hasNext: Boolean,
    val data: List<TaskDto>,
)


//@Data
//@Builder
//public class TaskPageDto {
//
//    private boolean hasNext;
//    private List<TaskDto> data;
//
//}

