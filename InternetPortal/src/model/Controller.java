package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.ejb.Stateless;


@Stateless
public class Controller {

	public String dnatTest(String port, String ip){
		try{
		
			Socket connect = new Socket(ip, Integer.parseInt(port));	
			BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			String line;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null){
				sb.append(line + System.lineSeparator());
			}
			connect.close();
			return sb.toString();

		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		return "No response";
	}
}
