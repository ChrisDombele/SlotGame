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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SlotGameGui extends Application {
	
	private int counter = 0;
    Stage  stage1, stage2, stage3, window;
    Scene scene1, scene2, scene3;
    
    
    public static void main(String[] args) {
		Application.launch(args);
	}
    
   /*
    * Main Screen
    */
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

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
        
        //scene 1 is created
        Scene scene1 = new Scene(grid, 552, 300);
        
        /*
         *  End of mainScreen
         */
        
    		Random random = new Random();
    	
    		ArrayList<Integer> list = new ArrayList<>();
    		for (int i = 1; i <= 13; i++) {
    			list.add(i);
    		}
    		
    		// Randomizes the picture that will show up
    		int value = random.nextInt(3);
    		int value1 = random.nextInt(3);
    		int value2 = random.nextInt(3);
    	
    		
    		java.util.Collections.shuffle(list);

    		HBox hBox = new HBox(50); // space between pictures
    		hBox.setAlignment(Pos.CENTER);
    		hBox.setPadding(new Insets(0,0,0,0));
    		
    		hBox.getChildren().add(new ImageView("image/" + list.get(value) + ".png"));
    		hBox.getChildren().add(new ImageView("image/" + list.get(value1) + ".png"));
    		hBox.getChildren().add(new ImageView("image/" + list.get(value2) + ".png"));
    			
    		// Create buttons
    		HBox hBtnBox = new HBox(10);
    		hBtnBox.setAlignment(Pos.CENTER);
    		hBtnBox.setPadding(new Insets(5,0,5,0));

    		Label counter = new Label("Trials until jackpot: "); 
    		
    		
    		Button btSpin = new Button("Spin");
    		btSpin.setOnAction(e -> {
    			java.util.Collections.shuffle(list);
    			hBox.getChildren().clear();
    			
    			hBox.getChildren().add(new ImageView("image/" + list.get(0) + ".png"));
    			hBox.getChildren().add(new ImageView("image/" + list.get(1) + ".png"));
    			hBox.getChildren().add(new ImageView("image/" + list.get(2) + ".png"));

    			
    			 counter1++;
    		        
    		    });
    		
    		
    	

    		//This is where the SlotGame scene switches back to the main screen
    		Button btPlayAgain = new Button("Play Again");
    		btPlayAgain.setOnAction(e -> {
    			
    			
    			window.setScene(scene1);
    			
    		});
    		
    		
    		
    		BorderPane pane = new BorderPane();
    		pane.setCenter(hBox);
    		pane.setBottom(hBtnBox);
    		BorderPane.setAlignment(btSpin, Pos.CENTER);
    		

    		// scene 2 is created
    		scene2 = new Scene(pane, 600, 400);
    		
    		Button btTrials = new Button("Score");	
    		btTrials.setOnAction(e -> {
    			window.setScene(scene3);
    		});
    		
    		hBtnBox.getChildren().addAll(btSpin, btPlayAgain, btTrials);
    	
	/*
     * End of gameMenu
     */
	
	/*
	 * Start of Score
	 */
    		
    
    	
//    pane.setPrefSize(400,400);

//    Button button4 = new Button("Trials till JackPot");
    
    HBox root = new HBox(50);

    
    root.getChildren().addAll(btPlayAgain);
    root.setAlignment(Pos.CENTER);
    root.getChildren().add(counter);

    //scene 3 is created
    scene3 = new Scene(root, 600, 400, Color.AQUA); 
    
    
    counter.setText("Trials: " + Integer.toString(counter));
    counter();
    
    
    
    window.setScene(scene1);
    window.setTitle("Slot Game");
    window.show();

    }

    public void counter(){
        counter++;
        //System.out.println(counter);
    		}
	
    
    
    }

    
    
