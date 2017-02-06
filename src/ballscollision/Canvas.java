package ballscollision;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

public class Canvas extends JPanel {
    private Random rand = new Random();
    private ArrayList<Ball> balls = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        drawBalls(g);
    }

    public void init() {
        int num = 10; //rand.nextInt(27) + 3;
        int width = this.getWidth();
        int height = this.getHeight();
        for (int i = 0; i < num; i++) {
            int r = 20; //rand.nextInt(10) + 20;
            int x = rand.nextInt(width - 2 * r) + r;
            int y = rand.nextInt(height - 2 * r) + r;
            int vx = rand.nextInt(20) - 10;
            int vy = rand.nextInt(20) - 10;
            Ball ball = new Ball(x, y, r, vx, vy);
            balls.add(ball);

        }
    }

    private void drawBalls(Graphics g) {
        for (Ball b : balls) {
            int r = b.getR();
            if (b.isCollided()) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.black);
            }
            g.drawOval(b.getX() - r, b.getY() - r, 2 * r, 2 * r);
        }
    }


    public void animateBalls() {
        Timer t = new Timer(50, e -> moveBalls());
        t.start();
    }

    public void moveBalls() {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).setCollided(false);
        }
        for (int i = 0; i < balls.size(); i++) {
            Ball b1 = balls.get(i);
            int x = b1.getX();
            int y = b1.getY();
            int r = b1.getR();

            for (int j = i + 1; j < balls.size(); j++) {
                Ball b2 = balls.get(j);

                int dx = Math.abs(b1.getX() - b2.getX());
                int dy = Math.abs(b1.getY() - b2.getY());
                int actualDist = (int) Math.sqrt(dx * dx + dy * dy);
                int minDist = b1.getR() + b2.getR();

                if (actualDist <= minDist) {
                    b1.setCollided(true);
                    b2.setCollided(true);
                }
            }

            if (x >= (this.getWidth() - r) || (x <= r)) {
                b1.setVx(-b1.getVx());
            }
            if ((y >= this.getHeight() - r) || (y <= r)) {
                b1.setVy(-b1.getVy());
            }

            b1.setX(x + b1.getVx());
            b1.setY(y + b1.getVy());
        }

        repaint();
    }
}

