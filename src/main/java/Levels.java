
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Levels extends JPanel implements KeyListener {

    private static Player player;
    private static Level_1 level1;
    private static Block block;
    private static Spike spike;

    int[][] grid = {
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 1, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1}
    };

    public Levels() {

        this.setBackground(Color.black);
        this.setBounds(0, 0, 200, 200);

        player = new Player();

        setFocusable(true); //read the keyboard
        addKeyListener(this);  //use keyboard methods for THIS

        player.movement();

        this.setVisible(true);
        
        Timer timer = new Timer(30, e -> {
            player.collision();
            player.movement();
            repaint();
        });

        timer.start();

    }

    @Override   
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);

        g.drawRect(player.getX(), player.getY(), 30, 30);
        for (int i = 0; i < 8; i++) {                       //loop y axis
            for (int j = 0; j < 20; j++) {                  //loop x axis
                if (grid[i][j] == 1) {
                    g.setColor(Color.GRAY);
                    block = new Block(j, i);
                    g.drawRect(block.getX(), block.getY(), 30, 30);
                }
                if (grid[i][j] == 2) {
                    g.setColor(Color.WHITE);
                    spike = new Spike(j,i);
                    g.drawPolygon(spike.getX(), spike.getY(), 3);
                }
            }
        }
        // g.drawRect()
    }
   
    public void paintBlock(int x, int y) {

        super.setSize(420, 420);
        
        
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
