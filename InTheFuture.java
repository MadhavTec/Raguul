package com.model;

import java.util.Scanner;


/**
 *
 * @author Raagul Srinivasan
 *
 *         Class to find the solution for In the Future
 *
 *         To Find the Minimum number of days it will take for Kelly to have
 *         solved more problems than Asha.
 *
 *         If Kelly cannot solve more than Asha, return -1
 *
 */

public class InTheFuture
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        // PROBLEMS SOLVED BY ASHA PER DAY
        int A = sc.nextInt();

        // PROBLEMS SOLVED BY KELLY PER DAY
        int K = sc.nextInt();

        // NO OF PROBLEMS ASHA IS AHEAD OF KELLY
        int P = sc.nextInt();

        // FUNCTION TO CALCULATE MINIMUM NUMBER OF DAYS REQUIRED
        int minDays = minNum(A, K, P);

        // PRINTING THE MINIMUM NUMBER OF DAYS
        System.out.println(minDays);

    }

    static int minNum(int A, int K, int P)
    {

        int days = 1;

        // IF THE PROBLEM SOLVED BY KELLY PER DAY IS LESS THAN PROBLEM SOLVED BY
        // ASHA PER DAY, THEN KELLY CANNOT SURPASS ASHA AT ALL, RETURNING -1
        // ACCORDING TO REQUIREMENT

        if (K < A)
        {
            return -1;
        }

        // CHECK IF KELLY'S PROBLEM COUNT IS MORE OR EQUAL TO ASHA'S
        // IF SO INCREMENT THE NUMBER OF DAYS, ELSE RETURN THE DAYS AS IT IS
        while ((A * days) + P >= K * days)
        {
            days = days + 1;
        }
        return days;
    }
}

