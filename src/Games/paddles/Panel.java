package Games.paddles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {

    private int Paddle1X = 100;
    private int Paddle2X = 650;
    private final int Paddle1Y = 10;
    private final int Paddle2Y = 740;
    private final int PaddleWidth = 100;
    private final int PaddleHeight = 10;
    private boolean xRightMove = false;
    private boolean xLeftMove = false;
    private boolean yRightMove = false;
    private boolean yLeftMove = false;

    private int player1 = 0;
    private int player2 = 0;

    public Timer t;

    private int ballXlocation = 400;
    private int ballYlocation = 375;
    private int ballXspeed = 2;
    private int ballYspeed = 4;
    int ballXvector = 4;
    int ballYvector = 2;

    public Panel () {


        t = new Timer( 20 , this::actionPerformed );

    }

    protected void paintComponent (Graphics g){
        g.setColor(new Color(0,0,0));
        g.fillRect(0,0,800,800);

        g.setColor(new Color(255, 255, 255));
        g.fillRect(Paddle1X,Paddle1Y,PaddleWidth,PaddleHeight);

        g.setColor(new Color(255, 255, 255));
        g.fillRect(Paddle2X,Paddle2Y,PaddleWidth,PaddleHeight);

        g.setColor(new Color(182, 21, 21));
        g.fillOval(ballXlocation , ballYlocation , 25,25);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(ballXlocation == 0){
            ballXvector= 4;
        }
        else if(ballXlocation == 768){
            ballXvector = -4;
        }
        if(ballYlocation == 15  ){
            if(ballXlocation >= Paddle1X && ballXlocation <= Paddle1X+100)
                    ballYvector = 2;
            else{
                fieldReset();
                t.stop();
                Window.gameStarted =false;
                player2++;
                JOptionPane.showMessageDialog(null , "PLayer 1: "+player1+"\nPlayer 2 :"+player2,"Scores",1);
            }

        }

        if(ballYlocation == 719  ){
            if( ballXlocation >= Paddle2X && ballXlocation <= Paddle2X+100)
                 ballYvector = -2;
            else{
               fieldReset();
               t.stop();
               Window.gameStarted =false;
               player1++;
               JOptionPane.showMessageDialog(null , "PLayer 1: "+player1+"\nPlayer 2 :"+player2,"Scores",1);
            }
        }

        if(xLeftMove){
            Paddle1X += -5;
        }
        else if(xRightMove){
            Paddle1X += 5;
        }
        else if(yLeftMove){
            Paddle2X += -5;
        }
        else if(yRightMove){
            Paddle2X += 5;
        }


        ballXlocation += ballXspeed*ballXvector;
        ballYlocation += ballYspeed*ballYvector;


        repaint();
    }

    public void x1MoveRightStart () {
        xRightMove = true;
    }
    public void x1MoveLeftStart () {
        xLeftMove = true;
    }
    public void x2MoveRightStart () {
        yRightMove = true;
    }
    public void x2MoveLeftStart () {
        yLeftMove = true;
    }
    public void x1MoveRightStop () {
        xRightMove = false;
    }
    public void x1MoveLeftStop () {
        xLeftMove = false;
    }
    public void x2MoveRightStop () {
        yRightMove = false;
    }
    public void x2MoveLeftStop () {
        yLeftMove = false;
    }

    public void gameStart () {
        t.start();
    }
    public void gameStop () {
        t.stop();
    }

    public void fieldReset(){
         Paddle1X = 100;
         Paddle2X = 650;
         xRightMove = false;
         xLeftMove = false;
         yRightMove = false;
         yLeftMove = false;


       ballXlocation = 400;
        ballYlocation = 375;
        ballXspeed = 2;
        ballYspeed = 4;
        ballXvector = 4;
        ballYvector = 2;

    }

}
