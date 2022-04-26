package Engine;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameButtons extends JButton implements ActionListener {

    public GameButtons() {
    this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Window.gameButtons[0]){
            Games.TicTak.GameApplet.run();
        }else if(e.getSource() == Window.gameButtons[1]){
            Games.paddles.Window.run();
        }else if(e.getSource() == Window.gameButtons[2]){
            try {
                Games.SnakeGame.SnakeGameWindow.run();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
        }else if(e.getSource() == Window.gameButtons[3]){
            Games.dinoRunner.Window.run();
        }else if(e.getSource() == Window.gameButtons[4]){
            Games.Wave.Main.runable();
        }else if(e.getSource() == Window.gameButtons[5]){
            Games.HangManWaleed.InputExcel.run();
        }else if(e.getSource() == Window.gameButtons[6]){
            JOptionPane.showMessageDialog(null , "Seventy button is pressed\n Game not yet added.");
        }else if(e.getSource() == Window.gameButtons[7]){
            JOptionPane.showMessageDialog(null , "Eighth button is pressed\n Game not yet added.");
        }else if(e.getSource() == Window.gameButtons[8]){
            JOptionPane.showMessageDialog(null , "Ninty button is pressed\n Game not yet added.");
        }
    }
}
