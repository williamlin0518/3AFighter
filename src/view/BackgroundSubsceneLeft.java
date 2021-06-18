package view;



import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.FirstView;


import java.io.FileNotFoundException;

public class BackgroundSubsceneLeft extends SubScene {

    private boolean isHidden=  true ;

    private final static String FONT_PATH ="Real Chinese.otf";
    private final static String BACKGROUND_IMAGE="panel_beige.png";




    BagroundButton button=new BagroundButton();
    BagroundButton button2=new BagroundButton();
    BagroundButton button3=new BagroundButton();
    BagroundButton button4=new BagroundButton();
    BagroundButton button5=new BagroundButton();




    public BackgroundSubsceneLeft(Stage stage) throws FileNotFoundException {

        super(new AnchorPane(),400,620);
        prefWidth(400);
        prefHeight(620);

        BackgroundImage image=new BackgroundImage(new Image(BACKGROUND_IMAGE,400,620,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        BackgroundImage image2=new BackgroundImage(new Image("stage.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        BackgroundImage image3=new BackgroundImage(new Image("stage2.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        BackgroundImage image4=new BackgroundImage(new Image("stage3.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        BackgroundImage image5=new BackgroundImage(new Image("stage4.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        BackgroundImage image6=new BackgroundImage(new Image("stage5.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane root2 =(AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));

        setLayoutX(-450);
        setLayoutY(40);






        button.setTranslateX(30);
        button.setTranslateY(20);
        button.setBackground(new Background(image2));

        button2.setTranslateX(30);
        button2.setTranslateY(140);
        button2.setBackground(new Background(image3));

        button3.setTranslateX(30);
        button3.setTranslateY(260);
        button3.setBackground(new Background(image4));

        button4.setTranslateX(30);
        button4.setTranslateY(380);
        button4.setBackground(new Background(image5));

        button5.setTranslateX(30);
        button5.setTranslateY(500);
        button5.setBackground(new Background(image6));

        root2.getChildren().add(button);
        root2.getChildren().add(button2);
        root2.getChildren().add(button3);
        root2.getChildren().add(button4);
        root2.getChildren().add(button5);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePlayer choosePlayer =new ChoosePlayer(1);
                choosePlayer.createLoseView(stage);
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePlayer choosePlayer =new ChoosePlayer(2);
                choosePlayer.createLoseView(stage);
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePlayer choosePlayer =new ChoosePlayer(3);
                choosePlayer.createLoseView(stage);
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePlayer choosePlayer =new ChoosePlayer(4);
                choosePlayer.createLoseView(stage);
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePlayer choosePlayer =new ChoosePlayer(5);
                choosePlayer.createLoseView(stage);
            }
        });







    }

    public void moveSubScene(){
        TranslateTransition transition=new TranslateTransition();
        transition.setDuration(Duration.seconds(0.55));
        transition.setNode(this);


        if(isHidden) {
            transition.setToX(550);
            transition.setToY(0);
            isHidden=false;
        } else{
            transition.setToX(-550);
            transition.setToY(0);
            isHidden= true;
        }
        transition.play();
    }
}
