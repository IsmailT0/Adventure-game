public class Player {

    private int rhealth;
    private int id;
    private int damage,health,money;
    private String name;
    //private Inventory inventory;

    public Player(String name){
        this.name = name;
    }

    public void selectCha(){

    }

    public int getRhealth() {
        return rhealth;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
