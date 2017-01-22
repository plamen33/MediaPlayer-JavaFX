package mediaplayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class Main extends Application {

    Player player;
    FileChooser fileChooser;

    public void start(final Stage primaryStage) {


        MenuItem openVideo = new MenuItem("Open media");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        file.getItems().add(openVideo);
        menu.getMenus().add(file);

        fileChooser = new FileChooser();

        openVideo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                player.player.pause();
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    try {
                        player = new Player(file.toURI().toURL().toExternalForm());
                        player.setTop(menu);
                        Scene scene = new Scene(player, 720, 535, Color.SNOW);
                        primaryStage.setScene(scene);
                    }

                    catch (MalformedURLException mUrlExc) {
                        mUrlExc.printStackTrace();
                    }
                } // end of if

            } // end of handle

        });

        player = new Player("file:///D:/Downloads/arch.mp4");
        player.setTop(menu);
        Scene scene =  new Scene(player, 720, 535, Color.SNOW);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media Player JavaFX");
        primaryStage.getIcons().add(new Image(getClass().getResource("mp.png").toExternalForm()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}