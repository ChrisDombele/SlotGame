package slotGame;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class mainScreen extends Application {

    Stage window;
    Scene scene1, scene2;

   //First scene

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Slot Game - Main Menu");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Credits Label
        Label creditsLabel = new Label("Created by Raymond Tan, Chris Dombele, and Eric Cruz.");
        GridPane.setConstraints(creditsLabel, 2, 10);
        //Slot Game Label
        Label gameLabel = new Label("SLOT GAME");
        GridPane.setConstraints(gameLabel, 2, 2);
        GridPane.setHalignment(gameLabel,HPos.CENTER);
        GridPane.setValignment(gameLabel,VPos.TOP);
        //amount label
        Label amountLabel = new Label("Enter Amount (¢): ");
        GridPane.setConstraints(amountLabel, 1, 5);
        
        //amount input
        TextField amountInput = new TextField();
        amountInput.setPromptText("0");
        GridPane.setConstraints(amountInput, 2, 5);

        //Play Button
        Button playButton = new Button("Play");
        GridPane.setConstraints(playButton, 2, 6);
        GridPane.setHalignment(playButton,HPos.CENTER);
        GridPane.setValignment(playButton,VPos.BOTTOM);
        playButton.setOnAction(e -> window.setScene(scene2));

        //Add everything to grid
        grid.getChildren().addAll(amountLabel, gameLabel, creditsLabel, amountInput, playButton);
        
        Scene scene1 = new Scene(grid, 552, 300);
        
//        ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        
        //Second scene
    		Random random = new Random();
    	
    		ArrayList<Integer> list = new ArrayList<>();
    		for (int i = 1; i <= 6; i++) {
    			list.add(i);
    		}
    		
    		// Randomizes the picture that will show up
    		int value = random.nextInt(3);
    		int value1 = random.nextInt(3);
    		int value2 = random.nextInt(3);
    	
    		
    		java.util.Collections.shuffle(list);

    		HBox hBox = new HBox(50);
    		hBox.setAlignment(Pos.CENTER);
    		hBox.setPadding(new Insets(0,0,0,0));
    		
    		hBox.getChildren().add(new ImageView("image/" + list.get(value) + ".png"));
    		hBox.getChildren().add(new ImageView("image/" + list.get(value1) + ".png"));
    		hBox.getChildren().add(new ImageView("image/" + list.get(value2) + ".png"));
    			
    		// Create buttons
    		HBox hBtnBox = new HBox(10);
    		hBtnBox.setAlignment(Pos.CENTER);
    		hBtnBox.setPadding(new Insets(5,0,5,0));

    		Button btSpin = new Button("Spin");
    		btSpin.setOnAction(e -> {
    			java.util.Collections.shuffle(list);
    			hBox.getChildren().clear();
    			
    			hBox.getChildren().add(new ImageView("image/" + list.get(0) + ".png"));
    			hBox.getChildren().add(new ImageView("image/" + list.get(1) + ".png"));
    			hBox.getChildren().add(new ImageView("image/" + list.get(2) + ".png"));

//    			this is where the points calculator should go Eric

    		});
    		
    		Button btPlayAgain = new Button("Play Again");
    		btPlayAgain.setOnAction(e -> {
    			//This is where the SlotGame scene switches back to the main screen
    			window.setScene(scene1);
    		});
    		
    		hBtnBox.getChildren().addAll(btSpin, btPlayAgain);
    		
    		BorderPane pane = new BorderPane();
    		pane.setCenter(hBox);
    		pane.setBottom(hBtnBox);
    		BorderPane.setAlignment(btSpin, Pos.CENTER);
    		

    		// Create a scene and place it in the stage
    		scene2 = new Scene(pane, 600, 400);
    		window.setScene(scene1); // Place the scene in the stage
    		window.show(); // Display the stage
    	}
    		
    
    public static void main(String[] args) {
		Application.launch(args);
	}
    
}