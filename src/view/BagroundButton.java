package view;



import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BagroundButton extends Button {

    String image;
    private final String FONT_PATH ="/Users/linchengwei/IdeaProjects/Fighter/src/resources/Real Chinese.otf";


    //private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('file:/Users/linchengwei/IdeaProjects/Fighter/src/resources/buttonLong_beige_pressed.png')";
    public BagroundButton(){



        setPrefWidth(340);
        setPrefHeight(100);

        changeButton();

    }

    private void changeButton(){
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());

            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);

            }
        });
    }

}
