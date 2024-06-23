package org.Uber;

import org.Uber.Taxi.Taxi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Uber {

    private final ArrayList<Taxi> listOfTaxi;
    private final ArrayList<Taxi> bookingHistory;

    Uber(int noOfTaxi) {
        listOfTaxi = new ArrayList<>();
        bookingHistory = new ArrayList<>();
        for (int index = 0; index < noOfTaxi; index++) {
            listOfTaxi.add(new Taxi(index + 1));
        }
    }

    public boolean bookTaxi(Character pickupPoint, Character dropPoint, int pickupTime) {

        Taxi booked_taxi = null;
        int min = Integer.MAX_VALUE;
        for (Taxi tx : listOfTaxi) {
            if (tx.getDropTime() <= pickupTime && Math.abs(pickupPoint - tx.getCurrentPosition()) <= min) {
                if (Math.abs(pickupPoint - tx.getCurrentPosition()) == min && booked_taxi != null) {
                    booked_taxi = booked_taxi.getEarnings() < tx.getEarnings() ? booked_taxi : tx;
                } else {
                    booked_taxi = tx;
                    min = Math.abs(pickupPoint - tx.getCurrentPosition());
                }
            }
        }
        if (booked_taxi != null) {
            booked_taxi.setPickupPoint(pickupPoint);
            booked_taxi.setPickupTime(pickupTime);
            booked_taxi.setDropPoint(dropPoint);
            booked_taxi.setDropTime(pickupTime + Math.abs(pickupPoint - dropPoint));
            int km = Math.abs(pickupPoint - dropPoint) * 15;
            booked_taxi.setEarnings(booked_taxi.getEarnings() + ((km - 5) * 10) + 100);
            booked_taxi.setCurrentPosition(dropPoint);
            bookingHistory.add(booked_taxi.clone());
            System.out.printf("Taxi %d is booked\n", booked_taxi.getId());
        }
        return booked_taxi != null;
    }

    public void printBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.err.println("No Booking Available");
            System.out.println();
            return;
        }
        for (Taxi tx : bookingHistory) {
            System.out.println(tx);
        }
    }

    public void printAllTaxiPosition() {

        System.out.println("Taxi's Position: ");
        for (Taxi tx : listOfTaxi) {
            System.out.print(tx.getId() + " -- ");
            System.out.println(tx.getCurrentPosition());
        }
    }

    public void topTaxiWithEarnings() {

        if (bookingHistory.isEmpty()) {
            System.err.println("No Bookings made");
            return;
        }
        System.out.println("Taxi with Top Earnings are: ");
        System.out.println(listOfTaxi.stream().sorted(Comparator.comparing(Taxi::getEarnings).reversed()).limit(3).filter((tx) -> tx.getEarnings() != 0.0).collect(Collectors.toList()));
        System.out.println();
    }
}
