
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Player {

    private Background background;

    boolean left;
    boolean right;
    boolean jump;
    public int health = 3;
    int damage = 1;
    int speed = 5;
    int jumpH = -15;
    int x = 390;
    int y = 501;
    int yVelocity = 1;
    int speedg = 1;
    int playerH = 28;
    int previousY;
    int previousX;

    public boolean completed = false;

    int[][] grid;

    public Player(int[][] grid) {
        this.grid = grid;
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
        if (x >= 753 + 28) {    //right side screen collision

            x = 753 + 28;
        }
        if (x <= 1) {    //left side screen collision
            x = 1;
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
                        getHit();
                    }

                    if ((previousY >= (30 * r + 30) && y <= (30 * r + 30)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity < 0) {
                        health -= 1;
                        x = 390;
                        y = 501;
                        return;

                    }
                    //left and right collision
                    if (((previousX + playerH) <= (30 * c) && ((x + playerH) >= 30 * c)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        health -= 1;
                        x = 390;
                        y = 501;
                        return;
                    }
                    if (((previousX) >= (30 * c + 30) && ((x) <= 30 * c + 30)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        health -= 1;
                        x = 390;
                        y = 501;
                        return;
                    }
                } else if (grid[r][c] == 3) {
                    //top collision
                    if (((previousY + playerH) <= (30 * r) && (y + playerH) >= (30 * r)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity > 0) {
                        completed = true;
                        x = 390;
                        y = 501;
                        return;
                    }

                    if ((previousY >= (30 * r + 30) && y <= (30 * r + 30)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity < 0) {
                        completed = true;
                        x = 390;
                        y = 501;
                        return;
                    }
                    //left and right collision
                    if (((previousX + playerH) <= (30 * c) && ((x + playerH) >= 30 * c)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        completed = true;
                        x = 390;
                        y = 501;
                        return;
                    }
                    if (((previousX) >= (30 * c + 30) && ((x) <= 30 * c + 30)) && ((y + playerH) > (30 * r) && y < (30 * r + 30))) {
                        completed = true;
                        x = 390;
                        y = 501;
                        return;
                    }
                }

            }

        }

        if (y > 600) {
            health -= 1;
            x = 390;
            y = 501;
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

    public void getHit() {
        health -= 1;
        x = 390;
        y = 150;
    }
}
