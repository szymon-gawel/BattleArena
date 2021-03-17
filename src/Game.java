import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("\nWelcome to BattleArena \n");
        System.out.println("First of all please name your Hero: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        Avatar hero = new Avatar(name, 100, 50);
        System.out.println("Great! Your hero was created! Here is some info about him: \n");
        System.out.println(hero.toString() + "\n");
        System.out.println("Here are steps that you can make by choosing a number: ");
        showAvailableSteps();
        System.out.println("Now if you know how to play, have fun! \n");
        System.out.println("What do you want to do? ");
        boolean end = false;
        do{
            showAvailableSteps();
            int choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.println(hero.toString());
                    break;
                case 2:
                    hero.showBackpack();
                    break;
                case 3:
                    hero.showBackpack();
                    Stuff equip = hero.chooseHand();
                    if(equip != null) {
                        hero.setHand(equip);
                    } else {
                        System.out.println("This slot is empty");
                    }
                    break;
                case 4:
                    int monsterHealth = (int)((Math.random()*100) + 50);
                    int monsterAttack = (int)((Math.random()*10) + 10);
                    Monster monster = new Monster(monsterHealth, monsterAttack, 60);

                    Arena arena = new Arena(hero, monster);

                    do{
                        arena.fight();
                    }while(!hero.isAlive() || monster.isAlive());
                    break;
                case 5:
                    int lootChance = (int)(Math.random() * 100);
                    if(lootChance < 50){
                        System.out.println("You didn't find anything this time");
                    } else if(lootChance >= 50 && lootChance < 75){
                        System.out.println("You found a potion!");
                        Potion potion = new Potion("Healing Potion");
                        hero.addToBackpack(potion);
                    } else if(lootChance >= 75){
                        System.out.println("You found a sword!");
                        Sword sword = new Sword("LightSword");
                        hero.addToBackpack(sword);
                    }
                    break;
                case 6:
                    end = true;
                    break;
            }
        }while(end != true);
    }

    public static void showAvailableSteps(){
        System.out.println("\n1. Show hero details");
        System.out.println("2. Open backpack");
        System.out.println("3. Choose hand");
        System.out.println("4. Go to fight on arena");
        System.out.println("5. Go to look for items");
        System.out.println("6. Exit game \n");
    }
}
