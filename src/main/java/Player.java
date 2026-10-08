
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Player {

    boolean left;
    boolean right;
    boolean jump;
    int health = 10;
    int damage = 1;
    int speed = 3;
    int jumpH = -15;
    int x = 195;
    int y = 150;
    int yVelocity = 1;
    int speedg = 1;

    public Player() {

    }

    public void movement() {

        if (left) {
            x -= speed;
        }
        if (right) {
            x += speed;
        }

        yVelocity += 1;
        y += yVelocity;
        
        if (collision() == true && yVelocity > 0) {
            yVelocity = 0;
            y = (210 - 30);
        }
        
        

        if (jump) {
            if (y == 210 - 30) {
            yVelocity = jumpH;
            }
            jump = false;
        }
    }

    public boolean collision() {
        if ((y >= (210 - 30) && (x > 0 && x < 570)) ) {
            return true;
        }

        return false;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveLeft(boolean left) {
        this.left = left;
    }

    public void moveRight(boolean right) {
        this.right = right;
    }

    public void doJump(boolean jump) {
        this.jump = jump;
    }
}
