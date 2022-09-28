package Player;

import Heroes.*;
import Menu_and_File.*;
import java.util.Random;


public class Player {
    private final String name;
    private int win;
    private int fightType;
    private final Barbarian barbarian;
    private final Healer healer;
    private final Killer killer;
    private final Defender defender;
    WriteFile file;


    public Player(String name) {
        this.name = name;
        win = 1;
        fightType = 0;
        barbarian = new Barbarian();
        healer = new Healer();
        killer = new Killer();
        defender = new Defender();
        file = null;
    }


    public void teamAttacked(int damage){
        int max = 3;
        int min = 1;
        int realdamage;
        String output;
        output = "Attack info:\n";
        if((int)(Math.random() * max + min) != 1) {
            max = damage;
            min = damage / 2;
            Random random = new Random();

            if(barbarian.isAlive()==1) {
                realdamage = barbarian.getDamage(random.nextInt((max - min) + 1) + min);
                output = output.concat(this.name + " barbarian -" + realdamage + "HP.\n");
            }
            else
                output = output.concat("Heroes.Barbarian is dead\n");

            if(healer.isAlive() == 1) {
                realdamage = healer.getDamage(random.nextInt((max - min) + 1) + min);
                output = output.concat(this.name + " healer -" + realdamage + "HP.\n");
            }
            else
                output = output.concat("Heroes.Healer is dead\n");

            if(killer.isAlive() == 1) {
                realdamage = killer.getDamage(random.nextInt((max - min) + 1) + min);
                output = output.concat(this.name + " killer -" + realdamage + "HP.\n");
            }
            else
                output = output.concat("Heroes.Killer is dead\n");

            if(defender.isAlive() == 1) {
                realdamage = defender.getDamage(random.nextInt((max - min) + 1) + min);
                output = output.concat(this.name + " defender -" + realdamage + "HP.\n");
            }
            else
                output = output.concat("Heroes.Defender is dead\n");
            System.out.println(output);
        }
        else{
            defender.ability(5);
            output = output.concat("\tBlocked!\n");
            System.out.println(output);
        }
        if(file !=null && file.checkWriting()){
            file.appendString(output);
        }
    }


    public void teamHealed(){
        int max = healer.getPower();
        int min = (healer.getPower())-5;
        Random random = new Random();
        int heal;
        String output;
        heal = barbarian.getHealed(random.nextInt((max - min) + 1) + min);
        output = this.name + " barbarian +" + heal + "HP.\n";
        heal = healer.getHealed(random.nextInt((max - min) + 1) + min);
        output = output.concat(this.name + " healer +" + heal + "HP.\n");
        heal = killer.getHealed(random.nextInt((max - min) + 1) + min);
        output = output.concat(this.name + " killer +" + heal + "HP.\n");
        heal = defender.getHealed(random.nextInt((max - min) + 1) + min);
        output = output.concat(this.name + " defender +" + heal + "HP.\n");

        System.out.println(output);
        if(file != null && file.checkWriting())
            file.appendString(output);
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

    public int checkWin(){
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

    public String barbarianGetAttacked(int damage, Player player,String output){
        int max = 5;
        int min = 1;
        int realDamage;

        Random defend = new Random();

        output = output.concat(player.getName() + " attack info:\n");
        System.out.println(player.getName() + " attack info:");

        if((defend.nextInt((max - min) + 1) + min ) != 2) {
            max = damage;
            min = damage / 2;
            Random random = new Random();
            realDamage = barbarian.getDamage(random.nextInt((max - min) + 1) + min);
            output = output.concat(this.name + " barbarian -" + realDamage + "HP.\n");
            System.out.println(this.name + " barbarian -" + realDamage + "HP.");
        }
        else{
            output = output.concat("|||Blocked!|||\n");
            System.out.println("|||Blocked!|||");
            player.barbarian.setPower(player.barbarian.getPower() + 5);
        }
        System.out.println();
        return output;
    }

    public void setFile(WriteFile file) {
        this.file = file;
    }

    public void setFightType(int type){
        fightType = type;
    }

    public WriteFile getFile() {
        return file;
    }

    public Barbarian getBarbarian() {
        return barbarian;
    }

    public Healer getHealer() {
        return healer;
    }

    public Killer getKiller() {
        return killer;
    }

    public Defender getDefender() {
        return defender;
    }
}
