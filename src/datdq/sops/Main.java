/*
 * String Operations Demo
 * DSA Assignment 2
 * @file    Main class file
 * @version 1.0
 * @author  Dat Dinhquoc
 */
package datdq.sops;

//java core classes
import java.util.ArrayList;
import java.util.List;

//javafx classes
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * Main application class
 * @author johnlowvale
 */
public class Main extends Application {

    //properties
    public Stage      primaryStage;
    public Scene      rootScene;
    public BorderPane rootLayout;
    
    //fxml elements
    @FXML
    public TextArea inputText;
    
    @FXML
    public TextArea outputText;
  
    /**
     * Show a message box
     * @param title
     * @param text
     */
    public void showMsg(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(text);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(primaryStage);  
        alert.show();
    }
    
    /**
     * Get screen width
     * @return
     */
    public int getScreenWidth() {
        Rectangle2D bound = Screen.getPrimary().getVisualBounds();
        return (int)bound.getWidth();
    }
    
    /**
     * Get screen height
     * @return
     */
    public int getScreenHeight() {
        Rectangle2D bound = Screen.getPrimary().getVisualBounds();
        return (int)bound.getHeight();
    }
    
    /**
     * Show prompt dialog to get input
     * @param title
     * @return
     */
    public String getInput(String title) {
        Stage  dialog = new Stage();
        Window owner  = inputText.getScene().getWindow();
        int scrWidth  = getScreenWidth();
        int scrHeight = getScreenHeight();
        int dialogW   = 500;
        int dialogH   = 200;

        dialog.setTitle(title);
        dialog.initOwner(owner);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setWidth(dialogW);
        dialog.setHeight(dialogH);
        dialog.setX((scrWidth-dialogW)/2);
        dialog.setY((scrHeight-dialogH)/2);

        TextField textField    = new TextField();
        Button    submitButton = new Button("OK");
        submitButton.setDefaultButton(true);
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent t) {
                dialog.close();
            }
        });
        textField.setMinHeight(TextField.USE_PREF_SIZE);

        final VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER_RIGHT);
        layout.setStyle("-fx-background-color: azure; -fx-padding: 10;");
        layout.getChildren().setAll(
            textField, 
            submitButton
        );

        dialog.setScene(new Scene(layout));
        dialog.showAndWait();

        String result = textField.getText();
        return result;
    }
    
    /**
     * Reset input to default text
     */
    @FXML
    public void resetData() {
        //inputText = (TextArea)rootScene.lookup("#inputText");
        inputText.setText("FIRST\n999\n158\n124\n238\n707\n608\n250\n888\nABC\nXYZ");
    }
    
    /**
     * Concatenate lines in input box
     */
    @FXML
    public void concatenate() {
      
        //get input
        String   input = inputText.getText();
        String[] strs  = input.split("\n");
        
        //make result
        String result = Algos.concatStrs(strs);
        
        //show result
        outputText.setText("Lines concatenated:\n"+result);
    }
    
    /**
     * Find a character in
     */
    @FXML
    public void findCharacter() {
        String str   = inputText.getText();
        String chStr = getInput("Enter a single character");        
        char   character;
        
        //check input
        if (chStr.length()!=1) {
            showMsg("Please enter exactly 1 character");
            return;
        }
        
        character = chStr.charAt(0);
        
        //call algo
        int pos = Algos.findFirstCharacter(str, character);
        
        //result
        if (pos==-1)
            outputText.setText("Character '"+character+"' not found in\n'"+str+"'");
        else
            outputText.setText("First character found at index "+pos);
    }
    
    /**
     * Get input length
     */
    @FXML
    public void getLength() {
        int len = inputText.getText().length();
        
        //result
        outputText.setText("Length of input is "+len);
    }
    
    /**
     * To lower case
     */
    @FXML
    public void toLowercase() {
        String input = inputText.getText();
        
        //get result
        String result = Algos.toLowercase(input);
        
        //set output
        outputText.setText("Lowercase text is:\n"+result);
    }
    
    /**
     * Get substring
     */
    @FXML
    public void getSubstring() {
      
        //get input
        String leftIndexStr  = getInput("Enter left index");
        String rightIndexStr = getInput("Enter right index"); //substr won't include this index
        int    leftIndex     = 0;
        int    rightIndex    = 0;
        
        try {
            leftIndex  = Integer.parseInt(leftIndexStr);
            rightIndex = Integer.parseInt(rightIndexStr); 
        }
        catch (Exception exception) {
            showMsg("Please enter integer values");
            return;
        }
        
        //current text
        String text = inputText.getText();
        
        //check input
        if (leftIndex<0) {
            showMsg("Left index must be >= 0");
            return;
        }
        
        //get result
        String result = Algos.substring(text,leftIndex,rightIndex);
        outputText.setText("Substring is:\n"+result);
    }
    
    /**
     * Trim the whole text
     */
    @FXML
    public void trimText() {
        
        //get input
        String input = inputText.getText();
        
        //get result
        String result = Algos.trimStr(input);
        
        //show result
        outputText.setText("Trimmed text is:\n"+result);
    }
    
    /**
     * Sort lines
     */
    @FXML
    public void sortLines() {
        
        //get input
        String   input = inputText.getText();
        String[] lines = input.split("\n");
        
        //trim
        for (int index=0; index<lines.length; index++)
            lines[index] = lines[index].trim();
        
        //take only numbers
        List<String> numberStrs = new ArrayList<String>();
        
        for (int index=0; index<lines.length; index++) {
            try {
                Integer.valueOf(lines[index]); //-->jump to 'catch' if fails
                numberStrs.add(lines[index]);
            }
            catch (Exception exception) {
                //do nothing
            }
        }//for
        
        //get result
        List<String> sortedStrs = Algos.radixSort(numberStrs);
        
        //show in ui
        outputText.setText("Sorted numbers:\n"+String.join("\n",sortedStrs));
    }
    
    /**
     * Test method for calling from FXML
     */
    @FXML
    public void test() {
        showMsg("Test!");
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
            this.rootScene = scene;
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