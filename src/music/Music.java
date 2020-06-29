package music;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JApplet;

import control.GameRunning;

public class Music {

	private List<AudioClip> au = new ArrayList<AudioClip>();

	private AudioClip gameMusic;

	
	public Music() {
		try {
			
			File file = new File("music_src/1.wav");
			URL url = file.toURL();
			AudioClip ac = Applet.newAudioClip(url);
			au.add(ac);
			
			file = new File("music_src/2.wav");
			url = file.toURL();
			ac = Applet.newAudioClip(url);
			au.add(ac);
			
			file = new File("music_src/3.wav");
			url = file.toURL();
			ac = Applet.newAudioClip(url);
			au.add(ac);
			
			file = new File("music_src/win.wav");
			url = file.toURL();
			ac = Applet.newAudioClip(url);
			au.add(ac);
			
			file = new File("music_src/lose.wav");
			url = file.toURL();
			ac = Applet.newAudioClip(url);
			au.add(ac);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		gameMusic = au.get(GameRunning.MAP - 1);
		if (gameMusic != null) {
			gameMusic.loop();
		}
	}
	public void gameOver() { 
		if (gameMusic != null) {
			gameMusic.stop();
		}
		au.get(4).play();
	}
}
