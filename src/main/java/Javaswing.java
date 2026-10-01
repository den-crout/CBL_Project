
import javax.swing.*;

public class Javaswing {

    private static NewJFrame myFrame;

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        myFrame = new NewJFrame();
        //JFrame frame = new JFrame("Game start!");   // git add .  //git commit - m "text"  //git push origin main
        //  frame.setSize(600,400);
        myFrame.setLocationRelativeTo(null);
        JButton button = new JButton("start");
        button.setBounds(100, 150, 50, 70);
        //JButton button2 = new JButton("start2");
        //String sf = "d3";
        //   frame.add(button);
        //frame.add(button2);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
} 
