package com.matrixArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 13, 0, 0 },
                { 0, 0, 0, 0, 0 }

        };

        boolean hasFound = false;
        int rowItter = 0;
        int absPosition = 0;
        int nestedItter = 0;
        // Find 13
        for (int[] arrEl : matrix) {
            nestedItter = 0;
            for(int numberElement : arrEl) {
                if(numberElement == 13) {
                    hasFound = true;
                    System.out.println("[rowItter]: " + rowItter);
                    System.out.println("[absPosition]: " + absPosition);
                    System.out.println("[NESTED_ITTER]: " + nestedItter);
                    if(hasFound) break;

                }
                nestedItter++;
                absPosition++;
            }
            if(hasFound) break;
            rowItter++;

        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(matrix[rowItter][nestedItter]);
    }
}
