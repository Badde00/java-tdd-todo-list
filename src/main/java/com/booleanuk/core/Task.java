package com.booleanuk.core;

public class Task {
    private String name;
    private String description;
    private boolean completed;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        completed = true;
    }

    public void setCompleted(boolean value) {
        this.completed = value;
    }
}
