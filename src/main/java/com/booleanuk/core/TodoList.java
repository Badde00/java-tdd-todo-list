package com.booleanuk.core;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> tdl;

    public TodoList() {
        tdl = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tdl;
    }

    public ArrayList<Task> getTasks(boolean filterCompleted) {
        ArrayList<Task> filtered = new ArrayList<>();
        for (Task t: tdl) {
            if (t.isCompleted() == filterCompleted) {
                filtered.add(t);
            }
        }
        return filtered;
    }

    public ArrayList<Task> getTasks(String name) {
        ArrayList<Task> filtered = new ArrayList<>();
        for (Task t: tdl) {
            if (t.getName().equals(name)) {
                filtered.add(t);
            }
        }
        return filtered;
    }

    public void addTask(Task task) {
        tdl.add(task);
    }

    public void changeCompleteStatus(String name) {
        Task task = null;
        for (Task t: tdl) {
            if (t.getName().equals(name)) {
                task = t;
            }
        }
        if (task != null) {
            task.complete();
        }
    }
}
