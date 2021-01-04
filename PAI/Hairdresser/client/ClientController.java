package client;

import common.Action;
import common.Data;

import java.io.IOException;
import java.net.Socket;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ClientController {

    @FXML
    private Button book;
    @FXML
    private ListView<Label> hoursList;
    @FXML
    private TextField textName;

    @FXML
    private void clickReserve() {
        try {
            reserve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String clientInfo = null, time = null;
    private ClientConnect clientThread = null;

    public void initialize(String client, ClientConnect controller) {

        this.clientInfo = client;
        this.clientThread = controller;
        book.setStyle("-fx-background-color: greenyellow;");
        textName.setText(client);
        for (int hour = 10; hour < 19; hour++) {
            Label l = new Label(String.format("%d:00", hour));
            this.hoursList.getItems().add(l);
        }
    }

    private void reserve() throws IOException {
        if (this.time == null) {
            Label selectedRow = this.hoursList.getSelectionModel().getSelectedItem();
            if (selectedRow != null) {
                String selectedTime = selectedRow.getText();
                if (selectedTime.contains("-")) {
                    new Alert(AlertType.ERROR, "Termin jest zajety").show();
                } else {
                    this.clientThread.makeAnAppointment(this.clientInfo, selectedTime);
                    this.book.setText("ANULUJ");
                    this.book.setStyle("-fx-background-color: red;");
                    this.time = selectedTime;
                }
            } else {
                new Alert(AlertType.ERROR, "Wybierz interesujacy cie termin").show();
            }
        } else {
            this.book.setText("REZERWUJ");
            this.book.setStyle("-fx-background-color: greenyellow;");
            this.clientThread.cancelAppointment(this.clientInfo, this.time);
            this.time = null;
        }
    }

    public void addClient(String client, String time) {
        ObservableList<Label> clientList = this.hoursList.getItems();
        for (Label row : clientList) {
            if (textName.getText().equals(client) && row.getText().contains(time)) {
                row.setText(String.format("%s- %s", row.getText(), client));
            } else {
                if (row.getText().contains(time)) {
                    row.setText(String.format("%s- %s", row.getText(), "Termin jest zajety"));
                }
            }
        }
    }

    public void deleteClient(String client, String time) {
        ObservableList<Label> clientList = this.hoursList.getItems();
        for (Label row : clientList) {
            if (time != null) {
                if (row.getText().contains(String.format("%s- %s", time, client))) {
                    row.setText(String.format("%s", time));
                }
                if (row.getText().contains(String.format("%s- %s", time, "Termin jest zajety"))) {
                    row.setText(String.format("%s", time));
                }
            }
        }
    }
}

class ClientConnect extends Thread {

    public static int PORT = 5000;
    public static String HOST = "127.0.0.1";

    private Socket clientSocket = null;
    private Action controller = null;
    private ClientController appController = null;

    public ClientConnect(ClientController controller) throws IOException {
        this.appController = controller;
        this.clientSocket = new Socket(HOST, PORT);
        this.controller = new Action(this.clientSocket);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Data bookInfo = this.controller.messageController();
                if (bookInfo != null) {
                    if (bookInfo.getMessageType().equals("REZERWUJ")) {
                        if (bookInfo.getSuccess()) {
                            Platform.runLater(() -> {
                                this.appController.addClient(bookInfo.getFullName(), bookInfo.getTime());
                            });
                        }
                    } else if (bookInfo.getMessageType().equals("ANULUJ")) {
                        if (bookInfo.getSuccess()) {
                            Platform.runLater(() -> {
                                this.appController.deleteClient(bookInfo.getFullName(), bookInfo.getTime());
                            });
                        }
                    }
                }
            } catch (IOException e) {
                try {
                    if (clientSocket != null) {
                        clientSocket.close();
                    }
                    return;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

    public void makeAnAppointment(String clientInfo, String time) throws IOException {
        this.controller.orderVisit(clientInfo, time);
    }

    public void cancelAppointment(String clientInfo, String time) throws IOException {
        this.controller.cancelVisit(clientInfo, time);
    }

    public void addClient(String clientInfo) throws IOException {
        this.controller.addClient(clientInfo);
    }

}
