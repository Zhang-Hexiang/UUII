package com.example.uuii;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Slf4JSqlLogger;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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
    private Button giveUpButton;
    @FXML
    private Label winText;

    private static boolean win = false;
    private static long totalTime = 0;
    private static int count = 0;
    public static PlayerInfo player = new PlayerInfo();
    public static Chessboard chessboard = new Chessboard();

    private static int emptyRow = 1;
    private static int emptyCol = 2;

    private static int locationRow = 0;
    private static int locationCol = 0;
    private static pieceMove move = new pieceMove();

    /**
     * This button represents that the player wants to move the piece in the 0 row and 0 column
     * @param event on click
     * @throws IOException
     */
    @FXML
    void onButton00Active(ActionEvent event) throws IOException {
        if(!win)
        this.buttonTODO(0,0);
        else
            this.testPrint();
    }

    /**
     * This button represents that the player wants to move the piece in the 0 row and 1 column
     * @param event on click
     * @throws IOException
     */
    @FXML
    void onButton01Active(ActionEvent event) throws IOException {
        if(!win)
         this.buttonTODO(0,1);
        else
            this.testPrint();
    }

    /**
     * This button represents that the player wants to move the piece in the 0 row and 2 column
     * @param event on click
     * @throws IOException
     */
    @FXML
    void onButton02Active(ActionEvent event) throws IOException {
        if(!win)
        this.buttonTODO(0,2);
        else
            this.testPrint();
    }

    /**
     * This button represents that the player wants to move the piece in the 1 row and 0 column
     * @param event on click
     * @throws IOException
     */
    @FXML
    void onButton10Active(ActionEvent event) throws IOException {
        if(!win)
        this.buttonTODO(1,0);
        else
            this.testPrint();
    }

    /**
     * This button represents that the player wants to move the piece in the 1 row and 1 column
     * @param event on click
     * @throws IOException
     */
    @FXML
    void onButton11Active(ActionEvent event) throws IOException {
        if(!win)
        this.buttonTODO(1,1);
        else
            this.testPrint();
    }

    /**
     * This button represents that the player wants to move the piece in the 1 row and 2 column
     * @param event on click
     * @throws IOException
     */
    @FXML
    void onButton12Active(ActionEvent event) throws IOException {
        if (!win)
        this.buttonTODO(1,2);
        else
            this.testPrint();
    }

    /**
     * This button allows player to give up this game
     * the window will close when player click this button
     * @param event on click
     */
    @FXML
    void onGiveUpButtonActive(ActionEvent event) throws IOException {
        DataSave dataSave = new DataSave();
        long endTime = System.currentTimeMillis();
        player.setEndDate(endTime);
        player.setTotalTime(player.getEndDate() - player.getStartDate());
        player.setGameOver(GameStatus.GIVEUP);
        player.setChessBoard(chessboard.getcBoard());
        player.setCount(count);
        dataSave.setPlayer(player);
        dataSave.save();
        Stage stage = (Stage)giveUpButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Initialization
     */
    public void initialize(){

        System.out.println("ini in game view");

        win = false;
        totalTime = 0;
        count = 0;
        player = new PlayerInfo();
        chessboard = new Chessboard();
        player.setStartDate(System.currentTimeMillis());
        player.setID(StartViewController.idGet);
        emptyRow = 1;
        emptyCol = 2;
        winText.setVisible(false);

        locationRow = 0;
        locationCol = 0;
        move = new pieceMove();
    }

    public void buttonTODO(int row, int col) throws IOException {
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
                DataSave dataSave = new DataSave();
                long endTime = System.currentTimeMillis();
                player.setEndDate(endTime);
                player.setTotalTime(player.getEndDate() - player.getStartDate());
                player.setGameOver(GameStatus.WIN);
                player.setChessBoard(chessboard.getcBoard());
                player.setCount(count);
                dataSave.setPlayer(player);
                dataSave.save();

                Jdbi jdbi = Jdbi.create("jdbc:oracle:thin:@oracle.inf.unideb.hu:1521:ora19c", "U_BRUL3M", "kalvinter");
                jdbi.installPlugin(new SqlObjectPlugin());
                jdbi.setSqlLogger(new Slf4JSqlLogger());
                List<GameResult> gameResults = jdbi.withExtension(GameResultDao.class, dao -> {
                   // dao.createTable();  This code is for the first time running to create table.
                    int lastGameID = dao.getLastGameID();

                    dao.insertGameResult(new GameResult(lastGameID + 1, player.getID(), count, fromLongToDate("yyyy-MM-dd HH:mm:ss", player.getStartDate()), fromLongToDate("yyyy-MM-dd HH:mm:ss", player.getEndDate())));
                    return dao.listGameResults();
                });
                gameResults.forEach(System.out::println);

                giveUpButton.setVisible(false);
                winText.setVisible(true);

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

    /**
     *
     * @param format Set the time format
     * @param time Input the time
     * @return the String type time with the given format
     */
    public static String fromLongToDate(String format, Long time){
        SimpleDateFormat sdf= new SimpleDateFormat(format);
        java.util.Date dt = new Date(time);
        String sDateTime = sdf.format(dt);
        return sDateTime;
    }
}
