package Stream;

import com.sun.tools.javac.util.List;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/5/26
 *  Last updated:  2018/5/26
 *  Compilation:   javac Stream.java
 *  Description: 
 *
 ******************************************************************************/


public class Stream {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("123")), StandardCharsets.UTF_8);
        java.util.List<String> words = Arrays.asList(contents.split("123"));

        long count = words.stream().filter(w -> w.length() > 12).count();
    }
}
