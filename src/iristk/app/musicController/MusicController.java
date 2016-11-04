package iristk.app.musicController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MusicController {
	
	private String url;
	
	public MusicController(String url) throws Exception {
		this.url = url;
	}
	
	private String _getUrl(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
	   }
	
	private String _controlMusic(String command) {
		try {
			return _getUrl("http://" + this.url + "/" + command);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
			return "Error";
		}
	}
	
	public void play(){
		_controlMusic("play");
	}
	
	public void play(String song) {
		_controlMusic("play/" + song);
	}
	
	public void pause() {
		_controlMusic("pause");
	}
	
	public String status() {
		return _controlMusic("status");
	}
	
}
