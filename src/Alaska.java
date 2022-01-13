/**
 * @author Preksha Tharigonda Ravikumar, Rishika Dadhich, Lab sec LC3
 * @version December 1st,2019
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Alaska implements Airline, Serializable {
    private int flightNumber;
    private Gate alaskaGate;
    private ArrayList<Passenger> passengers;
    private int maxCapacity;
    private int passengerCount;

    public Alaska() {
        //Random random = new Random();
        flightNumber = 18000; // figure out random flight number
        //alaskaGate = new Gate();
        passengers = new ArrayList<>();
        //maxCapacity = 100;
        passengerCount = passengers.size();

    }
    public String getAmenities() {
        return "is awesome.";
    }
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    } // for booking

    public void closeGate(){
        if(passengers.size()==maxCapacity) {
            alaskaGate = null;
            //alaskaGate = new Gate();        //delete this if no more than 100 required; after this create another
            // alaska object in gui part.
        }
    }
    public int getFlightNumber() {
        return this.flightNumber;
    }
    public String getGate() {
        return alaskaGate.getTerminal() + String.valueOf(alaskaGate.getGateNumber());
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
            this.alaskaGate = new Gate();
        }
    }
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
    public void removeAllPassengers() {
        for(int i = (passengers.size()-1); i >= 0; i--){
            passengers.remove(i);
            System.out.println("alaska remove, current size :" + passengers.size());
        }
    }

    @Override
    public String toString() {
        String gate = "";
        if (passengerCount >= maxCapacity) {
            gate = "no gate, flight is full";
        } else if (passengerCount == 0) {
            gate = "gate not assigned";
        }else if (alaskaGate != null) {
            gate = alaskaGate.getTerminal() + String.valueOf(alaskaGate.getGateNumber());
        }
        String alaskaDetails = String.format("ALASKA\n%d/%d\n" +  gate + "\n" +
                "Alaska passenger list\n",getPassengerCount(),getMaxCapacity());
        for (Passenger passenger:passengers) {
            alaskaDetails = alaskaDetails + passenger.toString() + "\n";
        }
        return alaskaDetails;
    }
    public void setAlaskaGate(char terminal, int gateNumber) {
        this.alaskaGate = new Gate(terminal, gateNumber);
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    public String getName(){
        return "Alaska";
    }


}
