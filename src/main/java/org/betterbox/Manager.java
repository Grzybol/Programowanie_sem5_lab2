package org.betterbox;

import java.time.LocalDate;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, LocalDate hireDate, double bonus) {
        super(name, salary, hireDate);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String getDescription() {
        return "Manager";
    }
}

