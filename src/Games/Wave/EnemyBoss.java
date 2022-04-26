package Games.Wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBoss extends Objects {
	public static int health=50;
	private Objects player;
	private ComponentHandler handler;
	public EnemyBoss(float x, float y, IDs ids,ComponentHandler handler) {
		super(x, y, ids);
		this.handler=handler;
		for (int i = 0; i < handler.objects.size(); i++) {
			if (handler.objects.get(i).getIDs()==IDs.Player) {
				player=handler.objects.get(i);
			}
		}
	}
	public void tick() {
		x +=speedx;
		y +=speedy;
		float diffX=x-player.getx()-8;
		float diffY=y-player.gety()-8;
		float distance=(float)Math.sqrt((x-player.getx())*(x-player.getx())+(y-player.gety())*(y-player.gety()));
		speedx=(float)(((-1.0/distance)*diffX)*2);
		speedy=(float)(((-1.0/distance)*diffY)*2);
		if (x<=0||x>=Main.width) {
			speedx*=-1;
		}
		if (y<=0||y>=Main.height) {
			speedy*=-1;
		}
	}
	public void render(Graphics graphics) {
		graphics.setColor(new Color(148,0,211));
		graphics.fillRect((int)x, (int)y, 64, 64 );
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,86,86);
	}
}