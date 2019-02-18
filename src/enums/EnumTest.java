package enums;


import java.util.Scanner;

/*
 * 枚举类功能
 * @author:Remark
 * @version: 2019-2-15
 */
enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    private String abbreviation;

}

public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size= " +  size);
        System.out.println("abbreviation= " + size.getAbbreviation());

        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job -- you pid attention to the _.");
        }
    }

}
