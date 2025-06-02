package com.grepp.curdsample.view;

import com.grepp.curdsample.app.TaskService;
import com.grepp.curdsample.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
    public String addTask(TaskDto req, Model model) {
        log.info("req = {}", req.toString());
        return "tasks/add";
    }

}
