public class Arena {
    private Avatar avatar;
    private Monster monster;

    public Arena(Avatar avatar, Monster monster) {
        this.avatar = avatar;
        this.monster = monster;
    }

    public void fight(){
        System.out.println("Avatars health: " + avatar.getHealth() + ", Monsters health: " + monster.getHealth() + "\n");

        int avatarAttack = avatar.attack();
        monster.hurt(avatarAttack);
        if(monster.isAlive()){
            int monsterAttack = monster.attack();
            avatar.hurt(monsterAttack);
        }
    }
}
