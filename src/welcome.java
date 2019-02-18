import static java.lang.Math.*;
/*
 * 游戏开始
 * @version 2019-1-25
 * @author Remark
 */
public class welcome {
    public static void main(String[] args){
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        for(int i = 0 ; i < greeting.length() ; i ++){
            System.out.println("=");
        }
        double y = pow(5.0,3);
        System.out.println(y);
    }
}
