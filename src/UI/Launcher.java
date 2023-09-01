package UI;

import MainCode.Enemy;

import javax.swing.*;
import java.util.concurrent.CompletableFuture;

public class Launcher {

    private static final MainFrame mainFrame = new MainFrame();

    public static void guiTask(Runnable task){
        SwingUtilities.invokeLater(task);
    }

    public static void runBackGroundStuff(Runnable task){
        CompletableFuture<Void> theTask = CompletableFuture.runAsync(task);
        theTask.join();
    }

    private static void theLoop(){
        final int[] z = {0};
        while (z[0] == 0){
            mainFrame.getStoryButton().addActionListener((e) -> {
                if (e.getSource() == mainFrame.getStoryButton())
                    z[0] = 1;
            });
        }
    }

    public static String textFieldLoop(){
        final int[] z = {0};
        while (z[0] == 0){
            mainFrame.getStoryBoard().getButton().addActionListener((e) -> {
                if (e.getSource() == mainFrame.getStoryBoard().getButton()){
                    z[0] = 1;
                }
            });
        }
        return mainFrame.getStoryBoard().getTextField().getText();
    }

    public static int attackOrPotionLoop(){
        final int[] theValue = {0};
        while (theValue[0] == 0){
            mainFrame.getStatsMenu().usePotionButton.addActionListener((e) -> {
                if (e.getSource() == mainFrame.getStatsMenu().usePotionButton){
                    theValue[0] = 1;
                }
            });
            mainFrame.getStoryButton().addActionListener((e) -> {
                if (e.getSource() == mainFrame.getStoryButton()){
                    theValue[0] = 2;
                }
            });
        }
        return theValue[0];
    }

    public static void storyProgression(String text){
        theLoop();
        mainFrame.getStoryBoard().getTextField().setVisible(false);
        mainFrame.getStoryBoard().getButton().setVisible(false);
        mainFrame.getStoryBoard().getLabel().setText(text);
    }

    public static void storyProgressionEnemyApproaches(String text){
        theLoop();
        mainFrame.getStatsMenu().usePotionButton.removeActionListener(mainFrame.potionListener);
        mainFrame.getStoryBoard().getTextField().setVisible(false);
        mainFrame.getStoryBoard().getButton().setVisible(false);
        mainFrame.getStoryBoard().getLabel().setText(text);
    }

    public static void storyProgression(String labelText, int columns){
        theLoop();
        mainFrame.getStoryBoard().getTextField().setVisible(true);
        mainFrame.getStoryBoard().getButton().setVisible(true);
        mainFrame.getStoryBoard().getLabel().setText(labelText);
        mainFrame.getStoryBoard().getTextField().setColumns(columns);
        textFieldLoop();
    }

    //////////////////////////////////ENEMY MAKER//////////////////////////////////////////////////////////////////////

    private static final Enemy lizard = new Enemy("Lizard", 11, 11, 8, 3, 7);

    private static final Enemy skeleton = new Enemy("Skeleton", 13, 13, 10, 4, 3);

    private static final Enemy beheader = new Enemy("Beheader", 15, 15, 12, 7, 1);

    private static final Enemy dragon = new Enemy("Dragon", 18, 18, 14, 6, 4);

    private static void statModifier(Enemy enemy){
        if (mainFrame.getStatsMenu().getPlayer().pHpMax > 20){
            enemy.eHPMax += (mainFrame.getStatsMenu().getPlayer().pHpMax + 1 - 20);
            enemy.eHP = enemy.eHPMax;
        }
        if (mainFrame.getStatsMenu().getPlayer().pAtt + mainFrame.getStatsMenu().getPlayer().pDef +
                mainFrame.getStatsMenu().getPlayer().pSpd > 23){
            int variable = mainFrame.getStatsMenu().getPlayer().pAtt + mainFrame.getStatsMenu().getPlayer().pDef +
                    mainFrame.getStatsMenu().getPlayer().pSpd - 23;
            enemy.eAtt += (variable - 1);
            enemy.eDef += (variable - 1);
            enemy.eSpd += (variable - 1);
        }
    }

    private static Enemy enemyGenerator(){
        Enemy enemy = null;
        int randomNumber = (int) (Math.random() * 12) + 1;
        if (randomNumber >= 1 && randomNumber <= 5){
            enemy = lizard;
        }
        if (randomNumber >= 6 && randomNumber <= 9){
            enemy = skeleton;
        }
        if (randomNumber >= 10 && randomNumber <= 11){
            enemy = beheader;
        }
        if (randomNumber == 12){
            enemy = dragon;
        }
        statModifier(enemy);
        return enemy;
    }

