package org.example;

public class User {

    private String last_name;
    private String first_name;
    private String surname;
    private String post;
    private int salary;
    private int department_id;

    public User(String last_name, String first_name, String surname, String post, int salary, int department_id) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.surname = surname;
        this.post = post;
        this.salary = salary;
        this.department_id = department_id;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getDepartmentId() {
        return department_id;
    }

    public void setDepartmentId(int department_id) {
        this.department_id = department_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", department_id=" + department_id +
                '}';
    }
}