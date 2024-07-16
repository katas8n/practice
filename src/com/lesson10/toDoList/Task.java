package com.lesson10.toDoList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String title;
    private String description;
    private LocalDateTime deadline;
    private boolean isDone;

    public Task(String title, String description, LocalDateTime deadline, boolean isDone) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.isDone = isDone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "Task {" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline.format(formatter) + '\'' +
                ", isDone='" + (isDone ? "done" : "pending") + '\'' +
                '}';
    }

    public void marsAsDone() {
        isDone = true;
    }
}
