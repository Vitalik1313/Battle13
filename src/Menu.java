import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Menu extends JFrame{
    private JPanel MainPanel;
    private JButton saveFightButton;
    private JButton a1VS1Button;
    private JButton a4VS4Button;
    private JButton showHeroesButton;
    private JButton EXITButton;
    Battle battle;
    public Menu()  {

        Player team = new Player("Player");
        Player opponent = new Player("Opponent");
        battle = new Battle(team, opponent);

        setContentPane(MainPanel);
        setTitle("Battle13");
        setSize(450,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        a1VS1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                team.setFightType(1);
                opponent.setFightType(1);
                battle.startFight1vs1();
            }
        });
        a4VS4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battle.startFight4vs4();
            }
        });
        showHeroesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\t\t  Game heroes");
                System.out.println("\t1)Barbarian - hit all team");
                System.out.println("\t2)Healer - healing your team");
                System.out.println("\t3)Killer - hit one hero by 50% of his current HP");
                System.out.println("\t4)Defender - gives your team shield\n\n");
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        saveFightButton.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)   {
                String path = "C:\\Users\\admin\\Desktop\\Лабораторні_JAVA\\FightHistory.txt";
                /*System.out.println("\n\tFight description was redirected to file.");
                File file = new File(path);
                try {
                    PrintStream stream = new PrintStream(file);
                    System.setOut(stream);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }*/
                battle.setFile();
                saveFightButton.setBackground(Color.GREEN);
            }
        });

    }
}
