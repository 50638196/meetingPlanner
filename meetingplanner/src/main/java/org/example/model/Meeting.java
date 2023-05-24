package org.example.model;

import org.example.model.enumeration.MeetingType;

import java.time.LocalTime;

public class Meeting {

    private String meetingName;
    private LocalTime startTime;
    private LocalTime endTime;
    private MeetingType meetingType;
    private int numberOfAttendees;
    private String roomName;

    public Meeting(String meetingName, LocalTime startTime, LocalTime endTime, MeetingType meetingType, int numberOfAttendees) {
        this.meetingName = meetingName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingType = meetingType;
        this.numberOfAttendees = numberOfAttendees;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public MeetingType getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(MeetingType meetingType) {
        this.meetingType = meetingType;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingName='" + meetingName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", meetingType=" + meetingType +
                ", numberOfAttendees=" + numberOfAttendees +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}
