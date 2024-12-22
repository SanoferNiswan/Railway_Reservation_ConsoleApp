package com.sano.reservation;

import java.util.*;

public class BookTicket {

    private static final int BERTH_LIMIT = 2 ;
    private static final int RAC_LIMIT = 2 ;
    private static final int WAITING__LIMIT = 2 ;

    private static int UPPER_BERTH_NO = -2 ;
    private static int MIDDLE_BERTH_NO = -1 ;
    private static int LOWER_BERTH_NO = 0 ;

    static ArrayList<Passenger> confirmedList = new ArrayList<>();

    static ArrayList<Passenger> upperBerth = new ArrayList<>();
    static ArrayList<Passenger> middleBerth = new ArrayList<>();
    static ArrayList<Passenger> lowerBerth = new ArrayList<>();

    static Queue<Passenger> RACQueue = new LinkedList<>();
    static Queue<Passenger> waitingQueue = new LinkedList<>();


    public static void  bookTicket(Passenger p){
        if(!allocateBerth(p,p.getPreference())){
            if(p.getPreference()!='u' && p.getPreference()!='l' && p.getPreference()!='m' ){
                System.out.println("invalid berth detail");
            }
            else if(updateQueue(p,RACQueue,RAC_LIMIT,"rac")){
                System.out.println("Ticket added to RAC "+p.getId());
            }
            else if(updateQueue(p,waitingQueue,WAITING__LIMIT,"waiting")){
                System.out.println("Ticket added to Waiting list "+p.getId());
            }
            else{
                System.out.println("Tickets not available");
            }
        }
        else{
            System.out.println("Ticket allocated successfully "+p.getId());
            confirmedList.add(p);
        }
    }

    public static boolean allocateBerth(Passenger p,char preference){
        if(preference=='u' && upperBerth.size()<BERTH_LIMIT){
            assignSeat(p,'u');
            upperBerth.add(p);
            return true;
        }else if(preference=='m' && middleBerth.size()<BERTH_LIMIT){
            assignSeat(p,'m');
            middleBerth.add(p);
            return true;

        }else if(preference=='l' && lowerBerth.size()<BERTH_LIMIT){
            assignSeat(p,'l');
            lowerBerth.add(p);
            return true;
        }
        return false;
    }

    public static void assignSeat(Passenger p,char preference){
        int seatNumber = getNextSeatNumber(preference);
        p.setSeatNumber(seatNumber);
        p.setTicketType("confirmed");
    }

    public static boolean updateQueue(Passenger p ,Queue<Passenger> queue,int limit,String type){
        if(queue.size()<limit){
            p.setTicketType(type);
            queue.add(p);
            return true;
        }
        return false;
    }

    public static int getNextSeatNumber(char preference){
        if(preference=='u') return UPPER_BERTH_NO+=3;
        else if(preference=='m') return MIDDLE_BERTH_NO+=3;
        else return LOWER_BERTH_NO+=3;
    }

   public static void displayTickets(){
        displayQueue(confirmedList,"Confirmed List");
        displayQueue(RACQueue,"RAC Queue");
        displayQueue(waitingQueue,"Waiting queue");
   }

   public static void displayQueue(Collection<Passenger> list,String type){
        System.out.println(type);
        int f=0;
        for(Passenger passenger:list){
            System.out.println(passenger.toString());
            f=1;
        }
        if(f==0) System.out.print("Empty\n");
   }

    public static void availableList() {
        System.out.println("Check out the no of seats available");
        System.out.println("Upper Berth "+(BERTH_LIMIT - upperBerth.size()));
        System.out.println("Middle Berth "+(BERTH_LIMIT - middleBerth.size()));
        System.out.println("Lower Berth "+(BERTH_LIMIT - lowerBerth.size()));
    }

}
