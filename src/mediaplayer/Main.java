package mediaplayer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Player player = new Player("file:///D:/Downloads/arch.mp4");
       // Parent root = FXMLLoader.load(getClass().getResource("mediaplayer.fxml"));
        Scene scene =  new Scene(player, 720, 510, Color.SNOW);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media Player JavaFX");
        primaryStage.getIcons().add(new Image(getClass().getResource("mp.png").toExternalForm()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
