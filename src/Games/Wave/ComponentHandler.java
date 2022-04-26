package Games.Wave;

import java.awt.Graphics;
import java.util.LinkedList;

public class ComponentHandler {
	LinkedList<Objects> objects=new LinkedList<Objects>();
	public int playerSpeed=5;
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			Objects tempObjects=objects.get(i);
			tempObjects.tick();
		}
	}
	public void render (Graphics graphics) {
		for (int i = 0; i < objects.size(); i++) {
			Objects tempObjects=objects.get(i);
			tempObjects.render(graphics);
		}
	}
	public void addObject(Objects objects) {
		this.objects.add(objects);
	}
	public void removeObject(Objects objects) {
		this.objects.remove(objects);
	}
	public void clearEnemys() {
		for (int i = 0; i < objects.size(); i++) {
			Objects tempObjects=objects.get(i);
			if (tempObjects.getIDs()==IDs.Player) {
				//removeObject(tempObjects);
			//	i--;
				objects.clear();
			//	addObject(new Player((int)tempObjects.getx(),(int)tempObjects.gety(),IDs.Player,this));
			}
		}
	}
}
