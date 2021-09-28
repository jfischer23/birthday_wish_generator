package com.example.javafx_task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class ViewInputController {

    static public String enteredName;
    static public String enteredBirthday;
    static public int years;

    @FXML
    private TextField nameInput;
    @FXML
    private DatePicker birthdayInput;

    @FXML
    public void initialize() {
        birthdayInput.setConverter(new StringConverter<>() {
            String pattern = "dd.MM.yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
    }

    public String getEnteredName() {
        return enteredName;
    }

    public String getEnteredBirthday() {
        return enteredBirthday;
    }

    public int getYears() {
        return years;
    }

    public void setEnteredName() {
        nameInput.setText(enteredName);
    }

    public void setEnteredBirthday() {
        birthdayInput.setValue(LocalDate.parse(enteredBirthday, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @FXML
    private void onKeyPressed(KeyEvent e) {
        enteredName = nameInput.getText();
    }

    @FXML
    private void onDatePicked(ActionEvent e) {
        enteredBirthday = birthdayInput.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        years = (Period.between(birthdayInput.getValue(), LocalDate.now())).getYears();
    }

}
