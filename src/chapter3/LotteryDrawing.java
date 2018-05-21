package chapter3;

import java.util.Arrays;
import java.util.Scanner;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       02/04/2018
 *  Last updated:  02/04/2018
 *  Compilation:   javac LotteryDrawing.java
 *  Execution:     java HelloWorld
 *  Description:   This program demonstrates array manipulation
 *
 *----------------------------------------------------------------*/
public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw?");
        int n = in.nextInt();

        // fill an array with number 1 2 3 ... n
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i + 1;

        // draw k numbers and pyt the into a second array
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);

            result[i] = numbers[r];

            numbers[r] = numbers[n - 1];
            n--;
        }

        Arrays.sort(result);

        System.out.println("Bet the following combination. It'll make you rich!");
        for(int i : result)
            System.out.println(i);

    }
}
