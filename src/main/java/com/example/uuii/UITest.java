package com.example.uuii;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UITest extends Application {

    //public static int sceneNum = 0;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Test Tittle");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void main(String[] args){
        launch();
    }

}
