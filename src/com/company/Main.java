package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Theatre t = new Theatre("Olympian", 8, 12);
    List<Theatre.Seat> seatCopy = new ArrayList<>(t.seats);
    printList(seatCopy);


    if (t.reserveSeat("D12")){
        System.out.println("Please pay for D12");
    } else {
        System.out.println("Seat already reserved");
    }


        if (t.reserveSeat("B13")){
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }


        List<Theatre.Seat> reverseSeats = new ArrayList<>(t.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeat = new ArrayList<>(t.getSeats());
        priceSeat.add(t.new Seat("B00", 13.00));
        priceSeat.add(t.new Seat("A00", 13.00));
        Collections.sort(priceSeat, Theatre.PRICE_ORDER);
        printList(priceSeat);



    // Reverses the order of the List
    Collections.reverse(seatCopy);
    // Pseudo-random shuffle method
    Collections.shuffle(seatCopy);

    // Gives the smallest value in the List
    Theatre.Seat minSeat = Collections.min(seatCopy);

    //Gives the highest value in the List , even out of order
    Theatre.Seat maxSeat = Collections.max(seatCopy);

        System.out.println(minSeat.getSeatNumber());
        System.out.println(maxSeat.getSeatNumber());

        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seat");
        printList(t.seats);

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);
    }


    public static void printList(List<Theatre.Seat> list){
        for (Theatre.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("============================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list){
        for (int i=0; i<list.size() -1; i++) {
            for (int j=i+1; j<list.size(); j++){
                if (list.get(i).compareTo(list.get(j)) >0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
