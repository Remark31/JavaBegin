import java.util.Scanner;

/*
 * 循环
 * @author:Remark
 * @version: 2019-1-28
 */

public class retirement {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("How much money do you need to retire?");
        double goal = in.nextDouble();

        System.out.println("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.println("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance < goal) {
            balance += payment;
            balance = balance*(1+interestRate);
            years ++;
        }

        System.out.println("you can retire in " + years + " years.");
    }
}
