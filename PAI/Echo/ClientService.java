
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientService implements Runnable {

    private Socket client;
    PrintWriter output = null;
    BufferedReader input = null;

    public ClientService(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            output = new PrintWriter(client.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            printMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printMessage() throws IOException {
        String line;
        while ((line = input.readLine()) != null) {
            System.out.printf("Wiadomosc %s\n", line);
            output.println(line);
        }
    }
}
