package org.future.code.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
//        Student firstStudent = new Student("Vasya", new ArrayList<Integer>(Arrays.asList(5,5,4,3)), 12);
//        Student secondStudent = new Student("Petya", new ArrayList<Integer>(Arrays.asList(5,5,5,5)), 13);
//        Student thirdStudent = new Student("Masha", new ArrayList<Integer>(Arrays.asList(1,2,4,3)), 11);
//
//        Professor professor = new Professor("SamokhinVN", "Math", new Student[]{firstStudent, secondStudent, thirdStudent});
//
//        firstStudent.callAge();
//        firstStudent.callMarks();
//
//        professor.describeClass();

        University newUniversity = new University();

        newUniversity.main();

        System.out.println("Final!");
    }
}

class Student{
    private String name;
    private List<Integer> marks;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String  name, List<Integer> marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    public Student(){

    }

    public void callAge(){
        System.out.printf("Студент %s имеет возраст %d\n", name, age);
    }

    public void callMarks(){
        System.out.printf("Студент %s имеет следующие оценки: ", name);
        for(int i = 0; i < marks.size(); i++){
            System.out.print(marks.get(i) + ", ");
        }
        System.out.println();
    }
}

class Professor{
    private String name;
    private String subject;
    private List<Student> studentList;

    public Professor(String name, String subject, List<Student> studentList) {
        this.name = name;
        this.subject = subject;
        this.studentList = studentList;
    }

    public Professor(){

    }

    public void describeClass(){
        System.out.printf("У профессора %s, преподающего дисциплину %s, учатся следующие студенты: \n", name, subject);
        for (Student currentStudent: studentList){
            currentStudent.callAge();
            currentStudent.callMarks();
        }
    }
}

class University{
    Scanner scanner = new Scanner(System.in);
    private String name;
    private List<Professor> professorList;

    public University(String name, List<Professor> professorList) {
        this.name = name;
        this.professorList = professorList;
    }

    public University() {
    }

    public void main(){
        System.out.println("First you need to create a database of students ...");
        List<Student> tempStudent = new ArrayList<>();

        for(int i = 0; i < 2; i++){
            System.out.printf("Enter the name of the #%d student: ", i+1);
            String studentName = scanner.nextLine();
            System.out.printf("Enter the age of the #%d student: ", i+1);
            int studentAge = Integer.parseInt(scanner.nextLine());
            System.out.printf("Enter 2 marks of the #%d student by space: ", i+1);
            List<Integer> currentMarks = new ArrayList<>();
            for(int j = 0; j < 2; j++){
               currentMarks.add(Integer.parseInt(scanner.nextLine()));
           }

            tempStudent.add(new Student(studentName, currentMarks, studentAge));
        }

        System.out.println("Second you need to create a database of professors ...");
        List<Professor> tempProfessor = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            System.out.printf("Enter the name of the #%d professor: ", i+1);
            String professorName = scanner.nextLine();
            System.out.printf("Enter the subject of the #%d professor: ", i+1);
            String professorSubject = scanner.nextLine();
            int studentsAmount = Integer.parseInt(scanner.nextLine());
            System.out.printf("Select the student number that belongs to the #%s professor's group, but no more %d: ", professorName, studentsAmount);
            List<Student> currentStudents = new ArrayList<>();
            for(int j = 0; j < studentsAmount; j++){
                currentStudents.add(tempStudent.get(Integer.parseInt(scanner.nextLine())-1));
            }

            tempProfessor.add(new Professor(professorName, professorSubject, currentStudents));
        }

        name = scanner.nextLine();
        professorList = tempProfessor;

        professorList.get(0).describeClass();
    }
}