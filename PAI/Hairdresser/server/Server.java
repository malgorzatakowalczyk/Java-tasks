package server;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Server extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLServer.fxml"));
        stage.setTitle("Fryzjer");
        Scene scene = new Scene(root);
        stage.setMinWidth(570);
        stage.setMaxWidth(570);
        stage.setMinHeight(350);
        stage.setMaxHeight(350);
        stage.setScene(scene);
        stage.setOnCloseRequest(except -> System.exit(0));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
