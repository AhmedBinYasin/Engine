package Games.dinoRunner;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Window extends JComponent implements ActionListener{
    public JFrame window;
    public BufferedImage currentDino,dino1,dino2,dino3,dino4,dino5,dino6,cloud,cactus;
    private static Timer t;
    private Dimension cloud1,cloud2,cloud3;
    private int loc;
    private int delay;
    private boolean jumping,decending,ducking;
    private int dinoY,dinoX;
    private  int defaultDinoY;
    private int score;
    private int paceTracker;
    private Dimension[] cactusLocation;
    private  int cactus0XLocation;

    public Window () {
        window = new JFrame("Dino Runner");
        window.setLayout(new BorderLayout());
        window.setSize(1000,800);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(this);

        delay = 60;

        cactusLocation = new Dimension[3];

        cactusLocation[0] = new Dimension(cactus0XLocation,515);
        cactusLocation[1] = new Dimension(cactus0XLocation+(int)(Math.random()*500)+300,515);
        cactusLocation[2] = new Dimension(cactusLocation[1].width+(int)(Math.random()*500)+300,515);

        cloud1=new Dimension(735 , 97);
        cloud2=new Dimension(411 , 81);
        cloud3=new Dimension(111 , 141);


        try {
            dino1 = ImageIO.read(getClass().getResource("dino1.png"));
            dino2 = ImageIO.read(getClass().getResource("dino2.png"));
            dino3 = ImageIO.read(getClass().getResource("dino3.png"));
            dino4 = ImageIO.read(getClass().getResource("dino4.png"));
            dino5 = ImageIO.read(getClass().getResource("dino5.png"));
            dino6 = ImageIO.read(getClass().getResource("dino6.png"));
            cloud = ImageIO.read(getClass().getResource("cloud.png"));
            cactus = ImageIO.read(getClass().getResource("cactus.png"));
        }catch (IOException e){}


        loc = 0;
        cactus0XLocation = 1000;
        defaultDinoY=509;
        dinoY = defaultDinoY;
        dinoX = 70;
        jumping = false;
        ducking = false;
        score=0;
        paceTracker=0;


        currentDino = dino1;

        t = new Timer(delay,this);
        t.start();
        window.setVisible(true);

        window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!jumping && !decending) {
                    if (e.getKeyCode() == 38) {//space
                        jumping = true;
                    } else if (e.getKeyCode() == 32) {//up
                    }
                }
                if (e.getKeyCode() == 48) {//down
                    ducking = true;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(!jumping && !decending) {
                    if (e.getKeyCode() == 38) {//space
                        jumping = true;
                    } else if (e.getKeyCode() == 32) {//up
                        jumping = true;
                    }
                }
                if (e.getKeyCode() == 40) {//down
                    ducking = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

                if(e.getKeyCode() == 40){//down
                    ducking = false;
                    System.out.print("oka");
                }
            }
        });
    }

    public void paintComponent(Graphics g){
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0,0,1000,800);

        g.setColor(new Color(0,0,0));
        g.drawString("Score: "+score,900,10);

        g.drawImage(currentDino,dinoX,dinoY,null);
        g.drawImage(cactus,cactusLocation[0].width,cactusLocation[0].height,null);
        g.drawImage(cactus,cactusLocation[1].width,cactusLocation[1].height,null);
        g.drawImage(cactus,cactusLocation[2].width,cactusLocation[2].height,null);
        g.drawImage(cloud , cloud1.width , cloud1.height , null);
        g.drawImage(cloud , cloud2.width , cloud2.height, null);
        g.drawImage(cloud , cloud3.width , cloud3.height, null);


        g.setColor(new Color(0, 0, 0));
        g.drawLine(0,600,1000,600);
    }


    public  static  void run (){
        new Window();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cloud1.width -=5;
        cloud2.width -=4;
        cloud3.width -=4;

        cactusLocation[0].width -=20;
        cactusLocation[1].width -=20;
        cactusLocation[2].width -=20;

        if(cloud1.width <-184){
            cloud1.width = 1000;
        }if(cloud2.width <-184){
            cloud2.width = 1000;
        }if(cloud3.width <-184){
            cloud3.width = 1000;
        }


        if(jumping || decending){
            currentDino = dino1;
            if(jumping) {
                dinoY -= 20;
            }else if(decending){
                dinoY += 17;
            }
            if(dinoY <= 375) {
                jumping = false;
                decending = true;
            }else if(dinoY >= defaultDinoY){
                dinoY = defaultDinoY;
                jumping = false;
                decending = false;
            }

        }else{
            loc++;
            loc %=4;
            if(ducking) {
                switch (loc) {
                    case 0:
                    case 2:
                        currentDino = dino4;
                        break;
                    case 1:
                        currentDino = dino5;
                        break;
                    case 3:
                        currentDino = dino6;
                }
            }else {
                switch (loc) {
                    case 0:
                    case 2:
                        currentDino = dino1;
                        break;
                    case 1:
                        currentDino = dino2;
                        break;
                    case 3:
                        currentDino = dino3;
                }
            }
        }

        if(cactusLocation[0].width <= -50){
            cactusLocation[0].width = cactusLocation[1].width;
            cactusLocation[1].width = cactusLocation[2].width;
            cactusLocation[2].width = cactusLocation[1].width+(int)(Math.random()*500)+300;
        }

        for (int i=0 ; i<3 ; i++){
            if ( ((dinoX+51 >= cactusLocation[i].width+20 && dinoX+90 <= cactusLocation[i].width+50) && (dinoY+90 >= cactusLocation[i].height+8 && dinoY+90 <= cactusLocation[i].height+90)) ||
                    ( (dinoX+23 >= cactusLocation[i].width+20 && dinoX+23 <= cactusLocation[i].width+50) && (dinoY+90 >= cactusLocation[i].height+8 && dinoY+90 <= cactusLocation[i].height+90))){
                t.stop();
                int result = JOptionPane.showConfirmDialog(null,"What about trying again?","Game over",0);
                if( result == JOptionPane.YES_OPTION ){
                    t.stop();
                    window.dispose();
                    new Window();
                }else if( result == JOptionPane.NO_OPTION ){
                    t.stop();
                    window.dispose();
                }
            }
        }

        if( paceTracker> 500 && delay > 35 ){
            t.setDelay( delay -= 10);
        }

        paceTracker +=1;
        score +=1;
        repaint();
    }


}