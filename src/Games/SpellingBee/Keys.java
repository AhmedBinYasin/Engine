package Games.SpellingBee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Keys extends JButton implements ActionListener{
	private char alphabet;
	public Keys(char alphabet ,int i ) {
		super();
		
		if(i<10) {
			setText("     "+alphabet+"    ");
		}else {
			setText("       "+alphabet+"      ");}
		
		this.alphabet = alphabet;
		
		addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Play.buttonPressed(alphabet);
	}
}
