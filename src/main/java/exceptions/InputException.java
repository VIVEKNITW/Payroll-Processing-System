package main.java.exceptions;

public class InputException extends Exception{
    public InputException(){
        super("input didn't meet the criteria");
    }
}
