/** A subclass of the online reservation system that stores all the reservation details
 * Alina Hyder
 * 20/11/2024
 */

public class Ticket {
    private int pnr;
    private static int counter = 100;
    private String name;
    private int numberOfPassengers;
    private int trainNumber;
    private String trainName;
    private String classType;
    private String date;
    private String departureDestination;
    private String arrivalDestination;

    public Ticket(String name, int numberOfPassengers, int trainNumber, String trainName, String classType, String date, String departureDestination, String arrivalDestination){
        this.pnr = counter++;
        this.name = name;
        this.numberOfPassengers = numberOfPassengers;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.date = date;
        this.departureDestination = departureDestination;
        this.arrivalDestination = arrivalDestination;
    }

    public int getPnr() {
        return pnr;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "PNR: " + pnr + ", Ticket Holder: " + name + ", Number of Passengers: " + numberOfPassengers + "\nTrain Number: "
                + trainNumber + ", Train Name: " + trainName + ", Class Type: " + classType + "\nDate: " + date + " From: " + departureDestination
                + " To: " + arrivalDestination;
    }
}
