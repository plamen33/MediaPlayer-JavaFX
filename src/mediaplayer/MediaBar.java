package mediaplayer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

public class MediaBar extends HBox {  // we need this horizontal box to put at the bottom of the window

    Slider timeSlider = new Slider();
    Slider volumeSlider = new Slider();

    Button pauseButton = new Button("||");
    Label volume = new Label("Volume: ");

    MediaPlayer player;

    public MediaBar(MediaPlayer play){
         player = play;

        setAlignment(Pos.CENTER);
        setPadding(new Insets(5,10,5,10));

        volumeSlider.setPrefWidth(70);
        volumeSlider.setMinWidth(30);
        volumeSlider.setValue(100);

        HBox.setHgrow(timeSlider, Priority.ALWAYS);
        pauseButton.setPrefWidth(30);

        getChildren().add(pauseButton);
        getChildren().add(timeSlider);
        getChildren().add(volume);
        getChildren().add(volumeSlider);

     }
}
