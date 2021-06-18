package view;





import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import view.ChoosePlayer;

import static view.ChoosePlayer.countPlayer;

public class ChoosePlayerButton extends Button {

    Image image;
    ImageView imageView;

    //private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('file:/Users/linchengwei/IdeaProjects/Fighter/src/resources/buttonLong_beige_pressed.png')";
    public ChoosePlayerButton(Image image, Pane pane){

        this.image=image;

        imageView=new ImageView(image);


        setPrefWidth(200);
        setPrefHeight(200);

        changeButton();

        pane.getChildren().add(imageView);
        imageView.setVisible(false);



    }

    private void changeButton(){
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());
                if(countPlayer== 0) {
                    imageView.setTranslateX(20);
                    imageView.setTranslateY(120);
                }

                if(countPlayer== 1) {
                    imageView.setTranslateX(1060);
                    imageView.setTranslateY(120);
                }




                imageView.setVisible(true);
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);
                if(countPlayer== 0) {
                    imageView.setTranslateX(20);
                    imageView.setTranslateY(120);
                }
                if(countPlayer== 1) {
                    imageView.setTranslateX(1060);
                    imageView.setTranslateY(120);
                }

                imageView.setVisible(false);


            }
        });


    }

}
