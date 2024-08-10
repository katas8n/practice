package com.TodoListFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final String FILE_NAME = "tasks.ser";
    private static final List<Task> tasks = Collections.synchronizedList(new ArrayList<Task>());
    private static final ExecutorService es = Executors.newFixedThreadPool(2);
    private static final ExecutorService es2 = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws FileNotFoundException {
        readTasksFromFile();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if(tasks.size() > 0) {
                System.out.println("Ur hucking tasks : ");
                displayTasks();
            }

            System.out.println("Choose option u want: ");
            System.out.println("1. Add task ");
            System.out.println("2. Complete task ");
            System.out.println("3. Display Tasks ");
            System.out.println("4. Save and exit ");

            int chosenOption = scanner.nextInt();
            scanner.nextLine();

            switch (chosenOption) {
                case 1:
                    System.out.println("Please enter task description: ");
                    String desc = scanner.nextLine();
                    addTask(desc);
                    break;
                case 2:
                    System.out.println("Please enter tasks index: ");
                    int index = scanner.nextInt();
                    completeTask(index);
                    break;
                case 3:
                   displayTasks();
                    break;
                case 4:
                    saveTask();
                    return;
                default:
                    System.out.println("Huck you!");
                    break;
            }
        }
    }

    private static void displayTasks() {
        synchronized (tasks) {
            if (tasks.isEmpty()) return;

            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + 1 + ") " + tasks.get(i).getDescription());
            }
        }
    }

    private static void addTask(String desc) {
            es.submit(() -> {
                synchronized (tasks) {
                    tasks.add(new Task(desc));
                }

            });
            System.out.println("The task " + desc + " was successfully added, blead!");
    }

    private static void completeTask(int index) {
            es.submit(() -> {
                synchronized (tasks) {
                    Task completedTask = tasks.remove(index - 1);
                    System.out.println("The task: " + completedTask.getDescription() + " was completed!");
                }

            });
    }

    private static void saveTask() {
        try {
            synchronized (tasks) {
                ObjectOutputStream serialisedObjects = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
                serialisedObjects.writeObject(new ArrayList<>(tasks));
            }
        }
        catch(IOException e) {
            System.out.println("There is nothing here yet!");
        }
    }

    private static void readTasksFromFile() {
        try {
            synchronized (tasks) {
                ObjectInputStream serialisedObjects = new ObjectInputStream(new FileInputStream(FILE_NAME));
                List<Task> readTasks = (List<Task>) serialisedObjects.readObject();
                tasks.addAll(readTasks);
            }
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.println("There is nothing here yet!");
        }
    }

}
