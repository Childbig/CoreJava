package chapter3;

import java.util.Scanner;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       02/04/2018
 *  Last updated:  02/04/2018
 *  Compilation:   javac LotteryOdds.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class LotteryOdds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw?");
        int n = in.nextInt();

        /*
        compute binomial coefficient n * (n-1) * (n * 2)
         */
        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
        }

        System.out.println("your odds are 1 in" + lotteryOdds + ". Good luck!");
    }
}
