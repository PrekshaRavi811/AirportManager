/**
 * @author Preksha Tharigonda Ravikumar, Rishika Dadhich, Lab sec LC3
 * @version December 1st,2019
 */
import java.io.Serializable;

public class BoardingPass implements Serializable {
//    private Airline airline;
//    private String firstName;
//    private String lastName;
//    private int age;
//    private char terminal;
//    private int gateNumber;
//    private String airlineChoice;
    private Passenger passenger;

    public BoardingPass(Passenger p) { // separate boarding pass object for each passenger
        this.passenger = p;
    }

 //   @Override
//    public String toString() {
//
//    }
    public String printBoardingPass() { // can have print method with passenger parameter but they said not to in the handout?
        String boardingPass = ("<html>-----------------------------------------------------------------------------------<br>"
        + "<b>BOARDING PASS FOR FLIGHT NUMBER " + passenger.getAirlineChoice().getFlightNumber() +
                " WITH " +
                passenger.getAirlineChoice().getName() + "</b><br>" +
        "<b>PASSENGER FIRST NAME: </b>" + passenger.getFirstName() + "<br>" +
        "<b>PASSENGER LAST NAME: </b>" + passenger.getLastName() + "<br>" +
        "<b>PASSENGER AGE: </b>" + passenger.getAge() + "<br>" +
        "You can now begin boarding at Gate " + passenger.getAirlineChoice().getGate() + "<br>" +
        "-----------------------------------------------------------------------------------<br></html>");
        return boardingPass;
    } // make return type String
}
