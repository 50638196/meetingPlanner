package org.example.utils;

import org.example.model.Meeting;
import org.example.model.Room;
import org.example.model.enumeration.Equipment;
import org.example.model.enumeration.MeetingType;

import java.time.LocalTime;
import java.util.*;

public class DataHolder {


    public static List<Room> getRoomsData() {

        return List.of(
                new Room("E1001", 23, Collections.emptySet()),
                new Room("E1002", 10, Set.of(Equipment.ECRAN)),
                new Room("E1003", 8, Set.of(Equipment.PIEUVRE)),
                new Room("E1004", 4, Set.of(Equipment.TABLEAU)),
                new Room("E2001", 4, Collections.emptySet()),
                new Room("E2002", 15, Set.of(Equipment.ECRAN, Equipment.WEBCAM)),
                new Room("E2003", 7, Collections.emptySet()),
                new Room("E2004", 9, Set.of(Equipment.TABLEAU)),
                new Room("E3001", 13, Set.of(Equipment.ECRAN, Equipment.WEBCAM, Equipment.PIEUVRE)),
                new Room("E3002", 8, Collections.emptySet()),
                new Room("E3003", 9, Set.of(Equipment.ECRAN, Equipment.PIEUVRE)),
                new Room("E3004", 4, Collections.emptySet())
        );
    }

    public static List<Meeting> getMeeingData() {

        return List.of(
                new Meeting("Reunion 1", LocalTime.of( 9, 0), LocalTime.of( 10, 0), MeetingType.VC, 8),
                new Meeting("Reunion 2", LocalTime.of( 9, 0), LocalTime.of( 10, 0), MeetingType.VC, 6),
                new Meeting("Reunion 3", LocalTime.of( 11, 0), LocalTime.of( 12, 0), MeetingType.RC, 4),
                new Meeting("Reunion 4", LocalTime.of( 11, 0), LocalTime.of( 12, 0), MeetingType.RS, 2),
                new Meeting("Reunion 5", LocalTime.of( 11, 0), LocalTime.of( 12, 0), MeetingType.SPEC, 9),
                new Meeting("Reunion 6", LocalTime.of( 9, 0), LocalTime.of( 10, 0), MeetingType.RC, 7),
                new Meeting("Reunion 7", LocalTime.of( 8, 0), LocalTime.of( 9, 0), MeetingType.VC, 9),
                new Meeting("Reunion 8", LocalTime.of( 8, 0), LocalTime.of( 9, 0), MeetingType.SPEC, 10),
                new Meeting("Reunion 9", LocalTime.of( 9, 0), LocalTime.of( 10, 0), MeetingType.SPEC, 5),
                new Meeting("Reunion 10", LocalTime.of( 9, 0), LocalTime.of( 10, 0), MeetingType.RS, 4),
                new Meeting("Reunion 11", LocalTime.of( 9, 0), LocalTime.of( 10, 0), MeetingType.RC, 8),
                new Meeting("Reunion 12", LocalTime.of( 11, 0), LocalTime.of( 12, 0), MeetingType.VC, 12),
                new Meeting("Reunion 13", LocalTime.of( 11, 0), LocalTime.of( 12, 0), MeetingType.SPEC, 5),
                new Meeting("Reunion 14", LocalTime.of( 8, 0), LocalTime.of( 9, 0), MeetingType.VC, 3),
                new Meeting("Reunion 15", LocalTime.of( 8, 0), LocalTime.of( 9, 0), MeetingType.SPEC, 2),
                new Meeting("Reunion 16", LocalTime.of( 8, 0), LocalTime.of( 9, 0), MeetingType.VC, 12),
                new Meeting("Reunion 17", LocalTime.of( 10, 0), LocalTime.of( 11, 0), MeetingType.VC, 6),
                new Meeting("Reunion 18", LocalTime.of( 11, 0), LocalTime.of( 12, 0), MeetingType.RS, 2),
                new Meeting("Reunion 19", LocalTime.of( 9, 0), LocalTime.of( 10, 0), MeetingType.RS, 4),
                new Meeting("Reunion 20", LocalTime.of( 9, 0), LocalTime.of( 10, 0), MeetingType.RC, 7)
        );
    }

    /**
     * Retrieves the required equipment for different meeting types.
     *
     * @return A map containing the required equipment for each meeting type.
     */
    public static Map<MeetingType, Set<Equipment>> getRequiredEquipment() {

        Map<MeetingType, Set<Equipment>> map = new HashMap<>();

        map.put(MeetingType.VC, Set.of(Equipment.ECRAN, Equipment.PIEUVRE, Equipment.WEBCAM));
        map.put(MeetingType.RC, Set.of(Equipment.ECRAN, Equipment.PIEUVRE, Equipment.TABLEAU));
        map.put(MeetingType.SPEC, Set.of(Equipment.TABLEAU));
        map.put(MeetingType.RS, Collections.emptySet());

        return map;
    }

    /**
     * Retrieves the additional equipment and their quantities.
     *
     * @return A map containing the additional equipment as keys and their corresponding quantities as values.
     */
    public static Map<Equipment, Integer> getAdditionalEquipment() {

        Map<Equipment, Integer> map = new HashMap<>();
        map.put(Equipment.ECRAN, 5);
        map.put(Equipment.PIEUVRE, 4);
        map.put(Equipment.WEBCAM, 4);
        map.put(Equipment.TABLEAU, 2);
        return map;
    }


}
