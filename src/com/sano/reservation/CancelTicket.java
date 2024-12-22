package com.sano.reservation;

import java.util.HashMap;

public class CancelTicket extends BookTicket {

    private  static char preferenceTracker='\0';
    private static int cancelledSeatNumber = 0 ;
//    public static HashMap<Integer,Character> seatWithBerth = new HashMap<>();

    public static String cancelTicket(int id){
        for(Passenger p : confirmedList){
            if(p.getId()==id){
                cancel(p);
                return "success";
            }
        }
        for(Passenger p : RACQueue){
            if(p.getId()==id){
                cancel(p);
                return "success";
            }
        }
        for(Passenger p : waitingQueue){
            if(p.getId()==id){
                cancel(p);
                return "success";
            }
        }
        return "Invalid ID";
    }

    private static void cancel(Passenger p){
        if(p.getTicketType()=="confirmed"){
            preferenceTracker = p.getPreference();
            cancelledSeatNumber = p.getSeatNumber();
//            seatWithBerth.put(cancelledSeatNumber,preferenceTracker);
            deleteFromAllList(p);
            addRacToBerth(RACQueue.poll());
            addWaitingtoRac(waitingQueue.poll());
        }
        if(p.getTicketType()=="rac"){
            RACQueue.remove(p);
            addWaitingtoRac(waitingQueue.poll());
        }
        if(p.getTicketType()=="waiting"){
            waitingQueue.remove(p);
        }
    }

    public static void addRacToBerth(Passenger p) {
        if(p!=null){
            p.setPreference(preferenceTracker);
            p.setSeatNumber(cancelledSeatNumber);
            p.setTicketType("confirmed");
            if(preferenceTracker=='u'){
                upperBerth.add(p);
            }
            else if(preferenceTracker=='m'){
                middleBerth.add(p);
            }
            else{
                lowerBerth.add(p);
            }
            confirmedList.add(p);
//            seatWithBerth.remove(cancelledSeatNumber);
            cancelledSeatNumber = 0;
            preferenceTracker = '\0';
        }
    }

    public static void addWaitingtoRac(Passenger p){
        if(p!=null){
            p.setTicketType("rac");
            RACQueue.add(p);
        }
    }

    public static void deleteFromAllList(Passenger p){
        confirmedList.remove(p);
        upperBerth.remove(p);
        middleBerth.remove(p);
        lowerBerth.remove(p);
    }
}
