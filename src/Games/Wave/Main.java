package Games.Wave;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = -651479458338758715L;
	private Thread thread;
	private ComponentHandler handler;
	private HUD hud;
	private LevelCacheSpawn spawner;
	private Manu manu;
	private Shop shop;
	private boolean running=false;
	public static final int width=1300;
	public static final int height=width/12*6;
	public static final String title="Wave";
	float x=0;
	float y=0;
	public enum STATES{
		Manu,
		help,
		End,
		Shop,
		Won,
		Game,
		Exit
	};
	public static STATES gameState=STATES.Manu;
	public Main() {
		handler=new ComponentHandler();
		hud=new HUD();
		manu=new Manu(this,handler,hud);
		shop=new Shop(handler);
		this.addKeyListener(new Input(handler));
		this.addMouseListener(manu);
		this.addMouseListener(shop);
		AudioPlayer.load();
		AudioPlayer.getMusic("Manu_Music").loop();
		new Window(width, height, title, this); 
		hud=new HUD();
		spawner=new LevelCacheSpawn(handler, hud);
		new Random();
	}
	public static void runable() {
		new Main();
	}
	public void run() {
		this.requestFocus();
		long lastTime=System.nanoTime();
		double amountOfTicks=60.0;
		double ns=1000000000/amountOfTicks;
		double delta=0;
		long timer=System.currentTimeMillis();
		int frames=0;
		while(running) {
			long now=System.nanoTime();
			delta +=(now-lastTime)/ns;
			lastTime=now;
			while (delta>=1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;
			if (System.currentTimeMillis()-timer>1000) {
				timer+=1000;
				System.out.println("FPS: "+frames);
				frames=0;
			}
		}
		stop();
	}
	private void render() {
		BufferStrategy bStrategy=this.getBufferStrategy();
		if (bStrategy==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics graphics=bStrategy.getDrawGraphics();
		graphics.setColor(Color.black);
		graphics.fillRect((int)x,(int) y, width, height);
		if (gameState==STATES.Game) {
			handler.render(graphics);
			hud.render(graphics);
		}
		else if (gameState==STATES.Shop) {
			shop.render(graphics);
		}
		else if (gameState==STATES.Manu||gameState==STATES.help||gameState==STATES.End||gameState==STATES.Won) {
			manu.render(graphics);
			handler.render(graphics);
		}
		graphics.dispose();
		bStrategy.show();
	}
	public synchronized void start() {
		thread=new Thread(this);
		thread.start();
		running=true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void tick() {
		if (gameState==STATES.Game) {
			handler.tick();
			hud.tick();
			spawner.tick();
			if(HUD.Health <=0) {
				HUD.Health=100;
				gameState=STATES.End;
				AudioPlayer.getMusic3("GameOver_Music").loop();
				handler.clearEnemys();
			}
		}
		else if (gameState==STATES.Manu||gameState==STATES.End||gameState==STATES.Won) {
			manu.tick();
			handler.tick();
		}
	}
	public static float clamp(float var,float min,float max) {
		if(var>=max) {
			return var=max;
		}
		else if (var<=min) {
			return var=min;
		}
		else {
			return var;
		}
	}
}
