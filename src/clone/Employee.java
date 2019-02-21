package clone;


import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Employee的clone相关测试
 *
 * @author remark
 * @version 2019-2-21
 */
public class Employee implements Cloneable {
    private String name;
    private Date hireDate;
    private double salaray;

    public Employee(String name, double salaray) {
        this.name = name;
        this.salaray = salaray;
        this.hireDate = new Date();
    }

    public String getName() {
        return this.name;
    }

    public Date getHireDate() {
        return (Date) this.hireDate.clone();
    }

    public double getSalaray() {
        return this.salaray;
    }

    public void setRaise(double bypersent) {
        this.salaray = this.salaray * (1 + bypersent / 100);
    }

    public void setHireDate(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        this.hireDate.setTime(newHireDay.getTime());
    }

    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();

        cloned.hireDate = (Date) this.hireDate.clone();

        return cloned;
    }

    public String toString() {
        Class cl = this.getClass();
        return cl.getName() + "[name=" + this.name
                + ",salaray=" + this.salaray + ",hireDate="
                + this.hireDate + "]";
    }


    public static void main(String[] args) {
        try {
            Employee orignal = new Employee("zf", 99999);
            Employee deepcopy = orignal.clone();
            Employee swallowcopy = orignal;

            orignal.setHireDate(2015, 3, 20);
            System.out.println("original " + orignal);
            System.out.println("deepcopy " + deepcopy);
            System.out.println("swallowcopy " + swallowcopy);






        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
