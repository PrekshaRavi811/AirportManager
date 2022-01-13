/**
 * @author Preksha Tharigonda Ravikumar, Rishika Dadhich, Lab sec LC3
 * @version December 1st,2019
 */
import java.io.Serializable;
import java.util.ArrayList;

public interface Airline extends Serializable {
    //String getAmenities();
    int getFlightNumber(); //- make field static final- but useful for boarding pass
    //String toString(); //useful for boarding pass stuff but does it need to be in the interface?
    String getGate();
    void addPassenger(Passenger passenger);
    void removeAllPassengers();
    void closeGate();
    int getPassengerCount();
    void setPassengerCount(int passengerCount);
    void assignGate(); // implement in all airlines
    ArrayList<Passenger> getPassengers();
    void setMaxCapacity(int maxCapacity);
    int getMaxCapacity();
    String getName();
}
