public class Monster {
    private int health;
    private int attackPower;
    private int attackChance;

    public Monster(int health, int attackPower, int attackChance) {
        this.health = health;
        this.attackPower = attackPower;
        this.attackChance = attackChance;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public int attack(){
        int attack = (int)(Math.random() * 100);
        if(attack >= attackChance){
            System.out.println("Monster attacks with " + attackPower + " damage");
            return attackPower;
        } else {
            System.out.println("Monster didn't hurt avatar");
            return 0;
        }
    }

    public void hurt(int damage){
        health -= damage;
        System.out.println("Monster health: " + health);
    }

    @Override
    public String toString() {
        return "Monster " +
                "health = " + health +
                ", attackPower = " + attackPower +
                ", attackChance = " + attackChance;
    }
}
