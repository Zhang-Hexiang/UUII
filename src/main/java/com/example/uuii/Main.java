package com.example.uuii;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.*;

public class Main extends Application {
    @SneakyThrows
    public static void main(String[] args)  {
        boolean start = true;
        boolean pause = false;
        boolean contiNUE = false;
        boolean giveUp = false;
        boolean win = false;
        long totalTime = 0;
        int count = 0;

        int locationRow =0,locationCol =0;

        DataSave dataSave = new DataSave();
        // PlayerInfo playertest = dataSave.read();
        PlayerInfo player = new PlayerInfo();

        launch();

        System.out.println("Please enter your ID : ");

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        player.setID(str);

        player.setCount(count);

        Date dateNow = new Date();

        player.setStartDate(dateNow);

        long startTime = System.currentTimeMillis();


        player.setGameOver(GameStatus.RUNNING);




        Chessboard pieceB = new Chessboard();

        while(player.getGameOver() == GameStatus.RUNNING){
            System.out.println(pieceB.getcBoard()[0][0]+ " " +pieceB.getcBoard()[0][1] + " "+pieceB.getcBoard()[0][2]);
            System.out.println(pieceB.getcBoard()[1][0]+ " " +pieceB.getcBoard()[1][1] + "   "+pieceB.getcBoard()[1][2]);

            System.out.println("enter next row");
            locationRow = input.nextInt();
            System.out.println("Enter next col");
            locationCol = input.nextInt();

            pieceMove movable = new pieceMove();
            if(movable.isMovable(pieceB.getcBoard(),locationRow,locationCol)){
                int emptyRow = 0, emptyCol = 0;     //记录空棋格位置信息
                for(int r = 0; r < 2; r++){       //遍历棋盘找出空棋格位置
                    for (int c = 0; c < 3; c++){
                        if(pieceB.getcBoard()[r][c] == Piece.EMPTY){
                            emptyCol = c;
                            emptyRow = r;
                        }
                    }
                }

                pieceB.swap(locationRow,locationCol,emptyRow,emptyCol);
                count++;

                //win = pieceB.isPlayerWin();
                win = pieceB.testWin();

                if(win) break;
                else continue;
            }
            else{
                System.out.println("EMPTY!");
                continue;
            }

        }
        input.close();
//-------------------游戏结束------------------------------------------------

        long endTime = System.currentTimeMillis();

        totalTime += (endTime - startTime);
        GameResponse gameResponse = new GameResponse();


        if(win){
            gameResponse.gameEnd(GameStatus.WIN,player,dataSave,totalTime,count,pieceB.getcBoard());
            System.out.println("WIN!");
        }
        else if(pause){
            gameResponse.gameEnd(GameStatus.PAUSE,player,dataSave,totalTime,count,pieceB.getcBoard());
            System.out.println("PAUSE");
        }
        else if(giveUp){
            gameResponse.gameEnd(GameStatus.GIVEUP,player,dataSave,totalTime,count,pieceB.getcBoard());
            System.out.println("FAIL");
        }
        //launch();
    }

    @Override
    public void start(Stage stage) {

        Label label = new Label("pls enter your ID!");
        BorderPane pane = new BorderPane(label);

        Scene scene = new Scene(pane,300,300);
        stage.setScene(scene);

        stage.setTitle("Sample");
        stage.show();
    }
}
