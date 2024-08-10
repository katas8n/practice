package com.TodoListFile;

import java.io.Serializable;

public class Task implements Serializable {
    private final String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
