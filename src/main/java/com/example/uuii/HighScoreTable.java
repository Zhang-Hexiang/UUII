package com.example.uuii;

public class HighScoreTable {
    public PlayerInfo compare(PlayerInfo a, PlayerInfo b){    // 比较 a和b 返回值为排名靠前的一个
        if(a.getCount() < b.getCount()){  // 首先比较步数  步数小的靠前
            return a;
        }
        else if(a.getCount() == b.getCount()
                && a.getTotalTime().compareTo(b.getTotalTime()) < 0){  //  第二比较用时  用时少的靠前
            return a;
        }
        else if(a.getCount() == b.getCount()
                && a.getTotalTime().compareTo(b.getTotalTime()) < 0  //  第三比较游戏结束时间  结束时间早的靠前
                && a.getEndDate().compareTo(b.getEndDate()) < 0){
            return a;
        }
        else
            return b;
    }
}
