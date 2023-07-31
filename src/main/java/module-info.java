module com.example.assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires unirest.java;


    opens com.example.assignment2 to com.google.gson, javafx.fxml;
    exports com.example.assignment2;
}