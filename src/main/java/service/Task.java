package main.java.service;

import main.java.exceptions.InputException;

import java.text.ParseException;

public interface Task {
    public void readInput(String[] parts) throws ParseException, InputException;
}
