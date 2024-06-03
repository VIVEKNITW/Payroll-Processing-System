package main.java.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private Date eventDate;
    private EventType eventType;
    private String notes;
    private Long amount;
    private Long eventNo;
    private String empId;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private Event(Builder builder) {
        this.eventDate = builder.eventDate;
        this.eventType = builder.eventType;
        this.notes = builder.notes;
        this.amount = builder.amount;
        this.eventNo = builder.eventNo;
        this.empId = builder.empId;
    }

    public static class Builder {
        private Date eventDate;
        private EventType eventType;
        private String notes;
        private Long amount;
        private Long eventNo;

        private String empId;


        public Builder(){
            eventDate = null;
            eventType = null;
            notes = null;
            amount=0L;
            eventNo=-1L;
            empId = "";
        }

        public String getEmpId() {
            return empId;
        }

        public Builder setEmpId(String empId) {
            this.empId = empId;
            return this;
        }

        public Long getEventNo() {
            return eventNo;
        }

        public Builder setEventNo(Long eventNo) {
            this.eventNo = eventNo;
            return this;
        }
        public Builder setEventDate(Date eventDate) {
            this.eventDate = eventDate;
            return this;
        }

        public Builder setEventType(EventType eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder setAmount(Long amount) {
            this.amount = amount;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }

    @Override
    public String toString() {
        String formattedEventDate = eventDate != null ? dateFormat.format(eventDate) : "N/A";
        return "Event{" +
                "sequence no= "+eventNo+
                ", eventDate=" + formattedEventDate +
                ", eventType=" + eventType +
                ", notes='" + notes + '\'' +
                ", amount=" + amount +
                ", empId=" + empId +
                '}';
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getEventNo() {
        return eventNo;
    }

    public void setEventNo(Long eventNo) {
        this.eventNo = eventNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
