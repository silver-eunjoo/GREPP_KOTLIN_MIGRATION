package com.est.curdsample.view

import com.est.curdsample.app.TaskService
import com.est.curdsample.dto.TaskDto
import com.est.curdsample.dto.TodayTaskDto
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Slf4j
@Controller
@RequiredArgsConstructor
class TaskViewController {
    private val taskService: TaskService? = null

    @GetMapping("/")
    fun showIndex(model: Model): String {
        val result: List<TaskDto?> = taskService!!.tasksDueToToday
        model.addAttribute("tasks", TodayTaskDto.from(result))
        return "index"
    }

    @GetMapping("/tasks")
    fun showList(model: Model, pageable: Pageable): String {
        val tasks = taskService!!.getTaskList(pageable.pageNumber)
        model.addAttribute("tasks", tasks)
        return "tasks/list"
    }

    @GetMapping("/tasks/more") //
    fun loadMoreTasks(page: Int, model: Model): String {
        val taskList = taskService!!.getTaskList(page)
        model.addAttribute("tasks", taskList)
        return "fragments/page_parts :: taskPagePart"
    }

    @GetMapping("/tasks/append")
    fun showAddPage(model: Model?): String {
//        model.addAttribute("taskDto", new TaskDto());
        return "tasks/add"
    }

    @PostMapping("/tasks/append")
    fun addTask(req: @Valid TaskDto, bindingResult: BindingResult, model: Model): String {
        // BindingResult는 @Valid 다음 위치에 와야 한다.
        // 원래 예외가 발생하면, 들어오지 못하고 나가는데, BindingResult가 있으면, 예외가 BindingResult에 담기고, 아래의 코드도 실행된다.
        TaskViewController.log.info("req = {}", req.toString())

        if (bindingResult.hasErrors()) {
//            List<ObjectError> allErrors = bindingResult.getAllErrors();
//            for (ObjectError allError : allErrors) {
//                log.info("allError.getCode() = {}", allError.getCode());
//                log.info("allError.getDefaultMessage() = {}", allError.getDefaultMessage());
//            }
            model.addAttribute("taskDto", req)
            TaskViewController.log.info("입력이 잘못되어 오류페이지로 이동되었음, {}", req.toString())
            return "tasks/add"
        }
        val taskDto = taskService!!.saveTask(req)
        TaskViewController.log.info("taskDto = {}", taskDto)

        return "redirect:/tasks/append"
    }

    @GetMapping("/tasks/{code}")
    fun showTaskDetail(
        @PathVariable(name = "code") code: String,
        model: Model
    ): String {
        val description = taskService!!.getDescriptionByCode(code)
        TaskViewController.log.info("description = {}", description)
        model.addAttribute("task", description)
        return "tasks/detail"
    }

    @GetMapping("/tasks/{code}/edit")
    fun showEditPage(@PathVariable code: String, model: Model): String {
        val task = taskService!!.getByCode(code)
        model.addAttribute("task", task)

        return "tasks/edit"
    }

    @PostMapping("/tasks/{code}/edit")
    fun updateTask(@PathVariable code: String, updateReq: @Valid TaskDto): String {
        updateReq.code = code
        taskService!!.update(updateReq)

        return "redirect:/tasks/$code"
    }
}
