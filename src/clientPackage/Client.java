package clientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.InputStream;
public class Client {
	public static void main(String [] args){
		try {
			Socket s =new Socket ("localhost",1234);
			System.out.println("connecte au serveur");
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(System.in);
			  System.out.print(" Entrez un nombre à envoyer au serveur : ");
	            int nb = sc.nextInt();
			os.write(nb);
			 System.out.println("Nombre envoyé au serveur.");
			InputStream i = s.getInputStream();
			int x=i.read();
			System.out.println(" Réponse reçue du serveur : " + x);
		
			s.close();
			sc.close();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
}}
