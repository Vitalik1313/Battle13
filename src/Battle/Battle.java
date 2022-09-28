package Battle;

import Menu_and_File.*;
import Player.Player;


import java.io.IOException;
import java.util.Scanner;

public class Battle {
    private final Player[] players = new Player[2];
    private WriteFile file;
    private Boolean writeToFile = false;

    public Battle(Player pl1, Player pl2 ){
        players[0] = pl1;
        players[1] = pl2;
    }

    public void setFile(){
        try {
            file = new WriteFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    public void startFight1vs1(){
        int i = 1;
        String output = "";
        while(players[0].checkWin() == 1 && players[1].checkWin() == 1){
            output = output.concat("Action: " + i + "\n---------------------------\n");
            System.out.println("Action: " + i++ + "\n---------------------------");
            output = this.printBarbarianInfo(output);
            output = this.fight1vs1(output);
            output = output.concat("---------------------------\n");
            System.out.println("---------------------------");
            /*try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }*/
        }
        if(this.checkWriting())
            file.appendString(output);
        printWinner();
    }

    String printBarbarianInfo(String output){
        for (Player player : players) {
            output = output.concat(player.getName() + " Heroes.Barbarian HP - " + player.getBarbarian().getHP()+"\n");
            System.out.println(player.getName() + " Heroes.Barbarian HP - " + player.getBarbarian().getHP());
        }
        System.out.println();
        output = output.concat("\n");
        return output;
    }

    public void startFight4vs4(){
        while(players[0].checkWin() == 1 && players[1].checkWin() == 1){
            this.printTeamInfo();
            this.fight4vs4();
        }
        printWinner();
    }

    void printTeamInfo(){
        String output = "";
        for (Player player : players) {
            System.out.println("---------------------------------------------- ");
            System.out.println("Team - " + player.getName() + ":");
            output = output.concat("----------------------------------------------\n" +
                    "Team - " + player.getName() + ":\n");

            if (player.getBarbarian().isAlive() == 0) {
                output = output.concat("The Heroes.Barbarian is dead\n");
            } else {
                output = output.concat("Heroes.Barbarian HP: " + player.getBarbarian().getHP() + "\n");
            }
            if (player.getHealer().isAlive() == 0) {
                output = output.concat("The Heroes.Healer is dead\n");
            } else {
                output = output.concat("Heroes.Healer HP: " + player.getHealer().getHP() + "\n");
            }
            if (player.getKiller().isAlive() == 0) {
                output = output.concat("The Heroes.Killer is dead\n");
            } else {
                output = output.concat("Heroes.Killer HP: " + player.getKiller().getHP() + "\n");
            }
            if (player.getDefender().isAlive() == 0) {
                output = output.concat("The Heroes.Defender is dead\n");
            } else {
                output = output.concat("Heroes.Defender HP: " + player.getDefender().getHP() + "\n");
            }
        }
        output = output.concat("----------------------------------------------\n");
        System.out.println(output);
        if(this.checkWriting())
            file.appendString(output);
    }

    void fight4vs4(){
        Scanner sc = new Scanner(System.in);
        String output;
        int choose;
        for(int i = 0;i < players.length;i++){
            output = "\n" + players[i].getName() + " choose the hero(1-3):\n";
            System.out.print(output);
            choose = sc.nextInt();
            output = output.concat(" " + choose + "\n");
            if(this.checkWriting())
                file.appendString(output);
            output = "";
            if(i == 0) {
                switch (choose) {
                    case (1):
                        if(players[i].getBarbarian().isAlive() == 1) {
                            players[i].getBarbarian().ability(players[i + 1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    case (2):
                        if(players[i].getHealer().isAlive() == 1) {
                            players[i].getHealer().ability(players[i],players[i+1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    case (3):
                        if(players[i].getKiller().isAlive() == 1) {
                            players[i].getKiller().ability(players[i + 1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    default:
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                }
            }
            else{
                switch (choose) {
                    case (1):
                        if(players[i].getBarbarian().isAlive() == 1) {
                            players[i].getBarbarian().ability(players[i - 1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    case (2):
                        if(players[i].getHealer().isAlive() == 1) {
                            players[i].getHealer().ability(players[i],players[i-1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    case (3):
                        if(players[i].getKiller().isAlive() == 1) {
                            players[i].getKiller().ability(players[i - 1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    default:
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                }
            }
            if(file.checkWriting())
                file.appendString(output);
        }
    }

    String fight1vs1(String output){
        for(int i = 0;i < players.length;i++){
            if(i == 0){
                output = players[i+1].barbarianGetAttacked(players[i].getBarbarian().getPower(), players[i],output);
            }
            else {
                output = players[i-1].barbarianGetAttacked(players[i].getBarbarian().getPower(),players[i],output);
            }
        }
        return output;
    }

    void printWinner(){
        String output = """
                \t--------------------------
                \t|\t\t\t\t\t\t |
                \t|\t\t\t\t\t\t |
                """;

        if(players[0].checkWin() == 1){
            output = output.concat("\t|\t\t" + players[0].getName() + " WIN" + "\t\t |\t\n");
           // System.out.println("\t|\t\t" + players[0].getName() + " WIN" + "\t\t |\t");
        }
        else{
            output = output.concat("\t|\t\t" + players[1].getName() + " WIN" + "\t |\t\n");
            //System.out.println("\t|\t\t" + players[1].getName() + " WIN" + "\t |\t");
        }
        output = output.concat("""
                \t|\t\t\t\t\t\t |
                \t|\t\t\t\t\t\t |
                \t--------------------------""");

        System.out.println(output);

        if(this.checkWriting()){
            file.appendString(output);
            file.writeToFile();
        }
    }

    public WriteFile getFile(){
        file.setSaveFile();
        return file;
    }

    public void setWriteToFile(){
        writeToFile = true;
    }

    boolean checkWriting(){
        return writeToFile;
    }
}
