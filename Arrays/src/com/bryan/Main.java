package com.bryan;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5);
       // printArray(myIntegers);
        printArray(sortArray(myIntegers));

    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter integer number: \r");
        int[] values = new int[number];

        for (int i=0; i <values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static void printArray(int[] array) {
        for (int i=0;i<array.length;i++) {
            System.out.println("Element " + i + ", Value " + array[i]);
        }
    }

    public static int[] sortArray(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i=0; i<array.length; i++) {
            sortedArray[i] = array[i];
        }
        boolean isTrue = true;
        int temp;
        while (isTrue) {
            isTrue = false;
            for (int i=0; i<array.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    isTrue = true;
                }
            }
        }
        return sortedArray;
    }
}
