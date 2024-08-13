package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {
    @Test
    public void doTasksExist() {
        Task task = new Task("Sleep", "Get to sleep on time");
        Assertions.assertEquals("Sleep", task.getName());
    }
}
