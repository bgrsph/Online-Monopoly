package ui.animation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundAnimation extends Thread {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 	AudioPlayer MGP = AudioPlayer.player;
		AudioStream BGM;
		AudioData MD;

	//This class plays islem.wav sound, thus I altered its name as "process"soundanimation.
		//orcun
		
	public SoundAnimation() {
		
	}
	
	
	public void playAnimation() {
		try {
			BGM = new AudioStream(new FileInputStream("islem.wav"));
			MGP.start(BGM);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
