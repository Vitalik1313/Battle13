
import java.io.IOException;
import java.util.Random;


public class Player {
    private final String name;
    private int win;
    private int fightType;
    Barbarian barbarian;
    Healer healer;
    Killer killer;
    Defender defender;
    WriteFile file;


    Player(String name) {
        this.name = name;
        win = 1;
        fightType = 0;
        barbarian = new Barbarian();
        healer = new Healer();
        killer = new Killer();
        defender = new Defender();
        file = null;
        try {
            file = new WriteFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void teamAttacked(int damage){
        int max = 3;
        int min = 1;
        int realdamage;
        String output;
        Random defend = new Random();
        output = "Attack info:\n";
        if((defend.nextInt((max - min) + 1) + min ) != 2) {
            max = damage;
            min = damage / 2;
            Random random = new Random();

            if(barbarian.isAlive()==1) {
                realdamage = barbarian.getDamage(random.nextInt((max - min) + 1) + min);
                output = output.concat(this.name + " barbarian -" + realdamage + "HP.\n");
            }
            else
                output = output.concat("Barbarian is dead\n");

            if(healer.isAlive() == 1) {
                realdamage = healer.getDamage(random.nextInt((max - min) + 1) + min);
                output = output.concat(this.name + " healer -" + realdamage + "HP.\n");
            }
            else
                output = output.concat("Healer is dead\n");

            if(killer.isAlive() == 1) {
                realdamage = killer.getDamage(random.nextInt((max - min) + 1) + min);
                output = output.concat(this.name + " killer -" + realdamage + "HP.\n");
            }
            else
                output = output.concat("Killer is dead\n");

            if(defender.isAlive() == 1) {
                realdamage = defender.getDamage(random.nextInt((max - min) + 1) + min);
                output = output.concat(this.name + " defender -" + realdamage + "HP.\n");
            }
            else
                output = output.concat("Defender is dead\n");

            System.out.println(output);
        }
        else{
            defender.ability(5);
            output = output.concat("\tBlocked!\n");
            System.out.println(output);
        }
        if(file.checkWriting()){
            file.appendString(output);
        }
    }


    public void teamHealed(){
        int max = healer.getPower();
        int min = (healer.getPower())-5;
        Random random = new Random();
        int heal;
        heal = barbarian.getHealed(random.nextInt((max - min) + 1) + min);
        System.out.println(this.name + " barbarian +" + heal + "HP.");
        heal = healer.getHealed(random.nextInt((max - min) + 1) + min);
        System.out.println(this.name + " healer +" + heal + "HP.");
        heal = killer.getHealed(random.nextInt((max - min) + 1) + min);
        System.out.println(this.name + " killer +" + heal + "HP.");
        heal = defender.getHealed(random.nextInt((max - min) + 1) + min);
        System.out.println(this.name + " defender +" + heal + "HP.");
    }

    int isTeamAlive(){
        if(fightType == 1){
            if(barbarian.isAlive() == 0){
                return 0;
            }
        }
        else {
            if (healer.isAlive() == 0 && barbarian.isAlive() == 0 && killer.isAlive() == 0 && defender.isAlive() == 0) {
                return 0;
            }
        }
        return 1;
    }

    int checkWin(){
        if(isTeamAlive() == 0){
            win = 0;
        }
        else {
            win = 1;
        }
        return win;
    }

    public String getName() {
        return name;
    }

    public void barbarianGetAttacked(int damage, Player player){
        int max = 5;
        int min = 1;
        int realDamage;

        Random defend = new Random();
        System.out.println(player.getName() + " attack info:");

        if((defend.nextInt((max - min) + 1) + min ) != 2) {
            max = damage;
            min = damage / 2;
            Random random = new Random();
            realDamage = barbarian.getDamage(random.nextInt((max - min) + 1) + min);
            System.out.println(this.name + " barbarian -" + realDamage + "HP.\n");
        }
        else{
            System.out.println("|||Blocked!|||");
            player.barbarian.setPower(player.barbarian.getPower() + 5);
        }
    }

    public void setFile(WriteFile file) {
        this.file = file;
    }

    public void setFightType(int type){
        fightType = type;
    }
}
