/** A subclass of the online reservation system that allows users to make and cancel reservations
 * Alina Hyder
 * 20/11/2024
 */

import java.util.HashMap;
import java.util.Scanner;

public class Reservation {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<Integer,Ticket> tickets;

    public Reservation(){
        tickets = new HashMap<>();
    }

    public static void makeReservation(String name){
        System.out.println("Please enter the following details to make your reservation.");
        System.out.println("Number of passengers:");
        int passengers = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Train number:");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Train name:");
        String trainName = scanner.nextLine();
        System.out.println("Class type:");
        String classType = scanner.nextLine();
        System.out.println("Date (Please enter in the format DD/MM/YYYY):");
        String date = scanner.nextLine();
        System.out.println("Departing destination:");
        String from = scanner.nextLine();
        System.out.println("Arriving destination:");
        String to = scanner.nextLine();

        var ticket = new Ticket(name,passengers,number,trainName,classType,date,from,to);
        tickets.put(ticket.getPnr(),ticket);

        System.out.println("You have successfully made your reservation! Your ticket details are as follows:");
        System.out.println(ticket);
        System.out.println(" ");
    }

    public static void cancelReservation(String name){
        System.out.println("Enter your PNR number:");
        int pnr = scanner.nextInt();
        scanner.nextLine();

        if (tickets != null && tickets.containsKey(pnr) && tickets.get(pnr).getName().equals(name)){
            System.out.println(tickets.get(pnr));
            System.out.println("Please insert 'OK' if you would like to confirm the cancellation of this ticket or 'CANCEL' to return to the main menu.");
            String confirm = scanner.nextLine().toUpperCase();
            if (confirm.equals("OK")) {
                tickets.remove(pnr);
                System.out.println("You have successfully cancelled your reservation.");
            }
            else if (confirm.equals("CANCEL"))
                System.out.println("Returning to main menu...");
        }
        else{
            System.out.println("The PNR number you have entered cannot be found.");
        }

        System.out.println(" ");
    }
}
