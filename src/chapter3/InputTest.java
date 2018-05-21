package chapter3;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       02/04/2018
 *  Last updated:  02/04/2018
 *  Compilation:   javac InputTest.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class InputTest {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("What is your name");
        String name = in.nextLine();

        System.out.println("How old are you?");
        int age = in.nextInt();

        System.out.println("Hello," + name + ". Next year, you'll be " + (age + 1));
    }
}
