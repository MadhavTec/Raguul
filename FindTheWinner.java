package com.model;
 
import java.util.Scanner;

/**
 *
 * @author Raagul Srinivasan
 *
 *         Class to Implement find_the_winner
 *
 *         Returns a String as a Result based on the Outcome of Game between
 *         Andrea and Maria
 *
 */

public class FindTheWinner
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // READING THE NUMBER OF INPUTS FOR ANDREA
        int numOfAndrea = sc.nextInt();

        // INITAILIZE ARRAY FOR ANDREA
        int[] a = new int[numOfAndrea];

        // READ THE INPUTS FOR ANDREA
        for (int i = 0; i < numOfAndrea; i++)
        {
            a[i] = sc.nextInt();
        }

        // READING THE NUMBER OF INPUTS FOR MARIA
        int numOfMaria = sc.nextInt();

        // INITAILIZE ARRAY FOR MARIA
        int[] m = new int[numOfMaria];

        // READ THE INPUTS FOR MARIA
        for (int i = 0; i < numOfMaria; i++)
        {
            m[i] = sc.nextInt();
        }
        // READ POSITION ODD OR EVEN
        String oddOrEven = sc.next();

        // CALLING METHOD TO DETERMINE THE WINNER
        String winner = winner(a, m, oddOrEven);

        System.out.println(winner);
    }

    static String winner(int andrea[], int maria[], String s)
    {
        int andreaSum = 0;
        int mariaSum = 0;
        String winner;

        // CHECK IF EVEN POSITION
        if ("Even".equals(s))
        {
            // ITERATING VALUES IN ANDREA LIST FOR EVEN POSITIONS
            for (int i = 0; i < andrea.length; i += 2)
            {
                // ITERATING VALUES IN MARIA LIST FOR EVEN POSITIONS
                for (int j = 0; j < maria.length; j += 2)
                {
                    int tempAndrea = andrea[i] - maria[j];
                    int tempMaria = maria[j] - andrea[i];

                    // SUM OF VALUES IN ANDREA LIST
                    andreaSum = andreaSum + tempAndrea;

                    // SUM OF VALUES IN MARIA LIST
                    mariaSum = mariaSum + tempMaria;
                }
            }
        }
        // CHECK IF EVEN POSITION
        if ("Odd".equals(s))
        {
            // ITERATING VALUES IN ANDREA LIST FOR ODD POSITIONS
            for (int i = 1; i < andrea.length; i += 2)
            {
                // ITERATING VALUES IN MARIA LIST FOR ODD POSITIONS
                for (int j = 1; j < maria.length; j += 2)
                {
                    int tempAndrea = andrea[i] - maria[j];
                    int tempMaria = maria[j] - andrea[i];

                    // SUM OF VALUES IN ANDREA LIST
                    andreaSum = andreaSum + tempAndrea;

                    // SUM OF VALUES IN MARIA LIST
                    mariaSum = mariaSum + tempMaria;

                }
            }
        }

        // IF ANDREA SUM IS GREATER THAN MARIA SUM, WINNER IS ANDREA
        if (andreaSum > mariaSum)
        {
            winner = "Andera";
        }

        // IF ANDREA SUM IS EQUAL TO MARIA SUM, RESULT IS TIE
        else if (andreaSum == mariaSum)
        {
            winner = "Tie";
        }

        // IF MARIA SUM IS GREATER THAN ANDREA SUM, WINNER IS MARIA
        else
        {
            winner = "Maria";
        }
        return winner;
    }

}

