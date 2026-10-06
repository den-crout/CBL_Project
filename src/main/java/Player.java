
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
    int speed = 2;
    int jumpH = 60;
    int x = 200;
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
        
        for (int n = 0; n < speedg; n++) {
            y = y + yVelocity;
        }
        speedg += 1;

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
