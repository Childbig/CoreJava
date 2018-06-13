package urlConnection;

import java.util.List;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.Scanner;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/6/8
 *  Last updated:  2018/6/8
 *  Compilation:   javac URLConnectionTest.java
 *  Description:   This program connects to an URL and displays the response header                     data and first 10 lines of the requested data Supply the URL and
                    and an optional username and password (for HTTP basic                                authentication) on the command line
 *
 ******************************************************************************/


public class URLConnectionTest {
    public static void main(String[] args) {
        try {
            String urlName;
            if (args.length > 0) urlName = args[0];
            else urlName = "http://horstmann.com";

            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();

            if (args.length > 2) {
                String username = args[1];
                String password = args[2];
                String input = urlName + ":" + password;
                Base64.Encoder encoder = Base64.getEncoder();
                String encoding = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
                connection.setRequestProperty("Authorization", "Basic " + encoding);
            }

            connection.connect();

            // print header fields
            Map<String, List<String>> headers = connection.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue())
                    System.out.println(key + ": " + value);
            }

            // print convenience function
            System.out.println("------------------");
            System.out.println("getContentType: " + connection.getContentType());
            System.out.println("getContentLength: " + connection.getContentLength());
            System.out.println("getContentEncoding: " + connection.getContentEncoding());
            System.out.println("getData: " + connection.getDate());
            System.out.println("getExpiration: " + connection.getExpiration());
            System.out.println("getLastModifed: " + connection.getLastModified());
            System.out.println("-------------------");

            String encoding = connection.getContentEncoding();
            if (encoding == null) encoding = "UTF-8";
            try (Scanner in = new Scanner(connection.getInputStream(), encoding)) {
                // print first ten lines of contents
                for (int n = 1; in.hasNextLine() && n <= 10; n++)
                    System.out.println(in.nextLine());
                if (in.hasNextLine()) System.out.println("....");


            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
