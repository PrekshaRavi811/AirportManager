/**
 * @author Preksha Tharigonda Ravikumar, Rishika Dadhich, Lab sec LC3
 * @version December 1st,2019
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;

// check hostname and port methods


public class ReservationClient { // two choices for sockets and streams --> fields or constructors. doing in main complicates.
    private Socket socket;
    DataOutputStream dos;
    DataInputStream dis;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    ReservationClient.ResponseListener listener;


    public ReservationClient() throws IOException, ConnectException {
        String portString;
        String hostname;
        int port = 0;
        try {

            do {
                hostname = (String) JOptionPane.showInputDialog(null,
                        "What is the hostname you'd like to connect to? ", "Hostname?", JOptionPane.PLAIN_MESSAGE);
                if (hostname == null) {
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;
                } else if (hostname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter valid hostname and port.", "Hostname?", JOptionPane.ERROR_MESSAGE);
                } else {
                    // }while(true);
                    //do {
                    portString = (String) JOptionPane.showInputDialog(null,
                            "What is the port you'd like to connect to? ",
                            "Port?", JOptionPane.PLAIN_MESSAGE);
                    //port = Integer.parseInt(portString);
                    if (portString == null) {
                        JOptionPane.showMessageDialog(null, "Goodbye!");
                        break;
                    } else if (portString.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter valid hostname and port.", "Port?", JOptionPane.ERROR_MESSAGE);
                    } else if (!isParsable(portString)) {
                        JOptionPane.showMessageDialog(null, "Error: the specified port must be a non-negative integer!", "Port?",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        port = Integer.parseInt(portString);
                        break;
                    }
                }
            } while (true);

//} else
//    JOptionPane.showMessageDialog(null, "GOODBYE!");


            this.socket = new Socket(hostname, port);
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.dis = new DataInputStream(socket.getInputStream());
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());
            this.listener = new ResponseListener(socket, dis, dos, ois, oos);
        } catch(ConnectException c) {
            JOptionPane.showMessageDialog(null, "Error in connection");
        }
    }
    private static boolean isParsable(String string) {
        return string.chars()
                .mapToObj(Character::isDigit)
                .reduce(Boolean::logicalAnd)
                .orElse(Boolean.FALSE);
    } //isParsable

    public void clientFunction() throws IOException {
        Thread listenerThread = new Thread(listener);
        listenerThread.start();
        UserInterface gui = new UserInterface(dos,oos,listener);
        gui.GUI();

    }

    public static void main(String[] args) throws IOException {
        ReservationClient client = new ReservationClient();
        client.clientFunction();
    }

    class ResponseListener extends Thread{
        Socket socket;
        DataInputStream dis;
        DataOutputStream dos;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        Alaska alaska;
        Delta delta;
        Southwest southwest;



        ResponseListener(Socket socket, DataInputStream dis, DataOutputStream dos, ObjectInputStream ois,ObjectOutputStream oos) {
            this.socket = socket;
            this.dis = dis;
            this.dos = dos;
            this.ois = ois;
            this.oos = oos;
        }

        public void run() {
            while(true){
                try{
                    String responseDataInput = dis.readUTF();
                    switch (responseDataInput) {
                        case "sending alaska":
                            alaska = (Alaska) ois.readObject();
                            System.out.println("received alaska");
                            break;
                        case "sending delta":
                            delta = (Delta) ois.readObject();
                            System.out.println("received delta");
                            break;
                        case "sending southwest":
                            southwest = (Southwest) ois.readObject();
                            System.out.println("received southwest");
                            break;
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    break;
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //        public static ArrayList receiveAirlines() throws IOException, ClassNotFoundException {
//            ArrayList<Object> airlineList = (ArrayList<Object>)objectInputStream.readObject();
//            // figure out how to assign stuff to jcombobox gui
//            return airlineList;
//        }



    }
}

// GUI PILOT WITHOUT SERVER CLIENT INTERACTION
//        String portString;
//        String hostname;
//        int port;
//
//        hostname = (String) JOptionPane.showInputDialog(null,
//                   "What is the hostname you'd like to connect to? ", "Hostname?", JOptionPane.PLAIN_MESSAGE);
////if (hostname != "") {
//    portString = (String) JOptionPane.showInputDialog(null,
//            "What is the port you'd like to connect to? ",
//            "Port?", JOptionPane.PLAIN_MESSAGE);
//    port = Integer.parseInt(portString);
////} else
////    JOptionPane.showMessageDialog(null, "GOODBYE!");
//        ReservationClient client = new ReservationClient(hostname,port);
//
//


