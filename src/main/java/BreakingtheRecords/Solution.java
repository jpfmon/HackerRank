package BreakingtheRecords;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here

        AtomicInteger max = new AtomicInteger(scores.get(0));
        AtomicInteger min = new AtomicInteger(scores.get(0));

        AtomicInteger countMaxChanged = new AtomicInteger();
        AtomicInteger countMinChanged = new AtomicInteger();

        scores.stream().forEach(element -> {
            if (element > max.get()) {
                countMaxChanged.getAndIncrement();
                max.set(element);
            } else if (element < min.get()) {
                countMinChanged.getAndIncrement();
                min.set(element);
            }
        });

        return new ArrayList<>(Arrays.asList(countMaxChanged.get(), countMinChanged.get()));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
