public class Barbarian extends Hero{
    private int HP;
    private int power;
    int alive;

    Barbarian() {
        HP = 100;
        power = 20;
        alive = 1;
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

    public void ability(Player opponent){
        opponent.teamAttacked(power);
    }

    public int getHealed(int heal){
        HP +=heal;
        return  heal;
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





