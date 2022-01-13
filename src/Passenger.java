/**
 * @author Preksha Tharigonda Ravikumar, Rishika Dadhich, Lab sec LC3
 * @version December 1st,2019
 */
import java.io.Serializable;

public class Passenger implements Serializable {

    private String firstName;
    private String lastName;
    private int age;
    private  BoardingPass boardingPass;
    private Airline airlineChoice;

    public Passenger(String firstName, String lastName, int age, Airline airlineChoice) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.airlineChoice = airlineChoice;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    public Airline getAirlineChoice() {
//gui
        return this.airlineChoice;
    }
    public void setAirlineChoice(Airline airlineChoice) {
        this.airlineChoice = airlineChoice;
    } // book a ticket method
    public void setBoardingPass(BoardingPass boardingPass) {
        this.boardingPass = boardingPass;
    }
    public BoardingPass createBoardingPass(Passenger p) {
        return this.boardingPass = new BoardingPass(p);
    }
    public BoardingPass getBoardingPass() {
        return boardingPass;
    }


    @Override
    public String toString() {
        String personString = firstName.substring(0,1).toUpperCase() + ", " + lastName.toUpperCase() + ", " + age;
        return personString;
    }
}

