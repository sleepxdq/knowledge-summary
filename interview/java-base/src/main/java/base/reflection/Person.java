package base.reflection;

/**
 * @author Seven.Xu
 * @version 2021/5/3
 **/
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("This Person name is "+this.name);
    }
}
