import java.util.Random;

public class Player {
    private String name;
    private int win;
    Barbarian barbarian;
    Healer healer;
    Killer killer;
    Defender defender;


    Player(String name) {
        this.name = name;
        win = 1;
        barbarian = new Barbarian();
        healer = new Healer();
        killer = new Killer();
        defender = new Defender();
    }

    public void teamAttacked(int damage){
        int max = 3;
        int min = 1;
        int realdamage = 0;

        Random defend = new Random();
        System.out.println("Attack info:");
        if((defend.nextInt((max - min) + 1) + min ) != 2) {
            max = damage;
            min = damage / 2;
            Random random = new Random();
            realdamage = barbarian.getDamage(random.nextInt((max - min) + 1) + min);
            System.out.println(this.name + " barbarian -" + realdamage + "HP.");
            realdamage = healer.getDamage(random.nextInt((max - min) + 1) + min);
            System.out.println(this.name + " healer -" + realdamage + "HP.");
            realdamage = killer.getDamage(random.nextInt((max - min) + 1) + min);
            System.out.println(this.name + " killer -" + realdamage + "HP.");
            realdamage = defender.getDamage(random.nextInt((max - min) + 1) + min);
            System.out.println(this.name + " defender -" + realdamage + "HP.");
        }
        else{
            defender.ability(5);
            System.out.println("\tBlocked!");
        }
    }


    public void teamHealed(){
        int max = healer.getPower();
        int min = (healer.getPower())-5;
        Random random = new Random();
        barbarian.getHealed(random.nextInt((max - min) + 1) + min);
        healer.getHealed(random.nextInt((max - min) + 1) + min);
        killer.getHealed(random.nextInt((max - min) + 1) + min);
        defender.getHealed(random.nextInt((max - min) + 1) + min);
    }

    int isTeamAlive(){
        if(healer.isAlive() == 0 && barbarian.isAlive() == 0 && killer.isAlive() == 0 && defender.isAlive() == 0){
            return 0;
        }
        return 1;
    }

    int checkWin(){
        if(isTeamAlive() == 0){
            win = 0;
            return win;
        }
        else {
            win = 1;
            return win;
        }
    }


    public String getName() {
        return name;
    }
}
