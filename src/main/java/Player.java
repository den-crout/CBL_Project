
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Player {
    boolean left;
    boolean right;
    int health = 10;
    int damage = 1;
    int jumpH = 1;
    int speed = 1;
    int x = 100;
    
    public Player() {
        
    }
    
    public void movement() {
         if (left) {
             x -= speed;
         }
         if (right) {
             x += speed;
         }
        
    }
    
    public int getX() {
        return x;
    }

    public void moveLeft(boolean left) {
        this.left = left;
    }
    
    public void moveRight(boolean right) {
        this.right = right;
    }
}
