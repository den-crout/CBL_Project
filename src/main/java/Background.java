import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Background extends JFrame {
    private static Levels level;
    
    public Background() {
        this.setTitle("Jump King");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        level = new Levels();
        this.add(level);
        pack();
        this.setVisible(true);
        
    }
}
