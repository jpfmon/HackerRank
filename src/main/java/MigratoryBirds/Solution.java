package MigratoryBirds;

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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here

        Map<Integer, Integer> treeMap = getMapCount(arr);

        int max = treeMap.values().stream().max(Integer::compare).get();

        return treeMap.entrySet().stream().filter(el-> el.getValue() == max).findFirst().get().getKey();
    }

    private static Map<Integer, Integer> getMapCount(List<Integer> arr) {
        Map<Integer, Integer> treeMap = new TreeMap<>();

        arr.stream().forEach(el -> {
            if (treeMap.containsKey(el)) {
                treeMap.computeIfPresent(el, (key, val) -> val + 1);
            } else {
                treeMap.put(el, 1);
            }
        });
        return treeMap;
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
