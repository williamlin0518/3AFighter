package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.ChooseBackground;


import static java.lang.Math.abs;

public class FirstView {


    int backgroundNumber;
    double robotBlood = 1;
    double greenBlood = 1;
    double powerRobot = 0;
    double powerGreen = 0;
    ProgressBar progressBarRobot = new ProgressBar(robotBlood);
    ProgressBar progressBarGreen = new ProgressBar(greenBlood);
    ProgressBar powerRobotBar = new ProgressBar(powerRobot);
    ProgressBar powerGreenBar = new ProgressBar(powerGreen);

    ImageView[] swords=new ImageView[140];


    private Scene firstScene;
    private Stage gameStage;

    private final Pane root = new Pane();


    PlayerFat player1;
    PlayerFat player2;



    public double playerRobotX, playerRobotY;
    public double playerGreenX, playerGreenY;

    int player1Height;
    int player2Height;

    int p1;
    int p2;


    public boolean right, left, punch, kick, beAttacked, direction = true,up1;
    public boolean right2, left2, punch2, kick2, beAttacked2, direction2 = false,up2;

    boolean canAttack = true;
    boolean canAttack2=true;
    boolean canLose=true;
    boolean isbigger;
    boolean transparent;
    boolean out;



    public FirstView(int backgroundNumber,int p1,int p2) {
        this.p1=p1;
        this.p2=p2;
        switch (p1){
            case 1:
                player1 = new PlayerFat(new ImageView(new Image("player2.png")),190,250,0,250,960,1210,2000,2250,1470,1710,490,740,2500,2750);
                player1.setTranslateY(400);
                player1Height=270;
                break;
            case 2:
                player1 = new PlayerFat(new ImageView(new Image("player4.png")),240,245,0,240,775,1050,1340,1600,1880,2130,500,500,2380,2660);
                player1.setTranslateY(400);
                player1Height=260;
                break;
            case 3:
                player1 = new PlayerFat(new ImageView(new Image("player5.png")),300,315,0,293,880,1187,1537,1884,2220,2530,560,560,2840,3175);
                player1.setTranslateY(400);
                player1Height=315;
                break;
            case 4:
                player1 = new PlayerFat(new ImageView(new Image("player6.png")),325,240,0,241,1021,1287,1561,1847,2133,2441,506,750,27485,3063);
                player1.setTranslateY(400);
                player1Height=250;
        }
        switch (p2){
            case 1:
                player2 = new PlayerFat(new ImageView(new Image("player2.png")),192,250,0,250,960,1210,2000,2250,1470,1710,490,740,2500,2750);
                player2.setTranslateY(400);
                player2Height=270;
                break;
            case 2:
                player2 = new PlayerFat(new ImageView(new Image("player4.png")),240,245,0,240,775,1050,1340,1600,1880,2130,500,500,2380,2660);
                player2.setTranslateY(400);
                player2Height=260;
                break;
            case 3:
                player2 = new PlayerFat(new ImageView(new Image("player5.png")),300,315,0,293,880,1187,1537,1884,2220,2530,585,585,2840,3175);
                player2.setTranslateY(400);
                player2Height=315;
                break;
            case 4:
                player2 = new PlayerFat(new ImageView(new Image("player6.png")),325,240,0,241,1021,1287,1561,1847,2133,2441,506,750,2785,3063);
                player2.setTranslateY(400);
                player2Height=250;
        }
        this.backgroundNumber=backgroundNumber;
        firstScene = new Scene(root, 1400, 700);
        firstScene.getStylesheets().add(getClass().getResource("first.css").toExternalForm());
        gameStage = new Stage();
        gameStage.setScene(firstScene);
        playerRobotY = (700 - player1Height);
        playerRobotX = 150;



        player1.setTranslateX(150);
        player2.setTranslateX(1150);

        progressBarRobot.setPrefWidth(400);
        progressBarRobot.setPrefHeight(60);
        progressBarRobot.setTranslateX(50);
        progressBarRobot.setStyle("-fx-accent: #ad0412;");
        powerRobotBar.setPrefWidth(200);
        powerRobotBar.setTranslateX(50);
        powerRobotBar.setTranslateY(60);
        powerRobotBar.setStyle("-fx-accent: #039c1d;");

        progressBarGreen.setTranslateX(950);
        progressBarGreen.setPrefWidth(400);
        progressBarGreen.setPrefHeight(60);
        powerGreenBar.setPrefWidth(200);
        powerGreenBar.setTranslateX(950);
        powerGreenBar.setTranslateY(60);
        powerGreenBar.setStyle("-fx-accent: #039c1d;");

        progressBarGreen.setStyle("-fx-accent: #b60202;");


        firstScene.setOnKeyPressed(new EventHandler<KeyEvent>() {                          //press press
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.W) {
                    if (player1.getTranslateY() > 350) {
                        player1.setTranslateY(player1.getTranslateY() - 150);
                        up1=true;

                    }
                    beAttacked = false;
                    System.out.println(gameStage.getX()+"  "+gameStage.getY());


                }
                if (event.getCode() == KeyCode.D) {

                    right = true;
                    direction = true;
                    beAttacked = false;




                }
                if (event.getCode() == KeyCode.S) {


                   if(powerRobot>=0.2) {

                       transparent = true;
                       player1.setScaleX(0);
                   }
                }

                if (event.getCode() == KeyCode.A) {

                    left = true;
                    direction = false;
                    beAttacked = false;
                    System.out.println("2");

                }

                if (event.getCode() == KeyCode.F) {
                    punch = true;
                    beAttacked = false;
                    if (direction) {
                        if (playerGreenX - playerRobotX < 110 && playerGreenX - playerRobotX > 5) {
                            if (canAttack) {
                                greenBlood = greenBlood - 0.05;
                                progressBarGreen.setProgress(greenBlood);
                                canAttack = false;
                                beAttacked2 = true;

                                powerRobot += 0.05;
                                powerRobotBar.setProgress(powerRobot);
                            }
                        }
                    }
                    if (!direction) {
                        if (playerRobotX - playerGreenX < 110 && playerRobotX - playerGreenX > 5) {
                            if (canAttack) {
                                greenBlood = greenBlood - 0.05;
                                progressBarGreen.setProgress(greenBlood);
                                canAttack = false;
                                beAttacked2 = true;

                                powerRobot += 0.05;
                                powerRobotBar.setProgress(powerRobot);
                            }
                        }
                    }
                }
                if (event.getCode() == KeyCode.G) {
                    kick = true;
                    beAttacked = false;
                    if (direction) {
                        if (playerGreenX - playerRobotX < 120 && playerGreenX - playerRobotX > 5) {
                            if (canAttack) {
                                greenBlood = greenBlood - 0.05;
                                progressBarGreen.setProgress(greenBlood);
                                canAttack = false;
                                beAttacked2 = true;
                            }
                        }
                    }
                    if (!direction) {
                        if (playerRobotX - playerGreenX < 120 && playerRobotX - playerGreenX > 5) {
                            if (canAttack) {
                                greenBlood = greenBlood - 0.05;
                                progressBarGreen.setProgress(greenBlood);
                                canAttack = false;
                                beAttacked2 = true;
                            }
                        }
                    }
                }
                if (event.getCode() == KeyCode.T) {
                    fireBall();
                }
                if (event.getCode() == KeyCode.H) {

                }
                if (event.getCode() == KeyCode.Y) {
                    createSword();
                }
                if (event.getCode() == KeyCode.R) {
                    createDragon();
                }





                if (event.getCode() == KeyCode.UP) {
                    if (player2.getTranslateY() > 300&&!isbigger) {
                        player2.setTranslateY(player2.getTranslateY() - 150);
                    }
                    if (player2.getTranslateY() > 250&&isbigger) {
                        player2.setTranslateY(player2.getTranslateY() - 150);
                    }
                    beAttacked2=false;
                    up2=true;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    right2 = true;
                    direction2 = true;
                    beAttacked2 = false;
                }
                if (event.getCode() == KeyCode.DOWN) {
                    player2.setScaleX(0);

                }
                if (event.getCode() == KeyCode.LEFT) {
                    left2 = true;
                    direction2 = false;
                    beAttacked2 = false;
                }
                if (event.getCode() == KeyCode.SEMICOLON) {
                    createSphere();
                }
                if (event.getCode() == KeyCode.L) {
                    player2.setTranslateY(300);
                    bigger();
                }
                if (event.getCode() == KeyCode.COMMA) {
                    punch2 = true;
                    if(direction2) {
                        if (isbigger) {
                            if (playerRobotX - playerGreenX <= 250 && playerRobotX - playerGreenX >= 30&&canAttack2) {
                                robotBlood -= 0.07;
                                progressBarRobot.setProgress(robotBlood);
                                beAttacked = true;
                                canAttack2=false;
                            }

                        }
                        if (!isbigger) {
                            if (playerRobotX - playerGreenX <= 120 && playerRobotX - playerGreenX >= 30&&canAttack2) {
                                robotBlood -= 0.09;
                                progressBarRobot.setProgress(robotBlood);
                                beAttacked = true;
                                canAttack2=false;
                            }

                        }
                    }
                    if(!direction2) {
                        if (!isbigger) {
                            if (playerGreenX - playerRobotX <= 120 && playerGreenX - playerRobotX >= 30&&canAttack2) {
                                robotBlood -= 0.07;
                                progressBarRobot.setProgress(robotBlood);
                                beAttacked = true;
                                canAttack2=false;

                            }
                        }
                        if (isbigger) {
                            if (playerGreenX - playerRobotX <= 250 && playerGreenX - playerRobotX >= 30&&canAttack2) {
                                robotBlood -= 0.09;
                                progressBarRobot.setProgress(robotBlood);
                                beAttacked = true;
                                canAttack2=false;
                            }
                        }
                    }
                    beAttacked2 = false;
                }
                if (event.getCode() == KeyCode.PERIOD) {
                    kick2 = true;
                    if(direction2) {
                        if (!isbigger) {
                            if (playerRobotX - playerGreenX <= 120 && playerRobotX - playerGreenX >= 20&&canAttack2) {
                                robotBlood -= 0.08;
                                progressBarRobot.setProgress(robotBlood);
                                beAttacked = true;
                                canAttack2=false;

                            }
                        }
                        if (isbigger) {
                            if (playerRobotX - playerGreenX <= 250 && playerRobotX - playerGreenX >= 20&&canAttack2) {
                                robotBlood -= 0.08;
                                progressBarRobot.setProgress(robotBlood);
                                beAttacked = true;
                                canAttack2=false;
                            }
                        }
                    }
                    if(!direction2) {
                        if (!isbigger) {
                            if (playerGreenX - playerRobotX <= 130 && playerGreenX - playerRobotX >= 20&&canAttack2) {
                                robotBlood -= 0.08;
                                progressBarRobot.setProgress(robotBlood);
                                beAttacked = true;
                                canAttack2=false;
                            }
                        }
                        if (isbigger) {
                            if (playerGreenX - playerRobotX <= 250 && playerGreenX - playerRobotX >= 20&&canAttack2) {
                                robotBlood -= 0.08;
                                progressBarRobot.setProgress(robotBlood);
                                beAttacked = true;
                                canAttack2=false;
                            }
                        }
                    }
                    beAttacked2 = false;
                }
            }
        });
        firstScene.setOnKeyReleased(new EventHandler<KeyEvent>() {             //release release release
            @Override
            public void handle(KeyEvent event) {


                if (event.getCode() == KeyCode.W) {
                    up1=false;
                }
                if (event.getCode() == KeyCode.D) {
                    right = false;
                }
                if (event.getCode() == KeyCode.A) {
                    left = false;
                }
                if (event.getCode() == KeyCode.S) {
                    player1.setScaleX(1);
                    player1.setScaleY(1);
                    transparent=false;
                }
                if (event.getCode() == KeyCode.F) {
                    canAttack = true;
                    punch = false;
                }
                if (event.getCode() == KeyCode.G) {
                    canAttack = true;
                    kick = false;
                }
                if (event.getCode() == KeyCode.T) {

                }
                if (event.getCode() == KeyCode.R) {

                }






                if (event.getCode() == KeyCode.UP) {
                   up2=false;
                }
                if (event.getCode() == KeyCode.DOWN) {
                    player2.setScaleX(1);
                    player2.setScaleY(1);

                }
                if (event.getCode() == KeyCode.RIGHT) {
                    right2 = false;
                }
                if (event.getCode() == KeyCode.LEFT) {
                    left2 = false;
                }
                if (event.getCode() == KeyCode.COMMA) {
                    punch2 = false;
                    canAttack2=true;
                }
                if (event.getCode() == KeyCode.PERIOD) {
                    kick2 = false;
                    canAttack2=true;
                }
            }
        });





        root.getChildren().add(player1);
        root.getChildren().add(player2);
        root.getChildren().add(progressBarRobot);
        root.getChildren().add(progressBarGreen);
        root.getChildren().add(powerRobotBar);
        root.getChildren().add(powerGreenBar);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {


                playerRobotX = player1.getTranslateX();
                playerRobotY = player1.getTranslateY();

                playerGreenX = player2.getTranslateX();
                playerGreenY = player2.getTranslateY();



                if (playerRobotY <= 700 - player1Height+10) {
                    player1.setTranslateY(playerRobotY + 3);
                    System.out.println("fall");
                }
                if (playerGreenY <= 700 - player2Height+10 &&!isbigger) {
                    player2.setTranslateY(playerGreenY + 3);
                    System.out.println("fall");
                }
                if(playerGreenY <= 700 - player2Height - 200&&isbigger){
                    player2.setTranslateY(playerGreenY + 3);
                }

                player1.update(right, left, punch, kick, beAttacked, direction,up1);
                player2.update(right2, left2, punch2, kick2, beAttacked2, direction2,up2);


                powerBarAdd(powerRobotBar);

                if(transparent){
                    powerBarDown(powerRobotBar);
                }

                if((greenBlood<=0||robotBlood<=0)&&canLose){
                    System.out.println("sssss");
                    gameLose();
                    canLose=false;
                }


            }



        };
        timer.start();


        createGameBackground();

    }


    private void createGameBackground() {
        ChooseBackground chooseBackground=new ChooseBackground(backgroundNumber);



        BackgroundImage background = new BackgroundImage(chooseBackground.choose(), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        root.setBackground(new Background(background));
    }

    public void createFirstrView(Stage stage) {
        //pane.getChildren().remove(player);
        player1.setTranslateX(playerRobotX);
        player1.setTranslateY(playerRobotY);
        stage.hide();
        gameStage.show();
    }

    public void powerBarAdd(ProgressBar progressBar) {

        if(powerRobot<=1) {
            powerRobot += 0.0012;
        }
        if (powerGreen<=1) {
            powerGreen += 0.0012;
        }
        powerGreenBar.setProgress(powerGreen);
        progressBar.setProgress(powerRobot);

        //System.out.println("angry plus");
    }
    public void powerBarDown(ProgressBar progressBar) {

        if(powerRobot>=0.002){
            powerRobot -= 0.008;
        }


        progressBar.setProgress(powerRobot);

        //System.out.println("angry plus");
    }


    public void fireBall()  {


        final boolean[] attackOnce = {true};
        ImageView imageView = new ImageView(new Image("fireBall.png"));

        root.getChildren().add(imageView);
        imageView.setTranslateX(playerRobotX-140);
        imageView.setTranslateY(-150);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1.15));
        transition.setNode(imageView);


        transition.setToX(playerGreenX);
        transition.setToY(playerGreenY+233);
        transition.play();



