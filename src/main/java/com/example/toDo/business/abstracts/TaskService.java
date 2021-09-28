package com.example.toDo.business.abstracts;

import com.example.toDo.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    Task addTask(Task task);

    void deleteTask(Integer id);
}
