package ACMICPCTeam;

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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here

        TreeMap<Integer, Integer> mapTopicsTeamCount = new TreeMap<>(Comparator.reverseOrder());

        for (int index = 0; index < topic.size() - 1; index++) {
            for (int jndex = index + 1; jndex < topic.size(); jndex++) {
                int topicsCount = 0;

                BigInteger student1 = new BigInteger(topic.get(index), 2);
                BigInteger student2 = new BigInteger(topic.get(jndex), 2);

                BigInteger both = student1.or(student2);
                String bothString = both.toString(2);

                for (char c : bothString.toCharArray()) {
                    if (c == '1') {
                        topicsCount++;
                    }
                }

                if (!mapTopicsTeamCount.containsKey(topicsCount)) {
                    mapTopicsTeamCount.put(topicsCount, 1);
                } else {
                    mapTopicsTeamCount.computeIfPresent(topicsCount, (key, val) -> val + 1);
                }
            }
        }

        return Arrays.asList(mapTopicsTeamCount.firstKey(), mapTopicsTeamCount.firstEntry().getValue());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}