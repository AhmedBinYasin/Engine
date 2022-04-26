package Games.SpellingBee;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Engine.playSound;

public class Play extends JFrame{

	private JLabel backGround,upperPart,middlePart,KeyBoard;
	private static JLabel scoreBoard;
	private static JLabel definition;
	private static JLabel blanks;
	private static int[] wordsUsed;
	private JButton audioButton;
	private Keys [] keys;
	private static String s_blanks,s_sr_no;
	private static String Word,word_definition;
	private static int sr_no,score,lives;
	private static char [] original_word;
	private static byte index=0;
	private playSound spoken_words;
	
	
	public Play () {
		super("spelling Bee");
		setSize(800,730);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		backGround = new JLabel(new ImageIcon("MainScreen.png"));
		backGround.setLayout(new GridLayout(4,1));
		definition = new JLabel("definition");
		definition.setFont(new Font("Serif", Font.PLAIN, 20));
		blanks = new JLabel("Blanks");
		blanks.setFont(new Font("Serif",Font.BOLD,25));
		upperPart = new JLabel();
		upperPart.setLayout(new FlowLayout());
		middlePart = new JLabel();
		middlePart.setLayout(new BorderLayout(2,1));
		KeyBoard = new JLabel();
		KeyBoard.setLayout(new FlowLayout());
		audioButton = new JButton();
		audioButton.setContentAreaFilled(false);
		audioButton.setIcon(new ImageIcon("audioButton.png"));
		audioButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				try {
					spoken_words = new playSound(s_sr_no+".wav");
					spoken_words.start();
				} catch (Exception e1) {
				}
		}});  
		
		
		keys = new Keys[26];
		String alphabet = "qwertyuiopasdfghjklzxcvbnm";
		char [] alpha = alphabet.toCharArray();
		score = 0;
		lives = 3;
		scoreBoard = new JLabel("Score: "+score+"  Lives: "+lives);
		scoreBoard.setFont(new Font("Serif", Font.PLAIN, 30));
		wordsUsed = new int[0];
		
		
		for(int i=0 ; i<26 ; i++) {
			keys[i] = new Keys(alpha[i],i);
			KeyBoard.add(keys[i]);}
		upperPart.add(audioButton);
		middlePart.add(definition,BorderLayout.NORTH);
		middlePart.add(blanks,BorderLayout.SOUTH);
		backGround.add(scoreBoard);
		backGround.add(upperPart);
		backGround.add(middlePart);
		backGround.add(KeyBoard);
		add(backGround);
		
		setVisible(true);
		

		totalWordsCalculator();
		gamePlay();
		try {
			spoken_words = new playSound(s_sr_no+".wav");
		} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
			System.out.print("Audio not found!!");
		}
		
		
	}
	
	public static void buttonPressed(char alphabet) {
		keyRecorder(alphabet);
	}

	public static void fileReader(int loops) {
		File file = new File("Words.txt");
		try {
			Scanner sc = new Scanner(file);
			while(loops>0 && sc.hasNext()) {
				s_sr_no=sc.next();
				Word = sc.next();
				original_word = Word.toCharArray();
				word_definition = sc.nextLine();
				loops--;
			}
			wordsUsed = wordsUsed(wordsUsed,Integer.parseInt(s_sr_no));
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			}
	}
	
	public static void totalWordsCalculator() {
		try {
			Scanner sc = new Scanner(new File("Words.txt"));
			while(sc.hasNext()) {
				sc.nextLine();
				sr_no++;}
			sc.close();
		} catch (FileNotFoundException e1) {
		}
	}
	
	public static void setWordOnScreen() {
		s_blanks = "";
		definition.setText("Definition: "+word_definition);
		for(int i=0 ; i<Word.length() ; i++) {
			s_blanks = s_blanks+" _";
		}
		blanks.setText(s_blanks);
		
	}
	

	
	public static void gamePlay() {
		fileReader(randNumberGenerator());
		setWordOnScreen();
	}
	
	public static void keyRecorder(char keyPressed) {
		if( Word.length()>index ) {
			if( original_word[index] == keyPressed ) {
				s_blanks = replace(s_blanks ,(index*2)+1,keyPressed);
				index++;
				blanks.setText(s_blanks);
			}else {
				lives--;
				scoreBoard.setText("Score: "+score+"          									   Lives: "+lives	);
			}
		}else {
			score++;
			scoreBoard.setText("Score: "+score+"          									   Lives: "+lives	);
			reset();
			gamePlay();
		}
	}
	
	public static String replace(String str, int index, char replace){     
	    if(str==null){
	        return str;
	    }else if(index<0 || index>=str.length()){
	        return str;
	    }
	    char[] chars = str.toCharArray();
	    chars[index] = replace;
	    return String.valueOf(chars);       
	}
	
	public static void reset() {
		s_blanks = null;
		Word = null;
		word_definition = null;
		original_word = null;
		index=0;
	}
	
	public static int[] wordsUsed( int[]wordsUsed ,int sr_no ) {
		int [] newWordsUsed = new int [wordsUsed.length+1];
		for(int i=0 ; i<wordsUsed.length ;i++) {
			newWordsUsed[i] = wordsUsed[i];
		}
		newWordsUsed[newWordsUsed.length-1] = sr_no;
		
		return newWordsUsed;
	}
	
	public static int randNumberGenerator() {
		boolean trueRand = false;
		int generatedInt = ((int)(Math.random()*(sr_no-1))+1);
		if(wordsUsed.length>0) {
			while(!trueRand) {
				int rand = ((int)(Math.random()*(sr_no-1))+1);
				for(int i=0; i<wordsUsed.length;i++) {
					if(wordsUsed[i] == rand) {
						break;
					}else if(i == wordsUsed.length-1) {
						trueRand = true;
				}
				}
			}
		}
		System.out.print(wordsUsed.length);
		for(int i=0 ; i<wordsUsed.length ; i++) {
			System.out.print(wordsUsed[i]);
		}System.out.println();
		return generatedInt;
	}
	
}
