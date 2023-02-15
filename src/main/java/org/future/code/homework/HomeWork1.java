package org.future.code.homework;

import java.util.List;

public class HomeWork1 {
/*
    Домашнее задание:
    Реализовать класс «Студент», придумать для него 3 подходящих поля и 2 подходящих метода
    (конструкторы, сеттеры и геттеры не в счёт). Защитить хотя бы одно поле модификатором
    доступа private, реализовать для него сеттер и геттер.

    Добавить класс «Преподаватель», одним из полей которого является массив из 3 студентов.
    Реализовать метод, который выводит информацию о всех студентах данного преподавателя
    согласно полям, придуманным в предыдущем задании. Дополнительно реализовать метод,
    вызывающий метод(ы) студентов.

    Добавить класс «Университет». Реализовать в нём функцию main, в которой нужно «трудоустроить»
    в университет 3 преподавателей, а также заполнить всю необходимую информацию о преподавателях
    и их студентах. Вызвать реализованные для преподавателей и студентов методы.
 */
    public static void main(String[] args) {

    }
}

class Student{
    protected StringBuilder name;
    protected List<Integer> marks;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(StringBuilder name, List<Integer> marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    public void callAge(){
        System.out.println();
    }
}
