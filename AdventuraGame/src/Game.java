import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("-------------------------------------");
        System.out.println("***** Welcome to Adventura Game *****");
        System.out.println("-------------------------------------");
        System.out.println("Please Enter the name :");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome to GAME " + player.getName() +"!");
        System.out.println("-------------------------------------");
        System.out.println("Please Select the Character : ");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("** Locations ** :\n---------------\n");
            System.out.println("1- Safe House");
            System.out.println("2- Tool Store -> You Can Buy Weapons or Armor");
            System.out.println("3- Cave       -> Enter the CAVE   - <PRIZE:MEAL>  BE CAREFUL... Zombies Live Here!!");
            System.out.println("4- Forest     -> Enter the FOREST - <PRIZE:WOOD>  Try Not To DIE, There's a VAMPIRE Here!!");
            System.out.println("5- River      -> Enter the RIVER  - <PRIZE:WATER> Drowning in the River, You May Encounter BEARS!!");
            System.out.println("0- Exit the GAME!");
            System.out.println("Please Select the Location You Want to Go!");
            System.out.print("Your Choice -> ");

            int select = input.nextInt();
            switch (select){
                case 0 :
                    location = null;
                    break;
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2 :
                    location = new ToolStore(player);
                    break;
                case 3 :
                    location = new Cave(player);
                    break;
                case 4 :
                    location = new Forest(player);
                    break;
                case 5 :
                    location = new River(player);
                    break;
                default:
                    System.out.println("Please Select a VALID LOCATION...");
            }

            if (location == null){
                System.out.println("Game Over...");
                break;
            }
            if(!location.onLocation()){
                System.out.println("You are DEAD... GAME OVER!");
                break;
            }
        }
    }
}
