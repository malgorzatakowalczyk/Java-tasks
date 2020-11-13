
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    PrintWriter output=null;
    BufferedReader input=null;

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start() {
        System.out.println("------------------Client---------------");
        String host = "127.0.0.1";
        int port = 8080;
        try (Socket socket = new Socket(host, port)) {
            output = new PrintWriter(socket.getOutputStream());
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            communicationWithServer();
        } catch (IOException e){
            System.out.println("Blad w poloczeniu z serwerem");
            e.printStackTrace();
        }
    }

    public void communicationWithServer() throws IOException {
        String line = null;
        Scanner scanner = new Scanner(System.in);
        while (!"exit".equalsIgnoreCase(line)) {
            System.out.println("Podaj wiadomosc:");
            line = scanner.nextLine();
            output.println(line);
            output.flush();
            System.out.println("Odpowiedz servera:  " + input.readLine());
        }
        scanner.close();
    }
}
