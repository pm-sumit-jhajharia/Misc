package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {

    public static void main(String[] args) {
        try {
            System.out.println("Please enter input String : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            System.out.println(getModifiedString(line));
        } catch (Exception exception) {
            System.out.println("Exception occured while reading input.");
        }
    }

    public static String getModifiedString(String inputString) {
        StringBuilder builder = new StringBuilder();
        /**
         * This will split all the Strings in String array by space.
         */
        String str[] = inputString.split(" ");
        int wordCount = 0; //This will keep the count of successive words.
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() == 0 || str[i].charAt(0) == ' ')
                continue;
            wordCount++;
            str[i] = str[i].trim();
            if (wordCount % 2 != 0) {
                builder.append(str[i]);
            } else {
                if (i != str.length - 1) {
                    for (int j = str[i].length() - 1; j >= 0; j--) {
                        builder.append(str[i].charAt(j));
                    }
                } else {
                    if (str[i].charAt(str[i].length() - 1) != '.')
                        builder.append(str[i].charAt(str[i].length() - 1));
                    for (int j = str[i].length() - 2; j >= 0; j--) {
                        builder.append(str[i].charAt(j));
                    }
                    if (str[i].charAt(str[i].length() - 1) == '.')
                        builder.append('.');
                }
            }
            if (i != str.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
