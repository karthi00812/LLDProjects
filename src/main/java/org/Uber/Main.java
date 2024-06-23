package org.Uber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(":::Taxi Booking Application:::");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of taxi's");
        Uber ub = new Uber(sc.nextInt());
        while (true) {
            System.out.println("Please Choose options below");
            System.out.println("1. Book Taxi");
            System.out.println("2. GetBooking History");
            System.out.println("3. Get Taxi With Top Earning");
            System.out.println("4. Print All Taxi Location");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("PickUpPoint: ");
                    Character pickupPoint = sc.next().charAt(0);
                    System.out.println("DropPoint: ");
                    Character dropPoint = sc.next().charAt(0);
                    System.out.println("Pickup Time: ");
                    int time = sc.nextInt();
                    if (!ub.bookTaxi(pickupPoint, dropPoint, time)) {
                        System.out.println("No Taxi Available");
                    }
                    break;
                case 2:
                    ub.printBookingHistory();
                    break;
                case 3:
                    ub.topTaxiWithEarnings();
                    break;
                case 4:
                    ub.printAllTaxiPosition();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect option, Please Choose Correct options");
            }
        }
    }
}