package com.example.uuii;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    public static boolean start = false;
    public static boolean giveUp = false;
    public static boolean win = false;
    public static long totalTime = 0;
    public static int count = 0;
    public static PlayerInfo player = new PlayerInfo();
    public static Chessboard chessboard = new Chessboard();

    public static int emptyRow = 1;
    public static int emptyCol = 2;

    public static int locationRow = 0;
    public static int locationCol = 0;
    public static pieceMove move = new pieceMove();

    @FXML
    void onButton00Active(ActionEvent event){
        if(!win)
        this.buttonTODO(0,0);
        else
            this.testPrint();
    }
    @FXML
    void onButton01Active(ActionEvent event){
        if(!win)
         this.buttonTODO(0,1);
        else
            this.testPrint();
    }
    @FXML
    void onButton02Active(ActionEvent event){
        if(!win)
        this.buttonTODO(0,2);
        else
            this.testPrint();
    }
    @FXML
    void onButton10Active(ActionEvent event){
        if(!win)
        this.buttonTODO(1,0);
        else
            this.testPrint();
    }
    @FXML
    void onButton11Active(ActionEvent event){
        if(!win)
        this.buttonTODO(1,1);
        else
            this.testPrint();
    }
    @FXML
    void onButton12Active(ActionEvent event){
        if (!win)
        this.buttonTODO(1,2);
        else
            this.testPrint();
    }

    public void initialize(){

        System.out.println("ini in game view");

        start = false;
        giveUp = false;
        win = false;
        totalTime = 0;
        count = 0;
        player = new PlayerInfo();
        chessboard = new Chessboard();
        player.setStartDate(System.currentTimeMillis());
        emptyRow = 1;
        emptyCol = 2;

        locationRow = 0;
        locationCol = 0;
        move = new pieceMove();
    }

    public void buttonTODO(int row, int col){
        Piece piece = chessboard.getcBoard()[row][col];
        locationRow = row;
        locationCol = col;
        if(move.isMovable(chessboard.getcBoard(),locationRow,locationCol)){
            chessboard.swap(locationRow,locationCol,emptyRow,emptyCol);
            count++;
            System.out.println(count);
            win = chessboard.isPlayerWin();
            ImageView kingPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\KING.png");
            ImageView emptyPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\EMPTY.png");
            ImageView rookPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\ROOK.png");
            ImageView bishopPiece = new ImageView("E:\\UUII\\src\\main\\resources\\image\\BISHOP.png");
            switch (piece){
                case ROOK:
                    grid.add(rookPiece,emptyCol,emptyRow);
                    break;
                case BISHOP:
                    grid.add(bishopPiece,emptyCol,emptyRow);
                    break;
                case KING:
                    grid.add(kingPiece,emptyCol,emptyRow);
                    break;
            }

            emptyRow = locationRow;
            emptyCol = locationCol;

            grid.add(emptyPiece,locationCol,locationRow);
            if(win){
                long endTime = System.currentTimeMillis();
                player.setEndDate(endTime);
                player.setTotalTime(player.getEndDate() - player.getStartDate());
            }
        }
    }

    public void testPrint(){

        String dateStart = fromLongToDate("yyyy-MM-dd HH:mm:ss",player.getStartDate());
        String dateEnd = fromLongToDate("yyyy-MM-dd HH:mm:ss", player.getEndDate());
        System.out.println(player.getID());
        System.out.println(count);
        System.out.println(player.getStartDate());
        System.out.println(dateStart);
        System.out.println(player.getEndDate());
        System.out.println(dateEnd);
    }

    public static String fromLongToDate(String format, Long time){
        SimpleDateFormat sdf= new SimpleDateFormat(format);
//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        java.util.Date dt = new Date(time);
        String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
        //System.out.println(sDateTime);
        return sDateTime;
    }
}
