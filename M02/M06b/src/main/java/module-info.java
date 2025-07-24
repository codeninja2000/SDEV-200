module com.m06.p02_batch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.m06.p02_batch to javafx.fxml;
    exports com.m06.p02_batch;
}