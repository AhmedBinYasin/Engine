package Games.Wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends Objects {
	Random random=new Random();
	ComponentHandler handler;
	HUD hud;
	public Player(float x, float y, IDs ids,ComponentHandler handler,HUD hud) {
		super(x, y, ids);
		this.handler=handler;
		this.hud=hud;
	}
	public void tick() {
		x+=speedx;
		y+=speedy;
		x=Main.clamp(x,0, Main.width-37);
		y=Main.clamp(y,0, Main.width-64);
		collision();
	    handler.addObject(new Trail(x+8, y+8, IDs.Trail, 0.03f, handler, Color.yellow, 16, 16));
	    handler.addObject(new Sword(x+11, y-30, IDs.Sword, handler, Color.blue, 8, 32,hud));
	}
	private void collision() {
		for (int i = 0; i < handler.objects.size(); i++) {
			Objects tempObjects=handler.objects.get(i);
			if (tempObjects.getIDs()==IDs.EnemyBasic||tempObjects.getIDs()==IDs.EnemyMedium||tempObjects.getIDs()==IDs.Bulits) {
				if (getBounds().intersects(tempObjects.getBounds())) {
					HUD.Health-=2;
				}
			}
			if (tempObjects.getIDs()==IDs.EnemyHard||tempObjects.getIDs()==IDs.EnemyBoss) {
				if (getBounds().intersects(tempObjects.getBounds())) {
					HUD.Health-=4;
				}
			}
			if (tempObjects.getIDs()==IDs.EnemyEpicBoss) {
				if (getBounds().intersects(tempObjects.getBounds())) {
					HUD.Health-=10;
				}
			}
		}
	}
	public void render(Graphics graphics) {
		graphics.setColor(Color.white);
		graphics.fillRect((int)x,(int)y, 32, 32);
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
}
