package com.est.crudsample

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
class TaskApiController(
    private val taskService: TaskService
) {

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{code}/status")
    fun updateTaskStatus(@PathVariable code: String): GeneralApiResponse<TaskDto> {
        val taskDto = taskService.checkTaskByCode(code)
        return GeneralApiResponse(
            data = taskDto,
            msg = "성공적으로 반영되었습니다!"
        )
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTask(@PathVariable code: String): GeneralApiResponse<Void> {
        taskService.removeByCode(code)
        return GeneralApiResponse(
            data = null,
            msg = "성공적으로 삭제했습니다!"
        )
    }
}