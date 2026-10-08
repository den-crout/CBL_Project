/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sebas
 */
public class Spike {

    int x;
    int y;

    public Spike(int x, int y) {
        this.x = x * 30;
        this.y = y * 30;
    }

    public int[] getX() {
        int[] output = {this.x+1, this.x + 15, this.x + 29};
        return output;
    }
    
    public int[] getY() {
        int[] output = {this.y+29, this.y+1, this.y+29};
        return output;
    }
}
