package com.airtribe.mediTrack.Entity;

public abstract class Person {

    protected String id;
    protected String name;
    protected int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + " [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
