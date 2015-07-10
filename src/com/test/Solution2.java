package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author raghunandanG
 *
 */
public class Solution2 {

    public static void main(String[] args) {
        /**
         * Here we are handling which are coming from command line arguments.
         */
        long temp =0;
        if (args.length != 0) {
            int inputArr[] = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                try{
                    temp = Long.parseLong(args[i]);
                    /**
                     * This check is done to test that input element should be in Integer range only.
                     */
                    if (temp != (int) temp) {
                        System.out.println("Number entered+ "+ temp + " has value greater than the Integer maximum value : " + Integer.MAX_VALUE);
                        System.out.println("Exiting...");
                        return;
                    }else{
                        inputArr[i] = (int) temp;
                    }
                }catch(Exception exception){
                    System.out.println("Exception occured while formatting : "+args[i]);
                    System.out.println("Please provide valid input.");
                    return;
                }
            }
            display(getModifiedArray(inputArr));
        } else {
            /**
             * Input using Buffered Reader.
             */
            String line = "";
            try{
                System.out.println("Please enter input (eg. 1 2 3 4): ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                line = br.readLine();
                String str[] = line.trim().split(" ");
                int inputArr[] = new int[str.length];
                for (int i = 0; i < str.length; i++) {
                    try{
                        temp = Long.parseLong(str[i]);
                        if (temp != (int) temp) {
                            System.out.println("Number entered+ "+ temp + " has value greater than the Integer maximum value : " + Integer.MAX_VALUE);
                            System.out.println("Exiting...");
                            return;
                        }else{
                            inputArr[i] = (int) temp;
                        }
                    }catch(Exception exception){
                        System.out.println("Exception occured while formatting : "+str[i]);
                        System.out.println("Please provide valid input.");
                        return;
                    }
                }
                display(getModifiedArray(inputArr));
            }catch(Exception exception){
                System.out.println("Exception occured while formatting : "+line);
                System.out.println("Please provide valid input.");
                return;
            }
        }
    }

    public static void display(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            System.out.print(inputArr[i] + " ");
        }
        System.out.println();
    }

    public static int[] getModifiedArray(int[] inputArr) {
        long sum = 0;
        if (inputArr.length < 2) {
            return inputArr;
        }
        for (int i = 0; i < inputArr.length; i++) {
            sum += inputArr[i];
            /**
             * This check is done to test that sum should be in Integer range only.
             */
            if (sum != (int) sum) {
                System.out.println("Sum exceeds than the Integer Maximum value : " + Integer.MAX_VALUE);
                System.out.println("Returning same array without modification.Exiting...");
                return inputArr;
            }
        }

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = (int) (sum - inputArr[i]);
        }
        return inputArr;
    }

}
