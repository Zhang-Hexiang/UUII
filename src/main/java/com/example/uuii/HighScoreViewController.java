package com.example.uuii;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Slf4JSqlLogger;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.tinylog.Logger;

import javax.inject.Inject;
import java.util.List;

public class HighScoreViewController {
    @FXML
    private TableColumn<GameResult , String> winnerName;
    @FXML
    private TableColumn<GameResult , Integer> TotalMoves;
    @FXML
    private TableColumn<GameResult , String> StartTime;
    @FXML
    private TableColumn<GameResult , String> EndTime;

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private GameResultDao gameResultDao;

    @FXML
    private TableView<GameResult> highScoreTable;


    @FXML
    private void initialize() {

        Logger.debug("Loading high scores...");
        Jdbi jdbi = Jdbi.create("jdbc:oracle:thin:@oracle.inf.unideb.hu:1521:ora19c", "U_BRUL3M", "kalvinter");
        jdbi.installPlugin(new SqlObjectPlugin());
        jdbi.setSqlLogger(new Slf4JSqlLogger());
        /**
         * Get sorted data
         */
        List<GameResult> winnerResults = jdbi.withExtension(GameResultDao.class, GameResultDao::listTop10Results);
        winnerName.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        TotalMoves.setCellValueFactory(new PropertyValueFactory<>("stepsByPlayer"));
        StartTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        EndTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));

        ObservableList<GameResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(winnerResults);
        highScoreTable.setItems(observableResult);

    }

}
