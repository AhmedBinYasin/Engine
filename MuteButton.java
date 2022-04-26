package Engine;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MuteButton extends JButton implements ActionListener {
    public static playSound introMusic;
    byte val=0;
    private ImageIcon on;
    private ImageIcon off;

    public MuteButton() throws IOException, LineUnavailableException, UnsupportedAudioFileException {

        on = new ImageIcon("on.png");
        off = new ImageIcon("off.png");
        setIcon(on);
        setOpaque(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        addActionListener(this);
        introMusic = new playSound("intro Music.wav");
        introMusic.start(10);
    }


    public void actionPerformed(ActionEvent e) {
        val++;
        val%=2;
        switch (val){
            case 0:
                setIcon(on);
                introMusic.start();
                break;
            case 1:
                setIcon(off);
                introMusic.stop();
                break;
        }
    }

}
