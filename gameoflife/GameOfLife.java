package gameoflife;

import java.util.Timer;
import java.util.TimerTask;


public class GameOfLife extends Thread{
    static int n_size = 70;
    static int percent = 11;
    static int point_size = 5;
    static int speed = 50;
    
    public static void main(String[] args) {
        ConwayAlgo con = new ConwayAlgo(n_size, percent);
        con.init();
        showGUI gui = new showGUI(con.getMatrix(), point_size);
        gui.setVisible(true);
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                con.change();
                gui.change(con.getMatrix());
            }
        }, 0, 10000/speed);
    }
}
