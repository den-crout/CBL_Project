import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Background extends JFrame {
    private static Levels level;
    private static GameOverRestart restart;
    private CardLayout cardLayout;
    private JPanel container;
    
    public Background() {
        
        this.setTitle("Jump King");
        this.setBackground(Color.green);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(810,600);
        this.setLocationRelativeTo(null);
        
        
        cardLayout = new CardLayout(); //layout to switch between screens
        container = new JPanel(cardLayout);  //container that holds screens
        
        level = new Levels();
        
        restart = new GameOverRestart(this);  // create restart panel with current background frame
        container.add(level, "game");    //add a screen
        container.add(restart, "restart");
        
        this.add(container);   // add container with screens to frame
        this.setContentPane(container);   //use container as main content area for frame
        
        cardLayout.show(container, "restart");  //show a screen
        
        
        this.setVisible(true);
        
        
    }
    public void showGame() {
        cardLayout.show(container, "game");
        level.requestFocusInWindow();  //make keyboard work again after switching panels
    }
}
