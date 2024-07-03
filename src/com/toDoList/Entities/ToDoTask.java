package com.toDoList.Entities;

import java.text.SimpleDateFormat;
import java.util.*;

import com.toDoList.interfaces.Task;

// Execute
// HIGH, MEDIUM, LOW
public class ToDoTask<T> implements Task {
    private T title;
    private String description;
    private Date to;
    private Boolean hasExecuted;

    public ToDoTask(T title ,String description, Date to) {
        this.title = title;
        this.description = description;
        this.to = to;
        this.hasExecuted = false;
        // priority according to the enum you have
    }
    @Override
    public void execute() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("\nThe task " + title + "\nDescrition" + "\nTO: " + sdf.format(to));
    }

    public Date getTo() {
        return to;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getHasExecuted() {
        return hasExecuted;
    }

    public T getTitle() {
        return title;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(T title) {
        this.title = title;
    }

    public void setHasExecuted(Boolean hasExecuted) {
        this.hasExecuted = hasExecuted;
    }
}
