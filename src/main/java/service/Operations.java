package main.java.service;

import main.java.models.Employee;
import main.java.models.Event;
import main.java.storage.EmployeeList;
import main.java.storage.EventsList;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

public class Operations {
    private EmployeeList employeeList = EmployeeList.getList();
    private EventsList eventsList = EventsList.getList();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void getEmployeesCount(){
        System.out.println("Total number of employees in the organization= "+employeeList.list().size());
    }

    private static int getMonth(Date date) {
        if(date==null){
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1; // Months are 0-based in Calendar, so add 1
    }

    private static int getYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public void getMonthlyJoiningList(){
        PriorityQueue<Employee> employeeQueue = new PriorityQueue<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getValue().getOnboard().compareTo(e2.getValue().getOnboard());
            }
        });

        for(String key:employeeList.list().keySet()){
            employeeQueue.add(employeeList.list().get(key));
        }

        int currentMonth = -1;
        System.out.println("Employees Onboarded month wise:");
        DateFormatSymbols dfs = new DateFormatSymbols();
        while(!employeeQueue.isEmpty()){
            Employee employee = employeeQueue.remove();
            int month = Operations.getMonth(employee.getValue().getOnboard());
            if(currentMonth==-1) {
                currentMonth = month;
                System.out.println(dfs.getMonths()[month - 1]);
                System.out.println(employee);
            }

            else if(month!=currentMonth){
                currentMonth = month;
                System.out.println(dfs.getMonths()[month - 1]);
                System.out.println(employee);
            }
            else{
                System.out.println(employee);
            }

        }
    }

    public void getMonthlyExitList() {
        PriorityQueue<Employee> employeeQueue = new PriorityQueue<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getValue().getExit().compareTo(e2.getValue().getExit());
            }
        });

        for (String key : employeeList.list().keySet()) {
            if (employeeList.list().get(key).getValue().getExit() != null) {
                employeeQueue.add(employeeList.list().get(key));
            }

        }
        int currentMonth = -1;
        System.out.println("Employees Exit month wise:");
        DateFormatSymbols dfs = new DateFormatSymbols();
        while (!employeeQueue.isEmpty()) {
            Employee employee = employeeQueue.remove();
            int month = Operations.getMonth(employee.getValue().getExit());
            if (currentMonth == -1) {
                currentMonth = month;
                System.out.println(dfs.getMonths()[month - 1]);
                System.out.println(employee);
            } else if (month != currentMonth) {
                currentMonth = month;
                System.out.println(dfs.getMonths()[month - 1]);
                System.out.println(employee);
            } else {
                System.out.println(employee);
            }

        }
    }



    public void getMonthlySalaryReport() {
        PriorityQueue<Employee> employeeQueue = new PriorityQueue<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getValue().getOnboard().compareTo(e2.getValue().getOnboard());
            }
        });

        for (String key : employeeList.list().keySet()) {
            employeeQueue.add(employeeList.list().get(key));

        }
        int currentMonth = -1;
        Long totalSalary = 0L;
        int employyesCount = 0;
        System.out.println("Salary report month wise:");
        DateFormatSymbols dfs = new DateFormatSymbols();
        while (!employeeQueue.isEmpty()) {
            Employee employee = employeeQueue.remove();

            int month = Operations.getMonth(employee.getValue().getOnboard());

            if (currentMonth == -1) {
                currentMonth = month;
                employyesCount = 1;
                totalSalary+=employee.getValue().getSalary();
            } else if (month != currentMonth) {
                System.out.println("month: "+dfs.getMonths()[currentMonth - 1]);
                System.out.println("total salary = "+totalSalary+", Employes count= "+employyesCount);
                currentMonth = month;
                totalSalary = employee.getValue().getSalary();
                employyesCount = 1;
            } else {
                totalSalary+=employee.getValue().getSalary();
                employyesCount+=1;
            }
        }
        if(currentMonth!=-1){
            System.out.println("month: "+dfs.getMonths()[currentMonth - 1]);
            System.out.println("total salary = "+totalSalary+", Employes count= "+employyesCount);
        }
    }



    public void getEmployeewiseFinancialReport(){
        System.out.println("Employeewise financial report:");
        for(String key:employeeList.list().keySet()){
            Employee employee = employeeList.list().get(key);
            System.out.println("EmployeeId:"+ employee.getEmpId()+", Name:"+ employee.getEmpFName()+", Surname:"+ employee.getEmpLName()+", Total amount paid:"
            +(employee.getValue().getSalary()+employee.getValue().getBonus()+employee.getValue().getReimbursement()));
        }


    }

    public void getTotalMonthlyAmountReleased() {
        PriorityQueue<Employee> employeeQueue = new PriorityQueue<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getValue().getOnboard().compareTo(e2.getValue().getOnboard());
            }
        });

        for (String key : employeeList.list().keySet()) {
            employeeQueue.add(employeeList.list().get(key));

        }
        int currentMonth = -1;
        Long totalSalary = 0L;
        int employyesCount = 0;
        System.out.println("Monthly total amount released:");
        DateFormatSymbols dfs = new DateFormatSymbols();
        while (!employeeQueue.isEmpty()) {
            Employee employee = employeeQueue.remove();

            int month = Operations.getMonth(employee.getValue().getOnboard());

            if (currentMonth == -1) {
                currentMonth = month;
                employyesCount = 1;
                totalSalary+=employee.getValue().getSalary()+employee.getValue().getBonus()+employee.getValue().getReimbursement();
            } else if (month != currentMonth) {
                System.out.println("month: "+dfs.getMonths()[currentMonth - 1]);
                System.out.println("total amount released = "+totalSalary+", Employes count= "+employyesCount);
                currentMonth = month;
                totalSalary = employee.getValue().getSalary()+employee.getValue().getBonus()+employee.getValue().getReimbursement();
                employyesCount = 1;
            } else {
                totalSalary+=employee.getValue().getSalary()+employee.getValue().getBonus()+employee.getValue().getReimbursement();
                employyesCount+=1;
            }
        }
        if(currentMonth!=-1){
            System.out.println("month: "+dfs.getMonths()[currentMonth - 1]);
            System.out.println("total amount released = "+totalSalary+", Employes count= "+employyesCount);
        }
    }

    public void getYearwiseReport() {
        System.out.println("yearly financial report:");
        PriorityQueue<Event> eventQueue = new PriorityQueue<>(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getEventDate().compareTo(e2.getEventDate());
            }
        });

        int currentYear = -1;
        for (Event event : EventsList.getList().list()) {
            int year = Operations.getYear(event.getEventDate());

            if(currentYear==-1){
                currentYear = year;
                System.out.println("Year: "+year);
            }
            else if(currentYear!=year){
                System.out.println("Year: "+year);
                currentYear = year;
            }
            String formattedEventDate = event.getEventDate() != null ? dateFormat.format(event.getEventDate()) : "N/A";
            System.out.println("event:"+event.getEventNo()+", EmpId:"+event.getEmpId()+", Event date:"+formattedEventDate+", Event value:"+event.getAmount());
        }
    }
}
