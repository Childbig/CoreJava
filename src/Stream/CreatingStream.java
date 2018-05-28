package Stream;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/5/26
 *  Last updated:  2018/5/26
 *  Compilation:   javac CreatingStream.java
 *  Description:   practice a Streams
 *
 ******************************************************************************/


public class CreatingStream {

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream
                .limit(SIZE + 1)
                .collect(Collectors.toList());

        System.out.println(title + ": ");

        for(int i = 0; i < firstElements.size(); i++) {
            if (i > 0) System.out.print(", ");
            if (i < SIZE) System.out.print(firstElements.get(i));
            else System.out.println("...");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/sa/ProgramStudy/basicJava/CoreJava/alice3-.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);

        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song", song);

        Stream<String> slience = Stream.empty();
        show("slience", slience);

        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echo", echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE,
                n -> n.add(BigInteger.ONE));
        show("integers", integers);

        Stream<String> wordsAnotherWay =
                Pattern.compile("\\PL+").splitAsStream(
                        contents);
        show("wordsAnotherWay", wordsAnotherWay);

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){
            show("lines", lines);
        }
    }
}
