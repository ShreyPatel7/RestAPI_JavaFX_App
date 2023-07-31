package com.example.assignment2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Game {
    // Instance variables to store game details
    private String name;         // Store the name of the game
    private String genre;        // Store the genre of the game
    private String releaseDate;  // Store the release date of the game
    private String url;          // Store the URL of the game
    private List<Integer> releaseDates; // Store a list of release dates (in case there are multiple releases)
    private String rating;       // Store the rating of the game
    private String slug;         // Store the slug (short name) of the game
    private String summary;      // Store the summary/description of the game

    // Constructor to create a new Game object and initialize its details
    public Game(String name, String genre, String releaseDate, List<Integer> releaseDates, String url) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.releaseDates = releaseDates;
        this.url = url;
    }

    // Getter methods to access the game details

    // Method to get the name of the game
    public String getName() {
        return name;
    }

    // Method to get the release date of the game
    public String getReleaseDate() {
        return releaseDate;
    }

    // Method to get the URL of the game
    public String getUrl() {
        return url;
    }

    // Method to get the rating of the game
    public String getRating() {
        return rating;
    }

    // Method to get the slug (short name) of the game
    public String getSlug() {
        return slug;
    }

    // Override the toString method to represent the game as its name
    @Override
    public String toString() {
        return name;
    }

    // Method to get the summary/description of the game
    public String getSummary() {
        return summary;
    }

    // Method to get a formatted release date (in the format yyyy-MM-dd)
    public String getFormattedReleaseDate() {
        if (releaseDates != null && !releaseDates.isEmpty()) {
            int releaseDateValue = releaseDates.get(0); // Get the first release date from the list

            // Assuming the releaseDateValue is an epoch timestamp in seconds:
            Date date = new Date(releaseDateValue * 1000L);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
        return "Unknown";
    }

    // Method to get the list of release dates (in case there are multiple releases)
    public List<Integer> getReleaseDates() {
        return releaseDates;
    }

    // Setter method to update the release date of the game
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
