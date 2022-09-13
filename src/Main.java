import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t\tGame heroes:");
        System.out.println("\t1)Barbarian - hit all team");
        System.out.println("\t2)Healer - healing your team");
        System.out.println("\t3)Killer - hit one hero by 50% of his current HP");
        System.out.println("\t4)Defender - gives your team shield\n\n");

        Player team= new Player("Player");
        Player opponent = new Player("Opponent");

        Battle battle = new Battle(team,opponent);
        battle.startFight();
    }
}