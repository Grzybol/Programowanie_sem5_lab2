package org.betterbox;

import java.time.LocalDate;

public class Employee extends Person {
    private double salary;
    private LocalDate hireDate;

    public Employee(String name, double salary, LocalDate hireDate) {
        super(name);
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String getDescription() {
        return "Employee";
    }

    public static Employee createJunior(String name, LocalDate hireDate) {
        return new Employee(name, 5000, hireDate);
    }

    public static Employee createMid(String name, LocalDate hireDate) {
        return new Employee(name, 10000, hireDate);
    }

    public static Employee createSenior(String name, LocalDate hireDate) {
        return new Employee(name, 15000, hireDate);
    }
}


