package com.est.crudsample

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class TaskDescription(
    val code: String,
    val title: String,
    val description: String,
    val priority: Int,
    val completeStatus: Boolean,
    val startDate: String,
    val dueDate: String,
    val createdAt: String,
    val updatedAt: String,
    val priorityLevel : String
)

data class TaskDto(
    var code: String = "",

    @field: NotBlank(message = "작업 이름은 반드시 입력되어야 합니다")
    val title: String = "",

    val description: String = "",

    @field: Min(value = 0)
    val priority: Int = 0,
    val priorityLevel: String = "",

    val completeStatus: Boolean = false,

    @field: Pattern(
        regexp = "^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$",
        message = "올바른 날짜를 입력하여 주시기 바랍니다."
    )
    @field: NotBlank(message = "날짜는 반드시 들어있어야 합니다")
    val startTime: String = "",

    @field: Pattern(
        regexp = "^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$",
        message = "올바른 날짜를 입력하여 주시기 바랍니다."
    )
    @field: NotBlank(message = "날짜는 반드시 들어있어야 합니다")
    val endTime: String = ""

)

data class TaskPageDto(
    val hasNext: Boolean,
    val data: List<TaskDto>,
)

data class TodayTaskDto(
    val uncompletedTasks: List<TaskDto>,
    val completedTasks: List<TaskDto>
)


fun List<TaskDto>.toTodayTasks() : TodayTaskDto {
//    val partition: Pair<List<TaskDto>, List<TaskDto>> = partition { it.completeStatus }
    // completeStatus가 true인 것들, false인 것들을 기준으로 나눠준다.

    val (completed, unCompleted) = partition { it.completeStatus }
    return TodayTaskDto(
        completedTasks = completed,
        uncompletedTasks = unCompleted)
}

data class GeneralApiResponse<T>(
    val data: T? = null,
    val msg: String,
)