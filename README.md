# Payroll-Processing-System

## Overview
PPC is a Payroll solution provider company who manages the payroll of the various companies from
small scale to large scale company.
PPC accepts the employees data from the client in either plain text format (.txt) or csv (.csv) format to
manage the employee life cycle starting from date of onboarding to date of exit.


## Following questions have been answered through code:
1. Total number of employees in an organization.
2. Month wise following details
a. Total number of employees joined the organization with employee details like emp id,
designation, name, surname.
b. Total number of employees exit organization with employee details like name, surname.
3. Monthly salary report in following format
a. Month, Total Salary, Total employees
4. Employee wise financial report in the following format
a. Employee Id, Name, Surname, Total amount paid
5. Monthly amount released in following format
a. Month, Total Amount (Salary + Bonus + REIMBURSEMENT), Total employees
6. Yearly financial report in the following format
a. Event, Emp Id, Event Date, Event value


## example input (.txt file)
1, emp101, Bill, Gates, Software Engineer, ONBOARD, 1-11-2022, 10-10-2022, “Bill Gates is going to join DataOrb on 1st November as a SE.” <br /> 
2, emp102, Steve Jobs, Architect, ONBOARD, 1-10-2022, 10-10-2022, “Steve Jobs joined DataOrb on 1st October as an Architect.” <br />
3, emp103, Martin, Fowler, Software Engineer, ONBOARD, 15-10-2022, 10-10-2022, “Martin has joined DataOrb as a SE.” <br />
4, emp102, SALARY, 3000, 10-10-2022, “Oct Salary of Steve.” <br />
5, emp101, BONUS, 1000, 10-10-2022, “heres the bonus for bill yayy”  <br />
6, emp103, EXIT, 1-11-2022, 20-10-2022, "Marlin leaving the org"  <br />
7, emp101, REIMBURSEMENT, 100, 20-10-2022, "laptop reimb"  <br />

## How to execute
You can directly run the Controller class in controller folder. If needed, file can be changed in input.

## Sample output
``` FINAL REPORTS:
------------------------------------------------------------------------------------------------------------------------------------
Total number of employees in the organization= 3
------------------------------------------------------------------------------------------------------------------------------------
Employees Onboarded month wise:
October
2, empId: emp102 Fname: Steve LName: Jobs Designation: ARCHITECT value: { onboard: 01-10-2022 salary: 0 bonus: 0 exit: N/A reimburrsement: 0 }
3, empId: emp103 Fname: Martin LName: Fowler Designation: SOFTWARE_ENGINEER value: { onboard: 15-10-2022 salary: 3000 bonus: 0 exit: 01-11-2022 reimburrsement: 0 }
November
1, empId: emp101 Fname: Bill LName: Gates Designation: SOFTWARE_ENGINEER value: { onboard: 01-11-2022 salary: 0 bonus: 1000 exit: N/A reimburrsement: 100 }
------------------------------------------------------------------------------------------------------------------------------------
Employees Exit month wise:
November
3, empId: emp103 Fname: Martin LName: Fowler Designation: SOFTWARE_ENGINEER value: { onboard: 15-10-2022 salary: 3000 bonus: 0 exit: 01-11-2022 reimburrsement: 0 }
------------------------------------------------------------------------------------------------------------------------------------
Salary report month wise:
month: October
total salary = 3000, Employes count= 2
month: November
total salary = 0, Employes count= 1
------------------------------------------------------------------------------------------------------------------------------------
Employeewise financial report:
EmployeeId:emp103, Name:Martin, Surname:Fowler, Total amount paid:3000
EmployeeId:emp102, Name:Steve, Surname:Jobs, Total amount paid:0
EmployeeId:emp101, Name:Bill, Surname:Gates, Total amount paid:1100
------------------------------------------------------------------------------------------------------------------------------------
Monthly total amount released:
month: October
total amount released = 3000, Employes count= 2
month: November
total amount released = 1100, Employes count= 1
------------------------------------------------------------------------------------------------------------------------------------
yearly financial report:
Year: 2022
event:1, EmpId:emp101, Event date:10-10-2022, Event value:0
event:2, EmpId:emp102, Event date:10-10-2022, Event value:0
event:3, EmpId:emp103, Event date:10-10-2022, Event value:0
event:4, EmpId:emp103, Event date:10-10-2022, Event value:3000
event:5, EmpId:emp101, Event date:10-10-2022, Event value:1000
event:6, EmpId:emp103, Event date:20-10-2022, Event value:0
event:7, EmpId:emp101, Event date:20-10-2022, Event value:100 ```

## Good code practise
1. Used object oriented Java and designed the code segregating models, services, controller and storage layer
2. Used builder design pattern in Event and Value models to make it simpler to build the object with optional parameters
3. Used singleton design pattern for storage objects
4. Used factory method to create objects specific to the input.
5. Created exceptions wherever required.  
