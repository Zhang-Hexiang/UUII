module com.example.uuii {
    requires javafx.controls;
    requires javafx.fxml;
    requires fastjson;
    requires jdk.jdi;
    requires org.apache.commons.lang3;
    requires velocity;
    requires org.testng;
    requires lombok;
    requires org.jdbi.v3.sqlobject;
    requires org.jdbi.v3.core;
    requires org.tinylog.api;
    requires javax.inject;
    requires java.sql;
    requires org.apache.commons.io;


    opens com.example.uuii to javafx.fxml;
    exports com.example.uuii;
}