package mediaplayer;
import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public MediaBar(MediaPlayer play)  {
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

        pauseButton.setOnAction(new EventHandler<ActionEvent>(){
           public void handle(ActionEvent e) {
               MediaPlayer.Status status = player.getStatus();
               if (status == MediaPlayer.Status.PLAYING){
                   if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){ // if we reach end of video play it again
                       player.seek(player.getStartTime());
                       player.play();
                   }
                   else{
                       player.pause();
                       pauseButton.setText(">");

                   }
               }
               if (status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.HALTED|| status == MediaPlayer.Status.STOPPED) {
                   player.play();
                   pauseButton.setText("||");

               }
           }
        });
        player.currentTimeProperty().addListener(new InvalidationListener() {

            public void invalidated(Observable observable) {
                updatesValues();   // needed for the slider to move across its duration along with the video - I created a method
            }
        });
        timeSlider.valueProperty().addListener(new InvalidationListener(){
                  public void invalidated(Observable observable){
                        if(timeSlider.isPressed()){
                            player.seek(player.getMedia().getDuration().multiply(timeSlider.getValue()/100));  // makes timeSlider jump to places of the Video
                        }
                  }
        });
        volumeSlider.valueProperty().addListener(new InvalidationListener(){
            public void invalidated(Observable observable){
                if(volumeSlider.isPressed()){
                    player.setVolume(volumeSlider.getValue()/100);  // makes volumeSlider to control the Volume of the video
                }
            }
        });

     } // end of public MediaBar

     protected void updatesValues(){
         Platform.runLater(new Runnable() {
             public void run() {
                 timeSlider.setValue(player.getCurrentTime().toMillis()/player.getTotalDuration().toMillis()*100);
             }
         });
     }
}
