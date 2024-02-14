public abstract class BattleLocation extends Location{
    protected Monster monster;
    public BattleLocation(Player player,String name,Monster monster) {
        super(player);
        this.name= name;
        this.monster = monster;
    }

    @Override
    public boolean getLocation() {
        int mCount = monster.getMaxNumber();
        System.out.println();
        System.out.println("Now you are in " + this.getName());
        System.out.println("Be careful.  you may encounter " + mCount+" "+ monster.getName());
        System.out.println("Will you <R>un or <F>ight");
        char choice = sc.next().toUpperCase().charAt(0);
        if (choice == 'F'){
            printStats();
            return combat(monster.getCount());
        }
        return true;
    }

    private boolean combat(int monsterCount){
        int killCount =0;
        while (monsterCount>0){
            int rhealth= monster.getHealth();
            while(player.getHealth()>=0 && monster.getHealth()>0){
                player.setHealth(player.getHealth() - monster.getDamage());
                monster.setHealth(monster.getHealth() - player.getDamage());
            }
            if (player.getHealth()<= 0){
                System.out.println("You died.");
                return false;
            }else{
                player.setMoney(player.getMoney()+ monster.getAward());
                System.out.printf("You killed %d %s\n",++killCount,monster.getName());
                System.out.println("Your current status are :\nDamage: " +player.getDamage()+
                        "\nHealth: "+ player.getHealth());
                System.out.println("Will you <R>un or <F>ight");
                char choice = sc.next().toUpperCase().charAt(0);
                if (choice=='R')
                    break;
                monsterCount -=1;
            }
            monster.setHealth(rhealth);

        }
        return true;
    }

    private void printStats(){
        System.out.println("Player's statuses are :\nDamage: " +player.getDamage()+ "\nHealth: "+ player.getHealth());
        System.out.println("Monster's statuses are :\nDamage: " +monster.getDamage()+ "\nHealth: "+ monster.getHealth()
                +"\n Reward: " +monster.getAward());
    }
}

class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Cave",new Zombie());
    } //zombie

}
class Forest extends BattleLocation{
    public Forest(Player player){
        super(player, "Forest",new Vampire());
    } //vampire
}
class River extends BattleLocation{
    public River(Player player){
        super(player,"River",new Bear());
    } //bear
}