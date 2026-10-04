import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Background extends JFrame implements KeyListener {
    private static Player player;
    
    public Background() {
        this.setTitle("Jump King");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,420);
        
        player = new Player();
        addKeyListener(this);
        player.movement();
        this.setVisible(true);
        
        Timer timer = new Timer(500, e -> {
            player.movement();
            repaint();
        });
        
        timer.start();
  
    }
    
    @Override   //override paint method in JFrame so we can use players draw
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics g2 = (Graphics2D) g;
        player.draw(g2);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            player.moveLeft(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            player.moveRight(true);
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            player.moveLeft(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            player.moveRight(false);
        }
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
