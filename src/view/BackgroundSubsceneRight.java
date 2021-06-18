package view;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.FirstView;

public class BackgroundSubsceneRight extends SubScene {

    private boolean isHidden=  true ;

    private final static String FONT_PATH ="Real Chinese.otf";
    private final static String BACKGROUND_IMAGE="panel_beige.png";

    BagroundButton button=new BagroundButton();
    BagroundButton button2=new BagroundButton();
    BagroundButton button3=new BagroundButton();
    BagroundButton button4=new BagroundButton();
    BagroundButton button5=new BagroundButton();

    public BackgroundSubsceneRight(Stage stage){
        super(new AnchorPane(),400,620);
        prefWidth(400);
        prefHeight(620);

        BackgroundImage image=new BackgroundImage(new Image(BACKGROUND_IMAGE,400,620,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        BackgroundImage image2=new BackgroundImage(new Image("stage6.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        BackgroundImage image3=new BackgroundImage(new Image("stage7.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        BackgroundImage image4=new BackgroundImage(new Image("stage8.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        BackgroundImage image5=new BackgroundImage(new Image("stage9.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        BackgroundImage image6=new BackgroundImage(new Image("stage10.gif",340,100,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);


        AnchorPane root2 =(AnchorPane) this.getRoot();

        root2.setBackground(new Background(image));

        setLayoutX(1450);
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
                ChoosePlayer choosePlayer =new ChoosePlayer(6);
                choosePlayer.createLoseView(stage);
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePlayer choosePlayer =new ChoosePlayer(7);
                choosePlayer.createLoseView(stage);
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePlayer choosePlayer =new ChoosePlayer(8);
                choosePlayer.createLoseView(stage);
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePlayer choosePlayer =new ChoosePlayer(9);
                choosePlayer.createLoseView(stage);
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChoosePlayer choosePlayer =new ChoosePlayer(10);
                choosePlayer.createLoseView(stage);
            }
        });


    }

    public void moveSubScene(){
        TranslateTransition transition=new TranslateTransition();
        transition.setDuration(Duration.seconds(0.55));
        transition.setNode(this);


        if(isHidden) {
            transition.setToX(-600);
            transition.setToY(0);
            isHidden=false;
        } else{
            transition.setToX(600);
            transition.setToY(0);
            isHidden= true;
        }
        transition.play();
    }
}
