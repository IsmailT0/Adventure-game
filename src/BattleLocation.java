public abstract class BattleLocation extends Location{
    protected Monster monster;
    public BattleLocation(Player player,String name,Monster monster) {
        super(player);
        this.name= name;
        this.monster = monster;
    }

    @Override
    public boolean getLocation() {
        return true;
    }
}

class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Cave");
    } //zombie

}
class Forest extends BattleLocation{
    public Forest(Player player){
        super(player, "Forest");
    } //vampire
}
class River extends BattleLocation{
    public River(Player player){
        super(player,"River");
    } //bear
}