public class Potion extends Stuff {
    private int healthAmount;

    public Potion(String name) {
        super(name);
        this.healthAmount = (int)((Math.random() * 10) + 10);
    }

    public int getHealthAmount() {
        return healthAmount;
    }
}
