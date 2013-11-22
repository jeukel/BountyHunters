package edu.itcr.bountyhunters;

import java.net.*;
import java.io.*;

public class client {

	Socket client;		//Creates communication tunnel
	int port = 61000;	//Selects a port
	String ip = "192.168.0.100";	//Sets ip to connect to
	BufferedReader input;	//Stream used as input
	PrintStream output;	//Stream used as output

	public void start(){
		try{
			//Connect to server ip connection on a specific port
			client = new Socket(ip, port);

			//Establish object used to store answer from server
			input = new BufferedReader
					(new InputStreamReader(client.getInputStream()));
			
			//Establish ongoing stream
			output = new PrintStream(client.getOutputStream());
			//send request to server
			output.println(hunter);
			
			String responce = input.readLine();
			
			
			input.close();
			output.close();
			client.close();
			
			
		} catch(Exception e){}
	}
	
}
