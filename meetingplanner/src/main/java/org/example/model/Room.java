package org.example.model;

import org.example.model.enumeration.Equipment;

import java.util.Set;

public class Room {
    private String name;
    private int capacity;
    private Set<Equipment> availableEquipments;

    private boolean[] reservations;
    private boolean reserved = false;


    public Room() {
    }

    public Room(String name, int capacity, Set<Equipment> availableEquipments) {
        this.name = name;
        this.capacity = capacity;
        this.availableEquipments = availableEquipments;
        reservations = new boolean[12];

    }

    public void reserve(int hour) {
        reservations[hour - 8] = true;
        reservations[hour - 7] = true;

    }

    public boolean isAvailable(int hour) {
        if (hour >= 8 && hour <= 19) {
            // Check if the current hour and the next hour are both available
            return !reservations[hour - 8] && !reservations[hour - 7];
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<Equipment> getAvailableEquipments() {
        return availableEquipments;
    }

    public void setAvailableEquipments(Set<Equipment> availableEquipments) {
        this.availableEquipments = availableEquipments;
    }

    public boolean[] getReservations() {
        return reservations;
    }

    public void setReservations(boolean[] reservations) {
        this.reservations = reservations;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }


    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", availableEquipments=" + availableEquipments +
                ", reserved=" + reserved +
                '}';
    }

}
