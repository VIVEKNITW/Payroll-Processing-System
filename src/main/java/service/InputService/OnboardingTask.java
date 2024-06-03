package main.java.service.InputService;


import main.java.exceptions.InputException;
import main.java.models.*;
import main.java.service.Task;
import main.java.storage.EmployeeList;
import main.java.storage.EventsList;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OnboardingTask implements Task {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private EmployeeList employeeList = EmployeeList.getList();
    private EventsList eventsList = EventsList.getList();

    @Override
    public void readInput(String[] parts) throws ParseException, InputException {
        if(parts.length<9){
            throw new InputException();
        }
        Long seqenceNo = Long.parseLong(parts[0].trim());
        String empId = parts[1].trim();
        String empFName = parts[2].trim();
        String empLName = parts[3].trim();
        String designationString = parts[4].trim().replace(" ", "_").toUpperCase();
        Designation designation = null;
        if(designationString.equals(Designation.SOFTWARE_ENGINEER.toString())){
            designation = Designation.SOFTWARE_ENGINEER;
        }
        else if(designationString.equals(Designation.ARCHITECT.toString())){
            designation = Designation.ARCHITECT;
        }


        EventType eventType = EventType.ONBOARD;

        String onboardDateString = parts[6].trim();
        // convert to Date
        Date onboardDate = dateFormat.parse(onboardDateString);

        String eventDateString = parts[7].trim();
        // convert to Date
        Date eventDate = dateFormat.parse(eventDateString);

        String note = parts[8].trim();

        Value value = new Value.ValueBuilder().setOnboard(onboardDate).build();
        employeeList.add(empId, new Employee(seqenceNo, empId, empFName, empLName, designation, value));

        Event event = new Event.Builder().setEventNo(seqenceNo).setEventDate(eventDate).setEventType(eventType).setNotes(note).setEmpId(empId).build();
        eventsList.add(event);
    }
}
