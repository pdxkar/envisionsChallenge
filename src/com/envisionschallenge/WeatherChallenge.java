package com.envisionschallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

//public class WeatherChallenge {
//	public static void main(String[] args) {
//		System.out.println("Enter a zipcode: ");
//		String zipCode = args[0];
//		System.out.println("You entered: " + zipCode + "!");
////        for (String s: args) {
////            System.out.println(s);
////        }
////        System.out.println("Helloxxx World!"); // Display the string.
//    }
//}
 
public class WeatherChallenge {
 
	public static void main(String[] args) {
		System.out.println("Enter a zipcode: ");
		String zipCode = args[0];
		System.out.println("You entered: " + zipCode + "!");
		
		//System.out.println("\nOutput: \n" + callURL("https://cdn.crunchify.com/wp-content/uploads/code/json.sample.txt"));
		System.out.println("\nOutput: \n" + callURL("http://api.openweathermap.org/data/2.5/weather?zip=32003,us&APPID=6581ca66d71dda19bdd5809073d78c5f"));

		
	}
 
	public static String callURL(String myURL) {
		System.out.println("Requeted URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 
 
		return sb.toString();
	}
}
