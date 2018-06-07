package collecting;

import java.util.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/5/29
 *  Last updated:  2018/5/29
 *  Compilation:   javac CollectingResults.java
 *  Description: 
 *
 ******************************************************************************/


public class CollectingResults {

    public static Stream<String> noVowels() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("/Users/sa/ProgramStudy/basicJava/CoreJava/alice3-.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();
        return words.map(s -> s.replaceAll("[aeiouAEIOU]]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.print(label + ": " + set.getClass().getName());
        System.out.println("["
                    + set.stream().limit(10).map(Object::toString)
                    .collect(Collectors.joining(",")) + "]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object array:" + numbers);

        try {
            Integer number = (Integer) numbers[0];
            System.out.println("number:" + number);
            System.out.println("The following statement throws an exception");
            Integer[] numbers2 = (Integer[]) numbers;
        } catch (ClassCastException ex) {
            System.out.println(ex);
        }

        Integer[] numbers3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array:" + numbers3);

        Set<String> noVowelSet = noVowels()
                .collect(Collectors.toSet());
        show("noVowelSet", noVowelSet);

        TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("moVowelTreeSet", noVowelTreeSet);

        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println("Joining: " + result);
        result = noVowels().limit(10).collect(Collectors.joining(","));
        System.out.println("Joining with commas:" + result);

        IntSummaryStatistics summary = noVowels().collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double maxWordLength = summary.getMax();
        System.out.println("Average word length: " + averageWordLength);
        System.out.println("Max word length: " + maxWordLength);
        System.out.println("forEach:");
        noVowels().limit(10).forEach(System.out::println);
    }
}
