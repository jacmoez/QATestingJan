package org.example;

/**
 * OOP
 * Object
 * Class
 * Inheritance
 * Polymorphism
 * Abstraction
 * Encapsulation
 *
 * Class
 * Interface
 * Method
 * Variable
 * Package
 * Constant
 *
 * Class Member
 *   -Fields
 *   -Methods
 *   -Constructors
 *   -Blocks
 *   -Nested Class
 *
 */
public class OOP {
    public static void main(String[] args) {
        String name = "Maung Maung";
        System.out.println("Hello Java");
    }
}

/**
 * Instance Variable
 * static variable
 * local variable
 */

class Student {
    int id;
    String name;
}

class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.id);
        System.out.println(s1.name);
    }
}

//initializing object
//1 reference variable
//2 method
//3 constructor

class TestStudent1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.id = 10;
        s1.name = "Maung Maung";

        s2.id = 202;
        s2.name = "Aung Aung";
        System.out.println("Student ID: " + s1.id );
        System.out.println("Student Name: " + s1.name);
        System.out.println("===============================");
        System.out.println("Student ID: " + s2.id );
        System.out.println("Student Name: " + s2.name);

    }
}

class Student2 {
    int id;
    String name;
    void insert(int i, String n){
        id = i;
        name = n;
    }
    void studentInfo(){
        System.out.println("Student ID: " + id + "\nStudent Name: " + name + "\n=====================================");
    }
}

class TestStudent2{
    public static void main(String[] args) {
        Student2 s1 = new Student2();
        Student2 s2 = new Student2();
        s1.insert(101, "Maung Maung");
        s2.insert(202,"Aung Aung");

        s1.studentInfo();
        s2.studentInfo();
    }
}

class Student3 {
    int id;
    String name;

    Student3(int i, String n){
        id = i;
        name = n;
    }
    void studentInfo(){
        System.out.println("Student ID: " + id + "\nStudent Name: " + name + "\n=====================================");
    }

}

class TestStudent3 {
    public static void main(String[] args) {
        Student3 s1 = new Student3(101,"Maung Maung");
        Student3 s2 = new Student3(202,"Aung Aung");
        s1.studentInfo();
        s2.studentInfo();
    }
}

class Loop1 {
    public static void main(String[] args) {
        int [] arr = {10,20,30, 40, 50, 60};
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        System.out.println("======================");

        for(int i : arr){
            System.out.println(i);
        }
    }
}