    private static void enemyStatReset(Enemy enemy){
        if (enemy == lizard){
            enemy.eHPMax = 11;
            enemy.eHP = 11;
            enemy.eAtt = 8;
            enemy.eDef = 3;
            enemy.eSpd = 7;
        }
        if (enemy == skeleton){
            enemy.eHPMax = 13;
            enemy.eHP = 13;
            enemy.eAtt = 10;
            enemy.eDef = 4;
            enemy.eSpd = 3;
        }
        if (enemy == beheader){
            enemy.eHPMax = 15;
            enemy.eHP = 15;
            enemy.eAtt = 12;
            enemy.eDef = 7;
            enemy.eSpd = 1;
        }
        if (enemy == dragon){
            enemy.eHPMax = 18;
            enemy.eHP = 18;
            enemy.eAtt = 14;
            enemy.eDef = 6;
            enemy.eSpd = 4;
        }
    }

    //////////////////////////////////EVENTS///////////////////////////////////////////////////////////////////////////

    public static void eventRoll1() {
        storyProgression("It's time to start your adventure");
        int random = (int) (Math.random() * 2) + 1;
        if (random == 1) {
            storyProgression("You found a potion!");
            mainFrame.getStatsMenu().remainingPotions++;
            mainFrame.getStatsMenu().potion.setText("Potion: " + mainFrame.getStatsMenu().remainingPotions);
            eventRoll();
        }
        if (random == 2) {
            storyProgressionEnemyApproaches("An enemy approached you!");
            Enemy enemy = enemyGenerator();
            storyProgression("A " + enemy.getClassName() + " is ready to fight you!");
            fight(enemy);
        }
    }

    public static void eventRoll(){
        storyProgression("Let's continue when you're ready");
        int random = (int) (Math.random() * 2) + 1;
        if (random == 1){
            storyProgression("You found a potion!");
            mainFrame.getStatsMenu().remainingPotions ++;
            mainFrame.getStatsMenu().potion.setText("Potion: " + mainFrame.getStatsMenu().remainingPotions);
            eventRoll();
        }
        if (random == 2){
            storyProgressionEnemyApproaches("An enemy approached you!");
            Enemy enemy = enemyGenerator();
            storyProgression("A " + enemy.getClassName() + " is ready to fight you!");

            String enemyLogTemplate = String.format("%s: Hp = %d, attack = %d, defense = %d, speed = %d",
                    enemy.getClassName(), enemy.eHPMax, enemy.eAtt, enemy.eDef, enemy.eSpd);
            System.out.println(enemyLogTemplate);

            fight(enemy);
        }
    }

    /////////////////////////////BATTLE////////////////////////////////////////////////////////////////////////////////

    private static int score = 0;

    public static void enemyFirst(Enemy enemy){
        storyProgression("The enemy attacks!");
        runBackGroundStuff(() -> {
            if (mainFrame.getStatsMenu().getPlayer().pDef < enemy.eAtt){
                mainFrame.getStatsMenu().getPlayer().pHp -= (enemy.eAtt - mainFrame.getStatsMenu().getPlayer().pDef);
            }
            else {
                mainFrame.getStatsMenu().getPlayer().pHp --;
            }
            mainFrame.getStatsMenu().getHp().setText(
                    "Hp: " + mainFrame.getStatsMenu().getPlayer().pHp + " / " + mainFrame.getStatsMenu().getPlayer().pHpMax);
        });

        if (mainFrame.getStatsMenu().getPlayer().pHp > 0){
            storyProgression("Your turn, what are your going to do?");
            storyProgression("(Press the use button to use a potion or press the story button to continue)");
            int value = attackOrPotionLoop();
            if (value == 1){
                mainFrame.getStatsMenu().usePotion();
                mainFrame.getStoryBoard().getLabel().setText("You used a potion");
            }
            if (value == 2){
                mainFrame.getStoryBoard().getLabel().setText("You attack!");
                runBackGroundStuff(() -> {
                    if (enemy.eDef < mainFrame.getStatsMenu().getPlayer().pAtt){
                        enemy.eHP -= (mainFrame.getStatsMenu().getPlayer().pAtt - enemy.eDef);
                    }
                    else {
                        enemy.eHP --;
                    }
                });
            }
        }
    }

