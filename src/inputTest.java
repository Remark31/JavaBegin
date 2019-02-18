import java.io.Console;
import java.util.Scanner;
/*
 * 输入输出以及console
 * @author:Remark
 * @version: 2019-1-28
 */
public class inputTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("What's your name");

        String name = in.nextLine();

        System.out.println("How old are you?");

        int age = in.nextInt();

        System.out.println("your name is " + name + " and your age is " + age);

        Console cons = System.console();
        String username = cons.readLine("User name: ");
        char[] passwd = cons.readPassword("Password: ");

        System.out.println("name is " + username + " password is " + passwd);

    }
}