//        RotateTransition transition1=new RotateTransition();
//        transition1.setDuration(Duration.seconds(0.5));
//        transition1.setNode(root);


        AnimationTimer timer =new AnimationTimer() {
            long nowTime=System.nanoTime();
            @Override
            public void handle(long now) {
                System.out.println(imageView.getTranslateX());
                if(abs(imageView.getTranslateX()-playerGreenX)<=300&&abs(imageView.getTranslateY()-playerGreenY)<=100&& attackOnce[0]){
                    greenBlood-=0.23;
                    progressBarGreen.setProgress(greenBlood);
                    beAttacked2=true;
                    attackOnce[0] =false;
                }

                if((now-nowTime)<1000000000){
                    if(now%2==1){
                        gameStage.setX(gameStage.getX()+10);
                        gameStage.setY(gameStage.getY()+10);
                    }else {
                        gameStage.setX(gameStage.getX()-10);
                        gameStage.setY(gameStage.getY()-10);
                    }
                }
                if((now-nowTime)>=1000000000){
                    this.stop();
                    root.getChildren().remove(imageView);
                    gameStage.setX(20);
                    gameStage.setY(75);
                    System.out.println("stop");
                }
            }
        };
        timer.start();





    }

    public void createSword(){
        //TranslateTransition[] swordsTrans=new TranslateTransition[56];
        for(int i=0;i<56;i++){
            swords[i] = new ImageView(new Image("sword.png"));
            swords[i].setTranslateX((i+1)*25);
            swords[i].setTranslateY(-100);
            root.getChildren().add(swords[i]);

            TranslateTransition transition = new TranslateTransition();
            transition.setNode(swords[i]);

            transition.setDuration(Duration.seconds(1.5));

            transition.setToY(2000);
            transition.play();
        }
        AnimationTimer timer =new AnimationTimer() {
            long nowTime=System.nanoTime();
            @Override
            public void handle(long now) {

                //System.out.println(blueFireBalls[5].getTranslateX()+" "+blueFires[5].getTranslateY());

                for(int i=0;i<56;i++){
                    if(abs(swords[i].getTranslateX()-playerGreenX)<=100&&abs(swords[i].getTranslateY()-playerGreenY)<=20){
                        greenBlood-=0.04;
                        progressBarGreen.setProgress(greenBlood);
                        beAttacked2=true;
                    }
                }
            }
        };
        timer.start();


    }

    public void createDragon(){
        //TranslateTransition[] swordsTrans=new TranslateTransition[56];


        ImageView dragon=new ImageView(new Image("dragon.png"));
        dragon.setTranslateX(450);
        root.getChildren().add(dragon);
        ImageView fireFace=new ImageView(new Image("fireFace.png"));
        fireFace.setTranslateX(370);
        root.getChildren().add(fireFace);
        ImageView[] blueFires=new ImageView[30];
        for(int i=0;i<30;i++){
            blueFires[i]=new ImageView(new Image("blueFire.png"));
            blueFires[i].setFitHeight(120);
            blueFires[i].setTranslateX((i*55));
            blueFires[i].setTranslateY(580);
            root.getChildren().add(blueFires[i]);


        }
        ImageView[] blueFireBalls=new ImageView[30];
        ImageView[] blueFireBalls2=new ImageView[30];
        for(int i=0;i<30;i++){
            blueFireBalls[i]=new ImageView(new Image("blueFireball.png"));
            blueFireBalls2[i]=new ImageView(new Image("blueFireball.png"));


            blueFireBalls[i].setTranslateY((i*60));
            blueFireBalls[i].setTranslateX(-200);

            blueFireBalls2[i].setTranslateY((i*60));
            blueFireBalls2[i].setTranslateX(1800);

            root.getChildren().add(blueFireBalls[i]);
            root.getChildren().add(blueFireBalls2[i]);

            TranslateTransition transition = new TranslateTransition();
            transition.setNode(blueFireBalls[i]);

            transition.setDuration(Duration.seconds(1.8));

            transition.setToX(2500);
            transition.setToY(60*i);
            transition.play();

            TranslateTransition transition2 = new TranslateTransition();
            transition2.setNode(blueFireBalls2[i]);

            transition2.setDuration(Duration.seconds(1.5));

            transition2.setToX(-200);
            transition2.setToY(60*i);
            transition2.play();

        }
        AnimationTimer timer =new AnimationTimer() {
            long nowTime=System.nanoTime();
            @Override
            public void handle(long now) {

                //System.out.println(blueFireBalls[5].getTranslateX()+" "+blueFires[5].getTranslateY());
                for(int i=0;i<30;i++){
                    if(abs(blueFireBalls[i].getTranslateX()-playerGreenX)<=120&&abs(blueFireBalls[i].getTranslateY()-playerGreenY)<=120){
                        greenBlood-=0.018;
                        progressBarGreen.setProgress(greenBlood);
                        beAttacked2=true;
                    }

                }
//                greenBlood-=0.08;
//                progressBarGreen.setProgress(greenBlood);
//                beAttacked2=true;

                if((now-nowTime)>=1700000000){
                    for(int i=0;i<30;i++){
                        root.getChildren().remove(blueFires[i]);

                    }
                    root.getChildren().remove(dragon);
                    root.getChildren().remove(fireFace);
                    this.stop();

                }
            }
        };
        timer.start();
    }

    public void createSphere()  {


        final boolean[] attackOnce = {true};
        ImageView sphere = new ImageView(new Image("sphere.png"));
        sphere.setFitWidth(1800);
        sphere.setFitHeight(1800);

        root.getChildren().add(sphere);
        sphere.setTranslateX(0);
        sphere.setTranslateY(-1000);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1.35));
        transition.setNode(sphere);


        transition.setToX(playerRobotX-750);
        transition.setToY(playerRobotY);
        transition.play();

        AnimationTimer timer =new AnimationTimer() {
            long nowTime=System.nanoTime();
            @Override
            public void handle(long now) {
                if(abs(sphere.getTranslateX()-playerGreenX)<=1200&&abs(sphere.getTranslateY()-playerGreenY)<=800&& attackOnce[0]){
                    robotBlood-=0.35;
                    progressBarRobot.setProgress(robotBlood);
                    beAttacked=true;
                    attackOnce[0] =false;
                }

                if((now-nowTime)<2000000000){
                    player2.setTranslateY(150);
                    player2.setTranslateX(playerGreenX);
                    if(greenBlood<0.8) {
                        greenBlood += 0.07;
                    }
                    progressBarGreen.setProgress(greenBlood);
                    if(now%2==1){
                        gameStage.setX(gameStage.getX()+10);
                        gameStage.setY(gameStage.getY()+10);
                    }else {
                        gameStage.setX(gameStage.getX()-10);
                        gameStage.setY(gameStage.getY()-10);
                    }
                }
                if((now-nowTime)>=2000000000){
                    root.getChildren().remove(sphere);
                    this.stop();
                    gameStage.setX(20);
                    gameStage.setY(75);
                    System.out.println("stop");
                }

            }
        };
        timer.start();

    }


    public void bigger(){
        player2.setScaleX(2.5);
        player2.setScaleY(2.5);
        isbigger=true;

        AnimationTimer timer =new AnimationTimer() {
            long nowTime=System.nanoTime();
            @Override
            public void handle(long now) {

                if((now-nowTime)>=(200000000L *40)){

                    player2.setScaleX(1);
                    player2.setScaleY(1);
                    isbigger=false;
                    this.stop();
                    System.out.println("disappear");
                }
            }
        };
        timer.start();
    }

    public void gameLose(){
        ImageView imageView =new ImageView("ko.png");
        imageView.setTranslateX(400);
        imageView.setTranslateY(100);
        root.getChildren().add(imageView);
        AnimationTimer timer =new AnimationTimer() {
            long nowTime=System.nanoTime();
            @Override
            public void handle(long now) {
                if((now-nowTime)>=(2100000000)){
                    Lose lose=new Lose(true);
                    lose.createLoseView(gameStage);
                    this.stop();
                }
            }
        };
        timer.start();
    }
}