package com.model;
import java.util.Scanner;

/**
 *
 * @author Raagul Srinivasan
 *
 *         Class to implement and find whether the given expressions are
 *         balanced or not
 *
 */
public class BalancedOrNot
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // READING NUMBER OF EXPRESSIONS
        int noOfInputs = scanner.nextInt();

        String[] expressions = new String[noOfInputs];

        int[] maxReplacements = new int[noOfInputs];

        scanner.nextLine();

        // READING EXPRESSION VALUES
        for (int i = 0; i < noOfInputs; i++)
        {
            expressions[i] = scanner.nextLine();
        }
 
        // READING NUMBER OF MAX REPLACEMENT.
        int noOfMaxReplacement = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < noOfMaxReplacement; i++)
        {
            maxReplacements[i] = scanner.nextInt();
            scanner.nextLine();
        }

        // CALLING balancedOrNot METHOD.
        int[] resultArray = balancedOrNot(expressions, maxReplacements);

        // PRINTING THE FINAL RESULT
        for (int i = 0; i < resultArray.length; i++)
        {
            System.out.println(resultArray[i]);
        }
    }

    static int[] balancedOrNot(String[] expressions, int[] maxReplacements)
    {
        int[] resultArray = new int[expressions.length];

        // LOOPING EXPRESSIONS.
        for (int i = 0; i < expressions.length; i++)
        {
            // CONVERTING EXPRESSION TO CHARACTER ARRAY TO APPLY LOGIC.
            char[] expressionCharArray = expressions[i].toCharArray();

            int count = 0;

            // LOOPING CHAR ARRAY.
            for (int j = 0; j < expressionCharArray.length; j++)
            {
                // IF '<' IS EXISTS.
                if (expressionCharArray[j] == '<')
                {
                    if ((j + 1) < expressionCharArray.length)
                    {
                        // CHECKING EXPRESSION IS BALANCED
                        if (expressionCharArray[j + 1] == '>')

                        {
                            // INCREMENTING THE LOOP TO CHECK THE NEXT
                            // EXPRESSION SINCE THE EXPRESSION IS BALANCED.
                            if ((j + 1) < expressionCharArray.length)
                            {
                                j++;
                            }
                        }
                        else
                        {
                            // INCREMENTING THE COUNT SINCE EXPRESSION IS NOT
                            // BALANCED.
                            count++;
                        }
                    }
                    else
                    {
                        // NEXT ELEMENT IS NOT EXISTS. NEED EXPRESSION TO
                        // BALANCE. INCREMENTING THE COUNT.
                        count++;
                    }
                }
                else
                {
                    // NEXT EXPRESSION IS NOT MATCHING. INCREMENTING THE COUNT.
                    count++;
                }
            }
            // COMPARING THE COUNT WITH MAX REPLACEMENT NUMBER

            if (count <= Integer.valueOf(maxReplacements[i]))
            {
                resultArray[i] = 1;
            }

            else
            {
                resultArray[i] = 0;
            }
        }
        return resultArray;
    }
}