package mediaplayer;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {

    Media media;
    MediaPlayer player;
    MediaView view;
    Pane mediaPane;

    public Player(String file){   // file is the path of the file we are going to load

        media = new Media(file);
        player = new MediaPlayer(media);
        view = new MediaView(player);
        mediaPane = new Pane();
        mediaPane.getChildren().add(view);
        setCenter(mediaPane);
        player.play();
    }

}