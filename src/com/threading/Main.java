package com.threading;

//class CustomThread extends Thread {
//    public void run() {
//        System.out.println("Custom threading 1 working");
//        for (int i = 100; i < 500; i++) {
//            System.out.println("[I]: " + i);
//        }
//    }
//}

import java.util.concurrent.*;

//class CustomRunnable implements Runnable {
//    public void  run() {
//        System.out.println("Custom threading 2 working");
//        for (int i = 100; i < 500; i++) {
//            System.out.println("[J]: " + i);
//        }
//    }
//}
public class Main {
    public static void main(String[] args) {
        ExecutorService pullExecutor = Executors.newFixedThreadPool(2);
//        pullExecutor.execute(new CustomRunnable());

//        pullExecutor.submit(() -> {
//            for (int i = 100; i < 500; i++) {
//       System.out.println("[I]: " + i);
//       }
//        });
//
//        pullExecutor.submit(() -> {
//            for (int i = 200; i < 400; i++) {
//                System.out.println("[J]: " + i);
//            }
//        });

        Callable<Integer> callable = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 1;
        };

        Callable<Integer> callable1 = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 12;
        };

        Future<Integer> future = pullExecutor.submit(callable);
        Future<Integer> future1 = pullExecutor.submit(callable1);

        try {
            Integer result = future.get();
            Integer result2 = future1.get();

            System.out.println(result);
            System.out.println(result2);


            System.out.println(result + result2);
        } catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            pullExecutor.close();
        }

        try {
            if(pullExecutor.awaitTermination(2, TimeUnit.SECONDS)) {
                pullExecutor.shutdown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        CustomThread customThread = new CustomThread();
//        Thread secondCustomThread = new Thread(new CustomRunnable());
//
//        customThread.run();
//        secondCustomThread.start();
    }
}
