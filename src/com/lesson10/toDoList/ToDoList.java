package com.lesson10.toDoList;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private final ArrayList<Task> list = new ArrayList<>();

    public void addTask(Task task) {
        list.add(task);
    }

    public void removeTask(Task task) {
        list.remove(task);
    }

    public List<Task> getAllTasks() {
        return list;
    }

    public List<Task> getPendingTasks() {
        return list.stream()
                .filter(task -> !task.isDone())
                .toList();
    }

    public List<Task> getCompletedTasks() {
        return list.stream()
                .filter(Task::isDone)
                .toList();
    }
}
