package Games.Wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyMedium extends Objects {
	public static int health=10;
	public EnemyMedium(float x, float y, IDs ids) {
		super(x, y, ids);
		speedx=5;
		speedy=2;
	}
	public void tick() {
		x +=speedx;
		y +=speedy;
		if (x<=0||x>=Main.width) {
			speedx*=-1;
		}
		if (y<=0||y>=Main.height) {
			speedy*=-1;
		}
	}
	public void render(Graphics graphics) {
		graphics.setColor(Color.cyan);
		graphics.fillRect((int)x,(int) y, 32, 32 );
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
}