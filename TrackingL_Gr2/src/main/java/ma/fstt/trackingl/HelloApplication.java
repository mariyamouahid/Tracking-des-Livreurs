package ma.fstt.trackingl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       FXMLLoader fxmlLoader0 = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene0 = new Scene(fxmlLoader0.load(), 660, 430);
        stage.setTitle("Tracking des Livreurs");
        stage.setScene(scene0);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}