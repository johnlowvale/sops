/*
 * String Operations Demo
 * DSA Assignment 2
 * @file    Main class file
 * @version 1.0
 * @author  Dat Dinhquoc
 */
package datdq.sops;

//javafx classes
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main application class
 * @author johnlowvale
 */
public class Main extends Application {

    //properties
    private BorderPane rootLayout;
  
    /**
     * JavaFX entry point
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Sops - String Operations Demo - datdqgt00570@fpt.edu.vn");
     
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("main.fxml"));
            rootLayout = (BorderPane)loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } 
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Java programme entry point
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

//end of file