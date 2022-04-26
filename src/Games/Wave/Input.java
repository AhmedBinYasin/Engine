package Games.Wave;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Games.Wave.Main.STATES;

public class Input extends KeyAdapter {
	private boolean[] keyDown=new boolean[4];
	private ComponentHandler handler;
	public Input(ComponentHandler handler) {
		this.handler=handler;
		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
	}
	public void keyPressed(KeyEvent event) {
		int key=event.getKeyCode();
		for (int i = 0; i < handler.objects.size(); i++) {
			Objects tempObjects=handler.objects.get(i);
			if (tempObjects.getIDs()==IDs.Player) {
				//P1
				if (key==KeyEvent.VK_UP) {
					tempObjects.setSpeedY(-handler.playerSpeed);
					keyDown[0]=true;
				}
				if (key==KeyEvent.VK_DOWN) {
					tempObjects.setSpeedY(handler.playerSpeed);
					keyDown[1]=true;
				}
				if (key==KeyEvent.VK_RIGHT) {
					tempObjects.setSpeedX(handler.playerSpeed);
					keyDown[2]=true;
				}
				if (key==KeyEvent.VK_LEFT) {
					tempObjects.setSpeedX(-handler.playerSpeed);
					keyDown[3]=true;
				}
			}
		}
		if (key==KeyEvent.VK_S) {
			if (Main.gameState==STATES.Game) {
				Main.gameState=STATES.Shop;
			}
			else if (Main.gameState==STATES.Shop) {
				Main.gameState=STATES.Game;
			}
		}
	}
	public void keyReleased(KeyEvent event) {
		int key=event.getKeyCode();
		for (int i = 0; i < handler.objects.size(); i++) {
			Objects tempObjects=handler.objects.get(i);
			if (tempObjects.getIDs()==IDs.Player) {
				//P1
				if (key==KeyEvent.VK_UP) {
					//tempObjects.setSpeedY(0);
					keyDown[0]=false;
				}
				if (key==KeyEvent.VK_DOWN) {
					//tempObjects.setSpeedY(0);
					keyDown[1]=false;
				}
				if (key==KeyEvent.VK_RIGHT) {
					//tempObjects.setSpeedX(0);
					keyDown[2]=false;
				}
				if (key==KeyEvent.VK_LEFT) {
					//tempObjects.setSpeedX(0);
					keyDown[3]=false;
				}
				if (!keyDown[0]&&!keyDown[1]) {
					tempObjects.setSpeedY(0);
				}
				if (!keyDown[2]&&!keyDown[3]) {
					tempObjects.setSpeedX(0);
				}
			}
		}
	}
}
