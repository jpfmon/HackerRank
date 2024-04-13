package PickingNumbers;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    private static boolean checkDiff(int element, int nextElement) {
        return Math.abs(element - nextElement) <= 1;
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here

        int maxLength;
        int maxLengthUp = 1;
        int maxLengthDown = 1;

        List<Integer> lengthes = new ArrayList<>();

        for (int index = 0; index < a.size() - 2; index++ ) {
            for (int jndex = index + 1; jndex < a.size(); jndex++) {
                if (a.get(index) - a.get(jndex) == 0) {
                    maxLengthDown++;
                    maxLengthUp++;
                } else if (a.get(index) - a.get(jndex) ==1) {
                    maxLengthDown++;
                } else if (a.get(index) - a.get(jndex) == -1) {
                    maxLengthUp++;
                }
            }
            lengthes.add(maxLengthUp);
            lengthes.add(maxLengthDown);
            maxLengthUp = 1;
            maxLengthDown = 1;
        }

        maxLength = lengthes.stream().max(Integer::compare).get();
        return maxLength;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
