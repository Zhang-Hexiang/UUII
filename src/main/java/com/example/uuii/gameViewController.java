package com.example.uuii;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class gameViewController {

    @FXML
    private Button button00;
    @FXML
    private GridPane grid;
    @FXML
    private Button button01;
    @FXML
    private Button button02;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button score;
    @FXML
    private TableView highScoreTable;
//    @FXML
//    private ImageView kingPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\KING.png");
//    @FXML
//    private ImageView rookPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\ROOK.png");
//    @FXML
//    private ImageView bishopPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\BISHOP.png");


    @FXML
    void onScoreActive(ActionEvent event){
        boolean vis = highScoreTable.isVisible();
        highScoreTable.setVisible(!vis);

    }
    @FXML
    void onButton00Active(ActionEvent event){
        ImageView kingPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\KING.png");
        grid.add(kingPiece,0,0);
    }
    @FXML
    void onButton01Active(ActionEvent event){
        ImageView kingPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\KING.png");
        grid.add(kingPiece,1,0);
        System.out.println("2222");
    }
    @FXML
    void onButton02Active(ActionEvent event){
        ImageView kingPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\KING.png");
        grid.add(kingPiece,2,0);
    }
    @FXML
    void onButton10Active(ActionEvent event){
        ImageView kingPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\KING.png");
        grid.add(kingPiece,0,1);
    }
    @FXML
    void onButton11Active(ActionEvent event){
        ImageView kingPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\KING.png");
        grid.add(kingPiece,1,1);
    }
    @FXML
    void onButton12Active(ActionEvent event){
        ImageView kingPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\KING.png");
        grid.add(kingPiece,2,1);
    }

    public void initialize(){
        System.out.println("ini");
    }

}
