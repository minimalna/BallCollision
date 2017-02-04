package ballscollision;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Canvas extends JPanel {
    private Random rand = new Random();
    private int num = rand.nextInt(27) + 3;
    private int[][] circleData = new int[num][3];

    public Canvas(int width, int height) {
        init(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        drawCircle(g);
    }

    private void init(int width, int height) {
        for (int i=0; i < num; i++){
            int r = rand.nextInt(80) + 20;
            while (2 * r >= width || 2 * r >= height) {
                r = rand.nextInt(80) + 20;
            }
            int x = rand.nextInt(width - 2 * r) + r;
            int y = rand.nextInt(height - 2 * r) + r;
            circleData[i][0] = r;
            circleData[i][1] = x;
            circleData[i][2] = y;
        }
    }

    public void drawCircle(Graphics g) {
        System.out.println("Drawing...");
        for(int[] oneCircleData : circleData){
            int r = oneCircleData[0];
            g.drawOval(oneCircleData[1] - r, oneCircleData[2] - r, 2 * r, 2 * r);
        }
    }
}

