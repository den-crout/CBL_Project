import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Levels extends JPanel implements KeyListener {
    
    private static Player player;
    
    public Levels() {
        
        this.setBackground(Color.black);
        
        //this.setBounds(0, 0, 300, 200);
        
        player = new Player();
        
        setFocusable(true); //read the keyboard
        addKeyListener(this);  //use keyboard methods for THIS
        
        player.movement();
        
        this.setVisible(true);
        
        Timer timer = new Timer(30, e -> {
            player.movement();
            repaint();
        });
        
        timer.start();
  
    }
    
    @Override   //override paint method in JFrame so we can use players draw
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setSize(420, 420);
        
        g.setColor(Color.white);
        
        g.drawRect(player.getX(), player.getY(), 30, 30);
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.doJump(true);
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

