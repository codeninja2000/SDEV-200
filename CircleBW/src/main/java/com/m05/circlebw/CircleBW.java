package com.m05.circlebw;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;

/**
 * JavaFX application that creates a circle that changes color when pressed and released.
 * The circle turns black when pressed and white when released.
 */
public class CircleBW extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Circle circle = new Circle(100, 100, 50);

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        // Event handlers to change the color of the circle
        circle.setOnMousePressed(e -> {
            circle.setFill(Color.BLACK);
        });
        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.WHITE);
        });
        // Create a StackPane to hold the circle
        StackPane pane = new StackPane(circle);
        pane.setStyle("-fx-background-color: lightblue;");
        Scene scene = new Scene(pane, 320, 240);
        stage.setTitle("Circle Color Change");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
