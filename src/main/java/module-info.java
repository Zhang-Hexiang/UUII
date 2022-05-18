module com.example.uuii {
    requires javafx.controls;
    requires javafx.fxml;
    requires fastjson;
    requires jdk.jdi;
    requires org.apache.commons.lang3;
    requires velocity;
    requires org.testng;
    requires lombok;


    opens com.example.uuii to javafx.fxml;
    exports com.example.uuii;
}