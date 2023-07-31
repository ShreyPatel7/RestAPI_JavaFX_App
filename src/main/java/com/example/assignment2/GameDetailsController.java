package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameDetailsController {

    @FXML
    private Label gameNameLabel;

    @FXML
    private Label releaseDateLabel;

    @FXML
    private Label summaryLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private Label urlLabel;

    @FXML
    private Label slugLabel;

    // Instance variables to store the reference to the stage, home scene, and selected game
    private Stage stage;
    private Scene homeScene;
    private Game selectedGame;

    // Method to set the stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Method to set the home scene
    public void setHomeScene(Scene homeScene) {
        this.homeScene = homeScene;
    }

    // Method to set the selected game and display its details
    public void setSelectedGame(Game game) {
        this.selectedGame = game;
        showGameDetails();
    }

    // Method to display the details of the selected game
    private void showGameDetails() {
        // Set the text of labels with the details of the selected game
        gameNameLabel.setText(selectedGame.getName());
        ratingLabel.setText(selectedGame.getRating());
        slugLabel.setText(selectedGame.getSlug());
        releaseDateLabel.setText(selectedGame.getReleaseDate());
        urlLabel.setText(selectedGame.getUrl());
        summaryLabel.setText("Summary: " + selectedGame.getSummary());

        // Apply inline CSS styling for the content elements to customize their appearance
        String contentLabelStyle = "-fx-font-size: 20px; -fx-text-fill: #007bff;";
        String contentTextStyle = "-fx-font-size: 18px; -fx-text-fill: #444444; -fx-padding: 5px 0;";
        gameNameLabel.setStyle(contentLabelStyle);
        ratingLabel.setStyle(contentTextStyle);
        slugLabel.setStyle(contentTextStyle);
        releaseDateLabel.setStyle(contentTextStyle);
        urlLabel.setStyle(contentTextStyle);
        summaryLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #444444; -fx-padding: 5px 0; -fx-wrap-text: true;");
    }

    // Method to handle the "Go Back" button click event
    @FXML
    private void goBack() {
        // Set the scene to the home scene to go back to the main screen
        stage.setScene(homeScene);
    }

    // Method to handle the "Go Home" button click event
    @FXML
    private void goHome() {
        // Create a new instance of the main application and start it to go to the home screen
        HelloApplication helloApp = new HelloApplication();
        helloApp.start(stage);
    }
}

