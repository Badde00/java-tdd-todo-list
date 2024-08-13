package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        Assertions.assertEquals(1, tdl.getTasks().size());
    }

    @Test
    public void shouldReturnEmptyList() {
        TodoList tdl = new TodoList();
        Assertions.assertEquals(0, tdl.getTasks().size());
    }

    @Test
    public void getFilteredTasks() {
        TodoList tdl = new TodoList();
        Task task1 = new Task("a", "a");
        Task task2 = new Task("b", "b");
        Assertions.assertFalse(task1.isCompleted());
        Assertions.assertFalse(task2.isCompleted());
        task1.complete();
        Assertions.assertTrue(task1.isCompleted());
        tdl.addTask(task1);
        tdl.addTask(task2);
        ArrayList<Task> completedTests = tdl.getTasks(true);
        Assertions.assertTrue(completedTests.contains(task1));
        Assertions.assertFalse(completedTests.contains(task2));
    }

    @Test
    public void getFilteredFalseTasks() {
        TodoList tdl = new TodoList();
        Task task1 = new Task("a", "a");
        Task task2 = new Task("b", "b");
        Assertions.assertFalse(task1.isCompleted());
        Assertions.assertFalse(task2.isCompleted());
        task1.complete();
        Assertions.assertTrue(task1.isCompleted());
        tdl.addTask(task1);
        tdl.addTask(task2);
        ArrayList<Task> completedTests = tdl.getTasks(false);
        Assertions.assertFalse(completedTests.contains(task1));
        Assertions.assertTrue(completedTests.contains(task2));
    }

    @Test
    public void changeCompleteStatus() {
        TodoList tdl = new TodoList();
        Task task1 = new Task("a", "a");
        tdl.addTask(task1);
        Assertions.assertFalse(tdl.getTasks("a").getFirst().isCompleted());
        tdl.changeCompleteStatus("a");
        Assertions.assertTrue(tdl.getTasks("a").getFirst().isCompleted());
    }
}
