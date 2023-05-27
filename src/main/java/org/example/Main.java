package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner commandScanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("0")) {

            if (command.equals("1")) {
                create();
            } else if (command.equals("2")) {
                getUser();
            } else if (command.equals("3")) {
                update();
            } else if (command.equals("4")) {
                delete();
            } else if (command.equals("5")) {
                add_department();
            }

            printMenu();
            command = commandScanner.nextLine();
        }
    }

    private static void create() {
        User user = new User();
        System.out.println("Введите фамилию:");
        Scanner lastnameScanner = new Scanner(System.in);
        user.setLast_name(lastnameScanner.nextLine());

        System.out.println("Введите имя:");
        Scanner firstnameScanner = new Scanner(System.in);
        user.setFirst_name(firstnameScanner.nextLine());

        System.out.println("Введите отчество:");
        Scanner surnameScanner = new Scanner(System.in);
        user.setSurname(surnameScanner.nextLine());

        System.out.println("Введите должность:");
        Scanner postScanner = new Scanner(System.in);
        user.setPost(postScanner.nextLine());

        System.out.println("Введите отдел:");
        Scanner departmentScanner = new Scanner(System.in);
        user.setDepartmentId(departmentScanner.nextInt());

        System.out.println("Введите зарплату:");
        Scanner salaryScanner = new Scanner(System.in);
        user.setSalary(salaryScanner.nextInt());

        UserDao userDao = new UserDaoImpl();
        userDao.create(user);
        System.out.println("Пользователь добавлен");
    }

    private static void getUser() {

        System.out.println("Введите ID:");
        Scanner idScanner = new Scanner(System.in);
        int id = idScanner.nextInt();

        UserDao userDao = new UserDaoImpl();
        User user = userDao.getById(id);
        System.out.println("Найден пользователь: " + user);
    }

    private static void update() {
        System.out.println("Введите ID:");
        Scanner idScanner = new Scanner(System.in);
        int id = idScanner.nextInt();

        UserDao userDao = new UserDaoImpl();
        User user = userDao.getById(id);
        System.out.println("Найден пользователь: " + user);
        System.out.println("Введите новые данные пользователя: ");

        System.out.println("Введите фамилию:");
        Scanner lastnameScanner = new Scanner(System.in);
        String last_name = lastnameScanner.nextLine();

        System.out.println("Введите имя:");
        Scanner firstnameScanner = new Scanner(System.in);
        String first_name = firstnameScanner.nextLine();

        System.out.println("Введите отчество:");
        Scanner surnameScanner = new Scanner(System.in);
        String surname = surnameScanner.nextLine();

        System.out.println("Введите должность:");
        Scanner postScanner = new Scanner(System.in);
        String post = postScanner.nextLine();

        System.out.println("Введите зарплату:");
        Scanner salaryScanner = new Scanner(System.in);
        int salary = salaryScanner.nextInt();

        System.out.println("Введите номер отдел:");
        Scanner departmentScanner = new Scanner(System.in);
        int department_id = departmentScanner.nextInt();

        userDao.update(id, last_name, first_name, surname, post, salary, department_id);

        user = userDao.getById(id);

        System.out.println("Данные пользователя обновлены: " + user);
    }

    private static void delete() {
        System.out.println("Введите ID:");
        Scanner idScanner = new Scanner(System.in);
        int id = idScanner.nextInt();

        UserDao userDao = new UserDaoImpl();
        User user = userDao.getById(id);
        System.out.println("Найден пользователь: " + user);
        System.out.println("Предупреждение - данные пользователя будут удалены навсегда!");

        userDao.delete(id);

        System.out.println("Пользователь удалён!");
    }

    private static void add_department() {

        System.out.println("Введите название отдела:");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();

        UserDao userDao = new UserDaoImpl();

        userDao.add_department(name);

        System.out.println("Отдел добавлен.");
    }

    private static void printMenu() {
        System.out.println("Введите команду:");
        System.out.println("1) Добавить пользователя.");
        System.out.println("2) Получить пользователя.");
        System.out.println("3) Обновить данные пользователя.");
        System.out.println("4) Удалить пользователя.");
        System.out.println("5) Добавить отдел в таблицу отделов.");
        System.out.println("0) Выход.");
    }
}