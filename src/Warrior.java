public class Warrior extends Avatar {

    public Warrior(String characterName, int health, int capacity) {
        super(characterName, health, capacity);
    }

    @Override
    public int attack() {
        if(getHand() instanceof Weapon){
            int totalDamage = ((Weapon) getHand()).getBaseAttack() + ((Weapon) getHand()).getBonus();
            System.out.println(getCharacterName() + " attacks with " + totalDamage + " damage");
            return ((Weapon) getHand()).getBaseAttack();
        } else if(getHand() instanceof Potion){
            int healthToAdd = ((Potion) getHand()).getHealthAmount();
            System.out.println(getCharacterName() + " were healed by " + healthToAdd + " hp");
            setHealth(healthToAdd);
            return 0;
        } else {
            System.out.println(getCharacterName() + " doesn't have any weapon in hand");
            return 0;
        }
    }
}
