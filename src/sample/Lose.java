package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.ViewManager;

import java.io.FileNotFoundException;

public class Lose {
    private Scene loseScene;
    private Stage loseStage;
    Label label =new Label("Back to menu");

    ImageView p1win = new ImageView(new Image("p1win.png"));
    ImageView p2lose = new ImageView(new Image("p2lose.png"));

    private final Pane root = new Pane();

    Lose(boolean leftWin){
        loseScene = new Scene(root, 1400, 700);

        loseStage = new Stage();
        loseStage.setScene(loseScene);
        if(leftWin){
            p1win.setTranslateX(500);
            p1win.setTranslateY(100);
            p2lose.setTranslateX(800);
            p2lose.setTranslateY(115);
            root.getChildren().add(p2lose);
            root.getChildren().add(p1win);

            label.setTranslateX(560);
            label.setTranslateY(420);
            label.setPrefSize(300,77);
            label.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    loseStage.close();
                    ViewManager viewManage= null;
                    try {

                        viewManage = new ViewManager();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    viewManage.createView(loseStage);
                }
            });
            Image backgroundImage = new Image("label.png",300 , 77, false, true);
            label.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null)));

            root.getChildren().add(label);
        }

        createGameBackground();
    }
    private void createGameBackground() {
        Image backgroundImage = new Image("loseStage.gif", 1400, 700, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        root.setBackground(new Background(background));
    }
    public void createLoseView(Stage stage) {
        //pane.getChildren().remove(player);
        stage.close();
        loseStage.show();
    }
}
