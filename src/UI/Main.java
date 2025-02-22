package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/hellofx.fxml"));
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/UI/styles.css").toExternalForm());
        
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icon.png")));
        primaryStage.setTitle("TechVille - Carrito de Compras");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
