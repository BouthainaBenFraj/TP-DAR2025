package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez l'adresse IP du serveur : ");
            String ipServeur = scanner.nextLine();
            int port = 5000;
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ipServeur, port));
            System.out.println("Connecté au serveur : " + ipServeur);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("\n=== CALCULATRICE ===");
            System.out.println("1. Addition (+)");
            System.out.println("2. Soustraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.print("Choisissez une opération (1-4) : ");
            String choix = scanner.nextLine();
            System.out.print("Entrez le premier nombre : ");
            double x = scanner.nextDouble();
            System.out.print("Entrez le deuxième nombre : ");
            double y = scanner.nextDouble();
            out.println(choix);
            out.println(x);
            out.println(y);
            String resultat = in.readLine();
            System.out.println("\n" + resultat);
            socket.close();
            System.out.println("Connexion fermée.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
