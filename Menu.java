/** A subclass of the online reservation system that stores the login and option menus
 * Alina Hyder
 * 20/11/2024
 */

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static void loginPrompt(){
        System.out.println("*****ONLINE RESERVATION SYSTEM*****");
        System.out.println("Please login to begin:");
        System.out.println("1. Existing user");
        System.out.println("2. New user");
        int choice = scanner.nextInt();

        if (choice == 1)
            Login.logInExistingUser();
        else if (choice == 2)
            Login.createNewUser();
    }

    public static void optionMenu(){
        while(true){
            System.out.println("Please select what you would like to do:");
            System.out.println("1. Change user");
            System.out.println("2. Make a reservation");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Log out");
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("1. Existing user");
                    System.out.println("2. New user");
                    int choice1 = scanner.nextInt();
                    scanner.nextLine();
                    if (choice1 == 1)
                        Login.logInExistingUser();
                    else
                        Login.createNewUser();
                    break;
                case 2:
                    Reservation.makeReservation(Login.getUsername());
                    break;
                case 3:
                    Reservation.cancelReservation(Login.getUsername());
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Please choose a valid option.");
            }
        }
    }
}
