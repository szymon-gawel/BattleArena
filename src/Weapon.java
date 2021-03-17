public class Weapon extends Stuff {
    private int baseAttack;
    private int bonus;

    public Weapon(String name) {
        super(name);
        this.baseAttack = (int)((Math.random() * 10) + 10);
        this.bonus = (int)((Math.random() * 50));
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getBonus() {
        return bonus;
    }
}
