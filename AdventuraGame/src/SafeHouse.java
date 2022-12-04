public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You're in the Safe House! Your Health is FULL... :)");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth());
        return true;
    }

}
