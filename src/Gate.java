/**
 * @author Preksha Tharigonda Ravikumar, Rishika Dadhich, Lab sec LC3
 * @version December 1st,2019
 */
import java.io.Serializable;
import java.util.Random;

public class Gate implements Serializable {

    private int gateNumber;
    private char terminal;

    public Gate(char terminal, int gateNumber) {
        this.terminal = terminal;
        this.gateNumber = gateNumber;
    }
    public Gate() {
        Random random = new Random();
        int tno = random.nextInt(3);

        if (tno == 0)
            terminal = 'A';
        else if (tno == 1)
            terminal = 'B';
        else terminal = 'C';

        gateNumber = random.nextInt(18) + 1;
    }
    public int getGateNumber(){
        return this.gateNumber;
    }
    public char getTerminal(){
        return this.terminal;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setTerminal(char terminal) {
        this.terminal = terminal;
    }



}
