public class Weapon {
    private String name;
    private int damage,battleCount,cost;

    public Weapon(String name, int damage,int cost) {
        this.name = name;
        this.damage = damage;
        this.battleCount = 0;
        this.cost= cost;
    }
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
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
