package com.model;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Raagul Srinivasan
 * 
 *         Class to Implement Relation between Two Circles
 * 
 *         Compare the Co-ordinates of two circles and determine whether their
 *         relation is one of the below
 * 
 *         Touching, Concentric, Disjoint-Outside, Disjoint-Inside, Intersecting
 *
 */
public class TwoCircles
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // READ THE NUMBER OF INPUTS
        int num = sc.nextInt();
        sc.nextLine();

        String[] info = new String[num];

        // READ THE NUMBER OF INPUT VALUES
        for (int i = 0; i < info.length; i++)
        {
            info[i] = sc.nextLine();
        }

        // METHOD CALL TO DETERMINE RELATION
        String[] result = circles(info);

        System.out.println(Arrays.toString(result));
    }


    static String[] circles(String info[])
    {

        String[] resultList = new String[info.length];

        for (int i = 0; i < info.length; i++)
        {
            String result = null;

            String circle = info[i];

            // CONVERTING STRING TO INTEGER FOR FURTHER PROCESSING
            String[] splitStr = circle.split("\\s+");

            int x0 = Integer.parseInt(splitStr[0]);
            int y0 = Integer.parseInt(splitStr[1]);
            int r0 = Integer.parseInt(splitStr[2]);
            int x1 = Integer.parseInt(splitStr[3]);
            int y1 = Integer.parseInt(splitStr[4]);
            int r1 = Integer.parseInt(splitStr[5]);


            // CALCULATING DISTANCE AND RADIUS
            double distance = (((x0 - x1) * (x0 - x1)) + ((y0 - y1) * (y0 - y1)));
            double radiusSumSquare = (r0 + r1) * (r0 + r1);
            double radiusDiffSquare = (r0 - r1) * (r0 - r1);

            // CHECK FOR TOUCHING
            if (Math.sqrt(distance) == Math.abs(r0 + r1) || Math.sqrt(distance) == Math.abs(r0 - r1))
            {

                result = "Touching";
            }

            // CHECK FOR CONCENTRIC
            if ((x0 == x1) && (y0 == y1))
            {

                result = "Concentric";
            }

            // CHECK FOR INTERSECTING
            if (radiusDiffSquare < distance && distance < radiusSumSquare)
            {
                result = "Intersecting";
            }

            // CHECK FOR DISJOINT-OUTSIDE
            if (Math.sqrt(distance) > (r0 + r1))
            {

                result = "Disjoint-Outside";
            }

            // CHECK FOR DISJOINT-INSIDE
            if (Math.sqrt(distance) < (r0 + r1) && (x0 != x1) && (y0 != y1))
            {

                result = "Disjoint-Inside";
            }

            resultList[i] = result;
        }

        return resultList;
    }
}