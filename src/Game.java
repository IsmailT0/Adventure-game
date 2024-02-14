import java.util.Scanner;

public class Game {
    private Player player;
    Location location;
    Scanner sc = new Scanner(System.in);

    //Defines the game to the player and asks the player his warrior choose
    public void start(){
        login();
        while (player.getHealth()>0){ //while player alive
            int locChoice= mainMenu(); // lists the places the player can go

            while(locChoice<0 || locChoice>5){
                System.out.println("Wrong entry. Please select a correct place to go.");
                locChoice=sc.nextInt();
            }


            switch (locChoice) {
                // according to the choice of the player we will initialize a new location where
                // player can fight, rest and heal or makes some shopping


                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new Cave(player);
                case 3 -> location = new Forest(player);
                case 4 -> location = new River(player);
                case 5 -> location = new Market(player);
                default -> location = new SafeHouse(player);
            }

            if (!location.getLocation()){//all get location methods will return true
                System.out.println("Game over.");
                break;
            }
        }
    }

    //gets players name and initialize a player with the name and then selects a character
    private void login(){
        System.out.println("---Welcome to Adventure Game---");
        System.out.print("Please enter your name warrior: ");
        player = new Player(sc.next(),sc);
        player.selectCha();
    }

    private int mainMenu(){
        System.out.println("1- Safe House ---> Your health will be renewed");
        System.out.println("2- Cave ----> You may encounter zombies");
        System.out.println("3- Forest ---> You may encounter vampires");
        System.out.println("4- River ---> You may encounter bears");
        System.out.println("5- Market ---> You can buy weapon and armor");
        System.out.print("Where would you like to go:");
        return sc.nextInt();
    }
}
