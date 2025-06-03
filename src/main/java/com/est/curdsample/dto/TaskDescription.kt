package com.est.curdsample.dto

import com.est.curdsample.domain.Task
import com.est.curdsample.util.PriorityResolver
import com.est.curdsample.util.TimeFormatter
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

data class TaskDescription(
    val code: String,
    val title: String,
    val description: String,
    val priority: Int,
    val completeStatus: Boolean,
    val startDate: String,
    val dueDate: String,
    val createdAt: String,
    val updatedAt: String
) {

    val priorityLevel: String
        get() = PriorityResolver.resolve(priority)

    companion object {
        @JvmStatic
        fun from(task: Task): TaskDescription {
            return TaskDescription(
                task.code,
                task.title,
                task.description,
                task.priority,
                task.completeStatus,
                TimeFormatter.convertToStr(task.startTime),
                TimeFormatter.convertToStr(task.endTime),
                TimeFormatter.convertToStr(task.createdAt),
                TimeFormatter.convertToStr(task.updatedAt)
            )
        }
    }
}
