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
        String[] defaultChars = {"a", "b", "c", "d"};
        String[] mainMenu = {"Add task in ToDoTask", "Mark Task as not pending", "Show all tasks", "Quit"};
        HashMap<String, String> Menu = new HashMap<>();
        Utils.fillMenuItems(mainMenu, defaultChars, Menu);
        ToDoList toDoList = new ToDoList();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("What would u like to do?");
            Utils.showMenuItems(Menu);
            String answer = scanner.nextLine().toLowerCase();
            int id = 1;
            switch (answer){
                case "a":
                    addTask(toDoList, id);
                    id++;
                    break;
                case "b":
                    markTaskDone(toDoList);
                    break;
                case "c":
                    showAllTasks(toDoList);
                    break;
                case "d":
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
}
