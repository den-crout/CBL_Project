
public class Block {

    int x;
    int y;

    //cords to pixels = times 30
    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x*30;
    }

    public int getY() {
        return this.y*30;
    }
}
