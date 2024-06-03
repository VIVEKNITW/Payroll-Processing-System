package main.java.controller;

import main.java.models.EventType;
import main.java.service.InputService.*;
import main.java.service.Operations;
import main.java.service.Task;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String fileName = "DatOrbAssignment/src/input/Employee_details.txt";

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            // Read each line from the file
            while (scanner.hasNextLine()) {
                Task task=new OnboardingTask();
                String line = scanner.nextLine();

                if(line.contains(EventType.ONBOARD.toString())){
                    task = new OnboardingTask();
                }

                else if(line.contains(EventType.SALARY.toString())){
                    task = new SalaryTask();
                }
                else if(line.contains(EventType.BONUS.toString())){
                    task = new BonusTask();
                }
                else if(line.contains(EventType.EXIT.toString())){
                    task = new ExitTask();
                }
                else if(line.contains(EventType.REIMBURSEMENT.toString())){
                    task = new ReimbursementTask();
                }

                String[] parts = line.split(",");
                try{
                    task.readInput(parts);
                }catch (Exception e){
                    System.out.println("Exception caught: "+e.getMessage());
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }


        Operations operations = new Operations();
        System.out.println("FINAL REPORTS:");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        operations.getEmployeesCount();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        operations.getMonthlyJoiningList();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        operations.getMonthlyExitList();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        operations.getMonthlySalaryReport();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        operations.getEmployeewiseFinancialReport();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        operations.getTotalMonthlyAmountReleased();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        operations.getYearwiseReport();
    }
}