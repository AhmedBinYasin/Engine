package Games.Wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bullet extends Objects {
	Random random=new Random();
	ComponentHandler handler;
	public Bullet(float x, float y, IDs ids,ComponentHandler handler) {
		super(x, y, ids);
		this.handler=handler;
		speedx=random.nextInt(5- -5)+-5;
		speedy=5;
	}
	public void tick() {
		x +=speedx;
		y +=speedy;
		if(y>=Main.height) {
			handler.removeObject(this);
		}
		/*if (x<=0||x>=Main.width) {
			speedx*=-1;
		}*/
	}
	public void render(Graphics graphics) {
		graphics.setColor(Color.orange);
		graphics.fillRect((int)x,(int) y, 16, 16 );
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
}