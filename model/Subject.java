package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Subject {
    private int number;
    private String name;
    private ObservableList<Activity> activities = FXCollections.observableArrayList();

    public Subject(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public ObservableList<Activity> getActivities() {
        return activities;
    }

    public void addActivity(String group, int number, String day, int start, int duration, String room, int capacity) {
        activities.add(new Activity(this, group, number, day, start, duration, room, capacity));
    }

    public boolean matches(int number) {
        return this.number == number;
    }

    @Override
    public String toString() {
        return number + " " + name;
    }
}
