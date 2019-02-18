import inheritance.Employee;

/*
 * 参数测试
 * @author:Remark
 * @version: 2019-2-11
 */
public class ParamTest {

    public static void changeInt(int x) {
        x = x * 3;
    }

    public static void changeEmploy(Employee a){
        a.raiseSalary(10.0);
    }

    public static void exchangeEmploy(Employee a , Employee b){
        Employee tmp = a;
        a = b;
        b = tmp;

        System.out.println("End of Method a's name is " + a.getName());
        System.out.println("End of Method b's name is " + b.getName());
    }


    public static void main(String[] args){
        // 普通类型值改变
        int x = 10;
        System.out.println("before X is " + x);
        changeInt(x);
        System.out.println("now X is " + x);

        // 对象的值的改变
        Employee a = new Employee("cq", 10000 , 1999, 1 , 1);
        Employee b = new Employee("wql", 20000, 2005, 3 , 3);

        System.out.println("before a's salary is " +  a.getSalary());
        changeEmploy(a);

        System.out.println("Now a's salary is " +  a.getSalary());


        // 对象的引用改变
        System.out.println("before a's Name is " +  a.getName());
        System.out.println("before b's Name is " +  b.getName());

        exchangeEmploy(a, b);

        System.out.println("Now a's Name is " +  a.getName());
        System.out.println("Now b's Name is " +  b.getName());


    }
}
