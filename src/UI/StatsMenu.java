package UI;


import MainCode.Player;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class StatsMenu {

    public StatsMenu() {
        makeIt();
    }

    private Player player = new Player("", 20, 20, 12, 5, 5);
    public Player getPlayer() { return player; }

    private OutlineLabel name = new OutlineLabel("");
    private OutlineLabel hp = new OutlineLabel("Hp: " + player.pHp + " / " + player.pHpMax + " ");
    private OutlineLabel att = new OutlineLabel("Attack: " + player.pAtt + " ");
    private OutlineLabel def = new OutlineLabel("Defense: " + player.pDef + " ");
    private OutlineLabel spd = new OutlineLabel("Speed: " + player.pSpd + " ");

    private JTextField textField = new JTextField("");
    private JButton button = new JButton("");
    private JPanel nestedPanel1 = new JPanel();
    private JPanel nestedPanel2 = new JPanel();
    public BackGroundPanel thePanel;

    {
        try {
            thePanel = new BackGroundPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BoxLayout boxLayout = new BoxLayout(thePanel, BoxLayout.Y_AXIS);

    public JButton changeMenuButton = new JButton("change");

    public void setFontAndColor(){
        name.colorsFontandSizeSetter(Color.BLACK, Color.BLUE, 30, "ATHLETIC", Font.PLAIN);
        hp.colorsFontandSizeSetter(Color.BLACK, Color.GRAY, 25, "ATHLETIC", Font.PLAIN);
        att.colorsFontandSizeSetter(Color.BLACK, Color.GRAY, 25, "ATHLETIC", Font.PLAIN);
        def.colorsFontandSizeSetter(Color.BLACK, Color.GRAY, 25, "ATHLETIC", Font.PLAIN);
        spd.colorsFontandSizeSetter(Color.BLACK, Color.GRAY, 25, "ATHLETIC", Font.PLAIN);
        potion.colorsFontandSizeSetter(Color.BLACK, Color.GRAY, 25, "ATHLETIC", Font.PLAIN);
    }

    public void makeIt(){

        setFontAndColor();

        thePanel.setLayout(boxLayout);
        thePanel.setPreferredSize(new Dimension(240, 50));
        thePanel.add(Box.createRigidArea(new Dimension(5, 20)));
        thePanel.add(name);
        thePanel.add(Box.createRigidArea(new Dimension(20, 10)));
        thePanel.add(hp);
        thePanel.add(Box.createRigidArea(new Dimension(5, 10)));
        thePanel.add(att);
        thePanel.add(Box.createRigidArea(new Dimension(5, 10)));
        thePanel.add(def);
        thePanel.add(Box.createRigidArea(new Dimension(5, 10)));
        thePanel.add(spd);
        thePanel.add(Box.createRigidArea(new Dimension(5, 10)));
        thePanel.add(changeMenuButton);

        whichMenu = 0;
    }


    ////////////////////////////////change into item menu////////////////////////////////////////////

    public int remainingPotions = 1;

    public void usePotion(){
        if (remainingPotions > 0 && player.pHp < player.pHpMax){
            player.pHp += 5;
            if (player.pHp > player.pHpMax){
                player.pHp = player.pHpMax;
            }
            hp.setText("Hp: " + player.pHp + " / " + player.pHpMax);
            remainingPotions --;
            potion.setText("Potion: " + remainingPotions);
        }
        else {
        }
    }

    public JButton usePotionButton = new JButton("Use");

    public int whichMenu = 0;

    public OutlineLabel potion = new OutlineLabel("Potion: " + remainingPotions + " ");

    public void changeIt(){

            thePanel.setLayout(boxLayout);
            thePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            thePanel.add(potion);
            thePanel.add(Box.createRigidArea(new Dimension(5, 10)));
            thePanel.add(usePotionButton);
            thePanel.add(Box.createRigidArea(new Dimension(5, 10)));
            thePanel.add(changeMenuButton);

        whichMenu = 1;
    }

    //////////////////////////////////////////////////////////////////////////


    public JLabel getName() { return name; }
    public JLabel getHp() { return hp; }
    public JLabel getAtt() { return att; }
    public JLabel getDef() { return def; }
    public JLabel getSpd() { return spd; }

    public BoxLayout getBoxLayout() {
        return boxLayout;
    }
    public JPanel getThePanel() {
        return thePanel;
    }

    public JTextField getTextField() {
        return textField;
    }
    public JButton getButton() {
        return button;
    }

}
