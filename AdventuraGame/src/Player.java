import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int defHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;

    private Scanner scanner = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){

        /*  GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        *
        * */

        System.out.println("------------------------------------------");
        System.out.println("             Damage      Health      Money");
        System.out.println("             ------      ------      -----");
        System.out.println("1-Samurai     5           21          15");
        System.out.println("2-Archer      7           18          20");
        System.out.println("3-Knight      8           24          5");
        System.out.println("------------------------------------------");
        System.out.print(" Your Choice ->  ");
        int charNumber = scanner.nextInt();

        while(charNumber!=1 && charNumber!=2 && charNumber!=3 ){
            System.out.println("WRONG ENTRY! Please Choose one of 1,2 and 3...");
            System.out.print(" Your Choice ->  ");
            charNumber = scanner.nextInt();
            if(charNumber==1 || charNumber==2 || charNumber==3)
                break;
        }
        switch (charNumber){
            case 1 : this.damage = 5;
                     this.health = 21;
                     this.defHealth = 21;
                     this.money = 15;
                     this.charName = "Samurai";
                     break;

            case 2 : this.damage = 7;
                     this.health = 18;
                     this.defHealth = 18;
                     this.money = 20;
                     this.charName = "Archer";
                     break;

            case 3 : this.damage = 8;
                     this.health = 24;
                     this.defHealth = 24;
                     this.money = 5;
                     this.charName = "Knight";
                     break;
        }
        System.out.println("------------------------------------------");
        System.out.println("You Have Selected the Caracter : " + this.charName);
        System.out.println("Your Damage : "+this.damage + "  Your Health : "+this.health + "  Your Money : "+this.money);
        System.out.println("------------------------------------------");
    }


    public void printInfo(){
        System.out.println("------------------------------------------");
        System.out.println("Your Weapon : "+this.getInventory().getWeapon().getName()+
                           " \nYour Damage : "+this.getTotalDamage() + "  " +
                           " \nYour Health : "+this.health + "  " +
                           " \nYour Money  : "+this.money +
                           " \nYour Armor  : "+this.inventory.getArmor().getName()+
                           " \nYour Block  : "+this.inventory.getArmor().getBlock());
        System.out.println("------------------------------------------");
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
