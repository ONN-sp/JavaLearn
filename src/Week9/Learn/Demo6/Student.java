package Week9.Learn.Demo6;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private double height;
    private double weight;
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    // 使用构造函数初始化成员变量

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Double.compare(height, student.height) == 0 && Double.compare(weight, student.weight) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, weight);
    }

    public Student(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    // 学习
    public void studu() {
        System.out.println(this.name+"正在学习");
    }
}
