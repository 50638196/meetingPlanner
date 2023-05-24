package org.example.service.impl;

import org.example.model.Meeting;
import org.example.model.Room;
import org.example.service.PlannerService;
import org.example.utils.DataHolder;
import org.example.model.enumeration.Equipment;
import org.example.model.enumeration.MeetingType;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class PlannerServiceImpl implements PlannerService {

    List<Room> roomList;
    List<Meeting> meetingList;
    Map<MeetingType, Set<Equipment>> requiredEquipmentData;
    Map<Equipment, Integer> additionalEquipmentData;


    public PlannerServiceImpl() {
        roomList=DataHolder.getRoomsData();
        meetingList=DataHolder.getMeeingData();
        requiredEquipmentData=DataHolder.getRequiredEquipment();
        additionalEquipmentData=DataHolder.getAdditionalEquipment();
    }

    @Override
    public void scheduleMeeting() {

//        meetingList.forEach(meeting -> {
//
//            Optional<Room> availableRoom = roomList.stream()
//                    .sorted(Comparator.comparingInt(room -> Math.abs(room.getCapacity() - meeting.getNumberOfAttendees())))
//                    .filter(room -> room.isAvailable(meeting.getStartTime().getHour()))
//                    .filter(room -> room.getCapacity() >= meeting.getNumberOfAttendees())
//                    .filter(room -> isMatchEquipment(room, meeting.getMeetingType()))
//                    .findFirst();
//
//            availableRoom.ifPresent(room -> {
//                room.reserve(meeting.getStartTime().getHour());
//                meeting.setRoomName(room.getName());
//            });
//        });
        meetingList.forEach(meetingAgenda -> {
            Optional<Room> first = roomList.stream()
                    .sorted(Comparator.comparingInt(room -> Math.abs(room.getCapacity() - meetingAgenda.getNumberOfAttendees())))
                    .filter(room -> room.isAvailable(meetingAgenda.getStartTime().getHour()))
                    .filter(room -> room.getCapacity() >= meetingAgenda.getNumberOfAttendees())
                    .filter(room -> isMatchEquipment(room, meetingAgenda.getMeetingType())).findFirst();
            // .min((o1, o2) -> o1.getCapacity()>o2.getCapacity() ? 1 : -1);

            if (first.isPresent()) {
                // System.out.println("rooms = " + first.get());
                Room room = first.get();
                room.reserve(meetingAgenda.getStartTime().getHour());
                // room.setAvailabilityTime(meetingAgenda.getEndTime().plusHours(1L).toLocalTime());
              //  room.setRoomId(meetingAgenda.getMeetingName());
                System.out.println("************. = ");
                System.out.println("room = " + room);
                meetingAgenda.setRoomName(room.getName());
               // meetingAgenda.setAffected(true);
              //  meetingAgenda.setRoomAffected(room.getName());


            }
        });

        System.out.println("\"**************************************** mEETING not reserved****************************************");

        meetingList.forEach(meeting -> {
            if (meeting.getRoomName() == null)
                System.out.println("meeting = " + meeting);
        });


        System.out.println("\"**************************************** mEETING  reserved****************************************");

        meetingList.forEach(meeting -> {
            if (meeting.getRoomName() != null)
                System.out.println("meeting = " + meeting);
        });





    }

    private boolean isMatchEquipment(Room room, MeetingType meetingType) {
        Map<MeetingType, Set<Equipment>> meetingTypeSetMap = requiredEquipmentData;
        Set<Equipment> requiredEquipment = meetingTypeSetMap.get(meetingType);
        Set<Equipment> availableEquipments = room.getAvailableEquipments();
        Map<Equipment, Integer> additionalEquipment = additionalEquipmentData;
        AtomicBoolean isMatch = new AtomicBoolean(false);

        if (availableEquipments.containsAll(requiredEquipment)) {
            return true;
        }
        else {
            requiredEquipment.forEach(e -> {

                if (additionalEquipment.containsKey(e) ) {
                    int i = additionalEquipment.get(e) - 1;
                    if (i != 0) {
                        additionalEquipment.put(e, i - 1);
                        isMatch.set(true);
                    }
                }
            });
            return isMatch.get();
        }


    }

}
