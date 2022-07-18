package ac.ucr.c01880.dotwarsprojectclient.domain;

import javax.swing.JOptionPane;

public class ThreadGameplay extends Thread {

    private boolean suspend;
    private int timeLife;

    public ThreadGameplay() {

    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(100);

                if (SingletonControllerGame.getIntance().getGame().getGameTurn() == 100) {
                    SingletonControllerGame.getIntance().getGame().setGameTurn(202);
                    SingletonControllerGame.getIntance().getGame().getDotsFlag().changeImageTwo();
                    SingletonControllerGame.getIntance().getGame().comprobatePointsRed();
                    SingletonControllerGame.getIntance().getGame().setAux("Puntos: " + SingletonControllerGame.getIntance().getGame().getPointRed());
                }
                if (SingletonControllerGame.getIntance().getGame().getGameTurn() == 200) {
                    SingletonControllerGame.getIntance().getGame().setGameTurn(102);
                    SingletonControllerGame.getIntance().getGame().getDotsFlag().changeImageOne();
                    SingletonControllerGame.getIntance().getGame().comprobatePointsBlue();
                    SingletonControllerGame.getIntance().getGame().setAux("Puntos: " + SingletonControllerGame.getIntance().getGame().getPointBlue());
                }

                synchronized (this) {
                    if (suspend) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public synchronized void suspendThread() {
        this.suspend = true;
    }

    public synchronized void resumeThread() {
        this.suspend = false;
        notify();
    }

}//end of class 
