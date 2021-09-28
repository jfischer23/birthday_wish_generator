package com.example.javafx_task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {

    @FXML
    public BorderPane mainBorderPane;
    public ToggleButton buttonDataInput;
    public ToggleButton buttonResults;
    @FXML
    protected void onShowInput(ActionEvent event) throws IOException {
        FXMLLoader loaderInput = new FXMLLoader(getClass().getResource("view_scene_input.fxml"));
        Parent rootInput = loaderInput.load();
        ViewInputController inputController = loaderInput.getController();

        buttonResults.setSelected(false);

        // reset previously entered values
        inputController.setEnteredName();
        inputController.setEnteredBirthday();

        mainBorderPane.setCenter(rootInput);
    }

    @FXML
    protected void onShowResults(ActionEvent event) throws IOException {
        // get loader and controller
        FXMLLoader loaderResults = new FXMLLoader(getClass().getResource("view_scene_result.fxml"));
        FXMLLoader loaderInput = new FXMLLoader(getClass().getResource("view_scene_input.fxml"));
        Parent rootResults = loaderResults.load();
        loaderInput.load();
        ViewInputController inputController = loaderInput.getController();
        ViewResultsController resultsController = loaderResults.getController();

        // check wrong or missing input
        if(inputController.getEnteredName() == null || inputController.getEnteredBirthday() == null) {
            buttonResults.setSelected(false);
            alertWrongEntries();
            return;
        }

        buttonDataInput.setSelected(false);

        resultsController.setResult(
                inputController.getEnteredName(),
                inputController.getEnteredBirthday(),
                inputController.getYears());

        mainBorderPane.setCenter(rootResults);
    }

    private void alertWrongEntries() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Felder unausgefüllt oder falsch");
        alert.setHeaderText(null);
        alert.setContentText("Bitte füllen Sie alle Felder korrekt aus!");
        alert.showAndWait();
    }
}


