package com.csizg.rxjava.entity;

/**
 * Created by Leo on 2017/11/2.
 *
 * @description：
 */

public class People {
    private int id;
    private int age;
    private String name;

    public People(int id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;

    }
    public People(int id, int age){
        this.id = id;
        this.age = age;

    }
    public People(int id, String name){
        this.id = id;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
