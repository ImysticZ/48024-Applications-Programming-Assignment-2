package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class AddStudentController extends Controller<University> {
    @FXML private TextField numberTf;
    @FXML private TextField nameTf;
    @FXML private ToggleGroup attenTg;
    @FXML private CheckBox scholCb;
    @FXML private Button addBtn;
    @FXML private Text errorText;

    @FXML private void initialize() {
        numberTf.textProperty().addListener(event -> addBtn.setDisable(getNumber().equals("") || getName().equals("") || getAttendance() == null));
        nameTf.textProperty().addListener(event -> addBtn.setDisable(getNumber().equals("") || getName().equals("") || getAttendance() == null));
        attenTg.selectedToggleProperty().addListener(event -> addBtn.setDisable(getNumber().equals("") || getName().equals("") || getAttendance() == null));
    }
    @FXML private void handleAdd(ActionEvent event) {
        try {
            model.addStudent(getNumber(), getName(), getAttendance(), getScholarship());
            stage.close();
        }
        catch (Exception e){
            errorText.setText("Student already exists");
        }
    }
    @FXML private void handleCancel(ActionEvent event) throws Exception {
        stage.close();
    }
    private String getNumber() {
        return numberTf.getText();
    }
    private String getName() {
        return nameTf.getText();
    }
    private String getAttendance() {
        if (attenTg.getSelectedToggle() != null) {
            return attenTg.getSelectedToggle().getUserData().toString();
        }
        else {
            return null;
        }
    }
    private Boolean getScholarship() {
        return scholCb.isSelected();
    }
}
