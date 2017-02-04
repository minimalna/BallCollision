package ballscollision;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(int width, int height) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(100, 100));
        Canvas canv = new Canvas();
        setContentPane(canv);
        this.pack();
        this.setTitle("Balls Collider");
        this.setVisible(true);
        System.out.println("Width: " + canv.getWidth() + ", Height: " + canv.getHeight());
        canv.init();
        canv.animateBalls();
    }
}
