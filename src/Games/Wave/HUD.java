package Games.Wave;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public static float Health=100;
	public static float MaxHealth=100;
	private float greenValue=255;
	public static int score=0;
	public static int level=1;
	public static int healthLevel=1;
	public int wave=1;
	public void tick() {
		Health=Main.clamp(Health, 0, MaxHealth);
		greenValue=Main.clamp(greenValue, 0, 255);
		greenValue=(Health*2)/healthLevel;
	}
	public void render(Graphics graphics) {
		graphics.setColor(Color.gray);
		graphics.fillRect((int)15,(int) 15, 200,32);
		graphics.setColor(new Color((int)75,(int) greenValue,(int) 0));
		graphics.fillRect((int)15,(int) 15, (int) (Health*2)/healthLevel,32);
		graphics.setColor(Color.white);
		graphics.drawRect((int)15, (int)15, 200,32);
		graphics.drawString("Score "+score, 15, 64);
		graphics.drawString("Level "+level, 15, 80);
		graphics.drawString("Wave : "+wave, 15, 94);
		graphics.drawString("press \"S\" Key to open store", 15, 120);
	}
}