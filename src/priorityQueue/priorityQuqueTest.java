package priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/16
 *  Last updated:  2018/5/16
 *  Compilation:   javac priorityQuqueTest.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class priorityQuqueTest {

    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements...");
        for (LocalDate data: pq) {
            System.out.println(data);
        }
        System.out.println("Removing the elements....");
        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}
