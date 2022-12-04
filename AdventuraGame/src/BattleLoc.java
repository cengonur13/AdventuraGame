import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Now You are in HERE : "+this.getName());
        System.out.println("Be Careful! " + this.randomObstacleNumber() + " " +this.getObstacle().getName() +" Live HERE...");

        System.out.println("*****  <F> FIGHT or <E> ESCAPE *****");
        String selectCase = scanner.nextLine().toUpperCase();

        if (selectCase.equals("F") && combat(obsNumber)){
            System.out.println("The WAR is Beginning!!");
            System.out.println(this.getPlayer().getName() +" defeated all the MONSTERS!!! Congrats...");
        }
        else {
            return false;
        }
        if (this.getPlayer().getHealth() <= 0 ){
            System.out.println("You DIED " + this.getPlayer().getName() + "!! I am sorry...");
            return false;
        }
        return true;
    }

    public boolean combat(int maxObstacle){
        for (int i = 1; i <= maxObstacle; i++){
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            System.out.println();
            System.out.println();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){

                System.out.print("*****  <F> FIGHT or <E> ESCAPE *****  : -> ");
                String selectCombat = scanner.nextLine().toUpperCase();

                if (selectCombat.equals("F")){
                    System.out.println("YOU Hit Obstacle!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());

                    afterHit();

                    if (this.getObstacle().getHealth() > 0 ){
                        System.out.println();
                        System.out.println("The MONSTER Hit You!");

                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();

                        if( obstacleDamage < 0 )
                            obstacleDamage = 0;

                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);

                        afterHit();

                    }
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You defeated the Monster. ");
                System.out.println("Money Earned : " + this.getObstacle().getAward());
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your CURRENT MONEY : " + this.getPlayer().getMoney());
            }
            else {
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Your Health     : " + this.getPlayer().getHealth());
        System.out.println("Obstacle Health : " + this.getObstacle().getHealth());
        System.out.println("************************************");
    }

    public void playerStats(){
        System.out.println(" -----------------------");
        System.out.println(" **** PLAYER VALUES ****");
        System.out.println(" -----------------------");
        System.out.println("Health   : " + this.getPlayer().getHealth());
        System.out.println("Damage   : " + this.getPlayer().getTotalDamage());
        System.out.println("Weapon   : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor    : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money    : " + this.getPlayer().getMoney());
    }

    public void obstacleStats(int i){
        System.out.println(" -----------------------");
        System.out.println(" **** " + i +". " +this.getObstacle().getName().toUpperCase() + " VALUES ****");
        System.out.println(" -----------------------");
        System.out.println("Health : " + this.getObstacle().getHealth());
        System.out.println("Damage : " + this.getObstacle().getDamage());
        System.out.println("Award  : " + this.getObstacle().getAward());
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }
}
