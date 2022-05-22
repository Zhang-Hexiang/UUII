package com.example.uuii;

import com.example.uuii.GameResult;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterBeanMapper(GameResult.class)
public interface GameResultDao {

    @SqlUpdate("""
        create table gameresult102 (
            id int primary key not null,
            playerName varchar2(50) not null,
            stepsByPlayer int not null,
            startTime varchar2(51) not null,
            endTime varchar2(52) not null
        )
        """

    )
/**
 *   create table of game result
 */
    void createTable();
    /**
     *   insert game result into database
     */
    @SqlUpdate("INSERT INTO gameresult102 VALUES (:id,:playerName, :stepsByPlayer, :startTime, :endTime)")
    void insertGameResult(@Bind("id") int id, @Bind("playerName") String playerName, @Bind("stepsByPlayer") int stepsByPlayer, @Bind("startTime") String startTime, @Bind("endTime") String endTime);

    /**
     *   insert game result into database
     */
    @SqlUpdate("INSERT INTO gameresult102 VALUES (:id,:playerName, :stepsByPlayer, :startTime, :endTime)")
    void insertGameResult(@BindBean GameResult gameResult);

    /**
     * Return all the game results from the database
     * @return list of all game results
     */
    @SqlQuery("SELECT * FROM gameresult102 ORDER BY id")
    List<GameResult> listGameResults();

    /**
     * Return top 10 player's data
     * @return top 10 player's data
     */
    @SqlQuery("select * from (select playerName , stepsByPlayer , startTime , endTime from gameresult102 order by stepsByPlayer) where rownum <= 10")
    List<GameResult> listTop10Results();

    /**
     * Return the last game's id
     * @return last game's id
     */
    @SqlQuery("SELECT id FROM gameresult102 WHERE ROWNUM <=1 ORDER BY id DESC")
    int getLastGameID();
}
