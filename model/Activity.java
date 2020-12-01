package model;

public class Activity {
    private Subject subject;
    private String group;
    private int number;
    private String day;
    private int start;
    private int duration;
    private String room;
    private int capacity;
    private int enrolled;

    public Activity(Subject subject, String group, int number, String day, int start, int duration, String room, int capacity) {
        this.subject = subject;
        this.group = group;
        this.number = number;
        this.day = day;
        this.start = start;
        this.duration = duration;
        this.room = room;
        this.capacity = capacity;
        enrolled = 0;
    }

    public Subject getSubject() { return subject; }
    public int getSubjectNumber() { return subject.getNumber(); }
    public String getGroup() { return group; }
    public int getNumber() { return number; }
    public String getDay() { return day; }
    public int getStart() { return start; }
    public int getDuration() { return duration; }
    public String getRoom() { return room; }
    public int getCapacity() { return capacity; }
    public int getEnrolled() { return enrolled; }

    public boolean canEnrol() {
        return enrolled < capacity;
    }

    public void enrol() {
        enrolled = enrolled + 1;
    }

    public void withdraw() {
        enrolled = enrolled - 1;
    }

    public boolean matches(int subjectNumber, String group) {
        return subject.matches(subjectNumber) && group.equals(this.group);
    }

    @Override
    public String toString() {
        return String.format("%d %s %d %s %s %02d:00 %dhrs %d/%d", subject.getNumber(), group, number, day, room, start, duration, enrolled, capacity);
    }
}
