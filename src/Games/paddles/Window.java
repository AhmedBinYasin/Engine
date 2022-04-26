package Games.paddles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public final class Window implements KeyListener, WindowListener {

    private Panel panel;
    public JFrame window;
    public static boolean gameStarted = false;


    public Window (){
        window = new JFrame("Paddle Game");
        window.setSize(800,805);
        window.setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new Panel();
        window.add(panel , BorderLayout.CENTER);

        window.addKeyListener(this);
        window.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == 37){
            panel.x1MoveLeftStart();
       }
       else if(e.getKeyCode() == 39){
            panel.x1MoveRightStart();
       }
       else if(e.getKeyCode() == 65){
           panel.x2MoveLeftStart();
       }
       else if(e.getKeyCode() == 68){
            panel.x2MoveRightStart();
       }
       else if(e.getKeyCode() == 32){
           if(!gameStarted) {
               panel.gameStart();
               gameStarted = true;
           }
           else{
               panel.gameStop();
               gameStarted = false;
           }
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 37){
            panel.x1MoveLeftStop();
        }
        else if(e.getKeyCode() == 39){
            panel.x1MoveRightStop();
        }
        else if(e.getKeyCode() == 65){
            panel.x2MoveLeftStop();
        }
        else if(e.getKeyCode() == 68){
            panel.x2MoveRightStop();
        }

    }

    public static void run() {
        Window window = new Window() ;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel.gameStop();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.dispose();
    }

    @Override
    public void windowIconified(WindowEvent e) {
        panel.gameStop();
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        panel.gameStart();
    }

    @Override
    public void windowActivated(WindowEvent e) {
        panel.gameStart();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        panel.gameStop();
    }




}
