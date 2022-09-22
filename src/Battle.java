import java.io.IOException;
import java.util.Scanner;

public class Battle {
    private final Player [] players = new Player[2];
    private WriteFile file;

    Battle(Player pl1, Player pl2){
        try {
        file = new WriteFile();
        } catch(IOException exception){
            exception.printStackTrace();
        }
        players[0] = pl1;
        players[1] = pl2;
    }

    void startFight1vs1(){
        int i = 1;
        String output = "";
        while(players[0].checkWin() == 1 && players[1].checkWin() == 1){
            output = output.concat("Action: " + i++ + "\n---------------------------\n");
            System.out.println(output);
            this.printBarbarianInfo();
            this.fight1vs1();
            output = output.concat("---------------------------\n");
            System.out.println(output);
            /*try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }*/
            if(file.checkWriting())
                file.appendString(output);
        }
        printWinner();
    }

    void printBarbarianInfo(){
        String output = "";
        for (Player player : players) {
            output = output.concat(player.getName() + " Barbarian HP - " + player.barbarian.getHP()+"\n");
            System.out.println(output);
        }
        output = output.concat("\n");
        if(file.checkWriting())
            file.appendString(output);
    }

    void startFight4vs4(){
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

            if (player.barbarian.isAlive() == 0) {
                output = output.concat("The Barbarian is dead\n");
            } else {
                output = output.concat("Barbarian HP: " + player.barbarian.getHP() + "\n");
            }
            if (player.healer.isAlive() == 0) {
                output = output.concat("The Healer is dead\n");
            } else {
                output = output.concat("Healer HP: " + player.healer.getHP() + "\n");
            }
            if (player.killer.isAlive() == 0) {
                output = output.concat("The Killer is dead\n");
            } else {
                output = output.concat("Killer HP: " + player.killer.getHP() + "\n");
            }
            if (player.defender.isAlive() == 0) {
                output = output.concat("The Defender is dead\n");
            } else {
                output = output.concat("Defender HP: " + player.defender.getHP() + "\n");
            }
        }
        output = output.concat("----------------------------------------------\n");
        System.out.println(output);
        if(file.checkWriting())
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
            if(file.checkWriting())
                file.appendString(output);
            if(i == 0) {
                switch (choose) {
                    case (1):
                        if(players[i].barbarian.isAlive() == 1) {
                            players[i].barbarian.ability(players[i + 1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    case (2):
                        if(players[i].healer.isAlive() == 1) {
                            players[i].healer.ability(players[i],players[i+1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    case (3):
                        if(players[i].killer.isAlive() == 1) {
                            players[i].killer.ability(players[i + 1]);
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
                        if(players[i].barbarian.isAlive() == 1) {
                            players[i].barbarian.ability(players[i - 1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    case (2):
                        if(players[i].healer.isAlive() == 1) {
                            players[i].healer.ability(players[i],players[i-1]);
                            break;
                        }
                        output = output.concat("Wrong move!!!\n");
                        System.out.println("Wrong move!!!");
                        break;
                    case (3):
                        if(players[i].killer.isAlive() == 1) {
                            players[i].killer.ability(players[i - 1]);
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

        }
    }

    void fight1vs1(){
        for(int i = 0;i < players.length;i++){
            if(i == 0){
                players[i+1].barbarianGetAttacked(players[i].barbarian.getPower(), players[i]);
            }
            else {
                players[i-1].barbarianGetAttacked(players[i].barbarian.getPower(),players[i]);
            }
        }
    }

    void printWinner(){
        String output = """
                \t--------------------------
                \t|\t\t\t\t\t\t |
                \t|\t\t\t\t\t\t |
                """;
        /*System.out.println("\t--------------------------");
        System.out.println("\t|\t\t\t\t\t\t |");
        System.out.println("\t|\t\t\t\t\t\t |");*/


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

        if(file.checkWriting()){
            file.appendString(output);
            file.writeToFile();
        }
        /*System.out.println("\t|\t\t\t\t\t\t |");
        System.out.println("\t|\t\t\t\t\t\t |");
        System.out.println("\t--------------------------");*/
    }

    public WriteFile getFile(){
        file.setSaveFile();
        return file;
    }
}
