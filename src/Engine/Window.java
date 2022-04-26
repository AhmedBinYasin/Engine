package Engine;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class Window extends JComponent implements WindowListener {
    private JFrame Window;
    public static GameButtons [] gameButtons;
    private ImageIcon windowIcon;
    private JLabel backGround;
    private JLabel Name;
    private MuteButton muteButton;
    private GridBagConstraints gc;
    private ImageIcon gameButtonIcon1,SnakeGameIcon,paddelGameIcon,ticTakGameIcon,dinoRunnerGameIcon,waveGameIcon,hangManGameIcon,spellingBeeGameIcon;
    public Window (String name) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Window = new JFrame ("Gaming Console V 1.0");
        Window.setSize(1600,870);
        Window.setLocationRelativeTo(null);
        Window.setLayout(new BorderLayout());
        Window.setResizable(false);
        Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Window.addWindowListener(this);

        windowIcon = new ImageIcon("icon.png");
        backGround = new JLabel(new ImageIcon("BackGround.jpg"));
        gameButtonIcon1 = new ImageIcon("GameIcon.png");
        SnakeGameIcon = new ImageIcon("snakeGameIcon.png");
        paddelGameIcon = new ImageIcon("paddleGameIcon.jpg");
        ticTakGameIcon = new ImageIcon("ticTakGameIcon.png");
        dinoRunnerGameIcon = new ImageIcon("dinoRunnerGameIcon.png");
        waveGameIcon=new ImageIcon("WaveGameIcon.PNG");
        hangManGameIcon = new ImageIcon("hangManGameIcon.png");
        spellingBeeGameIcon = new ImageIcon("spellingBeeGameIcon.png");
        Name = new JLabel("    Greetings "+name+"!");
        Name.setFont(new Font("amaze" , Font.BOLD, 20 ));
        Name.setForeground(Color.white);
        muteButton = new MuteButton();
        gameButtons = new GameButtons[9];
        gc = new GridBagConstraints();
        Window.add(backGround);
        backGround.setLayout(new GridBagLayout());

        for (int i=0 ; i<9 ; i++){
            gameButtons[i] = new GameButtons();
            gameButtons[i].setOpaque(true);
            gameButtons[i].setContentAreaFilled(false);
            gameButtons[i].setBorderPainted(false);
            if(i==0){
                gameButtons[i].setIcon(ticTakGameIcon);
            }
            else if(i==1){
                gameButtons[i].setIcon(paddelGameIcon);
            }
            else if(i==2){
                gameButtons[i].setIcon(SnakeGameIcon);

            }else if(i==3){
                gameButtons[i].setIcon(dinoRunnerGameIcon);
            }else if(i==4){
                gameButtons[i].setIcon(waveGameIcon);
            }else if(i==5) {
            	gameButtons[i].setIcon(hangManGameIcon);
            }else if(i==6) {
            	gameButtons[i].setIcon(spellingBeeGameIcon);
            }
            else {
            	gameButtons[i].setIcon(gameButtonIcon1);
            }
            
        }

       gc.weighty=1;
       gc.weightx=1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        backGround.add(Name , gc);


        gc.gridx = 2;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        backGround.add(gameButtons[0] , gc);

        gc.gridx = 4;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        backGround.add(gameButtons[1] , gc);

        gc.gridx = 6;
        gc.gridy = 2;
        backGround.add(gameButtons[2] , gc);

        gc.gridx = 2;
        gc.gridy = 4;
        backGround.add(gameButtons[3] , gc);

        gc.gridx = 4;
        gc.gridy = 4;
        backGround.add(gameButtons[4] , gc);

        gc.gridx = 6;
        gc.gridy = 4;
        backGround.add(gameButtons[5] , gc);

        gc.gridx = 2;
        gc.gridy = 6;
        backGround.add(gameButtons[6] , gc);

        gc.gridx = 4;
        gc.gridy = 6;
        backGround.add(gameButtons[7] , gc);

        gc.gridx = 6;
        gc.gridy = 6;
        backGround.add(gameButtons[8] , gc);

        gc.gridx = 7;
        gc.gridy = 7;
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        backGround.add(muteButton , gc);

        gc.gridx = 0;
        gc.gridy = 7;
        gc.anchor = GridBagConstraints.LAST_LINE_START;

        Window.setIconImage(windowIcon.getImage());
        Window.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(Window,"Are you sure you want to QUIT?","Close Button clicked",0);
        if(result == JOptionPane.NO_OPTION){
            Window.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
        else if(result == JOptionPane.YES_OPTION){
            Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        else{
            Window.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        JOptionPane.showMessageDialog(null , "Hello");
    }

    @Override
    public void windowIconified(WindowEvent e) {

        MuteButton.introMusic.stop();
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
        MuteButton.introMusic.start();
    }
    @Override
    public void windowActivated(WindowEvent e) {
        MuteButton.introMusic.start();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        MuteButton.introMusic.stop();
    }
}
