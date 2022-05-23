package com.example.uuii;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.jdi.Bootstrap;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.testng.annotations.Test;

import org.apache.commons.lang3.StringUtils;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DataSave {

    PlayerInfo player = new PlayerInfo();

    public void setPlayer(PlayerInfo player1){
        this.player = player1;
    }

    @Test
    public void save() throws IOException {
        JSONArray jsonArray = new JSONArray();
        File file = new File("E:\\UUII\\src\\main\\resources\\GameData.json");
        FileOutputStream fileOutputStream = new FileOutputStream(file,false);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ID",this.player.getID());
        jsonObject.put("Count", player.getCount());
        jsonObject.put("Start Date", player.getStartDate());
        jsonObject.put("End Date", player.getEndDate());
        jsonObject.put("Game Status", this.player.getGameOver());
        jsonObject.put("Total Time", player.getTotalTime());
        jsonObject.put("Board Status", player.getChessBoard());

        jsonArray.add(jsonObject);

        String jsonString = jsonArray.toString();
        bufferedWriter.write(jsonString);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
