package view;


import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.FirstView;

public class ChoosePlayer {
    private Scene chooseScene;
    private Stage chooseStage;
    public static int countPlayer=0;


    ImageView imageViewFrame=new ImageView(new Image("playerFrame.png"));
    ImageView imageViewFrame2=new ImageView(new Image("panel.jpeg"));

    ImageView imageViewP1=new ImageView(new Image("1p.png"));
    ImageView imageViewP2=new ImageView(new Image("2p.png"));
    ImageView sure1=new ImageView(new Image("choosePlayer2.png"));
    ImageView sure2=new ImageView(new Image("choosePlayer1.png"));
    ImageView sure3=new ImageView(new Image("choosePlayer3.png"));
    ImageView sure4=new ImageView(new Image("choosePlayer4.png"));
    ImageView sure5=new ImageView(new Image("choosePlayer5.png"));
    private final Pane root = new Pane();
    ChoosePlayerButton button =new ChoosePlayerButton(new Image("choosePlayer2.png"),root);
    ChoosePlayerButton button2 =new ChoosePlayerButton(new Image("choosePlayer1.png"),root);
    ChoosePlayerButton button3 =new ChoosePlayerButton(new Image("choosePlayer3.png"),root);
    ChoosePlayerButton button4 =new ChoosePlayerButton(new Image("choosePlayer4.png"),root);
    ChoosePlayerButton button5 =new ChoosePlayerButton(new Image("choosePlayer5.png"),root);

    int p1=0;
    int p2=0;



    public ChoosePlayer(int backgroundNumber){
        chooseScene = new Scene(root, 1400, 700);
        chooseStage = new Stage();
        chooseStage.setScene(chooseScene);

        button.setTranslateX(430);
        button.setTranslateY(400);
        button2.setTranslateX(430);
        button2.setTranslateY(180);
        button3.setTranslateX(630);
        button3.setTranslateY(180);
        button4.setTranslateX(630);
        button4.setTranslateY(400);
        button5.setTranslateX(830);
        button5.setTranslateY(400);




        BackgroundImage image=new BackgroundImage(new Image("kyo.png",200,200,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        button.setBackground(new Background(image));
        BackgroundImage image2=new BackgroundImage(new Image("kyo2.png",200,200,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        button2.setBackground(new Background(image2));
        BackgroundImage image3=new BackgroundImage(new Image("kyo3.png",200,200,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        button3.setBackground(new Background(image3));
        BackgroundImage image4=new BackgroundImage(new Image("kyo4.png",200,200,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        button4.setBackground(new Background(image4));
        BackgroundImage image5=new BackgroundImage(new Image("kyo5.png",200,200,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
        button5.setBackground(new Background(image5));

        imageViewFrame.setTranslateX(500);
        imageViewFrame.setTranslateY(50);
        imageViewFrame2.setTranslateX(420);
        imageViewFrame2.setTranslateY(120);
        imageViewFrame2.setFitWidth(600);
        imageViewFrame2.setFitHeight(580);
        imageViewP1.setTranslateX(120);
        imageViewP1.setTranslateY(25);
        imageViewP2.setTranslateX(1190);
        imageViewP2.setTranslateY(38);


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button.setDisable(true);


                if(countPlayer==0){
                    sure1.setTranslateX(20);
                    sure1.setTranslateY(120);
                    p1=1;
                }
                if(countPlayer==1){
                    sure1.setTranslateX(1000);
                    sure1.setTranslateY(120);
                    p2=1;
                }



                countPlayer++;
                root.getChildren().add(sure1);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button2.setDisable(true);
                if(countPlayer==0){
                    sure2.setTranslateX(20);
                    sure2.setTranslateY(120);
                    p1=1;
                }
                if(countPlayer==1){
                    sure2.setTranslateX(1000);
                    sure2.setTranslateY(120);
                    p2=1;
                }


                countPlayer++;
                root.getChildren().add(sure2);
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button3.setDisable(true);
                if(countPlayer==0){
                    sure3.setTranslateX(20);
                    sure3.setTranslateY(120);
                    p1=2;
                }
                if(countPlayer==1){
                    sure3.setTranslateX(1060);
                    sure3.setTranslateY(120);
                    p2=2;
                }


                countPlayer++;
                root.getChildren().add(sure3);
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button4.setDisable(true);
                if(countPlayer==0){
                    sure4.setTranslateX(20);
                    sure4.setTranslateY(120);
                    p1=3;
                }
                if(countPlayer==1){
                    sure4.setTranslateX(1060);
                    sure4.setTranslateY(120);
                    p2=3;
                }


                countPlayer++;
                root.getChildren().add(sure4);
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button5.setDisable(true);
                if(countPlayer==0){
                    sure5.setTranslateX(20);
                    sure5.setTranslateY(120);
                    p1=4;
                }
                if(countPlayer==1){
                    sure5.setTranslateX(1060);
                    sure5.setTranslateY(120);
                    p2=4;
                }


                countPlayer++;
                root.getChildren().add(sure5);
            }
        });




        AnimationTimer timer =new AnimationTimer() {
            long nowTime=System.nanoTime();
            @Override
            public void handle(long now) {

                   if(countPlayer==2){
                       System.out.println("eeeeeeeeee");
                       System.out.println(now-nowTime);
                       if((now-nowTime)>=(1500000000)) {
                           System.out.println(countPlayer);
                           FirstView firstView = new FirstView(backgroundNumber,p1,p2);
                           firstView.createFirstrView(chooseStage);
                       }
                       this.stop();
                   }



                }

        };
        timer.start();


        //root.getChildren().add(imageViewFrame2);
        root.getChildren().add(imageViewFrame);
        root.getChildren().add(button);
        root.getChildren().add(button2);
        root.getChildren().add(button3);
        root.getChildren().add(button4);
        root.getChildren().add(button5);
        root.getChildren().add(imageViewP1);
        root.getChildren().add(imageViewP2);


        createGameBackground();
    }
    private void createGameBackground() {
        Image backgroundImage = new Image("playerStage.jpeg", 1400, 700, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        root.setBackground(new Background(background));
    }
    public void createLoseView(Stage stage) {
        //pane.getChildren().remove(player);
        stage.close();
        chooseStage.show();
    }
}
