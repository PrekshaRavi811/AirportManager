import javax.swing.*;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(600,800);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setVisible(true);
        frame.add(panel);

        JTextArea area = new JTextArea();
        frame.add(area);
        String text = area.getText();
        System.out.println(text);
    }//// IS PARSABLE
//    private static boolean isParsable(String string) {
//        return string.chars()
//                .mapToObj(Character::isDigit)
//                .reduce(Boolean::logicalAnd)
//                .orElse(Boolean.FALSE);
//    }

//// HOST DIALOG BOX
//    public static String host() {
//        String hostname;
//        do {
//            hostname = (String) JOptionPane.showInputDialog(null,
//                    "What is the hostname you'd like to connect to? ", "Hostname?", JOptionPane.PLAIN_MESSAGE);
//
//            if (hostname == null) {
//                lastMessage(); // Change to rish's thank you msg
//                break;
//            } else if (hostname.equals("")) {
//                JOptionPane.showMessageDialog(null, "Please enter a valid hostname.",
//                        "Hostname?", JOptionPane.ERROR_MESSAGE);
//            } else break;
//        } while (true);
//        return hostname;
//    }

    //// lAST MSG DIALOG
//    public static void lastMessage() { // change to rish's thank you msg
//        JOptionPane.showMessageDialog(null, "We hope to serve you again!");
//    }

//// PORT DIALOG BOX
//    public static int port() {
//        int port = 0;
//        String portString;
//        try {
//            do {
//                portString = JOptionPane.showInputDialog(null,
//                        "What is the port you'd like to connect to? ",
//                        "Port?", JOptionPane.PLAIN_MESSAGE);
//
//                if (portString == null) {
//                    lastMessage();
//                    break;
//                } else if (portString.equals("")) { // also for invalid port
//                    JOptionPane.showMessageDialog(null, "Please enter a valid port.",
//                            "Port?", JOptionPane.ERROR_MESSAGE);
//                } else {
//                    port = Integer.parseInt(portString);
//
//                    break;
//                }
//            } while (true);
//
//
//        }catch (NullPointerException e) {
//            lastMessage();
//        }
//
//        return port;
    //   }

    //INPUT VALIDATION FOR GUI

}

