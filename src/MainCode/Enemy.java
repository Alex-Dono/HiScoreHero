package MainCode;

public class Enemy {

    public Enemy(String className, int eHPMax, int eHP, int eAtt, int eDef, int eSpd) {
        this.className = className;
        this.eHPMax = eHPMax;
        this.eHP = eHP;
        this.eAtt = eAtt;
        this.eDef = eDef;
        this.eSpd = eSpd;
    }

    private String className;   public String getClassName() { return className; }

    public int eHPMax;
    public int eHP;
    public int eAtt;
    public int eDef;
    public int eSpd;

}
