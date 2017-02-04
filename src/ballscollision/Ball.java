package ballscollision;

public class Ball {
    int x;
    int y;
    int r;

    public Ball(int x, int y, int r) {
    this.r = r;
    this.x = x;
    this.y =y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
