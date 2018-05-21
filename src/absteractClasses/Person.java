package absteractClasses;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/5
 *  Last updated:  2018/5/5
 *  Compilation:   javac Person.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public abstract class Person {
    public abstract String getDescription();
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
