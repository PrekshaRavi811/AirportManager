//import java.io.*;
//import java.net.Socket;
//import java.util.Objects;
//
//public class ClientHandler implements Runnable{
//
//    private Socket clientSocket;
//
//    public ClientHandler(Socket clientSocket) throws NullPointerException {
//        Objects.requireNonNull(clientSocket, "the specified client socket is null"); // just for ref - check usage
//
//        this.clientSocket = clientSocket;
//    } //CountdownRequestHandler
//
//    public void run() {
//        try { // oos and ois + gui?
//            File file = new File("reservations.txt");
//            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
//            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream()); // dk where to use yet
//            oos.flush();
//            FileReader fr = new FileReader(file);
//            BufferedReader bfr = new BufferedReader(fr);
//            PrintWriter pw = new PrintWriter(file);
//
//
//            Passenger passenger = (Passenger) ois.readObject(); // for passenger. Passenger object needs to be created here or gui
//            //oos.writeObject(passenger);
//            String newPassengerList = passenger.toString();
//            pw.write(newPassengerList);
//
//        } catch (IOException | ClassNotFoundException e) {
//
//        }
//    }
//
//    //hashcode
//    public int hashCode() {
//        int result = 23;
//
//        result = result * 31 * Objects.hashCode(this.clientSocket);
//
//        return result;
//    } //hashCode
//
//    //equals
//    public boolean equals(Object object) {
//        if (this == object) {
//            return true;
//        } else if (object instanceof ClientHandler) {
//            return Objects.equals(this.clientSocket, ((ClientHandler) object).clientSocket);
//        } else {
//            return false;
//        } //end if
//    } //equals
//
//    //toString
//
//    public String toString() {
//        String format = "ClientHandler[%s]";
//
//        return String.format(format, this.clientSocket);
//    } //toString
//
//
//
//}
