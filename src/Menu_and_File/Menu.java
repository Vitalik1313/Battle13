package Menu_and_File;

import Player.Player;
import Battle.Battle;

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
    private JButton showLastFightButton;
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
                System.out.println("\t1)Heroes.Barbarian - hit all team");
                System.out.println("\t2)Heroes.Healer - healing your team");
                System.out.println("\t3)Heroes.Killer - hit one hero by 50% of his current HP");
                System.out.println("\t4)Heroes.Defender - gives your team shield\n\n");
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
                battle.setWriteToFile();
                battle.setFile();
                team.setFile(battle.getFile());
                opponent.setFile(battle.getFile());
                saveFightButton.setBackground(Color.GREEN);
            }
        });

        showLastFightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                try
                {
                    File file=new File("C:\\Users\\admin\\Desktop\\Лабораторні_JAVA\\FightHistory.txt");
                    FileInputStream fis=new FileInputStream(file);

                    int r;
                    while((r=fis.read())!=-1)
                    {
                        System.out.print((char)r);
                    }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }
}
