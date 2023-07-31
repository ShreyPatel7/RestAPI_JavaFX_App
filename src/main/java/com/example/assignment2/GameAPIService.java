package com.example.assignment2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class GameAPIService {
    // constant variables store the API URL, API key, and client ID
    private static final String API_URL = "https://api.igdb.com/v4/games";
    private static final String API_KEY = "y1qko5fn3dgnkh7vox4olcb7ev3l1f";
    private static final String CLIENT_ID = "35f7yuk8s2b90jm8lajqmsqelzdsdf";

    // Method to search for games based on user input
    public Game[] searchGames(String userInput) {
        try {
            // Make a POST request to the API with the user input as the search query
            HttpResponse<JsonNode> response = Unirest.post(API_URL)
                    .header("Authorization", "Bearer " + API_KEY)
                    .header("Client-ID", CLIENT_ID)
                    .queryString("search", userInput)
                    .queryString("fields", "*") // Fetch all fields for the games
                    .asJson();

            // Create a Gson object to parse the JSON response into Game objects
            Gson gson = new Gson();
            Game[] games = gson.fromJson(response.getBody().toString(), Game[].class);

            // Handle null or empty releaseDates in the JSON response
            if (games != null) {
                for (Game game : games) {
                    if (game.getReleaseDates() == null || game.getReleaseDates().isEmpty()) {
                        // If the release dates are missing, set the release date as "Unknown"
                        game.setReleaseDate("Unknown");
                    } else {
                        // If the release dates are available, format them into a readable date
                        game.setReleaseDate(game.getFormattedReleaseDate());
                    }
                }
            }

            // Return the array of Game objects representing the search results
            return games;
        } catch (Exception e) {
            // Print any errors that occur during the API request and return null
            e.printStackTrace();
            return null;
        }
    }
}
