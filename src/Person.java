public class Person {
public abstract class person {
    // TODO implement Person and its subclasses in other Java files
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "Hello, my name is "+name;
    }

    public static class Customer extends Person {
        public Customer(String name, int age){
            super(name, age);
        }
    }

    public static class Employee extends Person {
        int hours;
        int salary;
        public Employee(String name, int age, int hours, int salary){
            super(name, age);
            this.hours = hours;
            this.salary = salary;
        }
    }

    public static class Clerk extends Employee {
        public Clerk(String name, int age, int hours, int salary){
            super(name,age,hours,salary);
        }
    }

    public static class Manager extends Employee {
        public Manager(String name, int age, int hours, int salary){
            super(name,age,hours,salary);
        }
    }
}
