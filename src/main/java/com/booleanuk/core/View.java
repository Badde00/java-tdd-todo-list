package com.booleanuk.core;

import java.util.*;

public class View {
    Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }
    public int displayMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Add Task");
        System.out.println("2. Complete Task");
        System.out.println("3. See Tasks");
        System.out.println("4. See specific Task");
        System.out.println("5. Remove Task");
        System.out.println("6. Exit");

        return getIntInput();
    }

    public int seeTaskMenu() {
        System.out.println("How do you want to see your tasks?");
        System.out.println("1. As is");
        System.out.println("2. Sorted by name");
        System.out.println("3. Sorted by name, descending order");
        System.out.println("4. See incomplete tasks only");
        System.out.println("5. See complete tasks only");

        return getIntInput();
    }

    public int getIntInput() {
        int input = -1;
        while (input == -1) {
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Invalid input");
            }

        }
        return input;
    }

    public String[] getTaskInformation() {
        String[] input = new String[2];
        System.out.println("Give a name:");
        input[0] = getStringInput();
        System.out.println("Give a description:");
        input[1] = getStringInput();
        return input;
    }

    public String getStringInput() {
        return scanner.next();
    }

    public String getTaskName() {
        System.out.println("Please provide task name:");
        return  getStringInput();
    }

    public void printTask(Task task) {
        System.out.println("Name: " + task.getName());
        System.out.println("Description: " + task.getDescription());
        System.out.print("Is completed: ");
        System.out.println(task.isCompleted());
    }

    public void printArrayList(ArrayList<Task> tasks) {
        for (Task t: tasks) {
            System.out.println(t.getName());
        }
    }

    public void noTaskByThatName() {
        System.out.println("There is no task by that name.");
    }
}
