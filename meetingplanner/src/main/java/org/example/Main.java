package org.example;

import org.example.service.PlannerService;
import org.example.service.impl.PlannerServiceImpl;

public class Main {
    public static void main(String[] args) {
        PlannerService  plannerService=new PlannerServiceImpl();
        plannerService.scheduleMeeting();
    }
}