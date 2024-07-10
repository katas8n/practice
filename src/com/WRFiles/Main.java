package com.WRFiles;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String helloFromFile = "Hello from file!";

        try {
            //  Block of code to try
            FileOutputStream fs = new FileOutputStream("greeting.txt");
            byte[] data = helloFromFile.getBytes();

            fs.write(data);
            fs.close();

            FileInputStream fis = new FileInputStream("greeting.txt");

            int letter = -1;

            while((letter = fis.read()) != -1) {
                System.out.println("HERE IS BYTE: " + letter);
                System.out.println((char) letter);
            }
            System.out.println(fis.read());
            fis.close();


        }
        catch(Exception e) {
            //  Block of code to handle errors
            System.out.println(e);
        }

    }
}
