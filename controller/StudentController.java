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

public class StudentController extends Controller<Student> {
    @FXML private TableView<Activity> enrolledTv;
    @FXML private TableView<Activity> activityTv;
    @FXML private Text nameTxt;
    @FXML private Text attenTxt;
    @FXML private Text scholTxt;
    @FXML private ComboBox<Subject> subjectCb;
    @FXML private Button withdrawBtn;
    @FXML private Button enrolBtn;
    @FXML private void initialize() {
        nameTxt.setText("Logged in as " + model.getName());
        if (model.getAttendance().equals("ft")) {
            attenTxt.setText("Full Time");
        }
        else {
            attenTxt.setText("Part Time");
        }
        if (model.getScholarship()) {
            scholTxt.setText("Yes");
        }
        else {
            scholTxt.setText("No");
        }
        subjectCb.getSelectionModel().selectedItemProperty().addListener(event -> activityTv.setItems(getSelectedSubject().getActivities()));
        activityTv.getSelectionModel().selectedItemProperty().addListener(event -> enrolBtn.setDisable(getStudent().isEnrolledIn(getSelectedActivity()) || !enrollable()));
        enrolledTv.getSelectionModel().selectedItemProperty().addListener(event -> withdrawBtn.setDisable(getSelectedEnroll()==null));
    }
    @FXML private void handleEnrol(ActionEvent event) throws Exception {
        getStudent().enrol(getSelectedActivity());
        activityTv.refresh();
        enrolBtn.setDisable(true);
    }
    @FXML private void handleWithdraw(ActionEvent event) throws Exception {
        getStudent().withdraw(getSelectedEnroll());
        activityTv.refresh();
    }
    @FXML private void handleCancel(ActionEvent event) throws Exception {
        stage.close();
    }
    public Student getStudent() {
        return model;
    }
    private Boolean enrollable() {
        if (getSelectedActivity() != null) {
            return getSelectedActivity().canEnrol();
        }
        else {
            return false;
        }
    }
    private Activity getSelectedActivity() {
        return activityTv.getSelectionModel().getSelectedItem();
    }
    private Subject getSelectedSubject() {
        return subjectCb.getSelectionModel().getSelectedItem();
    }
    private Activity getSelectedEnroll() {
        return enrolledTv.getSelectionModel().getSelectedItem();
    }


}
