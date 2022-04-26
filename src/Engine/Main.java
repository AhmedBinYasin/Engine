package Engine;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        login();
        //new Window("Muhammad");
            }
    public static void login() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        JTextField userName = new JTextField();
        JPasswordField password = new JPasswordField();
        final JComponent[] inputs = new JComponent[] {
                new JLabel("User Name"),
                userName,
                new JLabel("Password"),
                password
        };
        int result = JOptionPane.showConfirmDialog(null, inputs, "Please verify your Identity", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            if("12975".equals(password.getText()) ){
                new Window(userName.getText());
            }
            else{
                JOptionPane.showMessageDialog(null , "Wrong password");
                login();
            }
        }
    }
    }
