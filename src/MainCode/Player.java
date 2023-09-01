package MainCode;

public class Player {

    public Player(String playerName, int pHpMax, int pHp, int pAtt, int pDef, int pSpd) {
        this.playerName = playerName;
        this.pHpMax = pHpMax;
        this.pAtt = pAtt;
        this.pDef = pDef;
        this.pSpd = pSpd;
        this.pHp = pHp;
    }

    private String playerName;

    public int pHp;
    public int pAtt;
    public int pDef;
    public int pSpd;

    public int pHpMax;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
