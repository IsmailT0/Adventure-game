public class Armor {
    private String name;
    private int protection,battleCount;

    public Armor(String name, int protection) {
        this.name = name;
        this.protection = protection;
        this.battleCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getProtection() {
        return protection;
    }

    public int getBattleCount() {
        return battleCount;
    }

    public void increaseBattleCount(){
        this.battleCount+=1;
    }
}
