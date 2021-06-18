package view;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class MenuSubscene extends SubScene {

    private boolean isHidden=  true ;

    private final static String FONT_PATH ="Real Chinese.otf";
    private final static String BACKGROUND_IMAGE="panel_beige.png";

    public MenuSubscene(){
        super(new AnchorPane(),400,600);


        BackgroundImage image=new BackgroundImage(new Image(BACKGROUND_IMAGE,400,600,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane root2 =(AnchorPane) this.getRoot();

        this.prefWidth(400);
        this.prefHeight(600);
        root2.setBackground(new Background(image));

        setLayoutX(1450);
        setLayoutY(80);

    }

    public void moveSubScene(){
        TranslateTransition transition=new TranslateTransition();
        transition.setDuration(Duration.seconds(0.55));
        transition.setNode(this);


        if(isHidden) {
            transition.setToX(-550);
            transition.setToY(0);
            isHidden=false;
        } else{
            transition.setToX(550);
            transition.setToY(0);
            isHidden= true;
        }
        transition.play();
    }


}
