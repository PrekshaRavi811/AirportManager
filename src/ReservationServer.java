/**
 * @author Preksha Tharigonda Ravikumar, Rishika Dadhich, Lab sec LC3
 * @version December 1st,2019
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReservationServer {
    //public static final int PORT = 60088;
    private ServerSocket serverSocket = null;
    //private Socket clientSocket = null; // test
    //private Socket clientSocket = null;
//    private DataInputStream in = null;
//    private DataOutputStream out = null;
    //private ObjectInputStream ois = null;
    //private ObjectOutputStream oos = null;

    public ReservationServer() throws IOException {
        this.serverSocket = new ServerSocket(0);
    }

    // use getters for sockets
//    public Socket getClientSocket() {
//        return clientSocket;
//    }

    public void serveClients() throws IOException {
        Socket clientSocket; // uncomment
        ClientHandler handler;
        Thread handlerThread;
        int connectionCount = 0;

        System.out.printf("<Now serving clients on port %d...>%n", this.serverSocket.getLocalPort());
        System.out.println("serving clients");
        while (true) {
            try {
                clientSocket = this.serverSocket.accept();
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());


                handler = new ClientHandler(clientSocket, dis, dos, oos, ois); // removed socket parameter

                handlerThread = new Thread(handler);

                handlerThread.start();
            } catch (IOException e) {
                e.printStackTrace();

                break;
            } //end try catch

            System.out.printf("<Client %d connected...>%n", connectionCount); // just for ref, change with gui

            connectionCount++;
        } //end while
    }

    public static void main(String[] args) throws IOException {
        ReservationServer server;
        try {
            server = new ReservationServer();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        server.serveClients();
        //ClientHandler.run();


    }

    // hashcode
    public int hashCode() {
        int result = 23;

        result = result * 31 * Objects.hashCode(this.serverSocket);

        return result;
    } //hashCode

    // equals
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object instanceof ReservationServer) {
            return Objects.equals(this.serverSocket, ((ReservationServer) object).serverSocket);
        } else {
            return false;
        } //end if
    } //equals

    // toString
    public String toString() {
        String format = "ReservationServer[%s]";

        return String.format(format, this.serverSocket);
    } //toString

    class ClientHandler extends Thread { //implements runnable

        Socket clientSocket = null; // getClientSocket()
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        //DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        //        File file = new File("reservations.txt");
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        FileWriter fileWriter = new FileWriter(file);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Alaska alaska;
        Delta delta;
        Southwest southwest;
//        ArrayList<Object> airlines;


        ClientHandler(Socket clientSocket, DataInputStream dis, DataOutputStream dos, ObjectOutputStream oos,
                      ObjectInputStream ois) throws IOException { //clienthandler constructor//removed socket parameter
            Objects.requireNonNull(clientSocket);
            this.clientSocket = clientSocket; // possible error can just invoke server obj's socket
            this.ois = ois;
            this.oos = oos;
            this.dataInputStream = dis;
            this.dataOutputStream = dos;
            this.alaska = new Alaska();
            this.delta = new Delta();
            this.southwest = new Southwest();
//            this.alaska.assignGate(); // put in if with new variable counting clients if needed.
//            this.delta.assignGate();
//            this.southwest.assignGate();
        }




//        public Object readingObject(String filepath) throws IOException, ClassNotFoundException {
//            FileInputStream fis = new FileInputStream(filepath);
//            ObjectInputStream fileOis = new ObjectInputStream(fis);
//            Object object = fileOis.readObject();
//            System.out.println("object has been read");
//            System.out.println(object); // no to string
//            fileOis.close();
//            return object;
//        }
//
//        public void writeObject(String filepath, Object object) throws IOException {
//            FileOutputStream fos = new FileOutputStream(filepath);
//            ObjectOutputStream fileOos = new ObjectOutputStream(fos);
//            fileOos.writeObject(object);
//            fileOos.close();
//            System.out.println("Object was successfully written to a file");
//        }

        public void readFile() throws IOException {
//            Lock lock = new ReentrantLock();
//            lock.lock();
            if(alaska.getPassengers().size() != 0)
                alaska.removeAllPassengers();
            if(delta.getPassengers().size() != 0)
                delta.removeAllPassengers();
            if(southwest.getPassengers().size() != 0)
                southwest.removeAllPassengers();
            File file = new File("C:\\Users\\preks\\IdeaProjects\\CS180_Project_5\\src\\reservations.txt");
            //FileReader fileReader = new FileReader(file);
            //BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner scanner = new Scanner(file);
            String airline = scanner.nextLine();
            while (!airline.equals("EOF")) {
                if (airline.equals("ALASKA")) {
                    String line = scanner.nextLine();
                    //System.out.println(line);
                    String[] tokens = line.split("/");
                    this.alaska.setPassengerCount(Integer.parseInt(tokens[0]));
                    this.alaska.setMaxCapacity(Integer.parseInt(tokens[1]));
                    String gate = scanner.nextLine();
                    if (!gate.equals("gate not assigned") & !gate.equals("no gate, flight is full"))
                        this.alaska.setAlaskaGate(gate.charAt(0), Integer.parseInt(gate.substring(1,gate.length())));
                    if (scanner.nextLine().equals("Alaska passenger list")) {
                        String person = scanner.nextLine();
                        while (!person.equals("")) {
                            String[] personTokens = person.split(", ");
                            Passenger passenger = new Passenger(personTokens[0], personTokens[1],
                                    Integer.parseInt(personTokens[2]), this.alaska);
                            this.alaska.addPassenger(passenger);
                            //this.alaska.assignGate();
                            //this.alaska.closeGate(); // most recent change
                            person = scanner.nextLine();
                        }
                    }
                }
                if (airline.equals("DELTA")) {
                    String line = scanner.nextLine();
                    String[] tokens = line.split("/");
                    this.delta.setPassengerCount(Integer.parseInt(tokens[0]));
                    this.delta.setMaxCapacity(Integer.parseInt(tokens[1]));
                    String gate = scanner.nextLine();
                    if (!gate.equals("gate not assigned") & !gate.equals("no gate, flight is full"))
                        this.delta.setDeltaGate(gate.charAt(0), Integer.parseInt(gate.substring(1,gate.length())));
                    if (scanner.nextLine().equals("Delta passenger list")) {
                        String person = scanner.nextLine();
                        while (!person.equals("")) {
                            String[] personTokens = person.split(", ");
                            Passenger passenger = new Passenger(personTokens[0], personTokens[1],
                                    Integer.parseInt(personTokens[2]), this.delta);
                            this.delta.addPassenger(passenger);
                            //this.delta.assignGate();
                            this.delta.closeGate(); // most recent change // should I?
                            person = scanner.nextLine();
                        }
                    }
                }
                if (airline.equals("SOUTHWEST")) {
                    String line = scanner.nextLine();
                    String[] tokens = line.split("/");
                    this.southwest.setPassengerCount(Integer.parseInt(tokens[0]));
                    this.southwest.setMaxCapacity(Integer.parseInt(tokens[1]));
                    String gate = scanner.nextLine();
                    if (!gate.equals("gate not assigned") & !gate.equals("no gate, flight is full"))
                        this.southwest.setSouthwestGate(gate.charAt(0), Integer.parseInt(gate.substring(1,gate.length())));
                    if (scanner.nextLine().equals("Southwest passenger list")) {
                        String person = scanner.nextLine();
                        while (!person.equals("")) {
                            String[] personTokens = person.split(", ");
                            Passenger passenger = new Passenger(personTokens[0], personTokens[1],
                                    Integer.parseInt(personTokens[2]), this.southwest);
                            this.southwest.addPassenger(passenger);
                            //this.southwest.assignGate();
                            this.southwest.closeGate(); // most recent change
                            person = scanner.nextLine();
                        }
                    }
                }
                if (scanner.hasNext())
                    airline = scanner.nextLine();
                //System.out.println(airline);
            }

            scanner.close();
            //lock.unlock();
        }

        public void writeToFile() throws IOException {
            Lock lock = new ReentrantLock();
            lock.lock();
            File file1 = new File("C:\\Users\\preks\\IdeaProjects\\CS180_Project_5\\src\\reservations.txt");
            FileWriter fw = new FileWriter(file1, false);
            String contentsOfFile = alaska.toString() + "\n" + delta.toString() + "\n" +
                    southwest.toString() + "\n" + "EOF";
            fw.write(contentsOfFile);
            fw.flush();
            lock.unlock();
        }




        public void run() {
            this.alaska.assignGate(); // put in if with new variable counting clients if needed.
            this.delta.assignGate();
            this.southwest.assignGate();
//            alaska.closeGate();
//            delta.closeGate();
//            southwest.closeGate(); // dk where to put this
            while(true) {
                try {
                    String queryDataInput = dataInputStream.readUTF();
                    if (queryDataInput.equals("getAirlines")) {
                        readFile();
                        dataOutputStream.writeUTF("sending alaska");
                        oos.writeObject(alaska);
                        System.out.println("sent alaska");
                        System.out.println(alaska.getPassengers().size());
                        dataOutputStream.writeUTF("sending delta");
                        oos.writeObject(delta);
                        System.out.println("sent delta");
                        System.out.println(delta.getPassengers().size());
                        dataOutputStream.writeUTF("sending southwest");
                        oos.writeObject(southwest);
                        System.out.println("sent southwest");
                        System.out.println(southwest.getPassengers().size());
                    }
                    switch (queryDataInput) {
                        case "setAirlines : Alaska":
                            alaska = (Alaska) ois.readObject();
                            System.out.println("received setAirlines alaska");
                            writeToFile();
                            break;
                        case "setAirlines : Delta":
                            delta = (Delta) ois.readObject();
                            System.out.println("received setAirlines delta");
                            writeToFile();
                            break;
                        case "setAirlines : Southwest":
                            southwest = (Southwest) ois.readObject();
                            System.out.println("received setAirlines southwest");
                            writeToFile();
                            break;
                    }

                }catch (IOException | ClassNotFoundException e){
                    e.printStackTrace();
                    break;
                }

            }

        }





        //hashcode
        public int hashCode() {
            int result = 23;

            result = result * 31 * Objects.hashCode(this.clientSocket);

            return result;
        } //hashCode

        //equals
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            } else if (object instanceof ClientHandler) {
                return Objects.equals(this.clientSocket, ((ClientHandler) object).clientSocket);
            } else {
                return false;
            } //end if
        } //equals

        //toString

        public String toString() {
            String format = "ClientHandler[%s]";

            return String.format(format, this.clientSocket);
        } //toString



    }

}