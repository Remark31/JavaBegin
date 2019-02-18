package abstractClasses;


/*
 * 抽象类学生实现
 * @author:Remark
 * @version: 2019-2-14
 */
public class Student extends Person {
    private String major;

    /**
     * @param name the student's name
     * @param major the student's major
     */

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    public String getDescription() {
        return String.format("a student majoing in %s", major);
    }

    public static void main(String[] args) {
        Person[] ps = new Person[2];
        ps[0] = new Student("cq", "cs");
        ps[1] = new Employee("cq",10000,2014,3,19);

        System.out.println(ps[0].getDescription());
        System.out.println(ps[1].getDescription());
    }
}
