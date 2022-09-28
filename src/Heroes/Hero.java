package Heroes;

public abstract class Hero {
    abstract int getDamage(int damage);
    abstract int getHealed(int heal);
    abstract int isAlive();
    abstract int getHP();
    abstract void setPower(int newDamage);
}
