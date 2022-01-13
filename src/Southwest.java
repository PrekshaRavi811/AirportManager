/**
 * @author Preksha Tharigonda Ravikumar, Rishika Dadhich, Lab sec LC3
 * @version December 1st,2019
 */
import java.util.ArrayList;
import java.util.Random;

public class Southwest implements Airline {
    private int flightNumber;
    private Gate southwestGate;
    private ArrayList<Passenger> passengers;
    private int maxCapacity;
    private int passengerCount;

    public Southwest() {
        //Random random = new Random();
        flightNumber = 18000; // figure out random flight number
        //southwestGate = new Gate();
        passengers = new ArrayList<>();
        // maxCapacity = 100;

    }

    public String getAmenities() {
        return "is awesome.";
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void closeGate() {
        if (passengers.size() == maxCapacity) {
            southwestGate = null;
            //alaskaGate = new Gate();        //delete this if no more than 100 required; after this create another
            // alaska object in gui part.
        }
    }

    public int getFlightNumber() {
        return this.flightNumber;
    }

    public String getGate() {
        return southwestGate.getTerminal() + String.valueOf(southwestGate.getGateNumber());
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
            this.southwestGate = new Gate();
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
            System.out.println("southwest remove, current size :" + passengers.size());
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
        } else if (southwestGate != null) {
            gate = southwestGate.getTerminal() + String.valueOf(southwestGate.getGateNumber());
        }
        String southwestDetails = String.format("SOUTHWEST\n%d/%d\n" + gate + "\n" +
                "Southwest passenger list\n",getPassengerCount(),getMaxCapacity());
        for (Passenger passenger:passengers) {
            southwestDetails = southwestDetails + passenger.toString() + "\n";
        }
        return southwestDetails;
    }
    public void setSouthwestGate(char terminal, int gateNumber) {
        this.southwestGate = new Gate(terminal, gateNumber);
    }
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    public String getName(){
        return "Southwest";
    }


}
