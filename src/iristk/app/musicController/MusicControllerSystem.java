/*******************************************************************************
 * Copyright (c) 2014 Gabriel Skantze.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Gabriel Skantze - initial API and implementation
 ******************************************************************************/
package iristk.app.musicController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import iristk.speech.SpeechGrammarContext;
import iristk.speech.Voice.Gender;
import iristk.speech.windows.WindowsRecognizerFactory;
import iristk.speech.windows.WindowsSynthesizer;
import iristk.system.IrisUtils;
import iristk.system.SimpleDialogSystem;
import iristk.util.Language;
import iristk.cfg.SRGSGrammar;
import iristk.flow.FlowModule;

public class MusicControllerSystem {
	
	public MusicControllerSystem() throws Exception {
		
		// Create the system
		SimpleDialogSystem system = new SimpleDialogSystem(this.getClass());
		
		// Set the language of the system
		system.setLanguage(Language.ENGLISH_US);
		
		// Uncomment this if you want to turn on logging
		//system.setupLogging(new File("c:/iristk_logging"), true);
		
		// Set up the GUI
		system.setupGUI();
		
		// Add the recognizer to the system
		system.setupRecognizer(new WindowsRecognizerFactory());
		
		// Add a synthesizer to the system		
		system.setupSynthesizer(new WindowsSynthesizer(), Gender.FEMALE);
		
		// Add the music controller
		
		MusicController musicController = new MusicController("192.168.0.3:3000");
		
		// Add the flow
		system.addModule(new FlowModule(new MusicControllerFlow(
			musicController
		)));
		
		// Load a grammar in the recognizer
		system.loadContext("default", new SpeechGrammarContext(new SRGSGrammar(system.getPackageFile("MusicControllerGrammar.xml"))));
		
		// Start the interaction
		system.sendStartSignal();
	}

	public static void main(String[] args) throws Exception {
		new MusicControllerSystem();
	}

}
