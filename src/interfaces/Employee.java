package interfaces;


import java.util.Arrays;

/*
 * 员工类实现接口
 * @author:Remark
 * @version: 2019-2-21
 */
public class Employee implements Comparable<Employee> {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    /**
     * 实现compareTo接口
     * @param o 一个Employee对象
     * @return
     */
    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.getSalary(), o.getSalary());
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new Employee("cq", 25000.1);
        employees[1] = new Employee("zf", 30001.5);
        employees[2] = new Employee("yzb", 9000);

        Arrays.sort(employees);

        employees[0].raiseSalary(300);

        for (Employee e : employees) {
            System.out.println("name: " + e.getName() + "  salary: " + e.getSalary());
        }
    }
}
