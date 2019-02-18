package inheritance;


/*
 * 员工薪水调用
 * @author:Remark
 * @version: 2019-1-29
 */
public class EmployeeTest {
    public static void main(String[] args){
        Employee[] staff = new Employee[4];

        staff[0] = new Employee("xiaoA", 80000,1989,1,1);
        staff[1] = new Employee("xiaoB",90000,1988,1,5);
        staff[2] = new Employee("xiaoC",95000,1987,1,6);
        staff[3] = new Employee("xiaoA", 80000,1989,1,1);

        for (Employee e : staff){
            e.raiseSalary(15);
        }

        for (Employee e : staff){
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
        }


    }
}
