public class Weapon {
    private String name;
    private int damage,battleCount;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
        this.battleCount = 0;
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
}
