package bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/17
 *  Last updated:  2018/5/17
 *  Compilation:   javac Bounce.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class Bounce {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}

class BounceFrame extends JFrame {
    private  BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    public BounceFrame() {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "start", event -> addBall());
        addButton(buttonPanel, "close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a button to a container
     * @param c
     * @param title
     * @param listener
     */
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        try {
           Ball ball = new Ball();
           comp.add(ball);

           for (int i = 1; i <= STEPS; i++) {
               ball.move(comp.getBounds());
               comp.paint(comp.getGraphics());
               Thread.sleep(DELAY);
           }


        } catch (InterruptedException e) {

        }
    }
}