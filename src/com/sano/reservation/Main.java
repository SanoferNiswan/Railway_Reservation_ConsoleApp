package com.sano.reservation;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        int choice;
        do{
            System.out.println("Enter choice : \n1 - Booking ticket \n2 - Cancel ticket\n3 - Display All booking\n4 - Display Availability\n6 - Exit");
            choice = in.nextInt();
            switch(choice){
                case 1 :
                    in.nextLine();
                    System.out.println("Enter name");
                    String name=in.nextLine();
                    System.out.println("Enter age");
                    int age=in.nextInt();
                    System.out.println("Enter preference : 'u' - upper berth, 'm' - middle berth, 'l' - lower berth " );
                    char berthType = in.next().charAt(0);
                    Passenger p = new Passenger(name,age,berthType);
                    if(berthType!='u' || berthType!='l' || berthType!='m'){
                        BookTicket.bookTicket(p);
                    }else System.out.println("Invalid berth");
                    break;
                case 2 :
                    System.out.println("Enter ticket ID");
                    int id=in.nextInt();
                    String message = CancelTicket.cancelTicket(id);
                    System.out.println(message);
                    break;
                case 3 :
                    BookTicket.displayTickets();
                    break;
                case 4 :
                    System.out.println("Availability of seats");
                    BookTicket.availableList();
                    break;
                case 6 :
                    System.out.println("Thanks for your kindness");
                    in.close();
                    break;
                default:
                    System.out.println("Invalid choice try again..!");
            }
        }while(choice!=6);
    }
}
