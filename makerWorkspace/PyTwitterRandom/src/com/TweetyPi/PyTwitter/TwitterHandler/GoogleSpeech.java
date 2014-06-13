package com.TweetyPi.PyTwitter.TwitterHandler;

import java.io.IOException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;

public class GoogleSpeech {
	
	public void textToSpeech(String data) throws JavaLayerException  {
		Audio audio = Audio.getInstance();
		InputStream sound ;
			try {
				sound = audio.getAudio(data, Language.ENGLISH);
				audio.play(sound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("");
			}
			
	}
	
	public static void main(String[] args) throws JavaLayerException, IOException {
	}
}