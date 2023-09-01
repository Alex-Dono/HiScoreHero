package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BackGroundPanel extends JPanel {

    public BackGroundPanel() throws IOException {
    }

    Image bgImage = ImageIO.read(getClass().getResource("/MenuBar.png"));


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }

}
