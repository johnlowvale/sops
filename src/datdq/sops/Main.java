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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Main application class
 * @author johnlowvale
 */
public class Main extends Application {

    //properties
    public Stage      primaryStage;
    public BorderPane rootLayout;
  
    /**
     * Show a message box
     * @param title
     * @param text
     */
    public void showMsg(String title,String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(primaryStage);  
        alert.show();
    }
    
    /**
     * Test method for calling from FXML
     */
    @FXML
    public void test() {
        showMsg("Message","Test!");
    }
    
    /**
     * JavaFX entry point
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
      
        try {
            primaryStage.setMaximized(true);
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