package Staircase;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        // Write your code here
        String hash = "#";
        String sp = " ";
        int count = 0;
        while (count <n) {
            StringBuilder sb = new StringBuilder();
            int dif = n - count;
            for (int i = 1; i < dif; i++) {
//                System.out.print(sp);
                sb.append(sp);
            }
            for (int i = dif; i <= n; i++) {
//                System.out.print(hash);
                sb.append(hash);
            }
            System.out.printf("%s", sb);
            if (count < n)
                System.out.println();
            count++;
        }
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
