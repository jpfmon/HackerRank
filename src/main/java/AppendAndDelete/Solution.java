package AppendAndDelete;

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
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here

        int toDelete = 0;
        int index = 0;

        while (index < s.length() && index < t.length() && s.charAt(index) == t.charAt(index)) index++;

        toDelete = s.length() - index;
        int ops = toDelete + (t.length() - index);

        if (ops <= k && ((k - ops) % 2 == 0 || (k - ops) > 2 * index)) {
            return "Yes";
        } else {
            return "No";
        }
}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        String t = bufferedReader.readLine();
//
//        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete("abcd", "abcdert", 10);

        System.out.println(result);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}