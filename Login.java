/** A subclass of the online reservation system that allows users to log in and create an account
 * Alina Hyder
 * 20/11/2024
 */

import java.util.HashMap;
import java.util.Scanner;

public class Login {
    static Scanner scanner = new Scanner(System.in);
    private static HashMap<String,String> users;
    private static String username;

    public Login(){
        users = new HashMap<>();
    }

    public static void logInExistingUser(){
        String password;
        System.out.println("Username:");
        username = scanner.next().toLowerCase();
        
        if (!checkExistingUser(username)) {
            System.out.println("User does not exist.");
            System.out.println("Please create an account.");
            createNewUser();
            return;
        }

        System.out.println("Password:");
        scanner.nextLine();
        password = scanner.nextLine();

        if (validateUser(username, password))
            System.out.println("Logged in successfully.");
        else if (checkExistingUser(username)) {
            while (!validateUser(username, password)) {
                System.out.println("Incorrect password.");
                System.out.println("Please re-enter your password:");
                password = scanner.nextLine();
            }
            if (validateUser(username, password))
                System.out.println("Logged in successfully.");
        }
        System.out.println(" ");
    }

    public static void createNewUser(){
        System.out.println("Create a username with no spaces:");
        username = scanner.next().toLowerCase();
        while (checkExistingUser(username)){
            System.out.println("This username already exists.");
            System.out.println("Please choose another username.");
            username = scanner.next().toLowerCase();
        }
        System.out.println("Create a password:");
        scanner.nextLine();
        String newPassword = scanner.nextLine();

        users.put(username,newPassword);
        System.out.println("New user " + username + " has been created successfully.");
        System.out.println(" ");
    }

    public static String getUsername(){
        return username;
    }

    private static boolean validateUser(String username, String password){
        if (users != null)
            return users.containsKey(username) && users.get(username).equals(password);
        return false;
    }

    private static boolean checkExistingUser(String username){
        if (users != null)
            return users.containsKey(username);
        return false;
    }
}
