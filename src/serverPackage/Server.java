package serverPackage;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        try {
            InetAddress ipServeur = InetAddress.getLocalHost();
            int port = 5000;
            System.out.println("Adresse IP du serveur : " + ipServeur.getHostAddress());
            System.out.println("Serveur en attente sur le port " + port + "...");
            ServerSocket serveurSocket = new ServerSocket();
            serveurSocket.bind(new InetSocketAddress(ipServeur, port));
            Socket socket = serveurSocket.accept();
            System.out.println("Client connecté : " + socket.getInetAddress().getHostAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String operation = in.readLine();
            double x = Double.parseDouble(in.readLine());
            double y = Double.parseDouble(in.readLine());
            double resultat = 0;
            switch (operation) {
                case "1": resultat = x + y; break;
                case "2": resultat = x - y; break;
                case "3": resultat = x * y; break;
                case "4": 
                    if (y != 0)
                        resultat = x / y; 
                    else {
                        out.println("Erreur : division par zéro !");
                        socket.close();
                        serveurSocket.close();
                        return;
                    }
                    break;
                default:
                    out.println("Opération invalide !");
                    socket.close();
                    serveurSocket.close();
                    return;
            }
            out.println("Résultat = " + resultat);
            System.out.println("Calcul effectué : " + x + " " + operation + " " + y + " = " + resultat);
            socket.close();
            serveurSocket.close();
            System.out.println("Serveur fermé.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
