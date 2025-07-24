package com.m06.p02_batch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JavaFX application to demonstrate batch and non-batch database operations.
 * It allows users to connect to a database, perform batch updates, and compare performance.
 */
public class Batch extends Application {
    private TextField driverField;
    private TextField urlField;
    private TextField userField;
    private PasswordField passwordField;
    private Label statusLabel;
    private TextArea outputArea;
    private static Connection conn;
    private static PreparedStatement ps;
    private static final int BATCH_SIZE = 1000;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        // Create form fields
        driverField = new TextField("com.mysql.cj.jdbc.Driver");
        urlField = new TextField("jdbc:mysql://localhost/db");
        userField = new TextField();
        passwordField = new PasswordField();
        statusLabel = new Label();
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefRowCount(10);

        // Create buttons
        Button connectButton = new Button("Connect");
        Button batchButton = new Button("Run Batch Update");
        Button nonBatchButton = new Button("Run Non-Batch Update");

        // Initially disable the operation buttons
        batchButton.setDisable(true);
        nonBatchButton.setDisable(true);


        // Add components to grid
        grid.add(new Label("JDBC Driver:"), 0, 0);
        grid.add(driverField, 1, 0);
        grid.add(new Label("Database URL:"), 0, 1);
        grid.add(urlField, 1, 1);
        grid.add(new Label("Username:"), 0, 2);
        grid.add(userField, 1, 2);
        grid.add(new Label("Password:"), 0, 3);
        grid.add(passwordField, 1, 3);

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(connectButton, batchButton, nonBatchButton);
        grid.add(buttonBox, 1, 4);
        grid.add(statusLabel, 1, 5);
        grid.add(outputArea, 0, 6, 2, 1);

        // Connect button action
        connectButton.setOnAction(e -> {
            if (connectToDatabase()) {
                batchButton.setDisable(false);
                nonBatchButton.setDisable(false);
            }
        });

        // Batch update button action
        batchButton.setOnAction(e -> {
            new Thread(() -> {
                try {
                    updateOutput("Starting batch update...\n");
                    long batchTime = runBatch();
                    updateOutput("Batch update completed in " + batchTime + " ns\n");
                } catch (SQLException ex) {
                    updateOutput("Error: " + ex.getMessage() + "\n");
                }
            }).start();
        });

        // Non-batch update button action
        nonBatchButton.setOnAction(e -> {
            new Thread(() -> {
                try {
                    updateOutput("Starting non-batch update...\n");
                    long noBatchTime = runNoBatch();
                    updateOutput("Non-batch update completed in " + noBatchTime + " ns\n");
                } catch (SQLException ex) {
                    updateOutput("Error: " + ex.getMessage() + "\n");
                }
            }).start();
        });


        Scene scene = new Scene(grid, 500, 600);
        stage.setTitle("Database Batch Operations");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e -> {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            Platform.exit();
        });
    }

    private boolean connectToDatabase() {
        String driver = driverField.getText();
        String url = urlField.getText();
        String user = userField.getText();
        String password = passwordField.getText();

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into Temp (num1, num2, num3) values (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            
            statusLabel.setText("Connection successful!");
            statusLabel.setStyle("-fx-text-fill: green;");
            return true;
        } catch (Exception e) {
            statusLabel.setText("Connection failed: " + e.getMessage());
            statusLabel.setStyle("-fx-text-fill: red;");
            return false;
        }
    }

    private void runBatchTests() {
        new Thread(() -> {
            try {
                updateOutput("Starting batch operations...\n");
                
                updateOutput("Started inserting numbers using Batch update\n");
                long batchTime = runBatch();
                updateOutput("Batch update completed in " + batchTime + " ns\n\n");

                updateOutput("Started inserting numbers using Non-Batch update\n");
                long noBatchTime = runNoBatch();
                updateOutput("Non-Batch update completed in " + noBatchTime + " ns\n");
                
                updateOutput("All operations completed successfully!\n");
            } catch (SQLException e) {
                updateOutput("Error: " + e.getMessage() + "\n");
            }
        }).start();
    }

    private void updateOutput(String text) {
        Platform.runLater(() -> outputArea.appendText(text));
    }

    private long runBatch() throws SQLException {
        long startTime = System.nanoTime();

        for (int i = 0; i < BATCH_SIZE; i++) {
            ps.setDouble(1, Math.random());
            ps.setDouble(2, Math.random());
            ps.setDouble(3, Math.random());
            ps.addBatch();
        }
        ps.executeBatch();

        return System.nanoTime() - startTime;
    }

    private long runNoBatch() throws SQLException {
        long startTime = System.nanoTime();

        for (int i = 0; i < BATCH_SIZE; i++) {
            ps.setDouble(1, Math.random());
            ps.setDouble(2, Math.random());
            ps.setDouble(3, Math.random());
            ps.executeUpdate();
        }

        return System.nanoTime() - startTime;
    }
}
