package com.booleanuk.core;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> tdl;

    public TodoList() {
        tdl = new ArrayList<Task>();
    }

    public ArrayList<Task> getTasks() {
        return tdl;
    }

    public void addTask(Task task) {
        tdl.add(task);
    }
}
