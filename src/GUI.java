//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Scanner;

//public class GUI {
//    public static void main(String[] args) {
//        JFrame firstFrame = new JFrame("Purdue University Flight Reservation System");
//        firstFrame.setSize(1000, 700);
//        firstFrame.setVisible(true);
//        firstFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        JPanel mainPanel = new JPanel();
//        mainPanel.setVisible(true);
//        firstFrame.getContentPane().add(mainPanel);
//        JLabel welcome = new JLabel("Welcome to the Purdue University Airline Reservation Management System!");
//        mainPanel.add(welcome);
//        JButton exitButton = new JButton("Exit");
//        JPanel confirmBooking = new JPanel();
//        exitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                firstFrame.dispose();
//            }
//        });
//        JButton continueButton = new JButton("Continue");
//        continueButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                firstFrame.getContentPane().removeAll();
//                firstFrame.getContentPane().add(confirmBooking);
//
//
//            }
//        });
//        mainPanel.add(exitButton, BorderLayout.CENTER);
//        mainPanel.add(continueButton, BorderLayout.SOUTH);
//        confirmBooking.add(new JLabel("Do you want to book a flight today?"));
//        confirmBooking.add(exitButton);

// TRYING TO MAKE AUX WORK
//        System.out.println("welcome to flight management system!");
//        System.out.println("Pick a flight:");
//        Scanner scanner = new Scanner(System.in);
//        String airline = scanner.nextLine();
//        Alaska alaska = new Alaska();
//        if (airline.equals("alaska")) {
//            scanner.nextLine();
//            System.out.println("enter first name");
//            String firstName = scanner.nextLine();
//            System.out.println("enter last name");
//            String lastName = scanner.nextLine();
//            scanner.nextLine();
//            System.out.println("enter age");
//            int age = scanner.nextInt();
//            Passenger first = new Passenger(firstName, lastName, age);
//            first.setAirlineChoice(alaska);
//            alaska.passengerList(first);
//            BoardingPass boardingPass = new BoardingPass(first);
//            first.setBoardingPass(boardingPass);
//            boardingPass.printBoardingPass();
//        }
//        import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.io.*;
//
//        public class GUI {
//            public static void main(String[] args) {
//                JFrame frame = new JFrame("Purdue University Flight Reservation System");
//
//                frame.setVisible(true);
//                frame.setLayout(new BorderLayout());
//
//                frame.setSize(700, 600);
//
//                JPanel panel1 = new JPanel();
//                JPanel panel2 = new JPanel();
//                JPanel panel3 = new JPanel();
//
//                panel1.setVisible(true);
//                panel2.setVisible(true);
//                panel3.setVisible(true);
//
//                JLabel label1 = new JLabel("Welcome to the Purdue University Airline Reservation Management System!");
//                panel1.add(label1);
//                label1.setVisible(true);
//
//                ImageIcon icon = new ImageIcon("/Users/rishikadadhich/IdeaProjects/Projext5/purduelogo.png",
//                        BorderLayout.CENTER);
//                JLabel label2 = new JLabel();
//                label2.setIcon(icon);
//                label2.setBounds(500, 500, 700, 800);
//                panel2.add(label2);
//
//
//                JButton exitButton = new JButton("Exit");
//                JButton bookAFlightButton = new JButton("Book a Flight");
//
//                exitButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        frame.dispose();
////                panel.removeAll();
////                JLabel label = new JLabel("Hello!");
////                panel.add(label, BorderLayout.CENTER);
////                panel.updateUI();
//                    }
//                });
//                //panel1.add(new JLabel("<html><br></html>"));
//
//                panel3.add(exitButton);
//                panel3.add(bookAFlightButton);
//
//                exitButton.setVisible(true);
//                bookAFlightButton.setVisible(true);
//
//                frame.add(panel1, BorderLayout.NORTH);
//                frame.add(panel2, BorderLayout.CENTER);
//                frame.add(panel3, BorderLayout.SOUTH);
//
//                bookAFlightButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        panel1.removeAll();
//                        panel2.setVisible(false);
//                        panel3.removeAll();
////                JLabel label = new JLabel("Hello!");
////                panel.add(label, BorderLayout.CENTER);
////                panel.updateUI();
//                        JLabel label3 = new JLabel("Do you want to book a flight today?");
//                        panel1.add(label3, BorderLayout.CENTER);
//                        panel1.updateUI();
//                        panel3.add(exitButton);
//                        panel3.updateUI();
//                        JButton yesButton = new JButton("Yes, I want to book a flight today.");
//                        panel3.add(yesButton);
//                        yesButton.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                panel1.removeAll();
//                                panel2.removeAll();
//                                panel3.removeAll();
//                                JLabel label4 = new JLabel("Choose a flight from the drop down menu");
//                                panel1.add(label4, BorderLayout.NORTH);
//                                String[] list = {"Alaska", "Delta", "SouthWest"};
//                                JComboBox jcb = new JComboBox(list);
//                                jcb.setVisible(true);
//                                panel1.add(jcb, BorderLayout.SOUTH);
//                                panel1.updateUI();
//
//                                panel3.add(exitButton);
//                                panel3.updateUI();
//                                JButton chooseButton = new JButton("Choose this flight");
//                                panel3.add(chooseButton);
//
//
//                                JLabel label5 = new JLabel("good stuff about alaska");
//                                label5.setVisible(true);
//                                panel2.add(label5, BorderLayout.SOUTH);
//                                panel2.setVisible(true);
//                                panel2.updateUI();
//
//
//                                jcb.addItemListener(listener -> {
//                                    int flightChoice = jcb.getSelectedIndex();
//                                    setMessage(flightChoice, panel2);
//                                });
//                                jcb.addKeyListener(new KeyListener() {
//                                    @Override
//                                    public void keyTyped(KeyEvent e) {
//
//                                    }
//
//                                    @Override
//                                    public void keyPressed(KeyEvent e) {
//                                        if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
//                                            JFrame frame2 = new JFrame();
//                                            frame2.setVisible(true);
//                                            frame2.setLayout(new BorderLayout());
//                                            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//
//                                            frame2.setSize(400, 300);
//                                            JPanel panel4 = new JPanel();
//                                            JPanel panel5 = new JPanel();
//                                            JLabel label6 = new JLabel("Hey peeps!");
//
//
//
//                                            //TODO:figure out how to read from file
//
//                                            panel4.add(label6, BorderLayout.CENTER);
//                                            label6.setVisible(true);
//                                            panel4.setVisible(true);
//
//                                            JButton exitButton2 = new JButton("Exit");
//                                            exitButton2.addActionListener(new ActionListener() {
//                                                @Override
//                                                public void actionPerformed(ActionEvent e) {
//                                                    frame2.dispose();
//
//                                                }
//                                            });
//
//                                            panel5.add(exitButton2);
//                                            panel5.setVisible(true);
//
//                                            frame2.add(panel4, BorderLayout.NORTH);
//                                            frame2.add(panel5, BorderLayout.SOUTH);
//
//                                        }
//
//                                    }
//
//                                    @Override
//                                    public void keyReleased(KeyEvent e) {
//
//                                    }
//                                });
//                            }
//                        });
//                    }
//                });
//
//
//            }
//
//
//            public static void setMessage(int flightChoice, JPanel panel2) {
//                panel2.removeAll();
//                if (flightChoice == 0) {
//                    JLabel label5 = new JLabel("good stuff about alaska");
//                    label5.setVisible(true);
//                    panel2.add(label5, BorderLayout.SOUTH);
//                    panel2.updateUI();
//                    panel2.setVisible(true);
//                } else if (flightChoice == 1) {
//                    JLabel label5 = new JLabel("good stuff about delta");
//                    label5.setVisible(true);
//                    panel2.add(label5, BorderLayout.SOUTH);
//                    panel2.updateUI();
//                    panel2.setVisible(true);
//                } else if (flightChoice == 2) {
//                    JLabel label5 = new JLabel("good stuff about southwest");
//                    label5.setVisible(true);
//                    panel2.add(label5, BorderLayout.SOUTH);
//                    panel2.updateUI();
//                    panel2.setVisible(true);
//                }
//            }
//        }

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class GUI {

    public static void stage2(JPanel panel1, JPanel panel2, JPanel panel3, JButton exitButton) {
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
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stage3(panel1, panel2, panel3, exitButton, yesButton);
            }
        });

    }

    public static void stage3(JPanel panel1, JPanel panel2, JPanel panel3, JButton exitButton, JButton yesButton) {

        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        JLabel label4 = new JLabel("Choose a flight from the drop down menu");
        panel1.add(label4, BorderLayout.NORTH);
        String[] list = {"Alaska", "Delta", "SouthWest"};
        JComboBox jcb = new JComboBox(list);
        jcb.setVisible(true);
        panel1.add(jcb, BorderLayout.SOUTH);
        panel1.updateUI();
        panel3.add(exitButton);
        panel3.updateUI();
        JLabel label5 = new JLabel("good stuff about alaska");
        label5.setVisible(true);
        panel2.add(label5, BorderLayout.SOUTH);
        panel2.setVisible(true);
        panel2.updateUI();
        JButton chooseButton = new JButton("Choose this flight");
        panel3.add(chooseButton);
        panel3.updateUI();

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
                    JLabel label6 = new JLabel("Hey peeps!");

                    int flightChoice = jcb.getSelectedIndex();
                    if (flightChoice == 0) {

                    } else if (flightChoice == 1) {

                    } else if (flightChoice == 2) {

                    }

                    panel4.add(label6, BorderLayout.CENTER);
                    label6.setVisible(true);
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


                    stage4(panel1, panel2, panel3, exitButton, yesButton, chooseButton, jcb);
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

    }

    private static void setMessage(int flightChoice, JPanel panel2) {
        panel2.removeAll();
        if (flightChoice == 0) {
            JLabel label5 = new JLabel("good stuff about alaska");
            label5.setVisible(true);
            panel2.add(label5, BorderLayout.SOUTH);
            panel2.updateUI();
            panel2.setVisible(true);
        } else if (flightChoice == 1) {
            JLabel label5 = new JLabel("good stuff about delta");
            label5.setVisible(true);
            panel2.add(label5, BorderLayout.SOUTH);
            panel2.updateUI();
            panel2.setVisible(true);
        } else if (flightChoice == 2) {
            JLabel label5 = new JLabel("good stuff about southwest");
            label5.setVisible(true);
            panel2.add(label5, BorderLayout.SOUTH);
            panel2.updateUI();
            panel2.setVisible(true);
        }
    }

    private static Airline airlineChoice;

    public static void stage4(JPanel panel1, JPanel panel2, JPanel panel3,
                              JButton exitButton, JButton yesButton, JButton chooseButton, JComboBox jcb) {
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel2.removeAll();
                panel3.removeAll();
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
                panel1.setVisible(true);

                JButton notThisFlight = new JButton("No, I want a different flight.");
                JButton yesThisFlight = new JButton("Yes, I want this flight.");
                panel3.add(exitButton);
                panel3.add(notThisFlight);
                panel3.add(yesThisFlight);

                notThisFlight.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        stage3(panel1, panel2, panel3, exitButton, yesButton);
                    }
                });
                yesThisFlight.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        if (jcb.getSelectedIndex() == 0) {
                            Alaska alaska = new Alaska(); // only for testing. Airline objects must already be in server ideally.
                            airlineChoice = alaska;
                        } else if (jcb.getSelectedIndex() == 1) {
                            Delta delta = new Delta();
                            airlineChoice = delta;
                        } else if (jcb.getSelectedIndex() == 2) {
                            Southwest southwest = new Southwest();
                            airlineChoice = southwest;
                        }

                        stage5(panel1, panel2, panel3, exitButton);


                    }
                });


            }
        });


    }

    public static void stage5(JPanel panel1, JPanel panel2, JPanel panel3, JButton exitButton) {
        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();

        JLabel label6 = new JLabel("Please input your information below:");
        panel1.add(label6);
        panel1.updateUI();

        JLabel fnlabel = new JLabel("What is your first name?");
        JTextArea firstName = new JTextArea();
        firstName.setSize(500, 300);


        JLabel lnlabel = new JLabel("What is your last name?");
        JTextArea lastName = new JTextArea();
        lastName.setSize(400, 550);


        JLabel agelabel = new JLabel("What is your age?");
        JTextArea age = new JTextArea();
        age.setSize(400, 500);


        panel2.add(fnlabel, BorderLayout.NORTH);
        panel2.add(firstName, BorderLayout.NORTH);
        panel2.add(lnlabel, BorderLayout.CENTER);
        panel2.add(lastName, BorderLayout.CENTER);
        panel2.add(agelabel, BorderLayout.SOUTH);
        panel2.add(age, BorderLayout.SOUTH);
        panel2.updateUI();

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
                stage6(first, last, ageString, panel1, panel2, panel3, exitButton);
            }
        });


    }

    public static void stage6(String first, String last, String ageString, JPanel panel1,
                              JPanel panel2, JPanel panel3, JButton exitButton) {
        int check = JOptionPane.showConfirmDialog(null, "Are all the details you " +
                "entered correct?\nThe passenger's name is " + first + " " + last + " and their age is "
                + ageString + ". If all " + "the information is correct, select the Yes button below, otherwise, " +
                "select No button.", "Confirm info!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.NO_OPTION) {
            stage5(panel1, panel2, panel3, exitButton);
        } else {
            Passenger passenger = new Passenger(first, last, Integer.parseInt(ageString), airlineChoice);
            passenger.getAirlineChoice().addPassenger(passenger);
            //System.out.println(passenger.toString()); // TESTING ONLY- DELETE LATER!
            stage7(panel1, panel2, panel3, passenger, exitButton);

        }

    }

    public static void stage7(JPanel panel1, JPanel panel2, JPanel panel3, Passenger passenger, JButton exitButton) {
        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();

        JLabel label = new JLabel("Flight data displaying for " + passenger.getAirlineChoice().toString() +
                "\nEnjoy your Flight!\nYour flight is now boarding at Gate " + passenger.getAirlineChoice().getGate());
        panel1.add(label);

        JLabel label2 = new JLabel(passenger.getAirlineChoice().getPassengerCount() + ": 100");
        panel1.add(label2);
        panel1.updateUI();
//        JLabel textPane = null;
//        for (int i = 0; i < passenger.getAirlineChoice().getPassengerCount(); i++) {
//            textPane = new JLabel(passenger.getAirlineChoice().getPassengers().get(i).toString());
//        }
//        panel2.add(textPane);
//        panel2.updateUI();

//        JLabel boardingPass = new JLabel(passenger.getBoardingPass().printBoardingPass()); // need to read from file here
//        panel3.add(boardingPass);
        JLabel label3 = new JLabel(passenger.toString());
        panel2.add(label3);
        panel2.updateUI();
        panel3.add(exitButton);
        JButton refreshButton = new JButton("Refresh Flight Status"); // add action listener
        panel3.add(refreshButton);
        panel3.updateUI();

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Purdue University Flight Reservation System");

        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        frame.setSize(700, 600);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setVisible(true);
        panel2.setVisible(true);
        panel3.setVisible(true);

        JLabel label1 = new JLabel("Welcome to the Purdue University Airline Reservation Management System!");
        panel1.add(label1);
        label1.setVisible(true);

        ImageIcon icon = new ImageIcon("/Users/rishikadadhich/IdeaProjects/Projext5/purduelogo.png",
                BorderLayout.CENTER);
        JLabel label2 = new JLabel();
        label2.setIcon(icon);
        label2.setBounds(500, 500, 700, 800);
        panel2.add(label2);


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

        exitButton.setVisible(true);
        bookAFlightButton.setVisible(true);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);

        bookAFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stage2(panel1, panel2, panel3, exitButton);

            }
        });
    }

}












