package methods;


import java.lang.reflect.Method;

/*
 * 使用反射实现的方法调用
 * @author:Remark
 * @version: 2019-2-20
 */
public class MethodTableTest {
    public static void main(String[] args) throws Exception {

        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * 返回一个浮点数的平方
     *
     * @param x 浮点数x
     * @return
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * 输出一个表
     *
     * @param from 表的开始
     * @param to 表的结束
     * @param n 表的数量
     * @param f 表需要调用的方法
     */
    public static void printTable(double from, double to, int n, Method f) {
        System.out.println(f);

        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            try {
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f\n", x, y);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
