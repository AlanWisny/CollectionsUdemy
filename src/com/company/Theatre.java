package com.company;

import java.util.*;

public class Theatre {
    private final String theatreName;
    public List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if (seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()){
                return 1;
            } else {
                return 0;
            }
        }
    };

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++){
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)){
                    price = 14.00;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)){
                    price = 7.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

     public boolean reserveSeat(String seatNumber){
        // genius binary search that splits the sorted list
             Seat requestSeat = new Seat(seatNumber, 0);
             int foundSeat = Collections.binarySearch(seats,requestSeat, null);
             if (foundSeat >= 0){
                 return seats.get(foundSeat).reserve();
             } else {
                 System.out.println("There is no seat at " + seatNumber);
                 return false;
             }
//              "Brute force" -way to search for a number
//             for (Seat seat : seats){
//                 if (seat.getSeatNumber().equals(seatNumber)){
//                 }
//             }
//
//             if (requestSeat == null){
//                 System.out.println("There is no seat at " + seatNumber);
//                 return false;
//             }
//             return requestSeat.reserve();
        }

        public Collection<Seat> getSeats() {
            System.out.println("All reserved seat ###");
//         for(Seat seat : seats){
//             System.out.println(seat.getSeatNumber());
//         }
            return seats;
        }


    public String getTheatreName() {
        return theatreName;
    }





    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " now reserved.");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved){
                this.reserved = false;
                System.out.println("Reservation at seat " + seatNumber + " is cancelled.");
                return true;
            } else {
                return false;
            }
        }

        public double getPrice() {
            return price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
