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

        // image paths and their positions in the grid
        String[] imagePaths = {
            "/com.m05.GridPane/images/germany.gif",
            "/com.m05.GridPane/images/china.gif",
            "/com.m05.GridPane/images/fr.gif",
            "/com.m05.GridPane/images/us.jpg"
        };
        int[][] positions = {{0,0}, {1,0}, {0,1}, {1,1}};

        // Load images and add them to the grid pane at specified positions
        for (int i = 0; i < imagePaths.length; i++) {
            try {
                Image img = loadImage(imagePaths[i]);
                if (img != null) {
                    pane.add(new ImageView(img), positions[i][0], positions[i][1]);
                }
            } catch (Exception e) {
                System.err.println("Failed to load image: " + imagePaths[i]);
            }
        }

        // Create a scene with the grid pane
        Scene scene = new Scene(pane);
        stage.setTitle("GridPane Example");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Loads an image from the specified path.
     * @param path The path to the image resource.
     * @return The loaded Image, or null if the resource is not found.
     */
    private Image loadImage(String path) {
        if (getClass().getResource(path) != null) {
            return new Image(getClass().getResource(path).toExternalForm());
        }
        return null;
    }

    public static void main(String[] args) {
        launch();
    }
}