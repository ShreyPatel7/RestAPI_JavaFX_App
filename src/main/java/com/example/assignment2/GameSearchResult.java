package com.example.assignment2;

import com.example.assignment2.Game;
import java.util.ArrayList;
import java.util.List;

public class GameSearchResult {
    // Instance variable to store a list of games
    private List<Game> games;

    // Constructor to create a new GameSearchResult object
    public GameSearchResult() {
        // Initialize the list of games as an empty ArrayList
        games = new ArrayList<>();
    }

    // Method to add a new game to the list
    public void addGame(Game game) {
        // Add the given game object to the list
        games.add(game);
    }

    // Method to get the list of games
    public List<Game> getGames() {
        // Return the list of games
        return games;
    }

    // Method to check if the list of games is empty
    public boolean isEmpty() {
        // Return true if the list is empty, otherwise return false
        return games.isEmpty();
    }

    // Method to get the number of games in the list
    public int getSize() {
        // Return the number of games in the list
        return games.size();
    }
}
