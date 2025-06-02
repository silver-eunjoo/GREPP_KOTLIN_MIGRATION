package com.grepp.curdsample.view;

import com.grepp.curdsample.app.TaskService;
import com.grepp.curdsample.dto.TaskDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
public class TaskViewController {

    private final TaskService taskService;

    @GetMapping("/")
    public String showIndex(Model model) {
//        model.addAttribute("tasks", new ArrayList<TaskDto>());
        return "index";
    }

    @GetMapping("/tasks/append")
    public String showAddPage(Model model) {
        model.addAttribute("taskDto", new TaskDto());
        return "tasks/add";
    }

    @PostMapping("/tasks/append")
    public String addTask(@Valid TaskDto req, BindingResult bindingResult, Model model) {
        log.info("req = {}", req.toString());

        if ( bindingResult.hasErrors() ) {
            model.addAttribute("taskDto", req);
            log.info("입력이 잘못되어 오류페이지로 이동되었음, {}", req.toString());
            return "tasks/add";
        }

        taskService.saveTask(req);

        return "redirect:/tasks/append";
    }

}
