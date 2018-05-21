package anonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/9
 *  Last updated:  2018/5/9
 *  Compilation:   javac anonymousInnerClassTest.java
 *  Description:   匿名内部类测试
 *
 *----------------------------------------------------------------*/
public class anonymousInnerClassTest {

    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit Program");
        System.exit(0);
    }

}

/**
 * a clock that prints the time in regular intervals
 */
class TalkingClock {
    /**
     * Start the clock
     * @param interval the interval between message (in milliseconds)
     * @param beep true if the clock should beep
     */
    public void start(int interval, boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}