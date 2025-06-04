package com.est.crudsample.dto

data class TodayTaskDto(
    val uncompletedTasks: List<TaskDto>,
    val completedTasks: List<TaskDto>
)

//    companion object {
//        fun from(tasks: MutableList<TaskDto?>): TodayTaskDto {
//            val result = tasks.stream()
//                .collect(
//                    Collectors.partitioningBy(TaskDto::completeStatus)
//                )
//            return TodayTaskDto(
//                result[false],
//                result[true]
//            )
//        }
//    }

fun List<TaskDto>.toTodayTasks() : TodayTaskDto {
    val partition: Pair<List<TaskDto>, List<TaskDto>> = partition { it.completeStatus }
    // completeStatus가 true인 것들, false인 것들을 기준으로 나눠준다.

    val (completed, unCompleted) = partition { it.completeStatus }
    return TodayTaskDto(
        completedTasks = completed,
        uncompletedTasks = unCompleted)
}