package chapter4;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/4
 *  Last updated:  2018/5/4
 *  Compilation:   javac ParamTest.java
 *  Execution:     java HelloWorld
 *  Description:   The program demonstrate parameter passing in java
 *
 *----------------------------------------------------------------*/
public class ParamTest {

}

class Employe
{
    private String name;
    private double salary;

    public Employe(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

}
