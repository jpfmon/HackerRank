package PlusMinus;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        float posRatio = 0;
        float zerRatio = 0;
        float negRatio = 0;

        AtomicInteger posCount = new AtomicInteger();
        AtomicInteger zerCount = new AtomicInteger();
        AtomicInteger negCount = new AtomicInteger();
        AtomicInteger totCount = new AtomicInteger();

        arr.stream().forEach(x -> {
            totCount.getAndIncrement();
            if (x == 0) zerCount.getAndIncrement();
            if (x < 0) negCount.getAndIncrement();
            if (x > 0) posCount.getAndIncrement();
        });

        posRatio =  posCount.floatValue() / totCount.floatValue();
        negRatio =  negCount.floatValue() / totCount.floatValue();
        zerRatio =  zerCount.floatValue() / totCount.floatValue();

        System.out.printf("%f6\n", posRatio);
        System.out.printf("%f6\n", negRatio);
        System.out.printf("%f6", zerRatio);


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}