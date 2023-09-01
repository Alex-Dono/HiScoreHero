package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class BackGroundPanelStory extends JPanel {


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Image bgImage = null;
        try {
            bgImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/StoryBar.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bgImage, 0, 0, null);
    }

}
