package com.lesson10;

import com.fight.Account.Account;
import com.lesson10.utils.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Задание: ToDo List с использованием времени
//                Цель
//        Создать приложение "ToDo List", где каждый элемент списка будет иметь название задачи, описание, дедлайн и отметку о выполнении. Используйте дженерики и классы для работы с датами.
//        Требования
//        Создание класса Task
//        Поля:
//        String title - название задачи.
//                String description - описание задачи.
//                LocalDateTime deadline - дедлайн задачи.
//        boolean isDone - статус выполнения задачи.
//        Методы:
//        Конструктор для инициализации всех полей.
//                Геттеры и сеттеры для полей.
//        Метод markAsDone() для отметки задачи как выполненной.
//                Создание класса ToDoList
//        Используйте дженерик для хранения задач (ArrayList<Task>).
//                Методы:
//        void addTask(Task task) - добавление задачи в список.
//        void removeTask(Task task) - удаление задачи из списка.
//                List<Task> getAllTasks() - получение всех задач.
//        List<Task> getPendingTasks() - получение невыполненных задач.
//        List<Task> getCompletedTasks() - получение выполненных задач.
//        Главный класс Main
//        Методы:
//        Создание нескольких задач.
//                Добавление задач в список.
//                Отметка задач как выполненных.
//                Вывод всех задач, выполненных задач и невыполненных задач на экран.

        Scanner scanner = new Scanner(System.in);
        String[] defaultChars = {"a", "b", "c", "d", "e", "f", "g"};
        String[] mainMenu = {"Add task", "Show all tasks", "Show completed tasks", "Complete task", "Update task", "Delete task", "Exit"};
        HashMap<String, String> Menu = new HashMap<>();
        Utils.fillMenuItems(mainMenu, defaultChars, Menu);
        ToDoList toDoList = new ToDoList();
        boolean isRunning = true;
        int id = 1;

        while (isRunning) {
            System.out.println("What would u like to do?");
            Utils.showMenuItems(Menu);
            String answer = scanner.nextLine().toLowerCase();
            switch (answer){
                case "a":
                    addTask(toDoList, id);
                    id++;
                    break;
                case "b":
                    showAllTasks(toDoList);
                    break;
                case "c":
                    showCompletedTasks(toDoList);
                    break;
                case "d":
                    markTaskDone(toDoList);
                    break;
                case "e":
                    updateTask(toDoList);
                    break;
                case "f":
                    deleteTask(toDoList);
                    break;
                case "g":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid answer, try again!");
                    break;
            }
        }
    }

    public static void addTask(ToDoList toDoList, int id) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Enter your title of task");
        String title = scanner.nextLine();
        System.out.println("Enter your description of task");
        String description = scanner.nextLine();

        LocalDateTime deadline = null;
        boolean isValidDeadLine = false;

        while (!isValidDeadLine) {
            System.out.println("Enter your deadline of task\nWrite in format: yyyy-MM-dd HH:mm");
            String dateTime = scanner.nextLine();

            try {
                deadline = LocalDateTime.parse(dateTime, formatter);
                if (deadline.isAfter(LocalDateTime.now())) {
                    isValidDeadLine = true;
                } else {
                    System.out.println("Your deadline is in the past. Please enter a future date and time.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use the format: yyyy-MM-dd HH:mm");
            }
        }

        Task task = new Task(title, description, deadline, id);
        toDoList.addTask(task);
        System.out.println("Ur currently tasksList looks so:");
        toDoList.getAllTasks();
    }

    public static void markTaskDone(ToDoList toDoList) {
        Scanner scanner = new Scanner(System.in);
        toDoList.getAllTasks();
        System.out.println("Choose the task you want to mark as done. Type the task ID:");
        int id = scanner.nextInt();

        Task task = toDoList.findTaskById(id);
        if (task != null) {
            task.markAsDone();
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public static void showAllTasks(ToDoList toDoList) {
        System.out.println("Ur pending tasks:");
        toDoList.getPendingTasks();
        System.out.println("Ur completed tasks:");
        toDoList.getCompletedTasks();
    }

    public static void showCompletedTasks(ToDoList toDoList) {
        System.out.println("Ur completed tasks:");
        toDoList.getCompletedTasks();
    }

    public static void updateTask(ToDoList toDoList) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        toDoList.getAllTasks();
        System.out.println("Choose the task which you want to update. Type the task ID:");
        int id = scanner.nextInt();

        Task task = toDoList.findTaskById(id);
        if (task != null) {
            System.out.println("Enter your title of task");
            String title = scanner.nextLine();
            System.out.println("Enter your description of task");
            String description = scanner.nextLine();

            LocalDateTime deadline = null;
            boolean isValidDeadLine = false;

            while (!isValidDeadLine) {
                System.out.println("Enter your deadline of task\nWrite in format: yyyy-MM-dd HH:mm");
                String dateTime = scanner.nextLine();

                try {
                    deadline = LocalDateTime.parse(dateTime, formatter);
                    if (deadline.isAfter(LocalDateTime.now())) {
                        isValidDeadLine = true;
                    } else {
                        System.out.println("Your deadline is in the past. Please enter a future date and time.");
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid format. Please use the format: yyyy-MM-dd HH:mm");
                }
            }
            System.out.println("Is ur task completed? Write y or n");
            String answer = scanner.nextLine();
            boolean isValidAnswer = false;
            while (!isValidAnswer) {
                if (answer.equalsIgnoreCase("y")) {
                    task.setDone(true);
                    isValidAnswer = true;
                } else if (answer.equalsIgnoreCase("n")) {
                    task.setDone(false);
                    isValidAnswer = true;
                } else {
                    System.out.println("Incorrect answer\nTry again!");
                }
            }

            task.setTitle(title);
            task.setDescription(description);
            task.setDeadline(deadline);
            task.setId(id);
            System.out.println("Ur currently tasksList looks so:");
            toDoList.getAllTasks();
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public static void deleteTask(ToDoList toDoList) {
        Scanner scanner = new Scanner(System.in);
        toDoList.getAllTasks();
        System.out.println("Choose the task which you want to remove. Type the task ID:");
        int id = scanner.nextInt();

        Task task = toDoList.findTaskById(id);
        if (task != null) {
            toDoList.removeTask(task);
            System.out.println("Task is removed.");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }
}
