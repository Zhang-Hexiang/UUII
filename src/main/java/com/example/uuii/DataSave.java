package com.example.uuii;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.jdi.Bootstrap;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.testng.annotations.Test;

import org.apache.commons.lang3.StringUtils;


import java.io.*;


public class DataSave {
    JSONArray jsonArray = new JSONArray();
    PlayerInfo player = new PlayerInfo();



    public void setPlayer(PlayerInfo player1){
        this.player = player1;
    }




    @Test
    public void save() throws IOException {
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
        bufferedWriter.write("\n");
        bufferedWriter.flush();
        bufferedWriter.close();


/*        String jsonOutput = jsonArray.toJSONString();
        System.out.println(jsonOutput);*/
    }

//    @Test
//    public PlayerInfo read(){
//        File file = new File("C:\\Users\\acer\\IdeaProjects\\SWEFinalProject\\src\\main\\resources\\GameData.json");
//        JSONObject jsonObject = new JSONObject();
//        jsonArray.add(jsonObject);
//        String jsonString = jsonArray.toJSONString();
//
//        PlayerInfo player = JSON.parseObject(jsonString, PlayerInfo.class);
//
//        System.out.println(player);
//
//        return player;
//
//    }

}
