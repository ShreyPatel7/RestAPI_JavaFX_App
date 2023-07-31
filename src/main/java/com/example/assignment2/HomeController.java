package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private TextField searchInput;

    @FXML
    private Button searchButton;

    @FXML
    private ListView<Game> searchResults;

    // Instance variables to store the reference to the main application and the current stage
    private HelloApplication mainApp;
    private Stage stage;

    // Method called when the FXML file is loaded and GUI components are initialized
    @FXML
    private void initialize() {
        // Set the action event for the search button using a lambda expression
        searchButton.setOnAction(event -> searchGames());

        // Set the mouse click event handler for the search results list view
        searchResults.setOnMouseClicked(this::handleGameSelection);
    }

    // Method to set the reference to the main application
    public void setMainApp(HelloApplication mainApp) {
        this.mainApp = mainApp;
    }

    // Method to set the current stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Method to search for games based on user input
    private void searchGames() {
        // Get the user input from the search input text field
        String userInput = searchInput.getText();

        // Get the GameAPIService instance from the main application
        GameAPIService gameAPIService = mainApp.getGameAPIService();

        // Call the searchGames method in GameAPIService to retrieve game search results
        Game[] games = gameAPIService.searchGames(userInput);

        // Check if the search results are not null
        if (games != null) {
            // Clear the existing items in the search results list view
            searchResults.getItems().clear();

            // Add the retrieved games to the search results list view
            searchResults.getItems().addAll(games);
        }
    }

    // Method to handle the selection of a game in the search results list view
    private void handleGameSelection(MouseEvent event) {
        // Get the selected game from the search results list view
        Game selectedGame = searchResults.getSelectionModel().getSelectedItem();

        // Check if a game is selected
        if (selectedGame != null) {
            // Show the details of the selected game using the main application
            mainApp.showGameDetails(selectedGame);
        }
    }
}

