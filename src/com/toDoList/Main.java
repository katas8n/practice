package com.toDoList;

import com.toDoList.Entities.ToDoTask;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<ToDoTask> taskList = new HashSet<>();

        // User as entity has it's own email, password, nickname

        // Conversation with user
        // You should create an app where you will ask user to use our program
        // if user exited to use it -> we should ask it about which tasks user have to complete
        // then we should keep it in       taskList and then we should give user menu with
        // a) Show All tasks  => we should show user all tasks which user have
        // b) Completed the task => we should show user all completed tasks which user have
        // c) Complete tasks => ask user which task it's gonna do
        // d) Update a task => ask user which task it's gonna update => then update
        // e) Delete a task => ask user which task it's want to delete => then delete
        // q) Exit         => Break the infinite cycle

        Stack<ToDoTask> taskHistory = new Stack<>();
        Queue<ToDoTask> taskQueue = new LinkedList<>(taskList);

        while (!taskQueue.isEmpty()) {
            ToDoTask executedTask = taskQueue.remove();
            executedTask.setHasExecuted(true);
            executedTask.execute();
            taskHistory.push(executedTask);
        }

        while (!taskHistory.isEmpty()) {
            ToDoTask taskInHistory = taskHistory.pop();
            System.out.println(taskInHistory.getTitle());
            System.out.println(taskInHistory.getDescription());
            System.out.println();
        }
    }
}
