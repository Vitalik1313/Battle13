public class Defender extends Hero {
    private int HP;
    private int alive;
    private int power;

    Defender(){
        HP = 60;
        alive = 1;
        power=5;
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

    public void ability(int healed) {
        HP+=healed;
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

    public Hero getHero(){
        return this;
    }
}
