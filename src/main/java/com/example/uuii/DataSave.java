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
        bufferedWriter.write("\n");
        bufferedWriter.flush();
        bufferedWriter.close();


/*        String jsonOutput = jsonArray.toJSONString();
        System.out.println(jsonOutput);*/
    }

    public void highScoreSave() throws IOException {
        JSONArray jsonArray = new JSONArray();
        File file = new File("E:\\UUII\\src\\main\\resources\\HighScoreData.json");

        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("ID",this.player.getID());
        jsonObject.put("steps", this.player.getCount());
        String totalTimeString = fromLongToDate("mm:ss",player.getTotalTime());
        jsonObject.put("Total Time",totalTimeString);

        jsonArray.add(jsonObject);

        String jsonString = jsonArray.toString();
        bufferedWriter.write(jsonString);
        bufferedWriter.write("\n");
        bufferedWriter.flush();
        bufferedWriter.close();


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
