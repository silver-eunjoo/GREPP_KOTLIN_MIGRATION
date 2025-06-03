package com.est.curdsample.api

import com.est.curdsample.app.TaskService
import com.est.curdsample.dto.GeneralApiResponse
import com.est.curdsample.dto.TaskDto
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
class TaskApiController {
    private val taskService: TaskService? = null

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{code}/status")
    fun updateTaskStatus(@PathVariable code: String): GeneralApiResponse<TaskDto> {
        val taskDto = taskService!!.checkTaskByCode(code)
        return GeneralApiResponse.< TaskDto > builder < TaskDto ? > ()
            .data(taskDto)
            .msg("성공적으로 반영하였습니다!")
            .build()
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //    public ResponseEntity<Void> deleteTask(@PathVariable String code) {
    fun deleteTask(@PathVariable code: String): GeneralApiResponse<Void> {
        taskService!!.removeByCode(code)
        //        return ResponseEntity.noContent().build();
        return GeneralApiResponse.< Void > builder < java . lang . Void ? > ()
            .msg("성공적으로 삭제했습니다!")
            .build()
    }
}