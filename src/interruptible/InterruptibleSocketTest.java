package interruptible;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/6/8
 *  Last updated:  2018/6/8
 *  Compilation:   javac InterruptibleSocketTest.java
 *  Description: 
 *
 ******************************************************************************/


public class InterruptibleSocketTest {




}


class InterruptibleSocketFrame extends JFrame {

    private Scanner in;
    private JButton interruptiableButton;
    private JButton blockingButton;
    private JButton cancelButton;
    private JTextArea message;
    private TestServer server;
    private Thread connectThread;


    public InterruptibleSocketFrame() {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);

        final int TEXT_ROWS = 20;
        final int TEXT_COLUMNS = 60;


    }


}


/**
 * A multithreaded server that listens to port 8189 and sends numbers to client,
 * simulating a hanging server after 10 numbers
 */
class TestServer implements Runnable {
    @Override
    public void run() {
        try (ServerSocket s = new ServerSocket(8189)){
            while (true) {
                Socket incoming = s.accept();
                Runnable r = new TestServerHandler(incoming);
                Thread t = new Thread(r);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class handles the client input for one server socket connection
 */
class TestServerHandler implements Runnable {
    private Socket incoming;
    private int counter;

    /**
     * Constructs a handler
     * @param incoming
     */
    public TestServerHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try {
            try {
                OutputStream outStream = incoming.getOutputStream();
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(outStream, "UTF-8"),
                        true
                );

                while (counter < 100) {
                    counter++;
                    if (counter <= 10) out.println(counter);
                    Thread.sleep(100);
                }

            } finally {
                incoming.close();
            }
        } catch (Exception e) {

        }
    }
}

