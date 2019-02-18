package inheritance;


/*
 * 管理员类测试
 * @author:Remark
 * @version: 2019-2-14
 */
public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("cq",10000,2013,9,30);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("wql",8000,2014,11,30);
        staff[2] = new Employee("zf",9000,2015,5,30);

        for (Employee e : staff){
            System.out.println("name= " + e.getName() + ", salary= " + e.getSalary());
        }

    }
}
