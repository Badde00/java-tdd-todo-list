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

    public void addTask(Task task) {
        tdl.add(task);
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
}
