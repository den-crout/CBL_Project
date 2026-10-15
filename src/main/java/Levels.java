
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Levels extends JPanel implements KeyListener {

    public Player player;
    private Block block;
    private Spike spike;
    private Background background;
    private Timer timer;
    private Flag flag;
    

    private int[][] grid;

    public Levels(Background background, int[][] grid) {

        this.setBackground(Color.black);

        player = new Player(grid);
        this.background = background;
        this.grid = grid;

        setFocusable(true); //read the keyboard
        addKeyListener(this);  //use keyboard methods for THIS

        player.movement();

        timer = new Timer(30, e -> {

            player.movement();
            repaint();
            if (player.health == 0) {
                player.moveLeft(false);
                player.moveRight(false);
                player.doJump(false);
                timer.stop();

                background.showRestart();
            
            }
            if (background.select.selected == 1 && player.completed == true) {
                background.select.selected = 2;
                player.completed = false;
                player.moveLeft(false);
                player.moveRight(false);
                player.doJump(false);
                background.showGame2();
                timer.stop();
            }
            if (background.select.selected == 2 && player.completed == true) {
                background.select.selected = 3;
                player.completed = false;
                player.moveLeft(false);
                player.moveRight(false);
                player.doJump(false);
                background.showGame3();
                timer.stop();
            }
            if (background.select.selected == 3 && player.completed == true) {
                
                background.level1.player.health = 3;
                background.level2.player.health = 3;
                background.level3.player.health = 3;
                
                background.select.selected = 0;
                player.completed = false;
                player.moveLeft(false);
                player.moveRight(false);
                player.doJump(false);
                background.showEnd();
                timer.stop();
            }

        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);

        g.drawRect(player.getX(), player.getY(), 28, 28);
        g.setColor(Color.white);
        g.fillRect(player.getX(), player.getY(), 28, 28);
        for (int i = 0; i < 19; i++) {                       //loop y axis
            for (int j = 0; j < 27; j++) {                  //loop x axis
                if (grid[i][j] == 1) {
                    g.setColor(Color.red);
                    block = new Block(j, i);
                    g.drawRect(block.getX(), block.getY(), 30, 30);
                    g.setColor(Color.gray);
                    g.fillRect(block.getX(), block.getY(), 30, 30);
                }
                if (grid[i][j] == 2) {
                    g.setColor(Color.WHITE);
                    spike = new Spike(j, i);
                    g.drawPolygon(spike.getX(), spike.getY(), 3);
                    g.setColor(Color.red);
                    g.fillPolygon(spike.getX(), spike.getY(), 3);
                }
                if (grid[i][j] == 3) {
                    g.setColor(Color.LIGHT_GRAY);
                    flag = new Flag(j, i);
                    g.drawRect(flag.getX()+1, flag.getY(), 1, 30);
                    g.setColor(Color.white);
                    g.drawRect(flag.getX() + 2, flag.getY(), 29, 10);
                    g.setColor(Color.MAGENTA);
                    g.fillRect(flag.getX() + 2, flag.getY(), 29, 10);
                }
            }
        }
        // g.drawRect()
    }

    public void paintBlock(int x, int y) {

        super.setSize(420, 420);

    }

    public void startT() {
        timer.start();
    }

    public void endT() {
        timer.stop();
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
