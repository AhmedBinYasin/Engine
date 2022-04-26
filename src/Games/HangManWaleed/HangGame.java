package Games.HangManWaleed;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class HangGame extends JPanel {
	static JFrame GameFrame = new JFrame("HangMan");
	JPanel ContPanel = new JPanel();
	JPanel KeyBoardTopPanel = new JPanel();
	JPanel KeyBoardMidPanel = new JPanel();
	JPanel KeyBoardBottPanel = new JPanel();
	static boolean PrintFlag = false;
	static TopPart Panel = new TopPart();
	static int mistakes =0;
	char[] Compare = new char[30];
    static String Word;
    char[] CompArr =new char[30];
	static String [] RightString = new String[30];
	static String TheString;
	static String MyString;

	

	
	
	public void ImpWord() throws IOException {
		InputExcel exanple = new InputExcel();
		Word = exanple.CellRead();
		int i = exanple.NoOfWords();
		exanple.StringtoCharArray();
	}
	public void Init() {
		for(int x =0; x<30; x++) {
			RightString[x] = "   ";
			CompArr[x] = '\0';
			
		}
	}
	public HangGame() throws IOException {
		setFrame();
		Init();
		ImpWord();
		addKeyBoardButts();
		setKeyPanel();
		GameFrame.setVisible(true);
	}
	public void setFrame() {
		GameFrame.setSize(new Dimension(1366, 768));
		GameFrame.setResizable(false);
		GameFrame.setBackground(Color.WHITE);
		ContPanel.setBackground(Color.WHITE);
		ContPanel.setLayout(null);
		ContPanel.add(Panel);
		GameFrame.setContentPane(ContPanel);
	}
	public void setKeyPanel() {
		setTopKeyPanel();
		setMidKeyPanel();
		setBottKeyPanel();
		
	}
	public void setTopKeyPanel() {
		Color c = new Color(255, 255, 255);
		GameFrame.add(KeyBoardTopPanel);
		KeyBoardTopPanel.setLocation(0, 439);
		KeyBoardTopPanel.setSize(1366, 110);
		KeyBoardTopPanel.setBackground(c);
	}
	public void setMidKeyPanel() {
		Color c = new Color(255, 255, 255);
		KeyBoardMidPanel.setLocation(0, 539);
		KeyBoardMidPanel.setSize(1366, 100);
		KeyBoardMidPanel.setBackground(c);
		GameFrame.add(KeyBoardMidPanel);
	}
	public void Comp (String Text) {
		int x =0;
		int i=0;
		int rep =0;
		boolean Found = false;
		while(x<InputExcel.WordArray1.length) {
		if (Text.charAt(0)== (InputExcel.WordArray1[x])) {
			RightString[x] = Character.toString(InputExcel.WordArray1[x]);
			CompArr[x] = (InputExcel.WordArray1[x]);
			PrintFlag = true;
			Found = true;
			if (Found== true) {
				for(int y = 0; y<InputExcel.WordArray1.length; y++) {
					if (Text.charAt(0) == InputExcel.WordArray1[y]) {
						i++;
						rep++;
						RightString[x] = Character.toString(InputExcel.WordArray1[x]);
						CompArr[x] = (InputExcel.WordArray1[x]);
						break;
					}
				}
				}
			}
			x++;
		}
		if (Found == false) {
			mistakes ++;
		}

		TheString = PrintString();
		MyString = CompString();
		GameOver();
		GameWon();
		Panel.repaint();
		Panel.revalidate();
	}
	public String PrintString() {
		String Print = "";
				
		for(int i =0; i<30; i++) {
			Print = Print + RightString[i] + "     ";	
			}
		return Print;
	}
	public String CompString() {
		String Print = "";
				
		for(int i =0; i<30; i++) {
			if(Character.isLetter(RightString[i].charAt(0))) {
			Print = Print + RightString[i];
			}
			}
		return Print;
	}
	public void GameWon() {
		int y;
		Object[] options = {"Yes", "No"};
		int total =0;
		for(int x =0; x<Word.length();x++) {
			if ((Word.charAt(x)) == CompArr[x] ) {
				total++;
			}
		}
		if (total == Word.length()) {
			y = JOptionPane.showOptionDialog(GameFrame, "You Won! Wanna Play Again?", "Game Won!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (y==0) {
				try {
					mistakes =0;
					GameFrame.dispose();
					MyString ="";
					TheString = "";
					InputExcel.Hint1 ="";
					InputExcel.Hint2 ="";
					InputExcel.Hint3 ="";
					InputExcel.Hint4 ="";
					InputExcel.Hint5 ="";
					new HangGame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (y==1) {
				GameFrame.dispose();
			}
		}
	}

	public void GameOver() {
		int x;
		Object[] options = {"Yes", "No"};
		if (mistakes ==5 ) {
			x = JOptionPane.showOptionDialog(GameFrame, "Game Over! Wanna Play Again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (x==0) {
				try {
					mistakes =0;
					GameFrame.dispose();
					MyString ="";
					TheString = "";
					InputExcel.Hint1 ="";
					InputExcel.Hint2 ="";
					InputExcel.Hint3 ="";
					InputExcel.Hint4 ="";
					InputExcel.Hint5 ="";
					new HangGame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (x==1) {
				GameFrame.dispose();
			}
			
		}
		
		}
	public void setBottKeyPanel() {
		Color c = new Color(255, 255, 255);
		GameFrame.add(KeyBoardBottPanel);
		KeyBoardBottPanel.setLocation(65, 649);
		KeyBoardBottPanel.setSize(1366, 110);
		KeyBoardBottPanel.setBackground(c);
	}
	public void addKeyBoardButts() {
		TopRowKey();
		MidRowKey();
		BottRowKey();

}
	public void TopRowKey() {
		ActionListener getText  = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() instanceof JButton) {	
				JButton ButtPress = (JButton)e.getSource();
				ButtPress.setEnabled(false);
				Comp(ButtPress.getText());
				}
			}
		};
		
		
		FlowLayout KeyLayTop = new FlowLayout(FlowLayout.LEFT, 5, 2);
		JButton[] buttonTopRow = new JButton[10];
		Dimension  SizeTR = new Dimension(130, 90);
		KeyBoardTopPanel.setLayout(KeyLayTop);
		int [] x = {81,87,69,82,84,89,85,73,79,80};
		for ( int i = 0; i < 10; i++ )
		{
		  buttonTopRow[i] = new JButton(Character.toString((char)(x[i])));
		  buttonTopRow[i].setPreferredSize(SizeTR);	
		  KeyBoardTopPanel.add(buttonTopRow[i]);
		  buttonTopRow[i].addActionListener(getText);
		}	
	}
	public void MidRowKey() {
		int[] x = {65,83,68,70,71,72,74,75,76};
		
		Dimension  SizeMR = new Dimension(132, 90);
		JButton[] buttonMidRow = new JButton[9];
		FlowLayout KeyLayMid = new FlowLayout(FlowLayout.LEFT, 5, 2);
		
		
		ActionListener getText  = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() instanceof JButton) {	
				JButton ButtPress = (JButton)e.getSource();
				ButtPress.setEnabled(false);
				Comp(ButtPress.getText());
				}
			}
			    
		};


		KeyLayMid.setHgap(16);
		KeyBoardMidPanel.setLayout(KeyLayMid);
		for ( int i = 0; i < 9; i++ )
		{
		  buttonMidRow[i] = new JButton(Character.toString((char)(x[i])));
		  buttonMidRow[i].setPreferredSize(SizeMR);	
		  buttonMidRow[i].addActionListener(getText);
		  KeyBoardMidPanel.add(buttonMidRow[i]);
		}
	}
	public void BottRowKey() {
		
		FlowLayout KeyLayBott = new FlowLayout(FlowLayout.LEFT, 5, 	2);
		JButton[] buttonBottRow = new JButton[7];
		Dimension  SizeBR = new Dimension(145, 75);
		
		int[] x = {90,88,67,86,66,78,77};
		
		
		
ActionListener getText  = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() instanceof JButton) {	
				JButton ButtPress = (JButton)e.getSource();
				ButtPress.setEnabled(false);
				Comp(ButtPress.getText());
				
				}
			}
		};

		
		KeyLayBott.setHgap(20);
		KeyBoardBottPanel.setLayout(KeyLayBott);
		for ( int i = 0; i < 7; i++ )
		{
		  buttonBottRow[i] = new JButton(Character.toString((char)(x[i])));
		  buttonBottRow[i].addActionListener(getText);
		  buttonBottRow[i].setPreferredSize(SizeBR);	
		  KeyBoardBottPanel.add(buttonBottRow[i]);
		}

	}
}