import java.util.ArrayList;
import java.util.Scanner;

public class Avatar {
    private String characterName;
    private int health;
    private Stuff hand;
    private int capacity;
    private Stuff[] backpack;

    public Avatar(String characterName, int health, int capacity) {
        this.characterName = characterName;
        this.health = health;
        this.hand = null;
        this.capacity = capacity;
        this.backpack = new Stuff[10];
    }

    public String getCharacterName() {
        return characterName;
    }

    public int getHealth() {
        return health;
    }

    public Stuff getHand() {
        return hand;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setHand(Stuff hand) {
        this.hand = hand;
    }

    public boolean isAlive(){
        if(health > 0){
            return true;
        } else {
            return false;
        }
    }

    public void addToBackpack(Stuff item){
        int totalWeight = 0;
        for (int i = 0; i < backpack.length; i++) {
            if(backpack[i] == null){
                totalWeight += 0;
            } else {
                totalWeight += backpack[i].getWeight();
            }
        }

        if(totalWeight + item.getWeight() < capacity){
            for (int i = 0; i < backpack.length; i++) {
                if(backpack[i] == null){
                    backpack[i] = item;
                    System.out.println(item.getName() + " was added to backpack");
                    break;
                }
                if (i == 19){
                    System.out.println("Your backpack is full");
                }
            }
        } else {
            System.out.println("This item is too heavy, you can't take it");
        }
    }

    public int attack(){
        if(hand instanceof Weapon){
            System.out.println(characterName + " attacks with " + ((Weapon) hand).getBaseAttack() + " damage");
            return ((Weapon) hand).getBaseAttack();
        } else if(getHand() instanceof Potion){
            int healthToAdd = ((Potion) getHand()).getHealthAmount();
            System.out.println(getCharacterName() + " were healed by " + healthToAdd + " hp");
            setHealth(healthToAdd);
            return 0;
        } else {
            System.out.println(characterName + " doesn't have any weapon in hand");
            return 0;
        }
    }

    public void showBackpack(){
        for (int i = 0; i < backpack.length; i++) {
            if(backpack[i] == null){
                System.out.println((i+1) + ". " + "Empty slot");
            } else {
                System.out.println((i+1) + ". " + backpack[i].getName());
            }
        }
    }

    public Stuff chooseHand(){
        System.out.println("Choose item: ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        Stuff hand = backpack[choice-1];
        return hand;
    }

    public void hurt(int damage){
        health -= damage;
        System.out.println(characterName + " health: " + health);
    }

    @Override
    public String toString() {
        return "Avatar's " +
                "name = " + characterName +
                ", health = " + health +
                ", hand = " + hand;
    }
}
