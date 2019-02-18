package abstractClasses;


/*
 * 抽象类人员功能
 * @author:Remark
 * @version: 2019-2-14
 */
public abstract class Person {
    public abstract String getDescription();
    private String name;


    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
