package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StoryBoard{

    public StoryBoard() {
        makeIt();
    }

    private JLabel label = new JLabel("");
    private JTextField textField = new JTextField("");
    private JButton button = new JButton("Go");
    private JPanel nestedPanel1 = new JPanel();
    private JPanel nestedPanel2 = new JPanel();
    private BackGroundPanelStory thePanel;

    {
        thePanel = new BackGroundPanelStory();
    }

    private FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 10, 10);

    public void makeIt(){

        label.setFont(new Font("Mechanical", Font.PLAIN, 20));

        thePanel.setLayout(flowLayout);
        thePanel.setPreferredSize(new Dimension(20, 90));
        thePanel.add(Box.createRigidArea(new Dimension(944, 13)));
        thePanel.add(label);
        thePanel.add(textField); textField.setVisible(false);
        thePanel.add(button); button.setVisible(false);

    }

    public JPanel getThePanel() { return thePanel; }
    public JLabel getLabel() { return label; }
    public FlowLayout getFlowLayout() { return flowLayout; }
    public JTextField getTextField() { return textField; }
    public JButton getButton() { return button; }
}
