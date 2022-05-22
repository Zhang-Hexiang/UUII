package com.example.uuii;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.Key;

public class StartViewController {

    @FXML
    private TextField textID;
    @FXML
    private Button startButton;
    @FXML
    private Button highScoreButton;
    @FXML
    private Button quitButton;
    String playerID = "";
    String emp = "";
    public static String idGet;

    /**
     * If player input the name and click this button, then show the game-view scene
     * @param event
     * @throws IOException
     */
    @FXML
    void onStartButtonActive(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        if(playerID != emp){
            System.out.println(playerID);
            textID.setText(emp);
            playerID = emp;
            gameViewController.player.setID(playerID);
            Parent root = FXMLLoader.load(getClass().getResource("game-view.fxml"));
            stage.setTitle("Board Game");
            stage.setScene(new Scene(root));
            stage.show();
//            Stage stageNow = (Stage)startButton.getScene().getWindow();
//            stageNow.close();
        }
    }

    /**
     * Show the High Score Board when player click this button
     * @param event
     * @throws IOException
     */
    @FXML
    void onHighScoreButtonActive(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("result.fxml"));
        stage.setTitle("Board Game");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onQuitButtonActive(ActionEvent event){
         Stage stage = (Stage)quitButton.getScene().getWindow();
         stage.close();
    }

    /**
     * Get the player's input, and save it as the player's Name
     * @param event
     */
    @FXML
    void inputPlayerID(KeyEvent event){
        playerID = textID.getText();
        idGet = textID.getText();
    }

    /**
     * Initialization
     */
    @FXML
    void initialize(){
        playerID = emp;
        System.out.println("ini in start");
    }

}
