package com.m05.TextColor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class ColorSelect extends Application {

    // lblTitle is declared as a class variable so it can be accessed in multiple methods
    private Label lblTitle;
    private int red = 0; // red color component
    private int green = 0; // green color component
    private int blue = 0; // blue color component


    @Override
    public void start(Stage primaryStage) {

        VBox vbox = new VBox(); // root layout
        GridPane gpane = new GridPane(); // grid layout for sliders and labels

        // top center title label that will show the current selected color
        lblTitle = new Label("Select Text Color");
        lblTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Create sliders for Red, Green, and Blue color components
        // Each slider will range from 0 to 255, with an initial value of 0
        // and will update the label color when moved

        Label lblRed = new Label("Red");
        Slider redSlider = new Slider(0, 255, 0);
        redSlider.setMinWidth(200);
        redSlider.setMinHeight(25);
        redSlider.setShowTickLabels(true);
        redSlider.setShowTickMarks(true);

        Label lblGreen = new Label("Green");
        Slider greenSlider = new Slider(0, 255, 0);
        greenSlider.setMinWidth(200);
        greenSlider.setMinHeight(25);
        greenSlider.setShowTickLabels(true);
        greenSlider.setShowTickMarks(true);

        Label lblBlue = new Label("Blue");
        Slider blueSlider = new Slider(0, 255, 0);
        blueSlider.setMinWidth(200);
        blueSlider.setMinHeight(25);
        blueSlider.setShowTickLabels(true);
        blueSlider.setShowTickMarks(true);

        // Create listeners for the sliders to update the color
        // when the slider values change

        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            red = newValue.intValue();
            updateLabelColor();
        });

        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            green = newValue.intValue();
            updateLabelColor();
        });

        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            blue = newValue.intValue();
            updateLabelColor();
        });

        // Add the title label to the grid pane
        gpane.add(lblTitle, 0, 0, 2, 1);
        GridPane.setHalignment(lblTitle, javafx.geometry.HPos.CENTER);

        // Add the sliders and labels to the grid pane
        gpane.add(lblRed, 0, 1);
        gpane.add(redSlider, 1, 1);
        gpane.add(lblGreen, 0, 2);
        gpane.add(greenSlider, 1, 2);
        gpane.add(lblBlue, 0, 3);
        gpane.add(blueSlider, 1, 3);

        vbox.getChildren().addAll(gpane);

        // Format the layout
        vbox.setSpacing(10);
        gpane.setHgap(10);
        gpane.setVgap(10);
        gpane.setPadding(new javafx.geometry.Insets(20));
        gpane.setAlignment(javafx.geometry.Pos.CENTER);

        // Create the scene and set it on the stage
        Scene scene = new Scene(vbox, 300, 175);
        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Update the label color when the sliders are moved
    private void updateLabelColor() {
        String color = String.format("rgb(%d, %d, %d)", red, green, blue);
        lblTitle.setTextFill(javafx.scene.paint.Color.rgb(red, green, blue));
        lblTitle.setText(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}