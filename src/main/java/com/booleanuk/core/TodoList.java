package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class TodoList {
    private final ArrayList<Task> tdl;

    public TodoList() {
        tdl = new ArrayList<>();
    }

    public static void main(String[] args) {
        TodoList tdl = new TodoList();
        View view = new View();
        boolean running = true;
        while(running) {
            String taskName;
            int answer = view.displayMenu();
            switch (answer) {
                case 1:
                    String[] taskInformation = view.getTaskInformation();
                    Task temp = new Task(taskInformation[0], taskInformation[1]);
                    tdl.addTask(temp);
                    break;
                case 2:
                    String name = view.getTaskName();
                    tdl.changeCompleteStatus(name);
                    break;
                case 3:
                    int taskMenuAnswer = view.seeTaskMenu();
                    displayTaskMenu(view, tdl, taskMenuAnswer);
                    break;
                case 4:
                    taskName = view.getTaskName();
                    if (!tdl.containsName(taskName)) {
                        view.noTaskByThatName();
                    } else {
                        view.printTask(tdl.getTask(taskName));
                    }
                    break;
                case 5:
                    taskName = view.getTaskName();
                    tdl.removeTask(taskName);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("No option that high. Try again.");
            }
        }
    }

    private static void displayTaskMenu(View view, TodoList tdl, int answer) {
        switch (answer) {
            case 1:
                view.printArrayList(tdl.getTasks());
                break;
            case 2:
                view.printArrayList(tdl.getTasksSorted(false));
                break;
            case 3:
                view.printArrayList(tdl.getTasksSorted(true));
                break;
            case 4:
                view.printArrayList(tdl.getTasks(false));
                break;
            case 5:
                view.printArrayList(tdl.getTasks(true));
                break;
            default:
                System.out.println("Something went wrong.");
                break;
        }
    }

    public boolean containsName(String name) {
        for (Task t: tdl) {
            if (t.getName().equals(name)) {
                return true;
            }
        }
        return false;
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
                break;
            }
        }
        return filtered;
    }

    public ArrayList<Task> getTasksSorted(boolean descending) {
        if (descending) {
            // The inverse sort wasn't available the way below, from what I can find
            tdl.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
        } else {
            tdl.sort(Comparator.comparing(Task::getName));
        }
        return tdl;
    }

    public Task getTask(String name) {
        for (Task t: tdl) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
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
        if (task == null) {
            throw new NoSuchElementException("There is no element by that name");
        }
        if (task.isCompleted()) {
            task.setCompleted(false);
        } else {
            task.complete();
        }
    }

    public boolean removeTask(String name) {
        for (int i = 0; i < tdl.size(); i++) {
            if (tdl.get(i).getName().equals(name)) {
                tdl.remove(i);
                return true;
            }
        }
        throw new NoSuchElementException();
    }
}
