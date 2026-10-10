
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Player {

    boolean left;
    boolean right;
    boolean jump;
    int health = 3;
    int damage = 1;
    int speed = 5;
    int jumpH = -15;
    int x = 195;
    int y = 150;
    int yVelocity = 1;
    int speedg = 1;
    int playerH = 28;
    int previousY;
    int previousX;

    int[][] grid = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},};

    public Player() {

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

        yVelocity += 1;
        y += yVelocity;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
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
                } else if (grid[r][c] == 2) {
                    //top collision
                    if (((previousY + playerH) <= (30 * r) && (y + playerH) >= (30 * r)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity > 0) {
                        health -= 1;
                        x = 195;
                        y = 150;
                    }

                    if ((previousY >= (30 * r + 30) && y <= (30 * r + 30)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity < 0) {
                        health -= 1;
                        x = 195;
                        y = 150;
                    }
                    //left and right collision
                    if (((previousX + playerH) <= (30 * c) && ((x + playerH) >= 30 * c)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        health -= 1;
                        x = 195;
                        y = 150;
                    }
                    if (((previousX) >= (30 * c + 30) && ((x) <= 30 * c + 30)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        health -= 1;
                        x = 195;
                        y = 150;
                    }
                    
                }
                
            }
        }
    }

    public void death() {
        if (health == 0) {
           
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
