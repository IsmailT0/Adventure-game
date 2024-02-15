import java.util.Scanner;

public abstract class Location {
    protected Player player;
    protected String name;
    Scanner sc;
    public Location(Player player){
        this.player = player;
        sc = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public abstract boolean getLocation();
}
