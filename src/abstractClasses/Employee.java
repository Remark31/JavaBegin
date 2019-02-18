package abstractClasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/*
 * 抽象类员工功能
 * @author:Remark
 * @version: 2019-2-14
 */
public class Employee extends Person {
    private double salary; // 以分为单位
    private LocalDate hireDay;

    public Employee(String name, double s, int year, int month, int day) {
        super(name);
        this.salary = s;
        this.hireDay = LocalDate.of(year, month, day);
    }


    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireDay() {
        return this.hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        salary += raise;
    }

    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", this.salary);
    }

    public int hashCode() {
        return Objects.hash(this.getName(), this.salary, this.hireDay);
    }

    public String toString() {
        return this.getClass().getName()
                + "[name=" + this.getName()
                + ",salary=" + this.salary
                + ",hireDay=" + this.hireDay
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Employee other = (Employee) obj;

        return this.getName().equals(other.getName()) && this.salary == other.salary && this.hireDay.equals(other.hireDay);

    }


    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();


        staff.add(new Employee("xiaoA", 80000, 1989, 1, 1));
        staff.add(new Employee("xiaoB", 90000, 1988, 1, 5));
        staff.add(new Employee("xiaoC", 95000, 1987, 1, 6));
        staff.add(new Employee("xiaoA", 80000, 1989, 1, 1));


        for (Employee e : staff) {
            e.raiseSalary(15);
        }

        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
        }

        System.out.println("the equal is " + staff.get(0).equals(staff.get(1)));
        System.out.println("the equal is " + staff.get(0).equals(staff.get(3)));
        System.out.println("the ans is " + staff.get(3).toString());

        Class cl = staff.get(0).getClass();
        System.out.println("the class is " +  cl.getName());


        try {
            Class cc = Class.forName("abstractClasses.Employee");
            System.out.println("the class is " +  cc);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
