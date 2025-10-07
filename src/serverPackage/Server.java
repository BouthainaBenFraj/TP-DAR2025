package serverPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

public class Server {
	public static void main(String [] args) {
	ServerSocket serveur;
	try {
		serveur = new ServerSocket(1234);
		Socket socket =serveur.accept();
		System.out.println("client connecte/requete reçue");
		InputStream i = socket.getInputStream();
		int x=i.read();
		x*=5;
		OutputStream os =socket.getOutputStream();
		os.write(x);
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	

}}
