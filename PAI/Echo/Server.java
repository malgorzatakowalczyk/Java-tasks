import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server{
    public static void main(String[] args){
        Server server = new Server();
        server.start();
    }
    public void start(){
        System.out.println("-----------------Server----------------");
        ServerSocket server = null;
        System.out.println("Oczekiwanie na klientow");
        try{
            server = new ServerSocket(8080);
            server.setReuseAddress(true);
            clientThread(server);
        }catch(IOException e){
            System.out.println("IOException occured: " + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                server.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public void clientThread(ServerSocket server) throws IOException{
        while(true){
            Socket client = server.accept();
            System.out.println("Polaczono z klientem " + client.getInetAddress().getHostAddress());
            ClientService clientSocket = new ClientService(client);
            new Thread(clientSocket).start();
        }
    }
}
