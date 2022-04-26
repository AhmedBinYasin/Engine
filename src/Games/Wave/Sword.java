package Games.Wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Sword extends Objects {
	private float alpha=1;
	private ComponentHandler handler;
	private Color color;
	private int width;
	private int hight;
	private float life=0.9f;
	public static int swordpoints=0;
	public Sword(float x, float y, IDs ids,ComponentHandler handler, Color color,int width, int hight,HUD hud) {
		super(x, y, ids);
		this.handler=handler;
		this.color=color;
		this.width=width;
		this.hight=hight;
	}
	public void tick() {
		if (alpha>life) {
			alpha-=life-0.0000001f;
		}
		else {
			handler.removeObject(this);
		}
		collision();
	}
	public void render(Graphics graphics) {
		Graphics2D graphics2d=(Graphics2D)graphics;
		graphics2d.setColor(color);
		graphics2d.fillOval((int)x,(int)y-swordpoints, width, hight+swordpoints);
	}
	public Rectangle getBounds() {	
		return new Rectangle((int)x,(int)y-swordpoints,8,32+swordpoints);
	}
	private void collision() {
		for (int i = 0; i < handler.objects.size(); i++) {
			Objects tempObjects=handler.objects.get(i);
			if (tempObjects.getIDs()==IDs.EnemyBasic||tempObjects.getIDs()==IDs.EnemyMedium||tempObjects.getIDs()==IDs.EnemyHard||tempObjects.getIDs()==IDs.EnemyBoss||tempObjects.getIDs()==IDs.Bulits) {
				if (getBounds().intersects(tempObjects.getBounds())) {
					if (tempObjects.getIDs()==IDs.EnemyBasic) {
						handler.removeObject(tempObjects);
						HUD.score+=10;
						LevelCacheSpawn.enemyKilled++;
					}
					if (tempObjects.getIDs()==IDs.Bulits) {
						handler.removeObject(tempObjects);
						HUD.score+=10;
					}
					if (tempObjects.getIDs()==IDs.EnemyMedium) {

						EnemyMedium.health--;
						if(EnemyMedium.health==0) {
							handler.removeObject(tempObjects);
							HUD.score+=25;
							LevelCacheSpawn.enemyKilled++;
							EnemyMedium.health=10;
						}
					}
					if (tempObjects.getIDs()==IDs.EnemyHard) {
						EnemyHard.health--;
						if(EnemyHard.health==0) {
							handler.removeObject(tempObjects);
							HUD.score+=100;
							LevelCacheSpawn.enemyKilled++;
							EnemyHard.health=50;
						}
					}
					if (tempObjects.getIDs()==IDs.EnemyBoss) {
						EnemyBoss.health--;
						if(EnemyBoss.health==0) {
							handler.removeObject(tempObjects);
							HUD.score+=500;
							LevelCacheSpawn.enemyKilled++;
							EnemyBoss.health=200;
						}
					}
					if (tempObjects.getIDs()==IDs.EnemyEpicBoss) {
						EnemyEpicBoss.life--;
						if(EnemyEpicBoss.life==0) {
							handler.removeObject(tempObjects);
							HUD.score+=10000;
							LevelCacheSpawn.enemyKilled++;
							EnemyEpicBoss.life=2000000000;
							
						}
					}
				}
			}
		}
	}
}
