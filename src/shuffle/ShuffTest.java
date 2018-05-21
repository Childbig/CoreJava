package shuffle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/16
 *  Last updated:  2018/5/16
 *  Compilation:   javac ShuffTest.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class ShuffTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 49; i++)
            numbers.add(i);
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
