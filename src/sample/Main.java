package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ViewManager;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        ViewManager viewManage=new ViewManager();
        viewManage.createView(stage);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
