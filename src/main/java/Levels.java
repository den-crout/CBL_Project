
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Levels extends JPanel implements KeyListener {

    public Player player;
    private Block block;
    private Spike spike;
    private Background background;
    private Timer timer;
    private Flag flag;
    private Enemy enemy;

    private int[][] grid;
    
    public List<Enemy> allEnemies = new ArrayList<>();

    public Levels(Background background, int[][] grid) {

        this.setBackground(new Color(20, 45, 35));

        player = new Player(grid);
        this.background = background;
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 4 || grid[i][j] == 5) {
                    allEnemies.add(new Enemy(j, i, grid[i][j] == 5, grid, player));
                }
            }
        }

        setFocusable(true); //read the keyboard
        addKeyListener(this);  //use keyboard methods for THIS

        player.movement();

        timer = new Timer(30, e -> {

            player.movement();
            for (Enemy enemy : allEnemies) {
                enemy.checkHit();
                enemy.movement();
                
            }
            repaint();
            
            
            if (player.health == 1) {
                background.label1.setText("Health: 1");
                background.label2.setText("Health: 1");
                background.label3.setText("Health: 1");
            
            }
            if (player.health == 2) {
                background.label1.setText("Health: 2");
                background.label2.setText("Health: 2");
                background.label3.setText("Health: 2");
            
            }
            if (player.health == 3) {
                background.label1.setText("Health: 3");
                background.label2.setText("Health: 3");
                background.label3.setText("Health: 3");
            }
            
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

        g.setColor(Color.white);

        g.drawRect(player.getX(), player.getY(), 28, 28);
        g.setColor(Color.red);
        g.fillRect(player.getX(), player.getY(), 28, 28);
        
        g.setColor(Color.BLUE);
        for (Enemy enemy : allEnemies) {
            g.drawOval(enemy.getX(), enemy.getY(), 28, 28);
        }

        for (int i = 0; i < 19; i++) {                       //loop y axis
            for (int j = 0; j < 27; j++) {                  //loop x axis
                if (grid[i][j] == 1) {

                    g.setColor(Color.GRAY);
                    block = new Block(j, i);
                    g.drawRect(block.getX(), block.getY(), 30, 30);

                } else if (grid[i][j] == 2) {

                    g.setColor(Color.WHITE);
                    spike = new Spike(j, i);
                    g.drawPolygon(spike.getX(), spike.getY(), 3);

                } else if (grid[i][j] == 3) {

                    g.setColor(Color.LIGHT_GRAY);
                    flag = new Flag(j, i);
                    g.drawRect(flag.getX(), flag.getY(), 1, 30);
                    g.setColor(Color.RED);
                    g.drawRect(flag.getX() + 1, flag.getY(), 29, 10);

                } 
            }
        }
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
