import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t\tGame heroes:");
        System.out.println("\t1)Barbarian - hit all team");
        System.out.println("\t2)Healer - healing your team");
        System.out.println("\t3)Killer - hit one hero by 50% of his current HP");
        System.out.println("\t4)Defender - gives your team shield\n\n");


        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a type of fight: (1) - 1 vs 1; (2) - 4 vs 4");
        int choice = sc.nextInt();

        if(choice == 1){
            Player team = new Player("Player",1);
            Player opponent = new Player("Opponent",1);
            Battle battle = new Battle(team, opponent);
            battle.startFight1vs1();
        }
        else {
            Player team = new Player("Player",2);
            Player opponent = new Player("Opponent",2);
            Battle battle = new Battle(team, opponent);
            battle.startFight4vs4();
        }
    }
}