import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NewServer {

    public static final int PORT = 60088;

    public void runServer() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server up");
        Socket socket = serverSocket.accept();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//        Alaska alaska = (Alaska) ois.readObject();
//        System.out.println(alaska.toString());
        Alaska alaska = new Alaska();
      //  new NewServer().writingObject("C:\\Users\\preks\\IdeaProjects\\CS180_Project_5\\reservations.txt", alaska);
        //Object object = new NewServer().readingObject("C:\\Users\\preks\\IdeaProjects\\CS180_Project_5\\reservations.txt");
       // oos.writeObject(object);
        System.out.println("Sent object");

        socket.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new NewServer().runServer();
    }

    public Object readingObject(String filepath) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filepath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();
        System.out.println("object has been read");
        System.out.println(object); // no to string
        ois.close();
        return object;


    }
    public void writingObject(String filepath, Object object) throws IOException {
        FileOutputStream fos = new FileOutputStream(filepath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        System.out.println("Object was successfully written to a file");
    }
    //-----------------------------------------------------------------------------------------------------------------
    //import java.net.ServerSocket;
////import java.util.Set;
////import java.io.File;
////import java.io.IOException;
////import java.io.BufferedReader;
////import java.util.HashSet;
////import java.io.FileReader;
////import java.util.Objects;
////import java.net.Socket;
////
////
////        private ServerSocket serverSocket;
////
////        /**
////         * Constructs a newly allocated {@code CensoringServer} object with the bad words in the specified file.
////         *
////         * @param file the file to be used in construction
////         * @throws NullPointerException if the specified file is {@code null}
////         * @throws IOException if an I/O exception occurred
////         */
////        public ReservationServer(File file) throws NullPointerException, IOException {
////            BufferedReader reader;
////            String line;
////
////            Objects.requireNonNull(file, "the specified file is null");
////
////            this.serverSocket = new ServerSocket(0);
////
////            reader = new BufferedReader(new FileReader(file));
////
////            line = reader.readLine();
////
////            while (line != null) {
////                this.badWords.add(line);
////
////                line = reader.readLine();
////            } //end while
////
////            reader.close();
////        } //CensoringServer
////
////        /**
////         * Serves the clients that connect to this server.
////         */
////        public void serveClients() {
////            Socket clientSocket;
////            Thread handlerThread;
////            int clientCount = 0;
////
////            System.out.printf("<Now serving clients on port %d...>%n", this.serverSocket.getLocalPort());
////
////            while (true) {
////                try {
////                    clientSocket = this.serverSocket.accept();
////                } catch (IOException e) {
////                    e.printStackTrace();
////
////                    return;
////                } //end try catch
////
////                handlerThread = new Thread(new CensoringRequestHandler(clientSocket, this.badWords));
////
////                handlerThread.start();
////
////                System.out.printf("<Client %d connected...>%n", clientCount);
////
////                clientCount++;
////            } //end while
////        } //serveClients
////
////        /**
////         * Returns the hash code of this server.
////         *
////         * @return the hash code of this server
////         */
////        @Override
////        public int hashCode() {
////            int result = 23;
////
////            result = 31 * result + Objects.hashCode(this.serverSocket);
////
////            result = 31 * result + Objects.hashCode(this.badWords);
////
////            return result;
////        } //hashCode
////
////        /**
////         * Determines whether or not the specified object is equal to this server. {@code true} is returned if and only if
////         * the specified object is an instance of {@code CensoringSever} and its server socket and {@code Set} of bad words
////         * are equal to this sever's.
////         *
////         * @param object the object to be used in the comparisons
////         * @return {@code true}, if the specified object is equal to this server and {@code false} otherwise
////         */
////        @Override
////        public boolean equals(Object object) {
////            if (this == object) {
////                return true;
////            } else if (object instanceof CensoringServer) {
////                boolean equal;
////
////                equal = Objects.equals(this.serverSocket, ((CensoringServer) object).serverSocket);
////
////                equal &= Objects.equals(this.badWords, ((CensoringServer) object).badWords);
////
////                return equal;
////            } else {
////                return false;
////            } //end if
////        } //equals
////
////        /**
////         * Returns the {@code String} representation of this server. The returned {@code String} consists of a comma
////         * separated list of this server's server socket and {@code Set} of bad words surrounded by this class' name and
////         * square brackets ("[]").
////         *
////         * @return the {@code String} representation of this server
////         */
////        @Override
////        public String toString() {
////            String format = "CensoringServer[%s, %s]";
////
////            return String.format(format, this.serverSocket, this.badWords);
////        } //toString
////}
//
////try -- this is from textbook
////
////    {
////        ServerSocket serverSocket = new ServerSocket(4321);
////        Socket socket = serverSocket.accept();
////        DataInputStream in = new DataInputStream(socket.getInputStream());
////        int sum = 0;
////        for (int i = 0; i < 100; i++)
////            sum += in.readInt();
////        in.close();
////        System.out.println("Sum: " + sum);
////    }
////        catch(
////    IOException e)
////
////    {
////        System.out.println("Network error: " + e.getMessage());
////    }
//
    //-----------------------------------------------------------------

}
