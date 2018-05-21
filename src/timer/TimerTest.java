package timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/6
 *  Last updated:  2018/5/6
 *  Compilation:   javac TimerTest.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class TimerTest {

    public static void main(String[] args) {

    }

    ActionListener L = new TimePrinter();



}

class TimePrinter implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
