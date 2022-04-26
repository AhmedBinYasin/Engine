package Games.Wave;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import Games.Wave.Main.STATES;

public class Manu extends MouseAdapter{
	private Main main;
	private ComponentHandler handler;
	private HUD hud;
	private Random random=new Random();
	public Manu(Main main,ComponentHandler handler,HUD hud) {
		this.main=main;
		this.handler=handler;
	}
	public void mousePressed(MouseEvent mEvent) {
		int mousex=mEvent.getX();
		int mousey=mEvent.getY();
		if(main.gameState==STATES.Manu) {
			if(mouseOver(mousex, mousey, 500, 100, 300, 64)) {
				main.gameState=STATES.Game;
				AudioPlayer.getMusic2("Game_Music").loop();
				handler.addObject(new Player((Main.width/2-32)-50,(Main.height/2-32)-50, IDs.Player,handler,hud));
				for (int i = 0; i < 10; i++) {
					handler.addObject(new EnemyBasic(random.nextInt(Main.width-250),random.nextInt(Main.height-150), IDs.EnemyBasic));
				}
			}
			if (mouseOver(mousex, mousey, 500, 250, 300, 64)) {
				main.gameState=STATES.help;
			}
			if(mouseOver(mousex, mousey, 500, 400, 300, 64)) {
				if (main.gameState==STATES.Manu) {
					AudioPlayer.getMusic("Manu_Music").pause();
				}
				else if (main.gameState==STATES.Game||main.gameState==STATES.Shop) {
					AudioPlayer.getMusic2("Game_Music").pause();
				}
				else {
					AudioPlayer.getMusic3("GameOver_Music").pause();
				}
				main.gameState=STATES.Exit;
				Window.frame.dispose();
			}
		}
		if(main.gameState==STATES.help) {
			if (mouseOver(mousex, mousey, 500, 500, 300, 64)) {
				main.gameState=STATES.Manu;
				return;
			}
		}
		if(main.gameState==STATES.End||main.gameState==STATES.Won) {
			if (mouseOver(mousex, mousey, 500, 500, 300, 64)) {
				main.gameState=STATES.Manu;
				AudioPlayer.getMusic("Manu_Music").loop();
				HUD.score=0;
				HUD.level=1;
				return;
			}
		}
		if(main.gameState==STATES.Exit) {
			handler.clearEnemys();
		}
	}
	public void mouseReleased(MouseEvent mEvent) {
	}
	private boolean mouseOver(int mousex,int mousey,int x,int y,int width,int hight) {
		if (mousex>x&&mousex<x+width) {
			if (mousey>y&&mousey<y+hight) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public void tick() {
	}
	public void render(Graphics graphics) {
		if (main.gameState==STATES.Manu) {
			Font font=new Font("arial", 1, 50);
			graphics.setFont(font);
			graphics.setColor(Color.white);
			graphics.drawString("Manu", 590, 70);
			graphics.drawRect(500, 100, 300, 64);
			graphics.drawString("Play", 600, 150);
			graphics.drawRect(500, 250, 300, 64);
			graphics.drawString("Help", 600, 300);
			graphics.drawRect(500, 400, 300, 64);
			graphics.drawString("Quit", 600, 450);
		}
		else if (main.gameState==STATES.help) {
			Font font=new Font("arial", 1, 50);
			graphics.setFont(font);
			graphics.setColor(Color.white);
			graphics.drawString("Help", 590, 70);
			Font font2=new Font("arial", 1, 20);
			graphics.setFont(font2);
			graphics.drawString("Use arrow keys to move", 400, 100);
			graphics.drawString("hunt down enemys using your weapon", 400, 200);
			graphics.setFont(font);
			graphics.drawRect(500, 500, 300, 64);
			graphics.drawString("Back", 600, 550);
		}
		else if (main.gameState==STATES.End) {
			Font font=new Font("arial", 1, 50);
			graphics.setFont(font);
			graphics.setColor(Color.white);
			graphics.drawString("Game Over", 500, 70);
			Font font2=new Font("arial", 1, 20);
			graphics.setFont(font2);
			graphics.drawString("You lost with the score of : "+HUD.score, 500, 300);
			graphics.drawRect(500, 500, 300, 64);
			graphics.drawString("Main Manu", 610, 535);
		}
		else if (main.gameState==STATES.Won) {
			Font font=new Font("arial", 1, 50);
			graphics.setFont(font);
			graphics.setColor(Color.white);
			graphics.drawString("Game Over", 500, 70);
			Font font2=new Font("arial", 1, 20);
			graphics.setFont(font2);
			graphics.drawString("You win with the score of : "+HUD.score, 500, 300);
			graphics.drawRect(500, 500, 300, 64);
			graphics.drawString("Main Manu", 610, 535);
		}
	}
}
