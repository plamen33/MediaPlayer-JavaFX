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
    MediaBar mediaBar;

    public Player(String file){   // file is the path of the file we are going to load
      try {
          media = new Media(file);
          player = new MediaPlayer(media);
          view = new MediaView(player);
          mediaPane = new Pane();
          mediaPane.getChildren().add(view);
          setCenter(mediaPane);
          mediaBar = new MediaBar(player);
          setBottom(mediaBar);
          setStyle("-fx-background-color: silver");
          player.play();
      }
      catch (Exception e){
          System.out.println("Program starts");
      }
    }
}
