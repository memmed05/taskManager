package com.example.toDo.controllers;

import com.example.toDo.business.abstracts.TaskService;
import com.example.toDo.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getTasks")
    public String getTasks(Model model){
        model.addAttribute("tasks",taskService.getTasks());
        model.addAttribute("newTask",new Task());
        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute("newTask") Task task){
        Task newTask=taskService.addTask(task);
        return "redirect:/getTasks";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
        return "redirect:/getTasks";
    }
}
