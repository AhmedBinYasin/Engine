package Games.Wave;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {
	public static Map<String,Music> musicMap= new HashMap<String,Music>();
	public static Map<String,Music> musicMap2= new HashMap<String,Music>();
	public static Map<String,Music> musicMap3= new HashMap<String,Music>();

	public static void load() {
		try {
			musicMap.put("Manu_Music", new Music("Resources/sdxb_intro.ogg"));
			musicMap2.put("Game_Music", new Music("Resources/sdxb_board4.ogg"));
			musicMap3.put("GameOver_Music", new Music("Resources/y8_d301.ogg"));

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	public static Music getMusic2(String key) {
		return musicMap2.get(key);
	}
	public static Music getMusic3(String key) {
		return musicMap3.get(key);
	}
	public static void unload() {
		musicMap.clear();
		musicMap2.clear();
		musicMap3.clear();
	}
}