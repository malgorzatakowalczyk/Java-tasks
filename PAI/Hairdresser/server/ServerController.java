package server;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController implements Initializable {

    @FXML
    private ListView<Label> hoursList;
    private Connect request = null;

    public ServerController() {
        request = new Connect(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.request.start();
        for (int i = 10; i < 19; i++) {
            Label logLabel = new Label(String.format("%d:00", i));
            this.hoursList.getItems().add(logLabel);
        }
    }

    public void addClientToList(String client, String time) {
        ObservableList<Label> currentList = this.hoursList.getItems();
        for (Label l : currentList) {
            if (l.getText().contains(time)) {
                l.setText(String.format("%s- %s", l.getText(), client));
            }
        }
    }

    public void deleteClientFromList(String client, String time) {
        ObservableList<Label> currentList = this.hoursList.getItems();
        for (Label l : currentList) {
            if (time != null) {
                if (l.getText().contains(String.format("%s- %s", time, client))) {
                    l.setText(String.format("%s", time));
                }
            } else {
                if (l.getText().contains(client)) {
                    String format = String.format("- %s", client);
                    l.setText(l.getText().replace(format, ""));
                }
            }
        }
    }

}

class Connect extends Thread {

    public static int PORT = 5000;
    public static String HOST = "127.0.0.1";
    private ServerController controller = null;
    private CollectData collector = null;

    public Connect(ServerController controller) {
        this.controller = controller;
        this.collector = new CollectData();
    }

    @Override
    public void run() {
        ServerSocket server = null;
        Socket clientSocket = null;
        try {
            server = new ServerSocket(PORT);
            while (true) {
                clientSocket = server.accept();
                ServerConnect serverThread = new ServerConnect(clientSocket, controller, collector);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
