package Games.HangManWaleed;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class TopPart extends JPanel {
	int x = 605;
	int y = 330;
	int z =0;
	/**
	 * Create the panel.
	 */
	public TopPart() {
		setSize(new Dimension(1366, 430)); 
		setBackground(Color.WHITE);
		repaint();
		revalidate();

	}
	public void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		int x1 =600;
		int x2 = 650;
		int y1 = 340;
		for(int i =0; i<HangGame.Word.length(); i++) {
		g2.drawLine(x1, y1, x2 , y1);
		x1 = x2 + 10;
		x2 = x2 + 65;
		}
		
		switch(HangGame.mistakes) {
		
		case 0: 
			{
				g.setFont(new Font("MyFont", Font.PLAIN, 20));
				g.drawImage(getImage("0.png"), 0, 0,  null);
				g.drawString(InputExcel.Hint1, 620, 25);
				HangGame.Panel.repaint();
				break;
				
			}
		case 1:{
			g.drawImage(getImage("1.png"), 0, 0, null);
			g.drawString(InputExcel.Hint1, 620, 25);
			g.drawString(InputExcel.Hint2, 620, 60);
			HangGame.Panel.repaint();
			break;
		}
		case 2: {
			g.drawImage(getImage("2.png"), 0, 0,  null);
			g.drawString(InputExcel.Hint1, 620, 25);
			g.drawString(InputExcel.Hint2, 620, 60);
			g.drawString(InputExcel.Hint3, 620, 95);
			HangGame.Panel.repaint();
			break;
		}
		case 3: {
			g.drawImage(getImage("3.png"), 0, 0, null);
			g.drawString(InputExcel.Hint1, 620, 25);
			g.drawString(InputExcel.Hint2, 620, 60);
			g.drawString(InputExcel.Hint3, 620, 95);
			g.drawString(InputExcel.Hint4, 620, 130);
			HangGame.Panel.repaint();
			break;
		}
		case 4: {
			g.drawImage(getImage("4.png"), 0, 0,   null);
			g.drawString(InputExcel.Hint1, 620, 25);
			g.drawString(InputExcel.Hint2, 620, 60);
			g.drawString(InputExcel.Hint3, 620, 95);
			g.drawString(InputExcel.Hint4, 620, 130);
			g.drawString(InputExcel.Hint5, 620, 165);

			HangGame.Panel.repaint();
			break;
		}
		case 5: {
			g.drawImage(getImage("5.png"), 0, 0,  null);
			g.drawString("", x, y);
			HangGame.Panel.repaint();
			break;
		}

		}
		
		g.drawRect(600, 5, 700, 260);
		g.setFont(new Font("MyFont", Font.PLAIN, 30));

		
			if (HangGame.PrintFlag == true) {
			g.drawString(HangGame.TheString, x, y);
			HangGame.Panel.repaint();
			HangGame.Panel.revalidate();
			
			}
	
}
	public Image getImage(String s) {
		Image HGImage = Toolkit.getDefaultToolkit().getImage(s);
		return HGImage;
		
	}

}
