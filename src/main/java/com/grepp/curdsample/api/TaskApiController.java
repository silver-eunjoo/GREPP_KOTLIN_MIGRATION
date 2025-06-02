package com.grepp.curdsample.api;

import com.grepp.curdsample.app.TaskService;
import com.grepp.curdsample.dto.GeneralApiResponse;
import com.grepp.curdsample.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskApiController {

    private final TaskService taskService;

    @PatchMapping("/{code}/status")
    public GeneralApiResponse<TaskDto> updateTaskStatus(@PathVariable String code) {
        TaskDto taskDto = taskService.checkTaskByCode(code);
        return GeneralApiResponse.<TaskDto>builder()
                .data(taskDto)
                .msg("성공적으로 반영하였습니다!")
                .build();
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Void> deleteTask(@PathVariable String code) {
    public GeneralApiResponse<Void> deleteTask(@PathVariable String code) {
        taskService.removeByCode(code);
//        return ResponseEntity.noContent().build(); // 204
        return GeneralApiResponse.<Void>builder()
                .msg("성공적으로 삭제되었습니다!")
                .build();
    }


}
