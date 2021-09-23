package base.reflection;

/**
 * @author Seven.Xu
 * @version 2021/5/3
 **/
public class Reflection {

    private static void createClassFromClassForName() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> personClass = Class.forName("base.reflection.Person");
        Person person = (Person) personClass.newInstance();
        person.setName("xdq");
        person.printName();
    }

    private static void createClassFromObjectClass() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        person.setName("xdq");
        person.printName();
    }

    private static void createClassFromClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> personClass = ClassLoader.getSystemClassLoader().loadClass("base.reflection.Person");
        Person person = (Person) personClass.newInstance();
        person.setName("xdq");
        person.printName();
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        createClassFromClassForName();
//        createClassFromObjectClass();
        createClassFromClassLoader();
    }
}
