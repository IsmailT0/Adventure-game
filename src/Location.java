public abstract class Location {
    protected Player player;
    protected String name;

    public Location(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public abstract boolean getLocation();
}
