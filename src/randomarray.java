import java.util.Arrays;

/*
 * 随机数组
 * @author:Remark
 * @version: 2019-1-28
 */
public class randomarray {
    static final int N = 100;
    static final int K = 10;
    public static void main(String[] args){
        int[] numbers = new int[N];
        for(int i = 0; i < N ; i ++){
            numbers[i] = i+1;
        }

        int[] result = new int[K];
        int n = N;
        for(int i = 0 ; i < K ; i ++){
            int r = (int) (Math.random() * n);
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n --;
        }

        Arrays.sort(result);
        for(int i : result){
            System.out.println(i);
        }

    }
}
