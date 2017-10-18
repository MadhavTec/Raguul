package com.model;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Raagul Srinivasan.
 *
 *         Class to Implement Largest Subset Sum
 *
 *         Given a List of integers, find the sum of all integers in the subset
 *         and return as List
 *
 *         Note : The Class will print solution in array as required by the
 *         problem Example : [1,3] and not like 1 3
 *
 */
public class LargestSubsetSum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // READ THE NUMBER OF INPUTS
        int num = sc.nextInt();

        // INTIALIZING ARRAY TO READ THE INPUT VALUES
        int[] k = new int[num];
 
        // READ THE INPUTS OF VALUES
        for (int i = 0; i < num; i++)
        {
            k[i] = sc.nextInt();
        }

        // CALL METHOD TO CALCULATE MAXIMUM SUBSET
        long[] result = maxSubsetSum(k);

        // PRINTING OUTPUT
        System.out.println(Arrays.toString(result));
    }

    static long[] maxSubsetSum(int[] k)
    {
        // INTIALIZING ARRAY TO RETURN WITH LENGTH SAME AS INPUT ARRAY K
        long[] result = new long[k.length];

        // ITERATING THE ARRAY AND FINDING THE SUM OF SUBSET OF EACH ELEMENT
        for (int i = 0; i < k.length; i++)
        {
            int num = k[i];
            long sum = 0;

            // ITERATING TO FIND THE DIVISORS OF NUM
            for (int j = 2; j <= num; j++)
            {
                // CHECK WHETHER J IS DIVISOR OF NUM, IF DIVISOR ADD THAT TO THE
                // SUM
                if (num % j == 0)
                {
                    sum = sum + j;
                }
            }

            // ADD THE SOME TO THE RESULT ARRAY
            result[i] = sum + 1;
        }
        return result;
    }
}