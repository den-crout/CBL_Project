import javax.swing.*;

public class Javaswing {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        JFrame frame = new JFrame("Game start!");
        JButton button = new JButton("start");
        JButton button2 = new JButton("start2");
        String sf = "d3";
        frame.add(button);
        frame.add(button2);
        frame.setVisible(true);
    }
}
