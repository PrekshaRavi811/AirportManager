import java.io.*;
import java.net.Socket;

public class NewClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", NewServer.PORT);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Object object = ois.readObject();
        System.out.println("received object");
        System.out.println(object.toString());


//        Alaska alaska = new Alaska();
//        oos.writeObject(alaska);
        socket.close();
    }

//----------------------------------------------------------------------------------------------------------------------
}