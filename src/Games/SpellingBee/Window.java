package Games.SpellingBee;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame {

	private JLabel mainScreen;
	private JButton [] buttons;
	private ImageIcon play,add,exit;
	
	public Window () {
		super("Spelling Bee");
		setSize(800,730);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		mainScreen = new JLabel(new ImageIcon("MainScreen.png"));
 
		mainScreen.setLayout(new BoxLayout(mainScreen, BoxLayout.Y_AXIS));
		mainScreen.setBorder(new EmptyBorder(new Insets(200, 320, 300, 320)));
		
		play = new ImageIcon("playButton.png");
		add = new ImageIcon("addButton.png");
		exit = new ImageIcon("exitButton.png");
         
		buttons =new JButton[3];
		
        for(int i=0 ;i<3 ;i++ ) {
        	buttons[i] = new JButton();
        	buttons[i].setOpaque(true);
        	buttons[i].setContentAreaFilled(false);
        	
        	if(i==0) {
        		buttons[i].setIcon(play);
        	}else if(i==1) {
        		buttons[i].setIcon(add);
        	}else {
        		buttons[i].setIcon(exit);
        	}
         }
         
        buttons[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 new Play();
                 dispose();
                    }
        });
        
        buttons[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	JTextField word = new JTextField();
                JTextField definition = new JTextField();
                int sr_no=0;
                final JComponent[] inputs = new JComponent[] {
                        new JLabel("Word"),
                        word,
                        new JLabel("Definition"),
                        definition
                };
                int OK_BUTTON = JOptionPane.showConfirmDialog(null, inputs, "Please fill the following fields", JOptionPane.PLAIN_MESSAGE);
                if(OK_BUTTON == JOptionPane.OK_OPTION) {
                	try {
						Scanner sc = new Scanner(new File("Words.txt"));
						while(sc.hasNext()) {
							sc.nextLine();
							sr_no++;
							}
					
						sc.close();
					} catch (FileNotFoundException e1) {
						System.out.println("File not found!!");
					}
                	FileWriter fr;
					try {
						fr = new FileWriter(new File("Words.txt"), true);
						fr.write("\n"+(sr_no+1)+" "+word.getText()+" "+definition.getText());
	                	fr.close();
					}catch (IOException e1) {
						System.out.println("Write file missing!!");
					}
                
                	JOptionPane.showMessageDialog(null, "Place the audio file assocoated to this word of name: "+(sr_no+1)+".wav in th resources.");
                }
                    }
        });
        
        buttons[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                  dispose();    
                    }
        });
        
        mainScreen.add(buttons[0]);  
        mainScreen.add(buttons[1]);
        mainScreen.add(buttons[2]);
        add(mainScreen);
		
		
		setVisible(true);
	}
}
