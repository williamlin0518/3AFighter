package view;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuButton extends Button {

    private final String FONT_PATH ="/Users/linchengwei/IdeaProjects/Fighter/src/resources/Real Chinese.otf";
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color:transparent; -fx-background-image: url('buttonLong_beige.png')";
    private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('buttonLong_beige_pressed.png')";//file:/Users/linchengwei/IdeaProjects/Fighter/src/resources/

    //private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('file:/Users/linchengwei/IdeaProjects/Fighter/src/resources/buttonLong_beige_pressed.png')";
    public MenuButton(String text){
        this.setText(text);
        this.setButtonFont();
        this.setPrefWidth(190);
        this.setPrefHeight(47);
        this.setStyle(BUTTON_FREE_STYLE);
        this.changeButton();
        //this.setFont(new Font("Real Chinese.otf",23));

        //setFont(Font.loadFont("/Real Chinese.otf", 23));

    }


    public void setButtonFont() {
        try {

            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setButtonPresedStyle(){
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(47);
        setLayoutY(getLayoutY()+4);
    }
    public void setButtonReleaseStyle(){
        setStyle(BUTTON_FREE_STYLE);
        setPrefHeight(47);
        setLayoutY(getLayoutY()-4);
    }

    private void changeButton(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    setButtonPresedStyle();
                }

            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    setButtonReleaseStyle();
                }

            }
        });
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
