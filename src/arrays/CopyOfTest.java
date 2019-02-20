package arrays;


import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * 使用反射实现的copy测试方法
 * @author:Remark
 * @version: 2019-2-19
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("======Exception====");
        b = (String[]) badCopyOf(b, 10);
    }

    /**
     *
     * @param a the array to grow
     * @param newLength the new length
     * @return
     */
    public static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0 , newArray, 0 , Math.min(a.length, newLength));
        return newArray;
    }

    /**
     *
     * @param a the array to grow
     * @param newLength the new length
     * @return
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if ( !cl.isArray() ) {
            return null;
        }

        Class componentType = cl.getComponentType();

        int length = Array.getLength(a);

        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a , 0 , newArray, 0 , Math.min(length, newLength));
        return newArray;

    }
}
