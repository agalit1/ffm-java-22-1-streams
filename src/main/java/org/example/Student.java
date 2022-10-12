package org.example;

import java.util.Objects;

public class Student {

    private String id;
    private String name;
    private String postalCode;
    private String age;

    public Student(String id, String name, String postalCode, String age) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(postalCode, student.postalCode) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, postalCode, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append(getId() + getName() + getPostalCode() + getAge() + "}");
        return sb.toString();
    }
}
