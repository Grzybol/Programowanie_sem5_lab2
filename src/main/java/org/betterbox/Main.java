package org.betterbox;

import java.time.DayOfWeek;
import java.util.*;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        Person[] employees = new Person[] {
                Employee.createJunior("Filip", LocalDate.of(2023, 1, 15)),
                Employee.createMid("Łukasz", LocalDate.of(2022, 5, 23)),
                Employee.createSenior("Tomasz", LocalDate.of(2021, 3, 10)),
                new Manager("David", 20000, LocalDate.of(2020, 7, 30), 5000)
        };
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();

            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length > 0 && parts[0].matches("\\d+")) {
                int choice = Integer.parseInt(parts[0]);
                switch (choice) {
                    case 1:
                        zad1(today.getYear(), today.getMonthValue());
                        break;
                    case 2:
                        zad2_3_4(employees);
                        break;
                    case 3:
                        zad5();
                        break;
                    case 0:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
                }

            } else {
                System.out.println("Proszę wprowadzić prawidłowy numeryczny input.");
            }

        }
    }
    private static void displayMenu() {
        System.out.println("Wybierz opcję (1-5) lub 0 aby zakończyć:");
        System.out.println("1: Wyświetlenie kalendarza (zad. 1)");
        System.out.println("2: Klasy pracowników (zad. 2, 3, 4)");
        System.out.println("3: Odległość między punktami (zad. 5)");
        System.out.println("0: Zakończ program");
    }

    public static void zad1(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate today = LocalDate.now();
        LocalDate firstOfMonth = yearMonth.atDay(1);
        DayOfWeek firstDayOfWeek = firstOfMonth.getDayOfWeek();
        int lengthOfMonth = yearMonth.lengthOfMonth();
        String[] headers = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (String header : headers) {
            System.out.print(header + " ");
        }
        System.out.println();
        int dayOfWeekValue = firstDayOfWeek.getValue();
        int currentPosition = 1;


        for (int i = 1; i < dayOfWeekValue; i++) {
            System.out.print("    ");
            currentPosition++;
        }
        for (int day = 1; day <= lengthOfMonth; day++) {
            LocalDate currentDate = yearMonth.atDay(day);
            String dayString = String.valueOf(day);
            if (currentDate.equals(today)) {
                dayString += "*";
            }
            if (dayString.length() == 2) {
                System.out.print(" " + dayString + " ");
            } else {
                System.out.print("  " + dayString + " ");
            }
            if (currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }
            currentPosition++;
        }
        if (currentPosition % 7 != 1) {
            System.out.println();
        }
    }
    public static void zad2_3_4(Person[] employees) {
        for (Person person : employees) {
            System.out.println("Imię: " + person.getName());
            if (person instanceof Employee) {
                Employee emp = (Employee) person;
                System.out.println("Wynagrodzenie: " + emp.getSalary());
                if(emp instanceof Manager) {
                    Manager manager = (Manager) emp;
                    System.out.println("Premia: " + manager.getBonus());
                }
                System.out.println("Data zatrudnienia: " + emp.getHireDate());
            }
            System.out.println("Opis: " + person.getDescription());
            System.out.println("-----------------------------");
        }
    }
    public static void zad5() {
        Point origin = new Point();
        Point pointA = new Point(13, 34);
        Point pointB = new Point(16, 28);

        double distance1 = Point.calculateDistance(origin, pointA);
        double distance2 = Point.calculateDistance(pointA, pointB);

        System.out.println("Odległość między " + origin + " a " + pointA + " wynosi: " + distance1);
        System.out.println("Odległość między " + pointA + " a " + pointB + " wynosi: " + distance2);
    }


}