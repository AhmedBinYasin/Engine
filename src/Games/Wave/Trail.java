package Games.Wave;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends Objects {
	private float alpha=1;
	private ComponentHandler handler;
	private Color color;
	private int width;
	private int hight;
	private float life;
	public Trail(float x, float y, IDs ids,float life,ComponentHandler handler, Color color,int width, int hight) {
		super(x, y, ids);
		this.handler=handler;
		this.color=color;
		this.width=width;
		this.hight=hight;
		this.life=life;
	}
	public void tick() {
		if (alpha>life) {
			alpha-=life-0.005f;
		}
		else {
			handler.removeObject(this);
		}
	}
	public void render(Graphics graphics) {
		Graphics2D graphics2d=(Graphics2D)graphics;
		graphics2d.setComposite(transperancy(alpha));
		graphics.setColor(color);
		graphics.fillRect((int)x,(int) y, width, hight);
		graphics2d.setComposite(transperancy(1));
	}
	public Rectangle getBounds() {
		return null;
	}
	private AlphaComposite transperancy(float alpha) {
		int type=AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
}