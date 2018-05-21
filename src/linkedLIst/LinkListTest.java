package linkedLIst;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/15
 *  Last updated:  2018/5/15
 *  Compilation:   javac LinkListTest.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class LinkListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Erica");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> alter = a.listIterator();
        Iterator<String> biter = b.iterator() ;


        while (biter.hasNext()) {
            if (alter.hasNext()) alter.next();
            alter.add(biter.next());
        }

        System.out.println(a);

        biter = b.iterator();

        while (biter.hasNext()) {
            biter.next();
            if (biter.hasNext()) {
                biter.next();
                biter.remove();
            }
        }

        System.out.println(b);

        a.removeAll(b);
        System.out.println(a);
    }
}
