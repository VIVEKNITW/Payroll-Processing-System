package main.java.storage;

import main.java.models.Event;

import java.util.ArrayList;
import java.util.List;

public class EventsList {
    private static List<Event> events = null;
    private static EventsList eventsList=null;

    private EventsList(){
        events=new ArrayList<>();
    }

    public static EventsList getList(){
        if(eventsList==null){
            eventsList = new EventsList();
        }
        return eventsList;
    }

    public Boolean add(Event event){

        events.add(event);
        return true;
    }

    public List<Event> list(){
        return this.events;
    }
}

