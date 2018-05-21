package absteractClasses;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/5
 *  Last updated:  2018/5/5
 *  Compilation:   javac Student.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class Student extends Person{
    private String major;

    public Student(String major, String name) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
