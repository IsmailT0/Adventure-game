import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class NormalLoc extends Location{

    public NormalLoc(Player player,String name) {
        super(player);
        this.name=name;
    }

    @Override
    public boolean getLocation() {
        return true;
    }
}
class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player,"SAfe House");
    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getRhealth()); // player will be fully recovered
        System.out.println("You cam to the Safe House. You are in safe now.");
        System.out.println("Your wounds have been healed.");
        return true;
    }
}

class Market extends NormalLoc {

    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armors;

    public Market(Player player) {
        super(player, "Market");
        setArmors();
        setWeapons();
    }


    @Override
    public boolean getLocation() {
        int choice = Menu();
        switch (choice){
            case 1 ->{
                sellWeapon();
            }
            case 2 ->{
                sellArmor();
            }
        }
        return true;
    }

    private int Menu(){ //displays the main menu where player selects what to buy
        System.out.println("Welcome to Market " + player.getName());
        System.out.println("Money you have: " +player.getMoney());
        System.out.println("What would you like to buy? ");
        System.out.println("1- Weapons\n2-Armors\n0- To exit");
        int choice = sc.nextInt();
        while (choice<0 || choice>3){
            System.out.println("You enter a wrong decision. Be careful 0, 1 or 2");
            System.out.print("Your answer: ");
            choice= sc.nextInt();
        }
        return choice;
    }

    private void sellArmor(){//deals with the sell of the armor
        System.out.println("Choose your Armor:");
        System.out.println("ID      NAME    Protection   MONEY");
        System.out.println("1-     Light        1          15 ");
        System.out.println("2-     Middle       3          25 ");
        System.out.println("3-     Heavy        5          40 ");
        System.out.println("Please enter 0 to leave.");

        System.out.print("Enter armor id: ");
        int armorId= sc.nextInt();
        if (armorId == 0)
            return;
        while (armorId<0 || armorId>3){
            System.out.print("Please enter a valid armor id: ");
            armorId = sc.nextInt();
        }

        Armor armor =  armors.get(armorId);

        if (player.getMoney()< armor.getCost()){
            System.out.println("your money is not enough please try again");
            sellArmor();
        }else{
            player.setMoney(player.getMoney()-armor.getCost());
            player.getInventory().setArmor(armor);
        }
    }
    private void sellWeapon(){//deals with the sell of the weapons
        System.out.println("Choose your Weapon:");
        System.out.println("ID      NAME    Damage   MONEY");
        System.out.println("1-    Pistol     2       25 ");
        System.out.println("2-    Sword      3       35 ");
        System.out.println("3-    Riffle     7       45 ");

        System.out.print("Enter armor id: ");
        int weaponId= sc.nextInt();
        while (weaponId<0 || weaponId>3){
            System.out.print("Please enter a valid weapon id: ");
            weaponId = sc.nextInt();
        }

        Weapon weapon = weapons.get(weaponId);

        if (player.getMoney() < weapon.getCost()){
            System.out.println("Your money is not enough please try again");
            setWeapons();
        }else{
            player.setMoney(player.getMoney()-weapon.getCost());
            player.getInventory().setWeapon(weapon);
        }
    }

//these helper methods helps to create arraylists of armors and weapons
    private void setArmors(){
        this.armors= new ArrayList<>();
        this.armors.add(new Armor("Light",1,15));
        this.armors.add(new Armor("Middle",3,25));
        this.armors.add(new Armor("Heavy",5,40));
    }
    private void setWeapons(){
        this.weapons= new ArrayList<>();
        this.weapons.add(new Weapon("Pistol", 2,25));
        this.weapons.add(new Weapon("Sword",3,35));
        this.weapons.add(new Weapon("Riffle",7,45));
    }
}