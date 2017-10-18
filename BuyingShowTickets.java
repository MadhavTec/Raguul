package com.model;

import java.util.Scanner;

/**
 * 
 * @author Raagul Srinivasan
 * 
 *         Class to Implement Buying Show Tickets
 * 
 *         Given a list of values where each value corresponds to the number of
 *         required tickets. Calculate the total time taken to get the number of
 *         tickets as mentioned in each value for a position that is given as
 *         input
 *
 */
public class BuyingShowTickets
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // READ THE NUMBER OF PERSONS
        int numberOfPersons = sc.nextInt();

        int[] tickets = new int[numberOfPersons];

        // READ THE TICKETS REQUIRED FOR EACH PERSON
        for (int i = 0; i < numberOfPersons; i++)
        {
            tickets[i] = sc.nextInt();
        }
        // READ THE POSITION
        int position = sc.nextInt();

        // CALL THE METHOD TO CALCULATE THE TOTAL WAITING TIME
        long totalWaitTime = waitingTime(tickets, position);

        // PRINTING THE RESULT TOTAL TIME
        System.out.println(totalWaitTime);
    }

    static long waitingTime(int[] tickets, int p)
    {
        // TEMP ARRAY TO PROCESS THE TICKET LIST
        int[] tempTickets = new int[tickets.length];
        long totalTime = 0;

        // SUBRACTING EACH TICKET VALUE WITH THE TICKET VALUE INPOSITION WHICH
        // ALLOWS TO DETERMINE THE TICKETS THAT ARE LESS THAN THE TICKETS IN
        // REQUIRED POSITION
        for (int i = 0; i < tickets.length; i++)
        {
            tempTickets[i] = tickets[i] - tickets[p];
        }

        // ITERATING THE TICKETS OF EACH PERSON
        for (int i = 0; i < tempTickets.length; i++)
        {
            // IF TICKET VALUE IS NEGATIVE, ENTIRE TICKET VALUE WILL BE
            // CONSIDERED AS THE REQUIRED TIME
            if (tempTickets[i] < 0)
            {
                totalTime = totalTime + tickets[i];
            }

            // IF TICKET VALUE IS POSITIVE
            else
            {
                // IN POSTIONS THAT ARE BEFORE OR EQUAL TO THE REQUIRED
                // POSITIONS, TIME OF THE POSITION WILL BE ADDED TO THE TOTAL
                // TIME
                if (i <= p)
                {
                    totalTime = totalTime + tickets[p];
                }
                // IN POSTIONS THAT ARE AFTER THE REQUIRED
                // POSITIONS, TIME OF THE POSITION -1 WILL BE ADDED TO THE TOTAL
                // TIME
                else
                {
                    totalTime = totalTime + tickets[p] - 1;
                }
            }
        }
        return totalTime;
    }
}