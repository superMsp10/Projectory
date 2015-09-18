package game.sounds;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static Sound SMSL = new Sound("/soundFiles/some more some less.wav");
	public AudioClip clip;

	public Sound(String name) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(name));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			new Thread() {
				public void run() {
					clip.play();
				}
			}.start();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}