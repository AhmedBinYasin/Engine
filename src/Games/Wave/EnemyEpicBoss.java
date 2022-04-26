package Games.Wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyEpicBoss extends Objects {
	Random random=new Random();
	ComponentHandler handler;
	public static int life=2000000000;
	public static int time=5000;
	private int timer=60;
	private int timer2=50;
	public EnemyEpicBoss(float x, float y, IDs ids,ComponentHandler handler) {
		super(x, y, ids);
		this.handler=handler;
		speedx=0;
		speedy=2;
	}
	public void tick() {
		time--;
		if (time==0) {
			for (int i = 0; i < handler.objects.size(); i++) {
				Objects tempObjects=handler.objects.get(i);
				if (tempObjects.getIDs()==IDs.EnemyEpicBoss) {
					handler.removeObject(tempObjects);
					time+=1000;
					HUD.score+=1000;
					LevelCacheSpawn.chankCache++;
				}
			}
		}
		x +=speedx;
		y +=speedy;
		if(timer<=0) {
			speedy=0;
		}
		else {
			timer--;
		}
		if (timer<=0) {
			timer2--;
		}
		if (timer2<=0) {
			if (speedx==0) {
				speedx=2;
			}
			if (speedx>0) {
				speedx+=0.005f;
			}
			else if (speedx<0) {
				speedx-=0.005f;
			}
			speedx=Main.clamp(speedx, -10, 10);
			int spawn=random.nextInt(10);
			if (spawn==0) {
				handler.addObject(new Bullet((int)x+48,(int) y+48, IDs.Bulits, handler));
			}
		}
		if (x<=0||x>=Main.width-96) {
			speedx*=-1;
		}
	}
	public void render(Graphics graphics) {
		graphics.setColor(Color.red);
		graphics.fillRect((int)x,(int) y, 96, 96 );
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,96,96);
	}
}