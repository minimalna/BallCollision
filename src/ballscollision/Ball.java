package ballscollision;

public class Ball {
    int x;
    int y;
    int r;
    int vx;
    int vy;


    public Ball(int x, int y, int r, int vx, int vy) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
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
    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

}
