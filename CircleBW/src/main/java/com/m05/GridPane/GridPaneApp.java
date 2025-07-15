package com.m05.GridPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX application that demonstrates the use of GridPane layout.
 * It displays four images in a grid format.
 */
public class GridPaneApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Create a GridPane layout
        GridPane pane = new GridPane();
        // Set alignment, padding, and gaps for the grid pane
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(10);
        pane.setVgap(10);
        // Load images and add them to the grid pane
        pane.add(new ImageView(new Image("/images/germany.gif")), 0, 0);
        pane.add(new ImageView(new Image("/images/china.gif")), 1, 0);
        pane.add(new ImageView(new Image("/images/fr.gif")), 0, 1);
        pane.add(new ImageView(new Image("/images/us.jpg")), 1, 1);

        // Create a scene with the grid pane
        Scene scene = new Scene(pane);
        stage.setTitle("GridPane Example");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}