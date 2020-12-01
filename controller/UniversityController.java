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

public class UniversityController extends Controller<University> {
    @FXML private ListView<Student> studentsLv;
    @FXML private Button remBtn;
    @FXML private Button logBtn;
    @FXML private void initialize() {
        studentsLv.getSelectionModel().selectedItemProperty().addListener(event -> remBtn.setDisable(getSelectedStudent()==null));
        studentsLv.getSelectionModel().selectedItemProperty().addListener(event -> logBtn.setDisable(getSelectedStudent()==null));
    }
    @FXML private void handleAdd(ActionEvent event) throws Exception {
        ViewLoader.showStage(getUniversity(), "/view/add_student.fxml", "Add Student", new Stage());
    }
    @FXML private void handleRemove(ActionEvent event) throws Exception {
        model.remove(getSelectedStudent());
    }
    @FXML private void handleLogin(ActionEvent event) throws Exception {
        ViewLoader.showStage(getSelectedStudent(), "/view/student.fxml", "Student", new Stage());
    }
    public final University getUniversity() {
        return model;
    }
    private Student getSelectedStudent() {
        return studentsLv.getSelectionModel().getSelectedItem();
    }
}
