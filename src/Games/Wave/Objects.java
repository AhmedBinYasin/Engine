package Games.Wave;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Objects {
	protected float x,y;
	protected IDs ids;
	protected float speedx,speedy;
	public Objects(float x,float y,IDs ids) {
		this.x=x;
		this.y=y;
		this.ids=ids;
	}
	public abstract void tick();
	public abstract void render(Graphics graphics);
	public abstract Rectangle getBounds();
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public float getx() {
		return x;
	}
	public float gety() {
		return y;
	}
	public void setIDs(IDs iDs) {
		this.ids=iDs;
	}
	public IDs getIDs() {
		return ids;
	}
	public void setSpeedX(int speedx) {
		this.speedx=speedx;
	}
	public void setSpeedY(int speedy) {
		this.speedy=speedy;
	}
	public float getSpeedX() {
		return speedx;
	}
	public float getySpeedY() {
		return speedy;
	}

}
