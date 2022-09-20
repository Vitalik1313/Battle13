public class Healer extends Hero {
    private int HP;
    private int power;
    private int alive;

    Healer() {
        this.HP = 70;
        this.power=15;
        this.alive=1;
    }

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

    public void ability(Player team, Player opponent){
        team.teamHealed();
        opponent.teamAttacked(10);
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
        return HP;
    }

    public Hero getHero(){
        return this;
    }
}
