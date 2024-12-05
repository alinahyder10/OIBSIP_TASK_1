/** Creating an online reservation system that allows users to log in, make and cancel reservations
 * Alina Hyder
 * 20/11/2024
 */

public class Main {
    public static void main(String[] args) {
        new Login();
        new Reservation();
        Menu.loginPrompt();
        Menu.optionMenu();
     }
}
