package Heroes;

import Player.*;
import Menu_and_File.*;

import java.util.Scanner;

public class Killer extends Hero {
    private int HP = 50;
    private int power = 10;
    private int alive = 1;

    public int getDamage(int damage){
        HP -= damage;
        if(HP <= 0){
            alive = 0;
        }
        return damage;
    }

    public void ability(Player opponent){
        WriteFile file = opponent.getFile();
        String output;
        output = "Enter a number of hero to be damaged(1-4):\n";
        System.out.print(output);

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        output = output.concat(" " + choice + "\n");
        if(file != null && file.checkWriting()) {
            file.appendString(output);
            output = "";
        }

        int realDamage;
        if(choice == 1 && (opponent.getBarbarian().isAlive()) == 1){
            if(opponent.getBarbarian().getHP() == 1){
                realDamage = opponent.getBarbarian().getDamage(1);
            }else {
                realDamage = opponent.getBarbarian().getDamage((opponent.getBarbarian().getHP() / 2));
            }
            output = output.concat(opponent.getName() + " barbarian -" + realDamage + "HP\n");
            System.out.println(opponent.getName() + " barbarian -" + realDamage + "HP");
        }
        if(choice == 2 && (opponent.getHealer().isAlive()) == 1){
            if(opponent.getHealer().getHP() == 1){
                realDamage = opponent.getHealer().getDamage(1);
            }else {
                realDamage = opponent.getHealer().getDamage((opponent.getHealer().getHP() / 2));
            }
            output = output.concat(opponent.getName() + " healer -" + realDamage + "HP\n");
            System.out.println(opponent.getName() + " healer -" + realDamage + "HP");
        }
        if(choice == 3 && (opponent.getKiller().isAlive()) == 1){
            if(opponent.getKiller().getHP() == 1){
                realDamage = opponent.getKiller().getDamage(1);
            }else {
                realDamage = opponent.getKiller().getDamage((opponent.getKiller().getHP() / 2));
            }
            output = output.concat(opponent.getName() + " killer -" + realDamage + "HP\n");
            System.out.println(opponent.getName() + " killer -" + realDamage + "HP");
        }
        if(choice == 4 && (opponent.getDefender().isAlive()) == 1){
            if(opponent.getDefender().getHP() == 1){
                realDamage = opponent.getDefender().getDamage(1);
            }else {
                realDamage = opponent.getDefender().getDamage((opponent.getDefender().getHP() / 2));
            }
            output = output.concat(opponent.getName() + "defender -" + realDamage + "HP\n");
            System.out.println(opponent.getName() + "defender -" + realDamage + "HP");
        }
        if(file != null && file.checkWriting())
            file.appendString(output);
    }

    public int getHealed(int heal){
        HP +=heal;
        return heal;
    }

    public int isAlive(){
        if(alive == 1) {
            return 1;
        }
        return 0;
    }

    public int getHP(){
        return this.HP;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
