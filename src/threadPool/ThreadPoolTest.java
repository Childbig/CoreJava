package threadPool;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/21
 *  Last updated:  2018/5/21
 *  Compilation:   javac ThreadPoolTest.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class ThreadPoolTest {

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /usr/local/jdk5.0/src):");
            String directory = in.nextLine();
            System.out.println("Enter keyword (e.g volatile):");
            String keyword = in.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();

            MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(counter);

            try {
                System.out.println(result.get() + "Matching files." );
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {}
            pool.shutdown();

            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();

            System.out.println("largest pool size =" + largestPoolSize);
        }
    }

}

class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    /**
     * Constructs a MatchCounter
     * @param directory the directory in which to start the search
     * @param keyword the keyword to look for
     * @param pool the thread pool for submitting subtasks
     */
    public MatchCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() {
        count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            for (File file: files) {
                if (file.isDirectory()) {
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                } else {
                    if (search(file)) count++;
                }
            }

            for (Future<Integer> result: results) {
                try {
                    count += result.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        } catch (InterruptedException e) {

        }
        return count;
    }

    /**
     * Searches a file for a given keyword.
     * @param file the file to search
     * @return true if the keyword is contained in the file
     */
    public boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }
                return found;
            }

        } catch (IOException e) {
            return false;
        }
    }
}
