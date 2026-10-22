/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sebas
 */
public class Enemy {

    int x;
    int y;
    int startX;
    int startY;
    boolean direction;
    int speed;
    int startSpeed;
    int yVelocity = 1;
    int speedg = 1;
    int enemyH = 28;
    int previousY;
    int previousX;
    int[][] grid;
    public Player player;
    public Levels level;

    public Enemy(int x, int y, boolean direction, int[][] grid, Player player) {
        this.x = x * 30;
        this.y = y * 30;
        this.startX = x * 30;
        this.startY = y * 30;
        this.previousX = x * 30;
        this.previousY = y * 30;
        this.direction = direction;
        if (direction) {
            this.speed = 2;
            this.startSpeed = 2;
        } else {
            this.speed = -2;
            this.startSpeed = 2;
        }
        this.grid = grid;
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void movement() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    //top collision 
                    if (((previousY + enemyH) <= (30 * r) && (y + enemyH) >= (30 * r)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity > 0) {

                        yVelocity = 0;
                        y = 30 * r - 29;

                    }
                    //bottom collision
                    if ((previousY >= (30 * r + 30) && y <= (30 * r + 30)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity < 0) {
                        yVelocity = 0;
                        y = 30 * r + 31;
                    }
                    //left and right collision
                    if (((previousX + enemyH) <= (30 * c) && ((x + enemyH) >= 30 * c)) && ((y + enemyH) > (30 * r) && y < (30 * r + 30))) {
                        x = 30 * c - 31;
                        speed = -speed;
                    }
                    if (((previousX) >= (30 * c + 30) && ((x) <= 30 * c + 30)) && ((y + enemyH) > (30 * r) && y < (30 * r + 30))) {
                        x = 30 * c + 31;
                        speed = -speed;
                    }
                } else if (grid[r][c] == 2) {
                    //top collision
                    if (((previousY + enemyH) <= (30 * r) && (y + enemyH) >= (30 * r)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity > 0) {
                        dead();
                    }

                    if ((previousY >= (30 * r + 30) && y <= (30 * r + 30)) && (x > 30 * c - 29 && x < 30 * c + 29) && yVelocity < 0) {
                        dead();
                    }
                    //left and right collision
                    if (((previousX + enemyH) <= (30 * c) && ((x + enemyH) >= 30 * c)) && ((y + enemyH) > (30 * r) && y < (30 * r + 30))) {
                        dead();
                    }
                    if (((previousX) >= (30 * c + 30) && ((x) <= 30 * c + 30)) && ((y + enemyH) > (30 * r) && y < (30 * r + 30))) {
                        dead();
                    }

                }

            }
        }

        if (y > 600) {
            dead();
        }
        previousX = x;
        previousY = y;
        x = x + speed;
        yVelocity += 1;
        y += yVelocity;

    }

    public void checkHit() {
        if (x - 30 < player.getX() && player.getX() < x + 30 && y - 30 < player.getY() && player.getY() < y + 30) {
            player.getHit();
        }
    }

    public void dead() {
        x = startX;
        y = startY;
        speed = startSpeed;
        previousX = x;
        previousY = y;
        yVelocity = 0;
    }
}
