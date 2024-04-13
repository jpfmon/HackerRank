package BetweenTwoSets;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here

        AtomicInteger count = new AtomicInteger();
        Integer maxInB = Collections.min(b);
        IntStream.rangeClosed(1, 100).forEach(el -> {
            if (el > maxInB) return;
            if (checkAllinAAreFactorOfElement(el, a) && checkElementIsFactorOfAllInB(el, b)) count.getAndIncrement();
        });

        return count.get();
    }

    private static boolean checkElementIsFactorOfAllInB(int el, List<Integer> b) {
        for (Integer number : b) {
            if (el > number) return false;
            if (!checkFactor(number, el)) return false;
        }

        return true;
    }

    private static boolean checkAllinAAreFactorOfElement(int el, List<Integer> a) {
        for (Integer number : a){
            if (el < number) return false;
            if (!checkFactor(el, number)) return false;
        }

        return true;
    }


    private static boolean checkFactor(Integer number, Integer factorCandidate) {

        System.out.println(number + " is divisble by? " + factorCandidate);
        System.out.println(number % factorCandidate == 0);
        return number % factorCandidate == 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int m = Integer.parseInt(firstMultipleInput[1]);
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());

        List<Integer> arr = new ArrayList<>(Arrays.asList(2,4));

        List<Integer> brr = new ArrayList<>(Arrays.asList(16, 32, 96));




        int total = Result.getTotalX(arr, brr);

        System.out.println("TOTAL ELEMENTS: " + total);

//        bufferedWriter.write(String.valueOf(total));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
