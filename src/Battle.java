import java.util.Scanner;

import java.io.*;

public class Battle {
    private Player [] players = new Player[2];

    Battle(Player pl1, Player pl2){
        players[0] = pl1;
        players[1] = pl2;
    }

    void startFight1vs1(){
        int i = 1;
        while(players[0].checkWin() == 1 && players[1].checkWin() == 1){
            System.out.println("Action: " + i++ + "\n---------------------------");
            this.printBarbarianInfo();
            this.fight1vs1();
            System.out.println("---------------------------");
            
        }
        printWinner();
    }

    void printBarbarianInfo(){
        for(int i = 0; i < players.length;i++){
            System.out.println("Barbarian HP - " + players[i].barbarian.getHP());
        }
        System.out.print("\n");
    }

    void startFight4vs4(){
        while(players[0].checkWin() == 1 && players[1].checkWin() == 1){
            this.printTeamInfo();
            this.fight4vs4();
        }
        printWinner();
    }

    void printTeamInfo(){
        for(int i = 0; i<players.length;i++) {
            System.out.println("---------------------------------------------- ");
            System.out.println("Team - " + players[i].getName() + ":");
            if (players[i].barbarian.isAlive() == 0) {
                System.out.println("The Barbarian is dead");
            } else {
                System.out.println("Barbarian HP: " + players[i].barbarian.getHP());
            }
            if (players[i].healer.isAlive() == 0) {
                System.out.println("The Healer is dead");
            } else {
                System.out.println("Healer HP: " + players[i].healer.getHP());
            }
            if (players[i].killer.isAlive() == 0) {
                System.out.println("The Killer is dead");
            } else {
                System.out.println("Killer HP: " + players[i].killer.getHP());
            }
            if (players[i].defender.isAlive() == 0) {
                System.out.println("The Defender is dead");
            } else {
                System.out.println("Defender HP: " + players[i].defender.getHP());
            }
        }
    }

    void fight4vs4(){
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        for(int i = 0;i < players.length;i++){
            System.out.println("\n" + players[i].getName() + " choose the hero(1-3):");
            choose = sc.nextInt();
            if(i == 0) {
                switch (choose) {
                    case (1):
                        if(players[i].barbarian.isAlive() == 1) {
                            players[i].barbarian.ability(players[i + 1]);
                            break;
                        }
                        choose = 2;
                    case (2):
                        if(players[i].healer.isAlive() == 1) {
                            players[i].healer.ability(players[i],players[i+1]);
                            break;
                        }
                        choose = 3;
                    case (3):
                        if(players[i].killer.isAlive() == 1) {
                            players[i].killer.ability(players[i + 1]);
                            break;
                        }
                    default:
                        System.out.println("You lose!!!");
                        break;
                }
            }
            else{
                switch (choose) {
                    case (1):
                        if(players[i].barbarian.isAlive() == 1) {
                            players[i].barbarian.ability(players[i - 1]);
                            break;
                        }
                        choose = 2;
                    case (2):
                        if(players[i].healer.isAlive() == 1) {
                            players[i].healer.ability(players[i],players[i-1]);
                            break;
                        }
                        choose = 3;
                    case (3):
                        if(players[i].killer.isAlive() == 1) {
                            players[i].killer.ability(players[i - 1]);
                            break;
                        }
                    default:
                        System.out.println("You lose!!!");
                        break;
                }
            }
        }
    }

    void fight1vs1(){
        for(int i = 0;i < players.length;i++){
            players[i].barbarianGetAttacked(players[i].barbarian.getPower());
        }
    }

    void printWinner(){
        System.out.println("\t-------------------------");
        System.out.println("\t|\t\t\t\t\t\t|");
        System.out.println("\t|\t\t\t\t\t\t|");
        if(players[0].checkWin() == 1){
            System.out.println("\t|\t\t" + players[0].getName() + " WIN" + "\t\t|");
        }
        else{
            System.out.println("\t|\t\t" + players[1].getName() + " WIN" + "\t|\t");
        }
        System.out.println("\t|\t\t\t\t\t\t|");
        System.out.println("\t|\t\t\t\t\t\t|");
        System.out.println("\t-------------------------");
    }
}
