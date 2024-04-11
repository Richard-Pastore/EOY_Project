import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class Sound

{

public void playmusic(String musicfile) {
File soundFile = new File(musicfile);
try {
Clip clip = AudioSystem.getClip();
AudioInputStream inputStream=
AudioSystem.getAudioInputStream(soundFile);
clip.open(inputStream);
clip.loop(clip.LOOP_CONTINUOUSLY);
clip.start();
}
catch(Exception e)
{

System.out.println(e);
}
}

public void playmusic1(String musicfile) {
    try {
        File soundFile = new File(musicfile);
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
        clip.open(inputStream);

        // Add a listener to close the Clip after it stops playing
        clip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                clip.close();
            }
        });

        clip.start();
    } catch (Exception e) {
        System.out.println(e);
    }
}
}

 