package Games.Wave;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import Games.Wave.Main.STATES;

public class Window extends Canvas  {

	private static final long serialVersionUID = -2145001138302984898L;
	public static JFrame frame;
	public Window(int width,int hight,String title, Main game){
		frame= new JFrame(title);
		frame.setPreferredSize(new Dimension(width,hight));
		frame.setMaximumSize(new Dimension(width,hight));
		frame.setMinimumSize(new Dimension(width,hight));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (game.gameState==STATES.Manu) {
					AudioPlayer.getMusic("Manu_Music").pause();
				}
				else if (game.gameState==STATES.Game||game.gameState==STATES.Shop) {
					AudioPlayer.getMusic2("Game_Music").pause();
				}
				else {
					AudioPlayer.getMusic3("GameOver_Music").pause();
				}
				game.gameState=STATES.Exit;
			}
		});
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}