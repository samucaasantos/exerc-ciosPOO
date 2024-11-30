package Aplication;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter department's name: ");
        String department_name = sc.nextLine();
        Department department = new Department(department_name);

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String level = sc.nextLine();
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();
        sc.nextLine();
        Worker worker = new Worker(name, baseSalary, WorkerLevel.valueOf(level), department);

        System.out.print("How many contracts to this worker? ");
        int qtt_contracts = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtt_contracts; i++) {
            System.out.println("Enter contract #" + (i+1) + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            Integer hours = sc.nextInt();
            sc.nextLine();
            HourContract hourContract = new HourContract(date, valuePerHour, hours);
            worker.addContract(hourContract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String date2 = sc.nextLine();
        int month = Integer.parseInt(date2.substring(0, 2));
        int year = Integer.parseInt(date2.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + date2 + ": " + String.format( "%.2f",  worker.income(month, year)));
        sc.close();
    }
}
