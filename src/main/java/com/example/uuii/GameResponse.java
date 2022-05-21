package com.example.uuii;

import java.io.IOException;
import java.util.Date;

public class GameResponse {

    public void gameEnd(GameStatus gameStatus, PlayerInfo player, DataSave dataSave, long totalTime, int count, Piece[][] pieceB) throws IOException {
        //Date now = new Date();
        long now = System.currentTimeMillis();

        player.setEndDate(now);
        player.setGameOver(gameStatus);
        player.setTotalTime(totalTime);
        player.setCount(count);
        player.setChessBoard(pieceB);
        //player.setEndDate(endDate);
        dataSave.setPlayer(player);
        dataSave.save();

    }
}
