package MainCode;

import javax.swing.*;
import java.awt.*;

public class Util {

    public void deleteAllComponents(JPanel panel){
        SwingUtilities.invokeLater(() -> {
            Component[] components = panel.getComponents();
            for (int i = 1; i <= components.length; i ++){
                panel.remove(components.length - i);
            }
        });

    }
}
