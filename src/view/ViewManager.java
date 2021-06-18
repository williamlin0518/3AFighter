package view;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;



public class ViewManager {

    Image image=new Image("logo1.png");
    Image image2=new Image("logo2.png");
    Image image3=new Image("logo3.png");

    private static final int HEIGHT=700;
    private static final int WEIGHT=1400;
    private AnchorPane root;
    private Scene mainScene;
    private Stage mainStage;




    private final static int MENU_BUTTONS_START_X=570;
    private final static int MENU_BUTTONS_START_Y=190;

    List<MenuButton> menuButtons;

    private MenuSubscene WinnerSubScene;
    private MenuSubscene helpsSubScene;
    private MenuSubscene scoreSubScene;

    private BackgroundSubsceneLeft backgroundSubsceneLeft;
    private BackgroundSubsceneRight backgroundSubsceneRight;

    public ViewManager() throws FileNotFoundException {



        menuButtons =new ArrayList<>();
        root =new AnchorPane();
        mainScene=new Scene(root,WEIGHT,HEIGHT);
        mainStage= new Stage();
        mainStage.setScene(mainScene);


        createButtons();
//        String css = this.getClass().getResource("/model/Button.css").toExternalForm();
//        mainScene.getStylesheets().add(css);

        createBackground();
        createLogo();

        createSubScenes();

    }

    private void createSubScenes() throws FileNotFoundException {
        WinnerSubScene = new MenuSubscene();
        root.getChildren().add(WinnerSubScene);

        helpsSubScene = new MenuSubscene();
        root.getChildren().add(helpsSubScene);

        scoreSubScene=new MenuSubscene();
        root.getChildren().add(scoreSubScene);

        backgroundSubsceneLeft=new BackgroundSubsceneLeft(mainStage);
        root.getChildren().add(backgroundSubsceneLeft);

        backgroundSubsceneRight=new BackgroundSubsceneRight(mainStage);
        root.getChildren().add(backgroundSubsceneRight);

    }

    private void addMenuButton(MenuButton button){
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y+menuButtons.size()*90);

        menuButtons.add(button);
        root.getChildren().add(button);
    }

    private void createButtons() {
        createStartButton();
        createScoreButton();
        createHelpButton();
        createCredistsButton();
        createExitButton();

    }

    private void createStartButton(){
        MenuButton startButton=new MenuButton("PLAY");
        addMenuButton(startButton);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//
//
                backgroundSubsceneLeft.moveSubScene();
                backgroundSubsceneRight.moveSubScene();
            }
        });
    }

    private void createScoreButton(){
        MenuButton scoreButton=new MenuButton("HELP");
        addMenuButton(scoreButton);

        scoreButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scoreSubScene.moveSubScene();
            }
        });
    }

    private void createHelpButton(){
        MenuButton helpButton=new MenuButton("Winner");
        addMenuButton(helpButton);

        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                helpsSubScene.moveSubScene();
            }
        });
    }

    private void createCredistsButton(){
        MenuButton creditsButton=new MenuButton("ABOUT GAME");
        addMenuButton(creditsButton);

        creditsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                WinnerSubScene.moveSubScene();
            }
        });
    }
    private void createExitButton(){
        MenuButton exitButton=new MenuButton("EXIT");
        addMenuButton(exitButton);

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });
    }

    private void createBackground(){
        Image backgroundImage= new Image("menu.gif",1400,700,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }

    private void createLogo(){

        ImageView logo = new ImageView(image);

        root.getChildren().add(logo);
        logo.setLayoutX(570);
        logo.setLayoutY(10);
        final int[] count = {1};
        AnimationTimer timer =new AnimationTimer() {
            long nowTime=0;
            @Override
            public void handle(long now) {


                if((now-nowTime)>=500000000){
                    if(count[0] ==1) {
                        nowTime = now;
                        logo.setImage(image2);
                        count[0] =2;
                    }
                    else if(count[0] ==2) {
                        nowTime = now;
                        logo.setImage(image3);
                        count[0] =3;
                    }
                    else if(count[0] ==3) {
                        nowTime = now;
                        logo.setImage(image);
                        count[0] =1;
                    }
                }
            }
        };
        timer.start();

        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(new DropShadow());
            }
        });

        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(null);
            }
        });


    }
    public void createView(Stage stage){
        mainStage.show();
        stage.close();
    }
}
