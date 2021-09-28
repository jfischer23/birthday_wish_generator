package com.example.javafx_task;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ViewResultsController {

    @FXML
    private Label resultText;

    public void setResult(String enteredName, String enteredBirthday, int years) {
        String birthdayMsg = "Liebe*r " + enteredName + ",\nwir von der intecsoft group wünschen\nDir " +
                "zu deinem "+ years + ". Geburtstag\nam " + enteredBirthday + " alles Gute!";
        resultText.setText(birthdayMsg);
    }
}
