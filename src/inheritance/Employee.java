package inheritance;

import java.time.LocalDate;

/*
 * 员工薪水基础功能
 * @author:Remark
 * @version: 2019-1-29
 */
public class Employee {

    private String name;
    private double salary; // 以分为单位
    private LocalDate hireDay;

    public Employee(String name, double s, int year, int month, int day) {
        this.name = name;
        this.salary = s;
        this.hireDay = LocalDate.of(year , month , day);
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public LocalDate getHireDay(){
        return this.hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = this.salary * byPercent / 100;
        salary += raise;
    }

}
