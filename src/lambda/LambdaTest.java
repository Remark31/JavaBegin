package lambda;


import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Lambda表达式测试
 *
 * @author remark
 * @version 2019-2-21
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};

        System.out.println(Arrays.toString(planets));

        Arrays.sort(planets, (frist,second) -> frist.length() - second.length());

        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event -> System.out.println("now Time is " + new Date()));
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
