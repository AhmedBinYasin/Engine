package Games.Wave;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Games.Wave.Main.STATES;

public class Shop extends MouseAdapter {
	private ComponentHandler handler;
	private int priceHealthUpgrade=30;
	private int priceSwordUpgrade=50;
	private int priceSpeedUpgrade=70;
	private int priceRefillHealth=200;
	private int priceplayerUpgrade1=1000;
	private int priceplayerUpgrade2=1000;
	private int healthLevel=1;
	private int speedLevel=1;
	private int swordLevel=1;
	private String playerRole="Swords Man";
	public Shop(ComponentHandler handler) {
		this.handler=handler;
	}
	public void render(Graphics graphics) {
		graphics.setColor(Color.white);
		graphics.setFont(new Font("arial", 0, 48));
		graphics.drawString("Shop", 590, 70);
		graphics.setFont(new Font("arial", 0, 15));
		graphics.drawRect(200, 100, 300, 64);
		graphics.drawString("Health Upgrade : "+priceHealthUpgrade, 300, 130);
		graphics.drawRect(200, 250, 300, 64);
		graphics.drawString("Sword Upgrade : "+priceSwordUpgrade, 300, 280);
		graphics.drawRect(200, 400, 300, 64);
		graphics.drawString("Speed Upgrade : "+priceSpeedUpgrade, 300, 430);
		graphics.drawRect(700, 100, 300, 64);
		graphics.drawString("Refill Health : "+priceRefillHealth, 800, 130);
		graphics.drawRect(700, 250, 300, 64);
		graphics.drawString("player Upgrade 1(duelist) : "+priceplayerUpgrade1, 750, 280);
		graphics.drawRect(700, 400, 300, 64);
		graphics.drawString("Player Upgrade 2(Gunner) : "+priceplayerUpgrade2, 750, 430);
		graphics.setFont(new Font("arial", 0, 48));
		graphics.drawString("Score : "+HUD.score, 580, 550);
		graphics.setFont(new Font("arial", 0, 15));
		graphics.drawString("press \"S\" Key to go back to game", 570, 600);
		graphics.drawString("Player Health Level : "+healthLevel,900, 500);
		graphics.drawString("Player Speed Level : "+speedLevel,900, 500+15);
		graphics.drawString("Sword Level : "+swordLevel,900, 500+30);
		graphics.drawString("Player Role : "+playerRole,900, 500+45);
	}
	public void mousePressed(MouseEvent event) {
		int mousex=event.getX();
		int mousey=event.getY();
		if(Main.gameState==STATES.Shop) {
			if (mousex>=200&&mousex<=500) {
				if (mousey>=100&&mousey<=164) {
					if (HUD.score>=priceHealthUpgrade) {
						HUD.score-=priceHealthUpgrade;
						priceHealthUpgrade*=2;
						healthLevel++;
						HUD.MaxHealth+=100;
						HUD.Health+=100;
						HUD.healthLevel=healthLevel;
					}
				}
			}
			if (mousex>=200&&mousex<=500) {
				if (mousey>=250&&mousey<=314) {
					if (HUD.score>=priceSwordUpgrade) {
						HUD.score-=priceSwordUpgrade;
						priceSwordUpgrade*=2;
						swordLevel++;
						Sword.swordpoints=swordLevel*4;
					}
				}
			}
			if (mousex>=200&&mousex<=500) {
				if (mousey>=400&&mousey<=464) {
					if (HUD.score>=priceSpeedUpgrade) {
						HUD.score-=priceSpeedUpgrade;
						priceSpeedUpgrade*=2;
						speedLevel++;
						handler.playerSpeed++;
					}
				}
			}
			if (mousex>=700&&mousex<=1000) {
				if (mousey>=100&&mousey<=164) {
					if (HUD.score>=priceRefillHealth) {
						HUD.score-=priceRefillHealth;
						priceRefillHealth+=200;
						HUD.Health=HUD.MaxHealth;
					}
				}
			}
			if (mousex>=700&&mousex<=1000) {
				if (mousey>=250&&mousey<=314) {
					if (HUD.score>=priceplayerUpgrade1) {
					//	HUD.score-=priceplayerUpgrade1;
					//	playerRole="Dulist";
					}
				}
			}
			if (mousex>=700&&mousex<=1000) {
				if (mousey>=400&&mousey<=464) {
					if (HUD.score>=priceplayerUpgrade2) {
					//	HUD.score-=priceplayerUpgrade2;
					//	playerRole="Gunner";
					}
				}
			}
		}
	}
}
