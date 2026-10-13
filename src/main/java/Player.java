
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Player {

    boolean left;
    boolean right;
    boolean jump;
    public int health = 3;
    int damage = 1;
    int speed = 5;
    int jumpH = -15;
    int x = 390;
    int y = 150;
    int yVelocity = 1;
    int speedg = 1;
    int playerH = 28;
    int previousY;
    int previousX;
    public Level_1 level1;
    
    public Player() {
        level1 = new Level_1();
    }

    public void movement() {

        previousY = y;
        previousX = x;

        if (yVelocity != 0) {
            jump = false;
        }

        if (left) {
            x -= speed;
        }
        if (right) {
            x += speed;
        }
        if (y <= 0) {
            yVelocity = 0;
            y = 0;
        }
        if (x >= 753 + 28) {
            
            x = 753 + 28;
        }
        if (x <= 1) {
            
            x = 1;
        }

        yVelocity += 1;
        y += yVelocity;

        for (int r = 0; r < level1.getGridLengthY(); r++) {
            for (int c = 0; c < level1.getGridLengthX(); c++) {
                if (level1.getCoordinate(r, c) == 1) {
                    //top collision 
                    if (((previousY + playerH) <= (30 * r) && (y + playerH) >= (30 * r)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity > 0) {

                        yVelocity = 0;
                        y = 30 * r - 29;

                        if (jump) {
                            if (y == 30 * r - playerH - 1) {
                                yVelocity = jumpH;
                            }
                            jump = false;
                        }
                    }
                    //bottom collision
                    if ((previousY >= (30 * r + 30) && y <= (30 * r + 30)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity < 0) {
                        yVelocity = 0;
                        y = 30 * r + 31;
                    }
                    //left and right collision
                    if (((previousX + playerH) <= (30 * c) && ((x + playerH) >= 30 * c)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        x = 30 * c - 31;
                    }
                    if (((previousX) >= (30 * c + 30) && ((x) <= 30 * c + 30)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        x = 30 * c + 31;
                    }
                } else if (level1.getCoordinate(r, c) == 2) {
                    //top collision
                    if (((previousY + playerH) <= (30 * r) && (y + playerH) >= (30 * r)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity > 0) {
                        health -= 1;
                        x = 390;
                        y = 150;
                    }

                    if ((previousY >= (30 * r + 30) && y <= (30 * r + 30)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity < 0) {
                        health -= 1;
                        x = 390;
                        y = 150;
                    }
                    //left and right collision
                    if (((previousX + playerH) <= (30 * c) && ((x + playerH) >= 30 * c)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        health -= 1;
                        x = 390;
                        y = 150;
                    }
                    if (((previousX) >= (30 * c + 30) && ((x) <= 30 * c + 30)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        health -= 1;
                        x = 390;
                        y = 150;
                    }

                }

            }
        }
        if (y > 600) {
            health -= 1;
            x = 390;
            y = 150;
        }
        

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



