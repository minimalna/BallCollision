package ballscollision;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public Window(int width, int height) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(100,100));
        setContentPane(new Canvas(width, height));
        this.pack();
        this.setTitle("Balls Collider");
        this.setVisible(true);
    }
}
