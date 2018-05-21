package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/5
 *  Last updated:  2018/5/5
 *  Compilation:   javac RefletionTest.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class RefletionTest {

    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        }
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date):");
            name = in.next();
        }
    }

    /**
     * Prints all constructors of a class
     * @param cl
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c: constructors) {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.println(modifiers + " ");
            System.out.println(name + "(");

            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j ++) {
                if (j > 0) System.out.println(", ");
                System.out.println(paramTypes[j].getName());
            }

            System.out.println(");");

        }
    }

    /**
     * Prints all methods of a class
     * @param cl
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m: methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.println("    ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.println(modifiers + "  ");
            System.out.println(retType.getName() + " " + name + "(");
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j < 0) System.out.println(", ");
                System.out.println(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all fields of a class
     * @param cl
     */
    public static void printField(Class cl) {
        Field[] fields = cl.getDeclaredFields();

    }

}
