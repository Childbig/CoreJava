package threaded;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/6/8
 *  Last updated:  2018/6/8
 *  Compilation:   javac ThreadedEchoServer.java
 *  Description: 
 *
 ******************************************************************************/


public class ThreadedEchoServer {
    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(8189)) {
            int i = 0;

            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);

                Runnable r = new ThreadedEchoHandler(incoming);
                Thread thread = new Thread(r);
                thread.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    /**
     * Constructs a handler
     * @param incomingSocket the incoming socket
     */
    public ThreadedEchoHandler(Socket incomingSocket) {
        this.incoming = incomingSocket;
    }

    @Override
    public void run() {
        try (InputStream instream = incoming.getInputStream();
             OutputStream outStream = incoming.getOutputStream()) {
            Scanner in = new Scanner(instream, "UTF-8");
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(outStream, "UTF-8"),
                    true
            );

            //echo client input
            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE"))
                    done = true;
            }


        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
