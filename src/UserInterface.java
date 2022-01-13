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
import java.net.URL;
import java.util.ArrayList;

public class UserInterface {
    private DataOutputStream output = null;
    private ObjectOutputStream oos = null;
    private ReservationClient.ResponseListener listener;
    //private DataInputStream input = null;
//        private Alaska alaska = null;
//        private Delta delta = null;
//        private Southwest southwest = null;

    public UserInterface(DataOutputStream dos, ObjectOutputStream oos, ReservationClient.ResponseListener listener) throws IOException {
        this.output = dos;
        this.listener = listener;
        this.oos = oos;
        output.writeUTF("getAirlines");
        //this.input = dis;
    }


    public void stage2(JPanel panel1, JPanel panel2, JPanel panel3, JButton exitButton) throws IOException {
        panel1.removeAll();
        panel2.setVisible(false);
        panel3.removeAll();

        JLabel label3 = new JLabel("Do you want to book a flight today?");
        panel1.add(label3, BorderLayout.CENTER);
        panel1.updateUI();
        panel3.add(exitButton);
        panel3.updateUI();
        JButton yesButton = new JButton("Yes, I want to book a flight today.");
        panel3.add(yesButton);
        //output.writeUTF("hey");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    output.writeUTF("getAirlines");
                    stage3(panel1, panel2, panel3, exitButton, yesButton);
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public void stage3(JPanel panel1, JPanel panel2, JPanel panel3, JButton exitButton, JButton yesButton) throws IOException, ClassNotFoundException {
        //System.out.println(listener.alaska.toString());
        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        JLabel label4 = new JLabel("Choose a flight from the drop down menu");
        panel1.add(label4, BorderLayout.NORTH);
        //TODO : UNCOMMENT
//        ArrayList airlines = ResponseListener.receiveAirlines();
        //       Alaska alaska = (Alaska) airlines.get(0);
//        Delta delta = (Delta) airlines.get(1);
//        Southwest southwest = (Southwest) airlines.get(2);
        //       String[] list = {alaska.toString(), delta.toString(), southwest.toString()};
        String[] list = {"Alaska", "Delta", "Southwest"};
        JComboBox<String> jcb = new JComboBox<>(list);
        jcb.setVisible(true);
        panel1.add(jcb, BorderLayout.SOUTH);
        panel1.updateUI();
        panel3.add(exitButton);
        panel3.updateUI();
        JLabel label5 = new JLabel("<html><b>Alaska Airlines is proud to serve the strong Boilermakers from Purdue University.<br>" +
                "We primarily fly westward, and often have stops in Alaska and California.<br>" +
                "We provide fun snacks like pretzels and goldfish.<br>We also have comfortable seats and free WiFi.<br>" +
                "We hope you choose Alaska Airlines for your next itinerary. </b></html>");
        label5.setVisible(true);
        panel2.add(label5, BorderLayout.SOUTH);
        panel2.setVisible(true);
        panel2.updateUI();
        JButton chooseButton = new JButton("Choose this flight");
//            panel3.add(chooseButton);
//            panel3.updateUI();

        jcb.addItemListener(listener -> {
            int flightChoice = jcb.getSelectedIndex();
            setMessage(flightChoice, panel2);
        });

        jcb.addKeyListener(new KeyListener() {

            /**
             * Invoked when a key has been typed.
             * See the class description for {@link KeyEvent} for a definition of
             * a key typed event.
             *
             * @param e the event to be processed
             */
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
                    JFrame frame2 = new JFrame();
                    frame2.setVisible(true);
                    frame2.setLayout(new BorderLayout());


                    frame2.setSize(400, 300);
                    JPanel panel4 = new JPanel();
                    JPanel panel5 = new JPanel();
                    // if statements
                    JLabel label6 = null;
                    JList airlineList = null;
                    if (jcb.getSelectedIndex() == 0) {
                        label6 = new JLabel("Alaska Airlines " + String.format("%d:%d", listener.alaska.getPassengerCount(), listener.alaska.getMaxCapacity()));
                        ArrayList<String> p = new ArrayList<>();
                        for (int i = 0; i < listener.alaska.getPassengers().size(); i++) {
                            p.add(listener.alaska.getPassengers().get(i).toString());
                        }
                        airlineList = new JList(p.toArray());
                    } else if (jcb.getSelectedIndex() == 1) {
                        label6 = new JLabel("Delta Airlines " + String.format("%d:%d", listener.delta.getPassengerCount(), listener.delta.getMaxCapacity()));
                        ArrayList<String> p = new ArrayList<>();
                        for (int i = 0; i < listener.delta.getPassengers().size(); i++) {
                            p.add(listener.delta.getPassengers().get(i).toString());
                        }
                        airlineList = new JList(p.toArray());
                    } else if (jcb.getSelectedIndex() == 2) {
                        label6 = new JLabel("Southwest Airlines " + String.format("%d:%d", listener.southwest.getPassengerCount(), listener.southwest.getMaxCapacity()));
                        ArrayList<String> p = new ArrayList<>();
                        for (int i = 0; i < listener.southwest.getPassengers().size(); i++) {
                            p.add(listener.southwest.getPassengers().get(i).toString());
                        }
                        airlineList = new JList(p.toArray());
                    }
                    JScrollPane scrollPane = new JScrollPane(airlineList);
                    //scrollPane.add(airlineList);

                    //int flightChoice = jcb.getSelectedIndex();

                    assert airlineList != null;
                    panel4.add(label6, BorderLayout.NORTH);
                    panel4.add(scrollPane, BorderLayout.SOUTH);
                    label6.setVisible(true);
                    scrollPane.setVisible(true);
                    panel4.setVisible(true);

                    JButton exitButton2 = new JButton("Exit");
                    exitButton2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame2.dispose();

                        }
                    });

                    panel5.add(exitButton2);
                    panel5.setVisible(true);

                    frame2.add(panel4, BorderLayout.NORTH);
                    frame2.add(panel5, BorderLayout.SOUTH);

                }
            }

            /**
             * Invoked when a key has been released.
             * See the class description for {@link KeyEvent} for a definition of
             * a key released event.
             *
             * @param e the event to be processed
             */
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if ((jcb.getSelectedIndex() == 0) & (listener.alaska.getPassengerCount() == listener.alaska.getMaxCapacity())) {
                    stage35();
                    // close gate == change method in classes too
                } else if ((jcb.getSelectedIndex() == 1) & (listener.delta.getPassengerCount() == listener.delta.getMaxCapacity())) {
                    stage35();
                } else if ((jcb.getSelectedIndex() == 2) & (listener.southwest.getPassengerCount() == listener.southwest.getMaxCapacity())) {
                    stage35();
                } else {
                    stage4(panel1, panel2, panel3, exitButton, yesButton, chooseButton, jcb);
                }
            }
        });
        panel3.add(chooseButton);
        panel3.updateUI();

    }


    public void stage35() {
        JFrame frame1 = new JFrame();
        frame1.setVisible(true);
        frame1.setSize(600, 500);
        frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("<html>Sorry, this flight is full!<br> Please pick another airline.</html>");
        JButton exit = new JButton("Exit");
        panel.add(label, BorderLayout.CENTER);
        panel.add(exit, BorderLayout.SOUTH);
        panel.setVisible(true);
        frame1.add(panel);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    output.writeUTF("getAirlines");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                frame1.dispose();
            }
        });

    }

    private void setMessage(int flightChoice, JPanel panel2) {
        panel2.removeAll();
        if (flightChoice == 0) {
            JLabel label5 = new JLabel("<html><b>Alaska Airlines is proud to serve the strong Boilermakers from Purdue University.<br>" +
                    "We primarily fly westward, and often have stops in Alaska and California.<br>" +
                    "We provide fun snacks like pretzels and goldfish.<br>We also have comfortable seats and free WiFi.<br>" +
                    "We hope you choose Alaska Airlines for your next itinerary. </b></html>");
            label5.setVisible(true);
            panel2.add(label5, BorderLayout.SOUTH);
            panel2.updateUI();
            panel2.setVisible(true);
        } else if (flightChoice == 1) {
            JLabel label5 = new JLabel("<html><b>Delta Airlines is proud to be one of the three premier Airlines at Purdue University." +
                    "<br>We offer exceptional services, with free unlimited WiFi for all customers.<br>" +
                    "Passengers who use T-Mobile as a cell phone carrier get additional benefits.<br> We are also happy to offer power " +
                    "outlets in each seat for passenger use.<br>We hope you choose Delta as your Airline!</b> </html>");
            label5.setVisible(true);
            panel2.add(label5, BorderLayout.SOUTH);
            panel2.updateUI();
            panel2.setVisible(true);
        } else if (flightChoice == 2) {
            JLabel label5 = new JLabel("<html><b>Southwest Airlines is proud to offer flights to Purdue University<br>" +
                    "We are happy to offer free in flight wifi as well as our amazing snacks.<br>" +
                    "In addition, we offer flights for much cheaper than other airlines, and offer two free checked bags.<br>" +
                    "We hope you choose Southwest for your next flight.</b></html>");
            label5.setVisible(true);
            panel2.add(label5, BorderLayout.SOUTH);
            panel2.updateUI();
            panel2.setVisible(true);
        }
    }


    private String airlineChoiceString;
    private Airline airlineChoice;
    private Passenger passenger;

    public void stage4(JPanel panel1, JPanel panel2, JPanel panel3,
                       JButton exitButton, JButton yesButton, JButton chooseButton, JComboBox<String> jcb) {

        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        panel2.updateUI();
        String msg = "";
        if (jcb.getSelectedIndex() == 0) {
            msg = "Are you sure you want to book a flight on Alaska Airlines?";
        } else if (jcb.getSelectedIndex() == 1) {
            msg = "Are you sure you want to book a flight on Delta Airlines?";
        } else if (jcb.getSelectedIndex() == 2) {
            msg = "Are you sure you want to book a flight on Southwest Airlines?";
        }

        JLabel label5 = new JLabel(msg);
        panel1.add(label5);
        panel1.updateUI();
        panel1.revalidate();
        panel1.repaint();
        System.out.println("reached here!!!!");
        panel1.setVisible(true);

        JButton notThisFlight = new JButton("No, I want a different flight.");
        JButton yesThisFlight = new JButton("Yes, I want this flight.");
        panel3.add(exitButton);
        panel3.add(notThisFlight);
        panel3.add(yesThisFlight);



        notThisFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    stage3(panel1, panel2, panel3, exitButton, yesButton);
                    output.writeUTF("getAirlines");

                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        yesThisFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jcb.getSelectedIndex() == 0) {
                    airlineChoiceString = "Alaska";
                    airlineChoice = listener.alaska;

                } else if (jcb.getSelectedIndex() == 1) {
                    airlineChoiceString = "Delta";
                    airlineChoice = listener.delta;

                } else if (jcb.getSelectedIndex() == 2) {
                    airlineChoiceString = "Southwest";
                    airlineChoice = listener.southwest;
                }
                stage5(panel1, panel2, panel3, exitButton);


            }
        });
    }

    public void stage5(JPanel panel1, JPanel panel2, JPanel panel3, JButton exitButton) {
        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();

        JLabel label6 = new JLabel("Please input your information below:");
        panel1.add(label6);
        panel1.updateUI();

        JLabel fnlabel = new JLabel("<html><br><left>What is your first name?<br></left></html>");
        JTextArea firstName = new JTextArea(5, 10);
        firstName.setSize(500, 300);
        panel2.add(fnlabel);
        panel2.add(firstName);


        JLabel lnlabel = new JLabel("<html><br><left>What is your last name?<br></left></html>");
        JTextArea lastName = new JTextArea(5, 10);
        lastName.setSize(400, 550);
        panel2.add(lnlabel);
        panel2.add(lastName);

        JLabel agelabel = new JLabel("<html><br><left>What is your age?<br></left></html>");
        JTextArea age = new JTextArea(5, 10);
        age.setSize(400, 500);


        panel2.add(agelabel);
        panel2.add(age);
        panel2.updateUI();
        panel3.updateUI();

        panel3.add(exitButton);
        JButton next = new JButton("Next");
        panel3.add(next);
        panel3.updateUI();


        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String first = firstName.getText();
                String last = lastName.getText();
                String ageString = age.getText();
                //
                boolean validFirst = false;
                boolean validLast = false;
                boolean validAge = false;
                boolean negativeAge = false;
                if (first.equals("") | last.equals("") | ageString.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter all the required details",
                            "Purdue University Airport Reservation Management System", JOptionPane.ERROR_MESSAGE);
                } else {

                    for (int i = 0; i < first.length(); i++) {
                        if (Character.isLetter(first.charAt(i)) | first.charAt(i) == '-')
                            validFirst = true;
                        else {
                            validFirst = false;
                            break;
                        }
                        validFirst = true;
                    }

                    for (int i = 0; i < last.length(); i++) {
                        if (Character.isLetter(last.charAt(i)) | last.charAt(i) == '-')
                            validLast = true;
                        else {
                            validLast = false;
                            break;
                        }
                        validLast = true;
                    }

                    try {
                        int ageInt = Integer.parseInt(ageString);
                        validAge = true;
                        if (ageInt >= 0) {
                            negativeAge = false;
                        } else {
                            negativeAge = true;
                        }
                    } catch (NumberFormatException ne) {
                        validAge = false;
                    }

                    if (!validFirst) {
                        JOptionPane.showMessageDialog(null, "Please enter valid first name!",
                                "Purdue University Airport Reservation Management System", JOptionPane.ERROR_MESSAGE);
                        firstName.requestFocus();

                    } else if (!validLast) {
                        JOptionPane.showMessageDialog(null, "Please enter valid last name!",
                                "Purdue University Airport Reservation Management System", JOptionPane.ERROR_MESSAGE);
                        lastName.requestFocus();

                    } else if (!validAge | negativeAge) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid age!",
                                "Purdue University Airport Reservation Management System", JOptionPane.ERROR_MESSAGE);
                        age.requestFocus();
                    } else {
                        try {
                            stage6(first, last, ageString, panel1, panel2, panel3, exitButton);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }


                }

            }
        });


    }

    public void stage6(String first, String last, String ageString, JPanel panel1,
                       JPanel panel2, JPanel panel3, JButton exitButton) throws IOException {
        int check = JOptionPane.showConfirmDialog(null, "Are all the details you " +
                "entered correct?\nThe passenger's name is " + first + " " + last + " and their age is "
                + ageString + ". If all " + "the information is correct, select the Yes button below, otherwise, " +
                "select No button.", "Confirm info!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.NO_OPTION) {
            stage5(panel1, panel2, panel3, exitButton);
        } else {
            passenger = new Passenger(first, last, Integer.parseInt(ageString), airlineChoice);
            stage7(panel1, panel2, panel3, passenger, exitButton);
            output.writeUTF("getAirlines");
            output.flush();
//            output.writeUTF("sending passenger");
//            output.flush();
//            output.writeUTF(passenger.toString());

        }

    }

    public void stage7(JPanel panel1, JPanel panel2, JPanel panel3, Passenger passenger, JButton exitButton) throws IOException {
        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
//
        //System.out.println(airlineChoice.latestPassenger());
        output.writeUTF("getAirlines");
        ////
        //

        airlineChoice.addPassenger(passenger);
        int previousCount = airlineChoice.getPassengerCount();
        airlineChoice.setPassengerCount(previousCount + 1);
        airlineChoice.assignGate();
        output.writeUTF("setAirlines : " + airlineChoiceString);
        oos.writeObject(airlineChoice);
//        output.flush();
//        output.writeUTF("sending passenger");
//        oos.writeObject(passenger);


        JLabel label = new JLabel("<html><center><font size = 28>Flight data displaying for " + airlineChoiceString +
                "<br>Enjoy your Flight!<br>Your flight is now boarding at Gate " + airlineChoice.getGate() + "<br>" +
                airlineChoice.getPassengerCount() + ":" + airlineChoice.getMaxCapacity() + "<br>" + "</font></center></html>");
        panel1.add(label, BorderLayout.NORTH);

        //JLabel label2 = new JLabel("<html><font size = 24>" + airlineChoice.getPassengerCount() + ":" + airlineChoice.getMaxCapacity() + "</font></html>");
        //panel1.add(label2, BorderLayout.SOUTH);
        panel1.updateUI();
        //
        //System.out.println(airlineChoice.latestPassenger());
//        JLabel textPane = null;
//        for (int i = 0; i < passenger.getAirlineChoice().getPassengerCount(); i++) {
//            textPane = new JLabel(passenger.getAirlineChoice().getPassengers().get(i).toString());
//        }
//        panel2.add(textPane);
//        panel2.updateUI();

//        JLabel boardingPass = new JLabel(passenger.getBoardingPass().printBoardingPass()); // need to read from file here
//        panel3.add(boardingPass);
        //JLabel label3 = new JLabel(airlineChoice.toString());
        //
        JList flightPassengerList1 = null;
        ArrayList<String> p = new ArrayList<>();
        for (int i = (airlineChoice.getPassengers().size() - 1); i >= 0; i--) {
            p.add(airlineChoice.getPassengers().get(i).toString());
        }
        flightPassengerList1 = new JList(p.toArray());
        JScrollPane scrollPane1 = new JScrollPane(flightPassengerList1);
        //

        //
//        airlineChoice.addPassenger(passenger);
//        int previousCount = airlineChoice.getPassengerCount();
//        airlineChoice.setPassengerCount(previousCount + 1);
//        airlineChoice.assignGate();
//        output.writeUTF("setAirlines : " + airlineChoiceString);
//        oos.writeObject(airlineChoice);
        //
        panel2.add(scrollPane1, BorderLayout.NORTH);
        panel2.updateUI();
        JLabel passengerBoardingPass = new JLabel(passenger.createBoardingPass(passenger).printBoardingPass());
        panel2.add(passengerBoardingPass, BorderLayout.SOUTH);
        panel3.add(exitButton);
        JButton refreshButton = new JButton("Refresh Flight Status"); // add action listener
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //JLabel label3 = new JLabel(airlineChoice.toString());
                try {
                    output.writeUTF("getAirlines"); // 100
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // remove below code if necessary
                JList flightPassengerList2 = null;
                ArrayList<String> p = new ArrayList<>();
                for (int i = (airlineChoice.getPassengers().size() - 1); i >= 0; i--) {
                    p.add(airlineChoice.getPassengers().get(i).toString());
                }
                flightPassengerList2 = new JList(p.toArray());
                JScrollPane scrollPane2 = new JScrollPane(flightPassengerList2);
                panel2.removeAll();
                panel2.add(scrollPane2, BorderLayout.NORTH);
                JLabel passengerBoardingPass = new JLabel(passenger.createBoardingPass(passenger).printBoardingPass());
                panel2.add(passengerBoardingPass, BorderLayout.SOUTH);
                panel2.updateUI();
                panel2.setVisible(true);
            }
        });
        panel3.add(refreshButton);
        panel3.updateUI();


    }

    public void GUI() throws IOException {
        //output.writeUTF("hey sup");
        JFrame frame = new JFrame("Purdue University Flight Reservation System");

        frame.setVisible(true);
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());


        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setVisible(true);
        panel2.setVisible(true);
        panel3.setVisible(true);

        JLabel label1 = new JLabel("Welcome to the Purdue University Airline Reservation Management System!");
        panel1.add(label1);
        label1.setVisible(true);

        ImageIcon icon = new ImageIcon(new URL("https://www.purdue.edu/brand/images/applications/Motion_P.png"));

        JLabel label2 = new JLabel(icon);
        label2.setBounds(500, 500, 300, 400);
        label2.setVisible(true);
        panel2.add(label2);
        panel2.updateUI();


        JButton exitButton = new JButton("Exit");
        JButton bookAFlightButton = new JButton("Book a Flight");

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Thank you for using Purdue University " +
                        "Reservation Management System!", "Thank You!", JOptionPane.INFORMATION_MESSAGE);
//                panel.removeAll();
//                JLabel label = new JLabel("Hello!");
//                panel.add(label, BorderLayout.CENTER);
//                panel.updateUI();
            }
        });
        //panel1.add(new JLabel("<html><br></html>"));

        panel3.add(exitButton);
        panel3.add(bookAFlightButton);
        GridLayout gl = new GridLayout(3, 1);
        exitButton.setVisible(true);
        bookAFlightButton.setVisible(true);
        frame.setLayout(gl);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        frame.revalidate();
        frame.repaint();

        bookAFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    stage2(panel1, panel2, panel3, exitButton);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }


}








