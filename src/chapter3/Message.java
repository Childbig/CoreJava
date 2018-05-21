package chapter3;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       02/04/2018
 *  Last updated:  02/04/2018
 *  Compilation:   javac Message.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class Message {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("-h"))
            System.out.println("hello,");
        else if (args[0].equals("-g"))
            System.out.println("Goodbye,");
        for (int i = 1; i < args.length; i++) {
            System.out.println("  " + args[i]);
        }
        System.out.println("!");
    }
}
