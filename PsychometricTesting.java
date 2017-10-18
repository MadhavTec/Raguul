package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Raagul Srinivasan
 *
 *         Class to Implement Psychometric Testing
 *
 *         Given a list of Integers, and queries of lower and upperlimits,
 *         calculating the count for the inclusive numbers between limits and
 *         returning as a list
 *
 *         Note : The Class will print solution in array as required by the
 *         problem Example : [1,3] and not like 1 3
 *
 */

public class PsychometricTesting
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // READ THE NUMBER OF INPUTS
        int numOfScores = sc.nextInt();

        // INITIALIZING ARRAY TO READ THE SCORES
        int[] scores = new int[numOfScores];

        // READ THE INPUTS
        for (int i = 0; i < numOfScores; i++)
        {
            scores[i] = sc.nextInt();
        }

        // READ THE NUMBER OF QUERIES FOR LOWER LIMIT
        int numOfLowerLimit = sc.nextInt();

        // INITIALIZING ARRAY TO READ THE LOWER LIMIT
        int[] lowerLimits = new int[numOfLowerLimit];

        // READ THE LOWER LIMIT
        for (int i = 0; i < numOfLowerLimit; i++)
        {
            lowerLimits[i] = sc.nextInt();
        }

        // READ THE NUMBER OF QUERIES FOR UPPER LIMIT
        int numOfUpperLimit = sc.nextInt();

        // INITIALIZING ARRAY TO READ THE UPPER LIMIT
        int[] upperLimits = new int[numOfUpperLimit];

        // READ THE UPPER LIMIT
        for (int j = 0; j < numOfUpperLimit; j++)
        {
            upperLimits[j] = sc.nextInt();
        }

        // CALLING METHOD TO CALCULATE THE RESULTS
        int[] psychometricResults = jobOffers(scores, lowerLimits, upperLimits);

        System.out.println(Arrays.toString(psychometricResults));

    }

    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits)
    {
        // USING LIST SINCE THE SIZE OF RESULT ARRAY IS UNKNOWN
        List<Integer> psychometricList = new ArrayList<>();

        int lowerLimit;
        int upperLimit;

        // ITERATING THE LOWER LIMIT POSITIONS
        for (int j = 0; j < lowerLimits.length; j++)
        {
            // ITERATING THE UPPER LIMIT POSITIONS
            for (int k = 0; k < upperLimits.length; k++)
            {
                int count = 0;
 
                // CHECK FOR SAME POSITIONS OF LOWER AND UPPER LIMIT
                if (j == k)
                {
                    lowerLimit = lowerLimits[j];
                    upperLimit = upperLimits[k];

                    // ITERATING SCORES
                    for (int i = 0; i < scores.length; i++)
                    {
                        // CHECK IF THE SCORE IS WITHIN THE LOWER AND UPPER
                        // LIMIT RANGE
                        if (lowerLimit <= scores[i] && scores[i] <= upperLimit)
                        {
                            // INCREMENT THE COUNT IF CONDITION PASSES
                            count++;
                        }
                    }

                    // ADD TO LIST
                    psychometricList.add(count);
                }
            }
        }

        int[] psychometricResult = new int[psychometricList.size()];
 
        // CONVERTING FROM LIST TO ARRAY
        for (int i = 0; i < psychometricList.size(); i++)
        {
            psychometricResult[i] = psychometricList.get(i);
        }
        return psychometricResult;

    }

}