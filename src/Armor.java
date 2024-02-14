public class Armor {
    private String name;
    private int protection,battleCount,cost;

    public Armor(String name, int protection,int cost) {
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

    public int getCost() {
        return cost;
    }
}
