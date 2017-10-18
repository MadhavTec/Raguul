package com.model;

import java.util.Scanner;

/**
 *
 * @author Raagul Srinivasan
 *
 *         Class to Calculate the Consecutive Sum
 *
 *         Given a long Integer, To find the number of ways to represent it as a
 *         sum of two or more consecutive positive integers.
 *
 */

public class ConsecutiveSum
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // INPUT FROM USER
        long input = scanner.nextLong();

        long output = consecutive(input);

        // OUTPUT TO THE USER

        System.out.println(output);

    }

    // METHOD TO PROCESS THE CONSECUTIVE SUM COUNT
    static int consecutive(long num)
    {
        int start = 1;
        long end = (num + 1) / 2;
        int count = 0;

        while (start < end)
        {

            int sum = 0;
            for (int i = start; i <= num; i++)
            {

                // CALCULATE THE SUM BY INCREMENTING I
                sum = sum + i;

                // IF CONSECUTIVE SUM EQUALS THE INPUT NUM, INCREMENT THE COUNT
                if (sum == num)
                {
                    count++;
                }

                // IF SUM VALUE EXCEEDS INPUT NUM, BREAK THE ITERATION
                if (sum > num)
                {
                    break;
                }
            }

            // INCREMENTING THE START POSITION WHEN THE SUM EXCEEDS INPUT NUM,
            // SO THAT THE NEXT CONSECUTIVE SUM MATCH CAN BE FOUND
            start++;
        }
        return count;
    }

}



