package Games.Wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBasic extends Objects {
	public EnemyBasic(float x, float y, IDs ids) {
		super(x, y, ids);
		speedx=5;
		speedy=0;
	}
	public void tick() {
		x +=speedx;
		y +=speedy;
		if (x<=0||x>=Main.width) {
			speedx*=-1;
		}
	}
	public void render(Graphics graphics) {
		graphics.setColor(Color.red);
		graphics.fillRect((int)x,(int) y, 16, 16 );
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
}
