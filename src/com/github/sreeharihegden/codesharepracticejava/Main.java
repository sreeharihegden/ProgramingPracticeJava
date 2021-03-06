package com.github.sreeharihegden.codesharepracticejava;

import java.awt.desktop.SystemEventListener;
import java.util.*;

import static com.github.sreeharihegden.codesharepracticejava.MissingNumberInArray.findMissing;

public class Main {

    public static int fiboRec(int n) {
        if (n < 0)
            return -1;
        else if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fiboRec(n - 1) + fiboRec(n - 2);
    }

    public static int fiboMemo(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        else {
            int resultsTable[] = new int[n + 2];
            Arrays.fill(resultsTable, -1);
            return fiboMemo(n, resultsTable);
        }
    }

    private static int fiboMemo(int n, int[] resultsTable) {
        if (n == 0)
            resultsTable[0] = 0;
        else if (n == 1)
            resultsTable[1] = 1;
        else if (resultsTable[n] == -1)
            resultsTable[n] = fiboMemo(n - 1, resultsTable) + fiboMemo(n - 2, resultsTable);
        // System.out.println(resultsTable[n]);
        return resultsTable[n];
    }

    private static void displayMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int col : row)
                System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
		/*
            for(int i = 0; i< n; i++){
                System.out.println(fiboRec(i) + " ");
            }
        */

        /*
        for(int i = 0; i<= n; i++){
            System.out.println(fiboMemo(i) + " ");
        }
        */

        /*
        int matrix[][] = {
                { 1, 15, 6},
                { 12, 13, 6},
                { 9, 5, 6},
                { 8, 0, 6}
        };
        LongestIncreasingPath LIP = new LongestIncreasingPath();
        System.out.println("Input matrix is: ");
        displayMatrix(matrix);
        System.out.println("Length of Longest Increasing Path in the above matrix is: " + LIP.getLongestIncreasingPath(matrix));

        System.out.println();
        matrix= new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("Input matrix is: ");
        displayMatrix(matrix);
        System.out.println("Length of Longest Increasing Path in the above matrix is: " + LIP.getLongestIncreasingPath(matrix));

        System.out.println();
        matrix= new int[][]{
                {6, 3},
                {2, 5},
                {4, 1}
        };
        System.out.println("Input matrix is: ");
        displayMatrix(matrix);
        System.out.println("Length of Longest Increasing Path in the above matrix is: " + LIP.getLongestIncreasingPath(matrix));

        // Missing Number In Array
        System.out.println("Missing Number In Array");
        List<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(3);
        input.add(2);
        input.add(4);
        input.add(6);
        System.out.println("Input is: " + input);
        System.out.println("Missing number is: " + findMissing(input));
        */

        System.out.println("========================");
        System.out.println("Unique ID of Top K Users");
        System.out.println("========================");
        TopKUsers t1 = new TopKUsers();
        /*
        List<String> input = new ArrayList<>();
        input.add("123, a");
        input.add("234, b");
        input.add("345, c");
        input.add("456, d");
        input.add("234, b");
        input.add("234, b");
        input.add("234, b");
        input.add("345, c");
        input.add("345, c");
        input.add("345, c");
        input.add("456, d");
         */
        List<Integer> input = new ArrayList<>();
        input.add(123);
        input.add(234);
        input.add(345);
        input.add(456);
        input.add(234);
        input.add(234);
        input.add(234); // 234: 4
        input.add(345); // 345: 2
        input.add(456); // 456: 2
        input.add(123);
        input.add(123); // 123: 3
        input.add(567);
        input.add(567); // 567: 2
        input.add(678); // 678: 1
        System.out.print("Input array: ");
        System.out.println(input);
        int k = 4;
        System.out.print("Top " + k + " users: ");
        System.out.println(t1.getTopKUsers(input, k));
    }
}