package objectAnalyzer;


import java.util.ArrayList;

/*
 * 公用的提供toString的方法的测试
 * @author:Remark
 * @version: 2019-2-19
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1 ; i <= 5 ; i ++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
