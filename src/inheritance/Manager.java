package inheritance;


/*
 * 管理员类
 * @author:Remark
 * @version: 2019-2-14
 */
public class Manager extends Employee {
    private double bonus;


    /**
     * @param name the employee's name
     * @param salary the salary
     * @param year the hire year
     * @param month the hire month
     * @param day the hire day
     */
    public Manager(String name , double salary , int year , int month , int day) {
        super(name , salary , year , month , day);
        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        return super.getSalary() + this.bonus;
    }
}
