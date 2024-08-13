package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {
    @Test
    public void doTasksExist() {
        Task task = new Task("Sleep", "Get to sleep on time");
        Assertions.assertEquals("Sleep", task.getName());
    }

    @Test
    public void canTasksBeAdded() {
        TodoList tdl = new TodoList();
        Task task = new Task("a", "a");
        Assertions.assertEquals(0, tdl.getTasks().size());
        tdl.addTask(task);
        Assertions.assertEquals(1, tdl.getTasks.size());
    }
}
