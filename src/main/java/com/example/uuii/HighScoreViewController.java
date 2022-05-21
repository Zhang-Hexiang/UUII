package com.example.uuii;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HighScoreViewController {
    @FXML
    private TableView<HighScoreViewController> highScoreTable;
    @FXML
    private TableColumn<HighScoreViewController, Number> rankCol;
    @FXML
    private TableColumn<HighScoreViewController, String> playerIDCol;
    @FXML
    private TableColumn<HighScoreViewController, Number> stepsCol;
    @FXML
    private TableColumn<HighScoreViewController, String> startCol;
    @FXML
    private TableColumn<HighScoreViewController, String> endCol;
    @FXML
    private TableColumn<HighScoreViewController, String> totalCol;

    private String playerID;
    private int playerRank;
    private int playerSteps;
    private Long playerStartTime;
    private Long playerEndTime;
    private Long playerTotalTime;
    private String playerTotalTimeString;

    public HighScoreViewController(PlayerInfo playerInfo){
        this.playerID = playerInfo.getID();
        this.playerSteps = playerInfo.getCount();
        this.playerStartTime = playerInfo.getStartDate();
        this.playerEndTime = playerInfo.getEndDate();
        this.playerTotalTime = playerEndTime - playerStartTime;
    }

    public HighScoreViewController(String id, int steps, Long start, Long end){
        this.playerID = id;
        this.playerSteps = steps;
        this.playerStartTime = start;
        this.playerEndTime = end;
        this.playerTotalTime = playerEndTime - playerStartTime;
    }

    public HighScoreViewController(int rank,String id, int steps, Long start, Long end){
        this.playerRank = rank;
        this.playerID = id;
        this.playerSteps = steps;
        this.playerStartTime = start;
        this.playerEndTime = end;
        this.playerTotalTime = playerEndTime - playerStartTime;
    }
    public HighScoreViewController(int rank, String id, int steps, String totalTime){
        this.playerRank = rank;
        this.playerID = id;
        this.playerSteps = steps;
        this.playerTotalTimeString = totalTime;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPlayerID() {
        return playerID;
    }
    public void setPlayerRank(int rank){
        this.playerRank = rank;
    }

    public int getPlayerRank() {
        return playerRank;
    }
    public void setPlayerStartTime(Long start){
        this.playerStartTime = start;
    }

    public Long getPlayerStartTime() {
        return playerStartTime;
    }

    public void setPlayerEndTime(Long playerEndTime) {
        this.playerEndTime = playerEndTime;
    }

    public Long getPlayerEndTime() {
        return playerEndTime;
    }

    public void setPlayerTotalTime(Long playerTotalTime) {
        this.playerTotalTime = playerTotalTime;
    }

    public Long getPlayerTotalTime() {
        return playerTotalTime;
    }

    @FXML
    void initialize(){
        ObservableList<HighScoreViewController> lis = FXCollections.observableArrayList();
        HighScoreViewController player1 = new HighScoreViewController(1,"aa",10,"123");
        HighScoreViewController player2 = new HighScoreViewController(2,"bb",16,"88888");
        lis.addAll(player1,player2);
        highScoreTable.setItems(lis);

    }
}
