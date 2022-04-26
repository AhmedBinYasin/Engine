package Games.SnakeGame;


import Engine.playSound;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SnakeGameWindow extends JComponent implements ActionListener, KeyListener {
    private JFrame Window;
    private BufferedImage snake,backGround;
    private int snakeXposition = 400;
    private int snakeYposition = 400;
    private int snakeVectorX = 1;
    private int snakeVectorY = 0;
    private int snakeXspeed = 25;
    private int snakeYspeed = 25;
    private int gameSpeed = 100;
    private Timer t;
    private boolean keyAlreadyPressed = false;
    private BufferedImage snakeHeadUp,snakeHeadDown,snakeHeadLeft,snakeHeadRight,snakeBody,food;
    private Dimension foodPosition;
    private Dimension [] snakeBodyPosition;
    private int score=0;
    private JLabel scorePanel = new JLabel();
    private playSound snakeMusic,foodeattenSound,gameOverSound;


    public SnakeGameWindow() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Window = new JFrame("Snake Game:");
        Window.setSize(815, 830);
        Window.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Window.setResizable(false);
        Window.setLayout(new BorderLayout());
        Window.setBackground(new Color(64, 119, 175));

        scorePanel.setText("Score: "+score);
        Window.add(scorePanel , BorderLayout.NORTH);

        Window.add(this);
        Window.addKeyListener(this);

        snakeBodyPosition = new Dimension[3];
        snakeHeadUp = ImageIO.read(getClass().getResource("upmouth.png"));
        snakeHeadDown = ImageIO.read(getClass().getResource("downmouth.png"));
        snakeHeadLeft = ImageIO.read(getClass().getResource("leftmouth.png"));
        snakeHeadRight = ImageIO.read(getClass().getResource("rightmouth.png"));
        snakeBody = ImageIO.read(getClass().getResource("snakeimage.png"));
        backGround = ImageIO.read(getClass().getResource("snakeGameBackground.jpg"));
        food = ImageIO.read(getClass().getResource("enemy.png"));
        snakeMusic = new playSound("snakeMusic.WAV");
        gameOverSound = new playSound("beep-03.wav");

        snakeMusic.start(10);
        snake = snakeHeadRight;
        for(int i=0 ; i<3 ; i++){
            snakeBodyPosition[i] = new Dimension(snakeXposition-25-(25*i),snakeYposition);
        }
        setFood();

        Window.setVisible(true);

        t = new Timer(gameSpeed, this);
        t.start();

        Window.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Window.dispose();
                snakeMusic.stop();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {
                t.stop();
                snakeMusic.stop();

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                t.start();
                snakeMusic.start();
            }

            @Override
            public void windowActivated(WindowEvent e) {
                t.start();
                snakeMusic.start();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                t.stop();
                snakeMusic.stop();
            }
        });
    }

    protected void paintComponent(Graphics g) {
        //backGround

        g.drawImage(backGround,0,0,this);

        //snake head
        g.drawImage(snake, snakeXposition, snakeYposition, this);
        //snake body
        for (Dimension dimension : snakeBodyPosition) {
            g.drawImage(snakeBody, dimension.width, dimension.height, this);
        }
        //snake food
        g.drawImage(food,foodPosition.width,foodPosition.height,this);

        keyAlreadyPressed = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setBodyPosition();

        snakeXposition += snakeXspeed * snakeVectorX;
        snakeYposition += snakeYspeed * snakeVectorY;

        if(snakeXposition == 800){
            snakeXposition = 0;
        }else if(snakeXposition == -25){
            snakeXposition = 775;
        }
        if(snakeYposition == -25){
            snakeYposition=750;
        }else if(snakeYposition == 775){
            snakeYposition = 0;
        }


        if(foodPosition.width == snakeXposition && foodPosition.height == snakeYposition){
            setFood();
            try {
                foodeattenSound = new playSound("beep-02.wav");
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ioException) {
                ioException.printStackTrace();
            }
            foodeattenSound.start();
            scoreUpdate(1);
            snakeGrowth();
            setFood();
        }

        repaint();
        try {
            collisionDetection();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!keyAlreadyPressed){
            keyAlreadyPressed = true;
            if (e.getKeyCode() == 38) {          //up
                if (snakeVectorY == 0) {
                    snakeVectorY = -1;
                    snakeVectorX = 0;
                    snake = snakeHeadUp;
                }
            } else if (e.getKeyCode() == 40) {    //down
                if (snakeVectorY == 0) {
                    snakeVectorX = 0;
                    snakeVectorY = 1;
                    snake = snakeHeadDown;
                }
            } else if (e.getKeyCode() == 37) {    //left
                if (snakeVectorX == 0) {
                    snakeVectorX = -1;
                    snakeVectorY = 0;
                    snake = snakeHeadLeft;
                }
            } else if(e.getKeyCode() == 39) {  //right
                if (snakeVectorX == 0) {
                    snakeVectorY = 0;
                    snakeVectorX = 1;
                    snake = snakeHeadRight;
                }
            }
        }
        }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setFood(){
        foodPosition = new Dimension(((int)((Math.random()*100)%32))*25,((int)((Math.random()*100)%30)+1)*25);
        if(foodPosition.width == snakeXposition && foodPosition.height == snakeYposition){
            setFood();
        }else{
            for (Dimension dimension : snakeBodyPosition) {
                if (foodPosition == dimension) {
                    setFood();
                }
            }
        }
    }



    public void snakeGrowth() {
        Dimension [] temp = new Dimension[snakeBodyPosition.length];
        System.arraycopy(snakeBodyPosition, 0, temp, 0, snakeBodyPosition.length);
        snakeBodyPosition = new Dimension[snakeBodyPosition.length+1];
        System.arraycopy(temp, 0, snakeBodyPosition, 0, temp.length);
        setBodyPosition();
    }




    public void setBodyPosition(){
        for(int i=snakeBodyPosition.length-1 ; i>=0 ; i--){
            if(i==0){
                snakeBodyPosition[i] = new Dimension(snakeXposition,snakeYposition);
            }
            else {
                snakeBodyPosition[i] = snakeBodyPosition[i - 1];
            }}}



    public void collisionDetection() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        for(int i=3 ; i<snakeBodyPosition.length ; i++){
            if(snakeBodyPosition[i].width == snakeXposition && snakeBodyPosition[i].height == snakeYposition){
                snakeMusic.stop();
                gameOverSound.start();
                final JComponent [] gameOver = new JComponent[]{
                        new JLabel("Game over"),new JLabel("Your score is: "+score),new JLabel("Would you like to play again?")
                };
                int input=JOptionPane.showConfirmDialog(null,gameOver,
                        "Better luck next time", JOptionPane.YES_NO_OPTION);
                if(input == JOptionPane.YES_OPTION){
                    Window.dispose();
                    run();
                }
                else {
                    Window.dispose();
                }
                }}}


    public void scoreUpdate (int add){
        score += add;
        scorePanel.setText("Score: "+score);
        Window.add(scorePanel , BorderLayout.NORTH);
    }

    public static void run () throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        new SnakeGameWindow();
    }

    }
