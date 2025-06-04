package com.est.curdsample.dto

import com.est.curdsample.domain.Task
import com.est.curdsample.util.convertToStr
import com.est.curdsample.util.priorityResolve

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
        get() = priorityResolve(priority)

    companion object {
        @JvmStatic
        fun from(task: Task): TaskDescription {
            return TaskDescription(
                task.code,
                task.title,
                task.description,
                task.priority,
                task.completeStatus,
                convertToStr(task.startTime),
                convertToStr(task.endTime),
                convertToStr(task.createdAt),
                convertToStr(task.updatedAt)
            )
        }
    }
}
