package ballscollision;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

public class Canvas extends JPanel {
    private Random rand = new Random();
    private int num = rand.nextInt(27) + 3;
    private ArrayList<Ball> balls = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        drawCircle(g);
    }

    public void init() {
        int width = this.getWidth();
        int height = this.getHeight();
        for (int i = 0; i < num; i++) {
            int r = rand.nextInt(80) + 20;
            while (2 * r >= width || 2 * r >= height) {
                r = rand.nextInt(80) + 20;
            }
            int x = rand.nextInt(width - 2 * r) + r;
            int y = rand.nextInt(height - 2 * r) + r;
            Ball ball = new Ball(x, y, r);
            balls.add(ball);

        }
    }

    private void drawCircle(Graphics g) {
        for (Ball b : balls) {
            int r = b.getR();
            g.drawOval(b.getX() - r, b.getY() - r, 2 * r, 2 * r);
        }
    }

    public void animateBalls() {
        Timer t = new Timer(50, e -> moveBalls());
        t.start();
    }

    public void moveBalls() {
        for (Ball b : balls) {
            if (b.getX() < this.getWidth()) {
                b.setX(b.getX() + 1);
            }
        }
        repaint();
    }
}

