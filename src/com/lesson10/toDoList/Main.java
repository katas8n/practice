package com.lesson10.toDoList;
//    Создать приложение "ToDo List", где каждый элемент списка будет иметь название задачи, описание, дедлайн и отметку о выполнении. Используйте дженерики и классы для работы с датами.
//    Требования
//    Создание класса Task
//    Поля:
//        String title - название задачи
//        String description - описание задачи
//        LocalDateTime deadline - дедлайн задачи
//        boolean isDone - статус выполнения задачи
//    Методы:
//        Конструктор для инициализации всех полей
//        Метод markAsDone() для отметки задачи как выполненной
//
//    Содание класса ToDoList
//    Используйте дженерик для хранения задач (ArrayList<Task>)
//    Методы:
//        void addTask(Task task) - добавление задачи в список
//        void removeTask(Task task) - удаление задачи из списка
//        List<Task> getAllTasks() - получение всех задач
//        List<Task> getPendingTasks() - получение невыполненных задач
//        List<Task> getCompletedTasks() - получение выполненных задач
//
//    Главный класс Main
//    Методы:
//        Создание нескольких задач
//        Добавление задач в список
//        Отметка задач как выполненных
//        Вывод всех задач, выполненных задач и невыполненных задач на экран

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("-------");
            System.out.println("Please select an action");
            Menu.showDefaultMenu();
            String action = input.nextLine();
            System.out.println("-------");

            switch (action) {
                case "1":
                    addTask(input, list);
                    break;
                case "2":
                    removeTask(input, list);
                    break;
                case "3":
                    markTaskDone(input, list);
                    break;
                case "4":
                    showAllTasks(list);
                    break;
                case "5":
                    showPendingTasks(list);
                    break;
                case "6":
                    showDoneTasks(list);
                    break;
                case "7":
                    System.exit(0);
                default:
                    System.out.println("You entered wrong list item number! Please, try again");
                    break;
            }
        }
    }

    private static void addTask(Scanner input, ToDoList list) {
        System.out.println("Enter the title of your task:");
        String title = input.nextLine();
        System.out.println("Enter the description of your task:");
        String description = input.nextLine();
        LocalDateTime datetime;

        while (true) {
            try {
                System.out.println("Enter the deadline in format dd/MM/yyyy HH:mm");
                String datetimeString = input.nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                datetime = LocalDateTime.parse(datetimeString, formatter);

                break;
            } catch (Exception e) {
                System.out.println("You entered dateTime in a wrong format! Please, try again.");
            }
        }

        Task task = new Task(title, description, datetime, false);
        list.addTask(task);

        System.out.println("Next task was added:");
        System.out.println(task);
    }

    private static void removeTask(Scanner input, ToDoList list) {
        List<Task> tasks = list.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("There are no tasks!");
            return;
        }

        System.out.println("--- Remove the task ---");
        Task task = chooseTask(tasks, input);

        if (task != null) {
            list.removeTask(task);
        }
    }

    private static void markTaskDone(Scanner input, ToDoList list) {
        List<Task> tasks = list.getPendingTasks();

        if (tasks.isEmpty()) {
            System.out.println("You finished all tasks!!!");
            return;
        }

        System.out.println("--- Mark the task as done ---");
        Task task = chooseTask(tasks, input);

        if (task != null) {
            task.markAsDone();
        }
    }

    private static Task chooseTask(List<Task> tasks, Scanner input) {
        System.out.println("0) Exit");
        HashMap<String, String> menu = Menu.generateMenu(tasks.toArray());
        Menu.showMenu(menu);

        while (true) {
            System.out.println("Please choose task number or enter 0: ");
            int number = Integer.parseInt(input.nextLine());

            if (number == 0) {
                return null;
            }

            if (number < 0 || number > tasks.size()) {
                System.out.println("You entered wrong number! Please, try again.");
            } else {
                return tasks.get(number - 1);
            }
        }
    }

    private static void showAllTasks(ToDoList list) {
        System.out.println("Your tasks:");

        List<Task> tasks = list.getAllTasks();
        printTasks(tasks);
    }

    private static void showPendingTasks(ToDoList list) {
        System.out.println("Your pending tasks:");

        List<Task> tasks = list.getPendingTasks();
        printTasks(tasks);
    }

    private static void showDoneTasks(ToDoList list) {
        System.out.println("Your completed tasks:");

        List<Task> tasks = list.getCompletedTasks();
        printTasks(tasks);
    }

    private static void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks");
        } else {
//            tasks.forEach(task -> {
//                System.out.println(task);
//                System.out.println("----");
//            });

            IntStream
                    .range(0, tasks.size())
                    .forEach(i -> System.out.printf("Task [%d]: %s \n", i + 1, tasks.get(i)));
        }
    }
}
