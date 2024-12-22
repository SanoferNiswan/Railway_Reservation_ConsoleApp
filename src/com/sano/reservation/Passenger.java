package com.sano.reservation;

public class Passenger {
    private static  int idProvider = 0;
    private int id;
    private String name;
    private int age;
    private char preference;
    private int seatNumber;
    private String ticketType;


    public Passenger(String name, int age, char preference){
        this.id=++idProvider;
        this.name=name;
        this.age=age;
        this.preference=preference;
    }

    public static int getIdProvider() {
        return idProvider;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getPreference() {
        return preference;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setId(int id) {
        this.idProvider = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPreference(char preference) {
        this.preference = preference;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", preference=" + preference +
                ", seatNumber=" + seatNumber +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }

    public static void main(String[] args){
        Passenger p = new Passenger("sano",21,'u');
        System.out.println(p.toString());
    }
}
