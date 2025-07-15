module com.m05.circlebw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.m05.circlebw to javafx.fxml;
    exports com.m05.circlebw;
    opens com.m05.TextColor to javafx.fxml;
    exports com.m05.TextColor;
    opens com.m05.GridPane to javafx.fxml;
    exports com.m05.GridPane;


}