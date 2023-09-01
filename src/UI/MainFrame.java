package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    public StoryBoard getStoryBoard() {
        return storyBoard;
    }

    private StoryBoard storyBoard = new StoryBoard();

    public StatsMenu getStatsMenu() {
        return statsMenu;
    }

    private StatsMenu statsMenu = new StatsMenu();
    private JButton storyButton = new JButton("Continue");

    public ActionListener potionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == getStatsMenu().usePotionButton){
                statsMenu.usePotion();
            }
        }
    };

    public void initialize() {

        setTitle("HiScoreHero");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(945, 500);
        setLayout(new BorderLayout(10, 5));
        setLocationRelativeTo(null);
        setVisible(true);

        add(storyBoard.getThePanel(), BorderLayout.NORTH);

        add(statsMenu.getThePanel(), BorderLayout.WEST);

        storyButton.setVisible(true);
        add(storyButton, BorderLayout.SOUTH);

        JPanel logoPanel = new JPanel();
        BoxLayout boxiee = new BoxLayout(logoPanel, BoxLayout.Y_AXIS);
        logoPanel.setLayout(boxiee);

        OutlineLabel logoLabel1 = new OutlineLabel("HiScore");
        OutlineLabel logoLabel2 = new OutlineLabel("Hero");
        logoLabel1.colorsFontandSizeSetter(Color.BLACK, Color.DARK_GRAY, 140, "Metamorve", Font.BOLD);
        logoLabel2.colorsFontandSizeSetter(Color.BLACK, Color.DARK_GRAY, 140, "Metamorve", Font.BOLD);

        logoPanel.add(Box.createRigidArea(new Dimension(50, 36)));
        logoPanel.add(logoLabel1, CENTER_ALIGNMENT);
        logoPanel.add(logoLabel2, CENTER_ALIGNMENT);

        add(logoPanel, BorderLayout.CENTER);


        statsMenu.usePotionButton.addActionListener(potionListener);


        statsMenu.changeMenuButton.addActionListener((e) -> {
            if (e.getSource() == statsMenu.changeMenuButton){
                if (statsMenu.whichMenu == 0){
                    SwingUtilities.invokeLater(() -> {
                        Component[] components = statsMenu.thePanel.getComponents();
                        for (int i = 1; i <= components.length; i ++){
                            statsMenu.thePanel.remove(components.length - i);
                        }
                        statsMenu.changeIt();
                        statsMenu.thePanel.revalidate();
                        statsMenu.thePanel.repaint();
                    });

                }
                if (statsMenu.whichMenu == 1){
                    SwingUtilities.invokeLater(() -> {
                        Component[] components = statsMenu.thePanel.getComponents();
                        for (int i = 1; i <= components.length; i ++){
                            statsMenu.thePanel.remove(components.length - i);
                        }
                        statsMenu.makeIt();
                        statsMenu.thePanel.revalidate();
                        statsMenu.thePanel.repaint();
                    });
                }
            }
        });

    }

    public JButton getStoryButton() {
        return storyButton;
    }
}
