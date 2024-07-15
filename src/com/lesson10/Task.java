package com.lesson10;

import java.time.LocalDateTime;

public class Task {
//    String title - название задачи.
//                String description - описание задачи.
//                LocalDateTime deadline - дедлайн задачи.
//        boolean isDone - статус выполнения задачи.

    private String title;
    private String description;
    private LocalDateTime deadline;
    private boolean isDone;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", isDone=" + isDone +
                ", id=" + id +
                '}';
    }

    public Task(String title, String description, LocalDateTime deadline, int id) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.isDone = false;
        this.id = id;
    }
}