    public static void youFirst(Enemy enemy){
        storyProgression("Your turn, what are your going to do?");
        storyProgression("(Press the use button to use a potion or press the story button to continue)");
        int value = attackOrPotionLoop();
        if (value == 1){
            mainFrame.getStatsMenu().usePotion();
            mainFrame.getStoryBoard().getLabel().setText("You used a potion");
        }
        if (value == 2){
            mainFrame.getStoryBoard().getLabel().setText("You attack!");
            runBackGroundStuff(() -> {
                if (enemy.eDef < mainFrame.getStatsMenu().getPlayer().pAtt){
                    enemy.eHP -= (mainFrame.getStatsMenu().getPlayer().pAtt - enemy.eDef);
                }
                else {
                    enemy.eHP --;
                }
            });
        }

        if (enemy.eHP > 0){
            storyProgression("The enemy attacks!");
            runBackGroundStuff(() -> {
                if (mainFrame.getStatsMenu().getPlayer().pDef < enemy.eAtt){
                    mainFrame.getStatsMenu().getPlayer().pHp -= (enemy.eAtt - mainFrame.getStatsMenu().getPlayer().pDef);
                }
                else {
                    mainFrame.getStatsMenu().getPlayer().pHp --;
                }
                mainFrame.getStatsMenu().getHp().setText(
                        "Hp: " + mainFrame.getStatsMenu().getPlayer().pHp + " / " + mainFrame.getStatsMenu().getPlayer().pHpMax);
            });
        }
    }

    public static void fight(Enemy enemy){
        while (mainFrame.getStatsMenu().getPlayer().pHp > 0 && enemy.eHP > 0) {
            if (mainFrame.getStatsMenu().getPlayer().pSpd > enemy.eSpd) {
                youFirst(enemy);
            }
            if (mainFrame.getStatsMenu().getPlayer().pSpd <= enemy.eSpd){
                enemyFirst(enemy);
            }
        }
        if (enemy.eHP <= 0){
            storyProgression("You won!");
            statLevelUp();
            runBackGroundStuff(() -> {
                score ++;
                enemyStatReset(enemy);
            });
            mainFrame.getStatsMenu().usePotionButton.addActionListener(mainFrame.potionListener);
            eventRoll();
        }
        if (mainFrame.getStatsMenu().getPlayer().pHp <= 0){
            storyProgression("You Lost. Farewell...");
            storyProgression("Your final score is: " + score);
        }
    }

    public static void statLevelUp(){
        int random = (int) (Math.random() * 4) + 1;
        String stat = "";
        if (random == 1) {
            mainFrame.getStatsMenu().getPlayer().pHpMax += 5; stat = "hp";
            mainFrame.getStatsMenu().getHp().setText("Hp: " +
                    mainFrame.getStatsMenu().getPlayer().pHp + " / " + mainFrame.getStatsMenu().getPlayer().pHpMax);
        }
        if (random == 2) {
            mainFrame.getStatsMenu().getPlayer().pAtt += 1; stat = "attack";
            mainFrame.getStatsMenu().getAtt().setText("Attack: " + mainFrame.getStatsMenu().getPlayer().pAtt);
        }
        if (random == 3) {
            mainFrame.getStatsMenu().getPlayer().pDef += 1; stat = "defense";
            mainFrame.getStatsMenu().getDef().setText("Defense: " + mainFrame.getStatsMenu().getPlayer().pDef);
        }
        if (random == 4) {
            mainFrame.getStatsMenu().getPlayer().pSpd += 1; stat = "speed";
            mainFrame.getStatsMenu().getSpd().setText("Speed: " + mainFrame.getStatsMenu().getPlayer().pSpd);
        }
        storyProgression("Your " + stat + " has increased!");
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main (String[] args){

        guiTask(() -> {
            mainFrame.initialize();
            mainFrame.getStoryBoard().getLabel().setText("Welcome to the plains adventurer");
        });

        storyProgression("What is your name?", 20);

        runBackGroundStuff(() -> mainFrame.getStatsMenu().getPlayer().setPlayerName(textFieldLoop())
        );

        guiTask(() ->
                mainFrame.getStatsMenu().getName().setText(mainFrame.getStatsMenu().getPlayer().getPlayerName() + " ")
        );

        storyProgression("I see, your name is " + mainFrame.getStatsMenu().getPlayer().getPlayerName());

        eventRoll1();

    }

}
