package com.tryCatchFinally;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            FileWriter output = new FileWriter("output.txt");
            output.write("Hello everyone");

            output.close();

            FileReader input = new FileReader("output.txt");
            input.read();
            System.out.println("HEre we are!");
        } catch (IOException e) {
            System.out.println("THERE ARE ERRORS!");
        } finally {
            System.out.println("Will be executed always");
        }
    }
}
