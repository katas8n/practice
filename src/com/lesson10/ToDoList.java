package com.lesson10;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private int id;
    private ArrayList<Task> tasks;

    public ToDoList() {
        this.id = (int)(Math.random() * 1000) + 1;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void getAllTasks() {
        int i = 1;
        for (Task task : tasks) {
            System.out.println(i + ". " + task);
            i++;
        }
    }

    public void getPendingTasks() {
        for (Task task : tasks) {
            if (!task.isDone()) {
                System.out.println(task);
            }
        }
    }

    public void getCompletedTasks() {
        for (Task task : tasks) {
            if (task.isDone()) {
                System.out.println(task);
            }
        }
    }

    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
