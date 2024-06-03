package main.java.models;

public class Employee {
    Long sequenceNo;
    String empId;
    String EmpFName;
    String EmpLName;
    Designation Designation;
    Value value;

    public Employee(Long sequenceNo, String empId, String empFName, String empLName, Designation designation, Value value) {
        this.sequenceNo = sequenceNo;
        this.empId = empId;
        EmpFName = empFName;
        EmpLName = empLName;
        Designation = designation;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.sequenceNo+", empId: "+this.empId+" Fname: "+this.EmpFName+" LName: "+this.EmpLName+" Designation: "+this.Designation+" value: "+this.value.toString();
    }

    public Long getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Long sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpFName() {
        return EmpFName;
    }

    public void setEmpFName(String empFName) {
        EmpFName = empFName;
    }

    public String getEmpLName() {
        return EmpLName;
    }

    public void setEmpLName(String empLName) {
        EmpLName = empLName;
    }

    public Designation getDesignation() {
        return Designation;
    }

    public void setDesignation(Designation designation) {
        Designation = designation;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
