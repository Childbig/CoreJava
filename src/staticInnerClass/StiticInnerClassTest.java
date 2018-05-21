package staticInnerClass;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/9
 *  Last updated:  2018/5/9
 *  Compilation:   javac StiticInnerClassTest.java
 *  Description:   This program demonstrates the use of static inner classes
 *
 *----------------------------------------------------------------*/
public class StiticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        //ArrayAlg.Pair p = new ArrayAlg.minmax(d);


    }
}

class ArrayAlg {

    /**
     * A pair of floating-point numbers
     */
    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * Returns the first number of the pair
         * @return the first number
         */
        public double getForst() {
            return first;
        }

        /**
         * Returns the second number of the pair
         * @return the second number
         */
        public double getSecond() {
            return second;
        }

    }

    /**
     * computes both the mininum and the maximum of an array
     * @param values an array of floating-point numbers
     * @return a pair whose first element is the minimum an whose second element
     */
    public static Pair minmax(double[] values) {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;

        for(double v: values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }

        return new Pair(min, max);
    }
}
