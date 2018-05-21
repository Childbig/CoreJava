package interfaces;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/6
 *  Last updated:  2018/5/6
 *  Compilation:   javac Employee.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class Employee implements Comparable<Employee>{

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * Compares employees by salary
     * @param o other another Employee object
     * @return a negative value if this employee has a lower salary then
     * otherObject . 0 if the salarys are the same , a positive value otherwise
     */
    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}
