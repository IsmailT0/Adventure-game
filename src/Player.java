import java.util.Scanner;

public class Player {

    private int rhealth;
    private int damage,health,money;
    private String name;
    private Inventory inventory;
    private Scanner sc ;

    public Player(String name, Scanner sc){
        this.name = name;
        this.sc = sc;
        this.inventory = new Inventory();
    }



    //initialize the player according to the players choice
    public void selectCha(){
        byte id = chaMenu();

        switch (id){
            case 1 -> initPlayer("Samurai",5,21,15);
            case 2 -> initPlayer("Archer",7,18,20);
            case 3 -> initPlayer("Knight",8,24,5);
        }

        System.out.println("Now you are ready to fight.");

    }

    //lists the available characters to the player, so they can select this is a helper method for selectCha method
    private byte chaMenu(){

        System.out.println("In this game you can choose three different warrior.");
        System.out.println("ID   NAME    DAMAGE     HEALTH   MONEY");
        System.out.println("1-  Samurai    5          21       15 ");
        System.out.println("2-  Archer     7          18       20 ");
        System.out.println("3-  Knight     8          24        5 ");

        System.out.print("Please enter the id of your warrior: ");
        byte id= sc.nextByte();

        while(id<0 || id>3){ // checking if the player enter a valid id or not
            System.out.print("Please enter a valid id: ");
            id = sc.nextByte();
        }

        return id;
    }

    //helper method for selectCha
    private void initPlayer(String name, int damage, int health, int money){
        setName(name+ " " + this.name);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setRhealth(health);
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

    public void setRhealth(int rhealth) {
        this.rhealth = rhealth;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    @Override
    public String toString(){
        return getName()+ " "+getDamage()+" "+getHealth()+" "+getMoney();
    }

}
