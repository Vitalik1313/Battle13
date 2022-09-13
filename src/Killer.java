import java.util.Scanner;

public class Killer extends Hero {
    private int HP = 50;
    private int power = 10;
    private int alive = 1;

    public int getPower(){
            return this.power;
    }

    public int getDamage(int damage){
        HP -= damage;
        if(HP <= 0){
            alive = 0;
        }
        return damage;
    }

    public void ability(Player opponent){
        System.out.println("Enter a number of hero to be damaged(1-4):");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int realDamage = 0;
        if(choice == 1 && (opponent.barbarian.isAlive()) == 1){
            realDamage = opponent.barbarian.getDamage((opponent.barbarian.getHP()/2));
            System.out.println(opponent.getName() + " barbarian -" + realDamage + "HP");
        }
        if(choice == 2 && (opponent.healer.isAlive()) == 1){
            realDamage = opponent.healer.getDamage((opponent.healer.getHP()/2));
            System.out.println(opponent.getName() + " healer -" + realDamage + "HP");
        }
        if(choice == 3 && (opponent.killer.isAlive()) == 1){
            realDamage = opponent.killer.getDamage((opponent.killer.getHP()/2));
            System.out.println(opponent.getName() + " killer -" + realDamage + "HP");
        }
        if(choice == 4 && (opponent.defender.isAlive()) == 1){
            realDamage = opponent.defender.getDamage((opponent.defender.getHP()/2));
            System.out.println(opponent.getName() + "defender -" + realDamage + "HP");
        }
    }

    public void getHealed(int heal){
        HP +=heal;
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
}
