public abstract class Monster {
    protected String name;
    protected int damage,health,award;
    protected int maxNumber;

    public Monster(String name, int damage, int health, int award, int maxNumber) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.award = award;
        this.maxNumber = maxNumber;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getAward() {
        return award;
    }

    public int getMaxNumber() {
        return (int)(Math.random()*maxNumber)+1;
    }
}
class Zombie extends Monster{
    public Zombie() {
        super("Zombie", 3, 10, 4, 3);
    }
}
class Vampire extends Monster{
    public Vampire() {
        super("Vampire", 4, 14, 7, 3);
    }
}
class Bear extends Monster{
    public Bear() {
        super("Bear",7,20,12,3);
    }
}