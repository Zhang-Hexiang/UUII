package com.example.uuii;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameResult {

    private int id;
    private String playerName;
    private int stepsByPlayer;
    private String startTime;
    private String endTime;
}
