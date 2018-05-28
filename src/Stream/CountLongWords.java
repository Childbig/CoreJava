package Stream;


import chapter3.BigInterTest;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/5/26
 *  Last updated:  2018/5/26
 *  Compilation:   javac CountLongWords.java
 *  Description: 
 *
 ******************************************************************************/


public class CountLongWords {
    public static void main(String[] args) throws IOException {
        /*String contens = new String(Files.readAllBytes(Paths.get("/Users/sa/Downloads/删除的站点.txt")),StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contens.split("\\PL+"));
        long count = 0;
        for (String w: words) {
           if (w.length() > 12) count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);*/

        Stream<String> echos = Stream.generate(() -> "echo");

        Stream<Double> randoms = Stream.generate(Math:: random);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));




    }
}
