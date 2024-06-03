package main.java.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Value {
    private Date onboard;
    private Long salary;
    private Long bonus;
    private Date exit;
    private Long reimbursement;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private Value(ValueBuilder valueBuilder) {
        this.onboard = valueBuilder.getOnboard();
        this.salary = valueBuilder.getSalary();
        this.bonus = valueBuilder.getBonus();
        this.exit = valueBuilder.getExit();
        this.reimbursement = valueBuilder.getReimbursement();
    }


    public static class ValueBuilder{
        private Date onboard;
        private Long salary;
        private Long bonus;
        private Date exit;
        private Long reimbursement;

        public ValueBuilder(){
            this.onboard=null;
            this.salary=0L;
            this.bonus=0L;
            this.exit=null;
            this.reimbursement=0L;
        }

        public Value build(){
            return new Value(this);
        }
        public Date getOnboard() {
            return onboard;
        }

        public ValueBuilder setOnboard(Date onboard) {
            this.onboard = onboard;
            return this;
        }

        public Long getSalary() {
            return salary;
        }

        public ValueBuilder setSalary(Long salary) {
            this.salary = salary;
            return this;
        }

        public Long getBonus() {
            return bonus;
        }

        public ValueBuilder setBonus(Long bonus) {
            this.bonus = bonus;
            return this;
        }

        public Date getExit() {
            return exit;
        }

        public ValueBuilder setExit(Date exit) {
            this.exit = exit;
            return this;
        }

        public Long getReimbursement() {
            return reimbursement;
        }

        public ValueBuilder setReimbursement(Long reimbursement) {
            this.reimbursement = reimbursement;
            return this;
        }
    }

    public Date getOnboard() {
        return onboard;
    }

    public void setOnboard(Date onboard) {
        this.onboard = onboard;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public Date getExit() {
        return exit;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }

    public Long getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(Long reimbursement) {
        this.reimbursement = reimbursement;
    }

    @Override
    public String toString() {
        String formattedOnboardDate = onboard != null ? dateFormat.format(onboard) : "N/A";
        String formattedExitDate = exit != null ? dateFormat.format(exit) : "N/A";
        return "{ onboard: "+ formattedOnboardDate+" salary: "+this.salary+" bonus: "+this.bonus+" exit: "+formattedExitDate+" reimburrsement: "+this.reimbursement+" }";
    }
}
