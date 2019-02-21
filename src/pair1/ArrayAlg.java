package pair1;


/**
 * 泛型设计
 * @author remark
 * @version 2019-2-21
 */
public class ArrayAlg {

    public static void main(String[] args){
        String[] a = {"def", "abe", "akk" , "mppu", "ypp;" , "ufff" , "zzoik", "zzzko"};
        System.out.println(minmax(a));
    }

    public static Pair<String> minmax(String[] a) {

        if (a == null || a.length == 0) {
            return null;
        }

        String min = a[0];
        String max = a[0];

        for (int i = 1 ; i < a.length ; i ++){
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0){
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}
