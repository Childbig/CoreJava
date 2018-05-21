package chapter3;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.math.BigInteger;
import java.util.Scanner;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       02/04/2018
 *  Last updated:  02/04/2018
 *  Compilation:   javac BigInterTest.java
 *  Execution:     java HelloWorld
 *  Description:   This Program uses big numbers to compute the
 *      `          odds of winning the grand prize in a lottery
 *
 *----------------------------------------------------------------*/
public class BigInterTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw?");
        int n = in.nextInt();

        /*
            compute binomial coefficient n * (n - 1) * (n - 2)*...*(n - k + 1)/( 1 * 2 * 3...*k)

         */
        BigInteger lotteryOdds = BigInteger.ONE;

        for(int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf( n - i + 1)
                    .divide(BigInteger.valueOf(i)));
        }
        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good Luck!");
    }
}
