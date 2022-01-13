/**
 * @author Preksha Tharigonda Ravikumar, Rishika Dadhich, Lab sec LC3
 * @version December 1st,2019
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Delta implements Airline {
    private int flightNumber;
    private Gate deltaGate;
    private ArrayList<Passenger> passengers;
    private int maxCapacity;
    private int passengerCount;
    public Delta() {
        //Random random = new Random();
        flightNumber = 18000; // figure out random flight number
        //deltaGate = new Gate();
        passengers = new ArrayList<>();
        // maxCapacity = 100;

    }
    public String getAmenities() {
        return "is awesome.";
    }
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
    public void closeGate(){
        if(passengers.size()==maxCapacity) {
            deltaGate = null;
            //alaskaGate = new Gate();        //delete this if no more than 100 required; after this create another
            // alaska object in gui part.
        }
    }
    public int getFlightNumber() {
        return this.flightNumber;
    }
    public String getGate() {
        return deltaGate.getTerminal() + (String.valueOf(deltaGate.getGateNumber()));
    }
    public int getPassengerCount() {
        return this.passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
    public void assignGate() {
        //Random random = new Random();
        if (passengers.size() == 1 | passengerCount == 1) {
            this.deltaGate = new Gate();
        }
    }
    public int getMaxCapacity() {
        return this.maxCapacity;
    }
    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
    public void removeAllPassengers() {
        for(int i = (passengers.size()-1); i >= 0; i--){
            passengers.remove(i);
            System.out.println("delta remove, current size :" + passengers.size());
        }
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        String gate = "";

        if (passengerCount >= maxCapacity) {
            gate = "no gate, flight is full";
        } else if (passengerCount == 0) {
            gate = "gate not assigned";
        } else if (deltaGate != null) {
            gate = deltaGate.getTerminal() + String.valueOf(deltaGate.getGateNumber());
        }
        String deltaDetails = String.format("DELTA\n%d/%d\n" + gate + "\n" +
                "Delta passenger list\n",getPassengerCount(),getMaxCapacity());
        for (Passenger passenger:passengers) {
            deltaDetails = deltaDetails + passenger.toString() + "\n";
        }
        return deltaDetails;
    }
    public void setDeltaGate(char terminal, int gateNumber) {
        this.deltaGate = new Gate(terminal, gateNumber);
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    public String getName(){
        return "Delta";
    }
}

