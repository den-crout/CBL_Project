import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Background extends JFrame {
    public Levels level1;
    public Levels level2;
    public Levels level3;
    
    public Level_1 level_1;
    public Level_2 level_2;
    public Level_3 level_3;
    
    private CardLayout cardLayout;
    private JPanel container;
    
    private GameStart start;
    private Restart restart;
    public SelectLevel select;
    public EndGame end;
    
    public JLabel label1;
    public JLabel label2;
    public JLabel label3;
    
    int hp;
    
    public int o;
    
    public Background() {
        
        this.setTitle("Jump King");    //describe the frame
        this.setBackground(Color.green);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(810,600);
        this.setLocationRelativeTo(null);
        
        
        cardLayout = new CardLayout(); //layout to switch between screens
        container = new JPanel(cardLayout);  //container that holds screens
        
        level_1 = new Level_1();    //creating 3 different grids;
        level_2 = new Level_2();
        level_3 = new Level_3();
        
        
        level1 = new Levels(this, level_1.getGrid());    //creating 3 different levels based on 3 grids;
        label1 = new JLabel("Health: 3" );
        label1.setFont(new Font("Arial", Font.BOLD, 22));
        label1.setForeground(Color.white);
        level1.add(label1);
        
        
        container.add(level1, "game1");   // add game screens
        
        level2 = new Levels(this, level_2.getGrid());
        label2 = new JLabel("Health: 3" );
        label2.setFont(new Font("Arial", Font.BOLD, 22));
        label2.setForeground(Color.white);
        level2.add(label2);
        
        container.add(level2, "game2");
        
        level3 = new Levels(this, level_3.getGrid());   
        label3 = new JLabel("Health: 3" );
        label3.setFont(new Font("Arial", Font.BOLD, 22));
        label3.setForeground(Color.white);
        level3.add(label3);
        
        container.add(level3, "game3");
        
        restart = new Restart(this, level1); //create panels with this background;
        start = new GameStart(this);
        select = new SelectLevel(this);
        end = new EndGame(this);
        
        
        container.add(start, "start");       //add menu panels
        container.add(restart, "restart");
        container.add(select, "select");
        container.add(end, "end");
        
        this.add(container);              //add container with screens to this frame
        this.setContentPane(container);   //use container as main content area for frame
        
        cardLayout.show(container, "start");  //show a screen
        
        
        this.setVisible(true);
        
        
    }
    public void showStart() {
        cardLayout.show(container, "start");
    }
    public void showGame1() {
        cardLayout.show(container, "game1");
        level1.startT();
        level1.requestFocusInWindow();  //make keyboard work again after switching panels
    }
    public void showGame2() {
        cardLayout.show(container, "game2");
        level2.startT();
        level2.requestFocusInWindow();  //make keyboard work again after switching panels
    }
    public void showGame3() {
        cardLayout.show(container, "game3");
        level3.startT();
        level3.requestFocusInWindow();  //make keyboard work again after switching panels
    }
    
    public void showSelect() {
        cardLayout.show(container, "select");
    }
    public void showRestart() {
        cardLayout.show(container, "restart"); 
    }
    public void showEnd() {
        cardLayout.show(container, "end");
    }
    
}
