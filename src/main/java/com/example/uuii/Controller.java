package com.example.uuii;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button hello;
    @FXML
    private GridPane grid;
    @FXML
    private ImageView kingPiece;


    int row = 0;
    int col = 0;

    @FXML
    void onHelloButtonClick(ActionEvent event){
        System.out.println("click!");

    }

    @FXML
    void clickOnKING(MouseEvent event){
        System.out.println("King!");
        grid.add(kingPiece,row,col++);

    }

    public void initialize(){
        System.out.println("init");
    }
}
