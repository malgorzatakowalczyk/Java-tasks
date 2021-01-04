package client;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private Button connectWithClientController;

    @FXML
    private void click() {
        try {
            loginToServer();
        } catch (IOException except) {
            new Alert(AlertType.ERROR, "Problem z polaczeniem").show();
            return;
        }
    }

    public void initialize() {
    }

    public void loginToServer() throws IOException {
        String clientName = name.getText();
        String clientSurname = surname.getText();

        if (clientName.length() == 0) {
            new Alert(AlertType.ERROR, "Podaj imie").show();
            return;
        }
        if (clientSurname.length() == 0) {
            new Alert(AlertType.ERROR, "Podaj nazwisko").show();
            return;
        }
        FXMLLoader newLoader = new FXMLLoader(getClass().getResource("FXMLClient.fxml"));
        Parent root = (Parent) newLoader.load();
        Stage newStage = new Stage();
        newStage.setMinWidth(500);
        newStage.setMaxWidth(500);
        newStage.setMinHeight(400);
        newStage.setMaxHeight(400);
        newStage.setTitle("Klient");
        newStage.setScene(new Scene(root));
        newStage.setOnCloseRequest(e -> System.exit(0));

        String clientInfo = String.format("%s %s", clientName, clientSurname);
        ClientController controller = (ClientController) newLoader.getController();
        ClientConnect clientController = new ClientConnect(controller);
        clientController.addClient(clientInfo);
        newStage.show();
        clientController.start();
        controller.initialize(clientInfo, clientController);
        this.connectWithClientController.getScene().getWindow().hide();

    }
}
