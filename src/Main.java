import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.Controller;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main.fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();
        controller.setStage(primaryStage);

        primaryStage.setTitle("FreeMarket");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/icon.png")));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
