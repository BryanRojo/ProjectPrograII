package ac.ucr.c01880.dotwarsprojectclient.bussiness;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ac.ucr.c01880.dotwarsprojectclient.domain.Game;
import ac.ucr.c01880.dotwarsprojectclient.domain.SingletonControllerGame;
import ac.ucr.c01880.dotwarsprojectclient.domain.ThreadGameplay;
import ac.ucr.c01880.dotwarsprojectclient.domain.ThreadStats;
import ac.ucr.c01880.dotwarsprojectclient.presentation.JFWindowPageSelect;
import ac.ucr.c01880.dotwarsprojectclient.presentation.JPPitch;
import ac.ucr.c01880.dotwarsprojectclient.utility.Route;

public class Controller implements ActionListener {

    private Client client;
    private ThreadControlClient threadControl;
    private Logic logic;
    private JFWindowPageSelect jfWindowPageController;
    private boolean select;

    public Controller() {
        this.jfWindowPageController = new JFWindowPageSelect();
        this.jfWindowPageController.setVisible(true);
        this.logic = new Logic();
        this.addActionListener();
    }//end of controller

    private void addActionListener() {

        this.jfWindowPageController.getJbNext().addActionListener(this);
        this.jfWindowPageController.getJbJoin().addActionListener(this);
        this.jfWindowPageController.getJbCreate().addActionListener(this);

    }//end of addActionListener()

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jfWindowPageController.getJbNext()) {
            this.client = new Client(this.logic, this.jfWindowPageController.getTfPlayerName().getText());
            this.threadControl = new ThreadControlClient(client);
            this.threadControl.start();
            SingletonControllerGame.getIntance().setClient(this.client);
            if (select) {
                this.client.SendMessage(this.client.getName() + ":" + Route.CREATEGAME + ":" + this.jfWindowPageController.getTfMatrixSize().getText() + ":" + this.jfWindowPageController.getTfPassword1().getText());
            } else {
                this.client.SendMessage(this.client.getName() + ":" + Route.CONECTGAME + ":" + this.jfWindowPageController.getTfPassword2().getText());
            }
            this.jfWindowPageController.dispose();
            SingletonControllerGame.getIntance().setGame(new Game(5, 5, "a"));
            System.out.println("jhas");
            JFrame windowS = new JFrame();
            JPPitch jpPitch = new JPPitch();
            System.out.println("jhasjkdhas");
            windowS.getContentPane().add(jpPitch);
            windowS.pack();
            System.out.println("jhasjkdhas1");
            windowS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowS.setVisible(true);
            System.out.println("jhasjkdhas2");
            ThreadStats threadStats = new ThreadStats(jpPitch);
            threadStats.start();
            ThreadGameplay threadGameplay = new ThreadGameplay();
            threadGameplay.start();
            System.out.println("hello");
        } else if (e.getSource() == this.jfWindowPageController.getJbJoin()) {
            this.select = false;
            this.visible(false);
        }
        if (e.getSource() == this.jfWindowPageController.getJbCreate()) {
            this.select = true;
            this.visible(true);
        }

    }//end of  actionPerformed

    private void visible(boolean visible) {
        this.jfWindowPageController.getTfPassword1().setVisible(visible);
        this.jfWindowPageController.getTfPassword2().setVisible(!visible);
        this.jfWindowPageController.getTfMatrixSize().setVisible(visible);

    }

}//end of class
