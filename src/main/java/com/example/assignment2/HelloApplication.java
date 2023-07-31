package com.example.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    // Instance variable to store the primary stage of the application
    private Stage primaryStage;

    // Instance variable to store the game API service for fetching game data from the API
    private GameAPIService gameAPIService;

    // Method called when the application starts
    @Override
    public void start(Stage primaryStage) {
        // Initialize the primary stage and set the application title
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Game Search App using RestAPI");

        // Set the application icon (optional)
        primaryStage.getIcons().add(new Image("icon.png"));

        // Create a new instance of the GameAPIService to interact with the game API
        gameAPIService = new GameAPIService();

        // Show the home scene main screen of the application
        showHomeScene();
    }

    // Method to show the home scene (main screen) of the application
    private void showHomeScene() {
        try {
            // Load the home.fxml file using FXMLLoader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("home.fxml"));
            BorderPane homeScene = loader.load();

            // Get the controller associated with the home scene and set its main app and stage
            HomeController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(primaryStage);

            // Create a new scene with the home scene as the root node and set it to the primary stage
            Scene scene = new Scene(homeScene);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to show the game details scene for the selected game
    public void showGameDetails(Game selectedGame) {
        try {
            // Load the gameDetails.fxml file using FXMLLoader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("gameDetails.fxml"));
            AnchorPane gameDetailsScene = loader.load();

            // Get the controller associated with the game details scene and set the selected game and stage
            GameDetailsController controller = loader.getController();
            controller.setSelectedGame(selectedGame);
            controller.setStage(primaryStage);
            controller.setHomeScene(primaryStage.getScene()); // Save the home scene for the back button

            // Create a new scene with the game details scene as the root node and set it to the primary stage
            Scene scene = new Scene(gameDetailsScene);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the GameAPIService instance for fetching game data
    public GameAPIService getGameAPIService() {
        return gameAPIService;
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}

