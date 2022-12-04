public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--- Welcome to the Tool Store! ---");
        System.out.println("1- Weaponry");
        System.out.println("2- Armors");
        System.out.println("3- Exit!");
        System.out.print(" Your Choice -> ");

        int selectCase = scanner.nextInt(); // variable from superclass

        while (selectCase < 1 || selectCase > 3){
            System.out.println("WRONG ENTRY! Please Choose one of 1,2 and 3...");
            System.out.print(" Your Choice -> ");
            selectCase = scanner.nextInt();
        }
        switch (selectCase){
            case 1 :
                printWeapon();
                buyWeapon();
                break;
            case 2 :
                printArmor();
                buyArmor();
                break;
            case 3 :
                System.out.println("You re OUT! We are Waiting for You Again...");
                return true;
        }
        return true;
    }

    public void printWeapon(){
        System.out.println(" --- Weapons ---\n***********");
        for (Weapon w : Weapon.weapons()){
            System.out.println("ID : " + w.getId() +" "+ w.getName() + " Money : "+w.getPrice() + " Damage : " + w.getDamage());
        }

    }

    public void printArmor(){
        System.out.println(" --- Armors ---\n***********");
        for (Armor armor : Armor.armors()){
            System.out.println(armor.getId() + " - " + armor.getName() + " <Price : " +armor.getPrice()+" Block Value : " +  armor.getBlock() +" > " );
        }
    }

    public void buyWeapon(){

        System.out.print("Choose a Weapon PLEASE! -> ");
        int selectWeaponID = scanner.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length){
            System.out.println("WRONG ENTRY! Please Choose one of 1,2 and 3...");
            System.out.print(" Your Choice -> ");
            selectWeaponID = scanner.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if ( selectedWeapon != null ){
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("------ You Do Not Have ENOUGH Money... ------");
            }
            // If Budget is ENOUGH...
            else{
                System.out.println("You Bought The "+ selectedWeapon.getName() +" ARMS!");
                int playerMoney = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(playerMoney);
                System.out.println("Your Remaining Money : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);

            }
        }
    }

    public void buyArmor(){
        System.out.print("Choose a Armor PLEASE! -> ");
        int selectArmorID = scanner.nextInt();
        while (selectArmorID < 1 || selectArmorID > Armor.armors().length){
            System.out.println("WRONG ENTRY! Please Choose one of 1,2 and 3...");
            System.out.print(" Your Choice -> ");
            selectArmorID = scanner.nextInt();
        }

        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

        if (selectedArmor != null ){
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("------ You Do Not Have ENOUGH Money... ------");
            }else {
                System.out.println("You Bought The " + selectedArmor.getName() + " ARMOR!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Your Remaining Money : " + this.getPlayer().getMoney());
            }
        }
    }
}
