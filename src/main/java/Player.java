
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Player {
    boolean left;
    boolean right;
    int health = 10;
    int damage = 1;
    int jumpH = 1;
    int speed = 30;
    int x = 200;
    
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        
        g2D.drawOval(x, 200, 30, 30);
    }
    
    public void movement() {
         if (left) {
             x -= speed;
         }
         if (right) {
             x += speed;
         }
        
    }
    public void moveLeft(boolean left) {
        this.left = left;
    }
    
    public void moveRight(boolean right) {
        this.right = right;
    }
}
