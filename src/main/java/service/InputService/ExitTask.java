package main.java.service.InputService;

import main.java.models.Employee;
import main.java.models.Event;
import main.java.models.EventType;
import main.java.models.Value;
import main.java.service.Task;
import main.java.storage.EmployeeList;
import main.java.storage.EventsList;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExitTask implements Task {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private EmployeeList employeeList = EmployeeList.getList();
    private EventsList eventsList = EventsList.getList();
    @Override
    public void readInput(String[] parts) throws ParseException {
        if(parts.length<6){
            return;
        }
        Long seqenceNo = Long.parseLong(parts[0].trim());
        String empId = parts[1].trim();

        EventType eventType = EventType.EXIT;

        String exitDateString = parts[3].trim();
        // convert to Date
        Date exitDate = dateFormat.parse(exitDateString);


        String eventDateString = parts[4].trim();
        // convert to Date
        Date eventDate = dateFormat.parse(eventDateString);

        String note = parts[5].trim();

        if(employeeList.list().containsKey(empId)){
            Employee myEmployee = employeeList.list().get(empId);
            Value myValue = myEmployee.getValue();
            myValue.setExit(exitDate);
            myEmployee.setValue(myValue);
            employeeList.list().put(empId, myEmployee);
        }

        Event event = new Event.Builder().setEventNo(seqenceNo).setEventDate(eventDate).setEventType(eventType).setNotes(note).setEmpId(empId).build();
        eventsList.add(event);
    }
}
