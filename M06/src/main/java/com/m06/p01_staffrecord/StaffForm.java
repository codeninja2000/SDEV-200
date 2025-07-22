package com.m06.p01_staffrecord;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * StaffForm is a JavaFX application that provides a user interface for managing staff records.
 * It allows users to search, save, update, and delete staff records in a database.
 * This application uses a StaffDao (Data Access Object) to interact with the database.
 */
public class StaffForm extends Application {
    String dbUrl = "jdbc:mysql://localhost:3306/dundermifflindb";
    String user = "mscott"; // Example connection string, adjust as needed
    String password = "abc123"; // Example connection string, adjust as needed
    private StaffDao staffDao = new StaffDao(new DbConnection(dbUrl, user, password));

    // Text fields for each attribute
    private TextField idField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField miField = new TextField();
    private TextField addressField = new TextField();
    private TextField cityField = new TextField();
    private TextField stateField = new TextField();
    private TextField telephoneField = new TextField();
    private TextField emailField = new TextField();

    public static void main(String[] args) {

        // This block was created for connection testing purposes, but it is a convenient way
        // to check whether the database was successful in opening, so I left it.
        DbConnection dbConnection = new DbConnection("jdbc:mysql://localhost:3306/dundermifflindb", "mscott", "abc123");
        try {
            dbConnection.testConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Connection failed", e);
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize your DAO (you'll need to set up dbConnection)
        // staffDao = new StaffDao(dbConnection);

        // Create the main layout
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));

        // Create the form grid
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        // Add form fields with labels
        addFormField(grid, "ID:", idField, 0);
        addFormField(grid, "Last Name:", lastNameField, 1);
        addFormField(grid, "First Name:", firstNameField, 2);
        addFormField(grid, "MI:", miField, 3);
        addFormField(grid, "Address:", addressField, 4);
        addFormField(grid, "City:", cityField, 5);
        addFormField(grid, "State:", stateField, 6);
        addFormField(grid, "Telephone:", telephoneField, 7);
        addFormField(grid, "Email:", emailField, 8);

        // Set up constraints for fields
        miField.setPrefWidth(30); // Middle initial should be small
        stateField.setPrefWidth(50); // State should be small

        // Create buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        Button searchButton = new Button("Search");
        Button saveButton = new Button("Save");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        Button clearButton = new Button("Clear");
        buttonBox.getChildren().addAll(searchButton, saveButton, updateButton, deleteButton, clearButton);

        // Add event handlers
        searchButton.setOnAction(e -> searchStaff());
        saveButton.setOnAction(e -> saveStaff());
        updateButton.setOnAction(e -> updateStaff());
        deleteButton.setOnAction(e -> deleteStaff());
        clearButton.setOnAction(e -> clearForm());

        // Add components to main layout
        mainLayout.getChildren().addAll(grid, buttonBox);

        // Create and show the scene
        Scene scene = new Scene(mainLayout);
        primaryStage.setTitle("Staff Record");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Adds a form field with a label to the specified grid at the given row.
     *
     * @param grid      The GridPane to add the field to.
     * @param labelText The text for the label.
     * @param field     The TextField to add.
     * @param row       The row index in the grid where the field should be added.
     */
    private void addFormField(GridPane grid, String labelText, TextField field, int row) {
        Label label = new Label(labelText);
        grid.add(label, 0, row);
        grid.add(field, 1, row);
    }

    /**
     * Searches for a staff member by ID and populates the form fields with the retrieved data.
     * If no staff member is found, an alert is shown.
     */
    private void searchStaff() {
        String id = idField.getText().trim();
        if (id.isEmpty()) {
            showAlert("Error", "Please enter an ID to search");
            return;
        }

        staffDao.viewById(id).ifPresentOrElse(
                staff -> {
                    // Populate fields with staff data
                    lastNameField.setText(staff.getLastName());
                    firstNameField.setText(staff.getFirstName());
                    miField.setText(staff.getMi());
                    addressField.setText(staff.getAddress());
                    cityField.setText(staff.getCity());
                    stateField.setText(staff.getState());
                    telephoneField.setText(staff.getTelephone());
                    emailField.setText(staff.getEmail());
                },
                () -> showAlert("Not Found", "No staff member found with ID: " + id)
        );
    }

    /**
     * Saves a new staff member using the data from the form fields.
     * If successful, an alert is shown and the form is cleared.
     * If an error occurs, an alert is shown with the error message.
     */
    private void saveStaff() {
        try {
            Staff staff = createStaffFromFields();
            staffDao.insert(staff);
            showAlert("Success", "Staff member saved successfully");
            clearForm();
        } catch (Exception e) {
            showAlert("Error", "Error saving staff member: " + e.getMessage());
        }
    }

    /**
     * Updates an existing staff member using the data from the form fields.
     * If successful, an alert is shown.
     * If an error occurs, an alert is shown with the error message.
     */
    private void updateStaff() {
        try {
            Staff staff = createStaffFromFields();
            staffDao.update(staff);
            showAlert("Success", "Staff member updated successfully");
        } catch (Exception e) {
            showAlert("Error", "Error updating staff member: " + e.getMessage());
        }
    }

    /**
     * Deletes a staff member by ID.
     * If successful, an alert is shown and the form is cleared.
     * If an error occurs, an alert is shown with the error message.
     */
    private void deleteStaff() {
        String id = idField.getText().trim();
        if (id.isEmpty()) {
            showAlert("Error", "Please enter an ID to delete");
            return;
        }

        try {
            staffDao.delete(id);
            showAlert("Success", "Staff member deleted successfully");
            clearForm();
        } catch (Exception e) {
            showAlert("Error", "Error deleting staff member: " + e.getMessage());
        }
    }

    /**
     * Creates a Staff object from the data in the form fields.
     *
     * @return A Staff object populated with the data from the form.
     */
    private Staff createStaffFromFields() {
        return new Staff(
                idField.getText().trim(),
                lastNameField.getText().trim(),
                firstNameField.getText().trim(),
                miField.getText().trim(),
                addressField.getText().trim(),
                cityField.getText().trim(),
                stateField.getText().trim(),
                telephoneField.getText().trim(),
                emailField.getText().trim()
        );
    }

    /**
     * Clears all form fields.
     */
    private void clearForm() {
        idField.clear();
        lastNameField.clear();
        firstNameField.clear();
        miField.clear();
        addressField.clear();
        cityField.clear();
        stateField.clear();
        telephoneField.clear();
        emailField.clear();
    }

    /**
     * Shows an alert dialog with the specified title and content.
     *
     * @param title   The title of the alert dialog.
     * @param content The content message of the alert dialog.
     */
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}