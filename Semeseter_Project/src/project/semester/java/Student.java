package project.semester.java;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String studentID;
    private String firstName;
    private String lastName;
    private String cnic;
    private int age;
    private double cgpa;
    private String emailID;

    public Student(String studentID, String firstName, String lastName, String cnic, int age, double cgpa, String emailID) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnic = cnic;
        this.age = age;
        this.cgpa = cgpa;
        this.emailID = emailID;
    }

    public int getAge() {
        return age;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString(){
        return String.format("%s\t%s\t%s\t%s\t%d\t%f\t%s\n", studentID, firstName, lastName, cnic, age, cgpa, emailID);
    }
    public static ArrayList<Student> sortByAge(ArrayList<Student> studentList){
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = i+1; j < studentList.size(); j++) {
                if (studentList.get(i).getAge() > studentList.get(j).getAge()){
                    Student temp = studentList.get(j);
                    studentList.remove(j);
                    studentList.add(j, studentList.get(i));
                    studentList.remove(i);
                    studentList.add(i, temp);
                }
            }
        }
        return studentList;
    }
    public static ArrayList<Student> sortByCGPA(ArrayList<Student> studentList){
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = i+1; j < studentList.size(); j++) {
                if (studentList.get(i).getCgpa() < studentList.get(j).getCgpa()){
                    Student temp = studentList.get(j);
                    studentList.remove(j);
                    studentList.add(j, studentList.get(i));
                    studentList.remove(i);
                    studentList.add(i, temp);
                }
            }
        }
        return studentList;
    }
    public static ArrayList<Student> sortBySID(ArrayList<Student> studentList){
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = i+1; j < studentList.size(); j++) {
                if ((studentList.get(i).getStudentID().compareTo(studentList.get(j).getStudentID())) > 0){
                    Student temp = studentList.get(j);
                    studentList.remove(j);
                    studentList.add(j, studentList.get(i));
                    studentList.remove(i);
                    studentList.add(i, temp);
                }
            }
        }
        return studentList;
    }
    public static ArrayList<Student> sortByFirstName(ArrayList<Student> studentList){
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = i+1; j < studentList.size(); j++) {
                if ((studentList.get(i).getFirstName().compareTo(studentList.get(j).getFirstName())) > 0){
                    Student temp = studentList.get(j);
                    studentList.remove(j);
                    studentList.add(j, studentList.get(i));
                    studentList.remove(i);
                    studentList.add(i, temp);
                }
            }
        }
        return studentList;
    }
}
