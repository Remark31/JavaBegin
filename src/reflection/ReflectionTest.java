package reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/*
 * 反射，分析输出类的域，方法，构造函数
 * @author:Remark
 * @version: 2019-2-19
 */
public class ReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Class name :");
            name = in.next();
        }

        try {

            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();

            String modifiers = Modifier.toString(cl.getModifiers());

            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);

            if (supercl != null && supercl != Object.class) {
                System.out.print(" extends " + supercl.getName());
            }

            System.out.print("\n{\n");

            printConstructors(cl);
            System.out.println();

            printMethods(cl);
            System.out.println();

            printFields(cl);
            System.out.println("}");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 输出类的所有构造函数
     *
     * @param cl a Class
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("   ");

            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            // 参数类型
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                    System.out.print(paramTypes[j].getName());
                }
            }
            System.out.println(");");

        }
    }

    /**
     * 输出方法的信息
     *
     * @param cl a Class
     */
    public static void printMethods(Class cl) {

        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");

            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }

            System.out.print(retType.getName() + " " + name + "(");

            Class[] paraTypes = m.getParameterTypes();

            for (int j = 0 ; j < paraTypes.length ; j ++){
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(paraTypes[j].getName());
            }
            System.out.println(");");
        }


    }

    /**
     * 输出类的域
     * @param cl
     */

    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();

            System.out.print("    ");

            String modifiers = Modifier.toString(f.getModifiers());

            if (modifiers.length() > 0 ) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name  + ";");

        }
    }
}
