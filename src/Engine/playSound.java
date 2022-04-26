package Engine;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class playSound{
        public Clip clip;

        public playSound(String path) throws IOException, LineUnavailableException, UnsupportedAudioFileException, LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        }
        public void start(){
            clip.start();
        }
        public void start (int loops){
            clip.loop(loops);
        }
        public void stop(){
            clip.stop();
        }

        }
