package CountingValleys;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        AtomicBoolean isSeaLevel = new AtomicBoolean(true);
        AtomicBoolean isOverSea = new AtomicBoolean(false);
        AtomicBoolean isBelowSea = new AtomicBoolean(false);
        AtomicInteger count = new AtomicInteger();
        AtomicInteger levelsBelowSea = new AtomicInteger();
        AtomicInteger levelsOverSea = new AtomicInteger();

        path.chars().forEach(el -> {
            if (el == 'D') {
                if (isSeaLevel.get()) {
                    isSeaLevel.set(false);
                    isBelowSea.set(true);
                    levelsBelowSea.getAndIncrement();
                } else if (isOverSea.get()) {
                    levelsOverSea.getAndDecrement();
                    if (levelsOverSea.get() == 0) {
                        isSeaLevel.set(true);
                        isOverSea.set(false);
                    }
                } else if (isBelowSea.get()) {
                    levelsBelowSea.getAndIncrement();
                }
            } else if (el =='U') {
                if (isSeaLevel.get()) {
                    isSeaLevel.set(false);
                    isOverSea.set(true);
                    levelsOverSea.getAndIncrement();
                } else if (isOverSea.get()) {
                    levelsOverSea.getAndIncrement();
                } else if (isBelowSea.get()) {
                    levelsBelowSea.getAndDecrement();
                    if (levelsBelowSea.get() == 0) {
                        isBelowSea.set(false);
                        isSeaLevel.set(true);
                        count.getAndIncrement();
                    }
                }
            }
        });
        return count.get();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
