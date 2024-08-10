package com.lambda;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.util.function.Consumer;

//interface CustomLambdaFunction {
//    int run(int str);
//}

//interface CustFunc<T, R> {
//    R apply(T t);
//}

public class Main {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(993,1,2,3,4,5);

        List<Integer> sortedValues = numbers.stream()
                .sorted()
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(sortedValues);

//        Consumer<String> greeting = string -> System.out.println(string + "!");
//
//        greeting.accept("Hello world");

//        CustFunc<Integer, String> concat = (Integer num) -> "Now it's string: " + num;
//        System.out.println(concat.apply(23));
////
//        System.out.println(concat.apply(33));
////
//        CustomLambdaFunction hailSign = (str) -> str + "!";
//        CustomLambdaFunction questionMark = (str) -> str + "?";
//        showResultsOnTheScreen("Hello world", hailSign);
//
//        String s = hailSign.run("Hello world");
//        String s2 = questionMark.run("How's it going");
//        System.out.println(s);
//        System.out.println(s2);

//        List<String> group = Arrays.asList("Anna", "Andrey", "Dmitro", "Alex", "John");
//
//
////                    parm
//        List<String> favourits = group.stream()
//                .filter(name -> name.startsWith("Joh"))
//                .collect(Collectors.toList());
//
//        List<String> newValues = group.stream()
//                .map(name -> name.toUpperCase())
//                .collect(Collectors.toList());
//
//        System.out.println(newValues);
//
//        for(String student : favourits) {
//            System.out.println(student);
//        }
    }

//    public static void showResultsOnTheScreen(String str, CustomLambdaFunction fn) {
//        String result = fn.run(str);
//        System.out.println("[RESULT]: " + result);
//    }
}
