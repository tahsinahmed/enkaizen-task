package com.company.enkaizen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Map<Integer, Character> mapper;
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        String input = x.nextLine();
        int length = x.nextInt();
        int n = input.length();
        int[] array = new int[n];
        mapper = new HashMap<>();
        for (int i=0; i<n; i++) {
            array[i] = i + 1;
            mapper.put(i + 1, input.charAt(i));
        }
        stringArrayCombination(array, length);
    }

    static void stringArrayCombination(int arr[], int r)
    {
        int data[]=new int[r];
        recursiveAction(arr, data, 0, arr.length-1, 0, r);
    }

    static void recursiveAction(int arr[], int data[], int start,
                                int end, int index, int r) {
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(mapper.get(data[j])+" ");
            System.out.println("");
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            recursiveAction(arr, data, i+1, end, index+1, r);
        }
    }
}
