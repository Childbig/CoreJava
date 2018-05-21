package absteractClasses;

import java.util.Random;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/5
 *  Last updated:  2018/5/5
 *  Compilation:   javac PersonTest.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class PersonTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Person[] people = new Person[2];

        people[0] = new Employee("Harry Hacker", 50000, 1989, 10 ,1);
        people[1] = new Student("Harry Hacker",  "computer science");

        for(Person p: people) {
            System.out.println(p.getName() + "," + p.getDescription());
        }


        Random generator = new Random();
        Class c1 = generator.getClass();
        String name = c1.getName();
        System.out.println(name);

        String dassName = "java.util.Random";
        Class cl = Class.forName(dassName);


    }
}
