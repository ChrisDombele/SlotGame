package slotGame;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class gameMenu extends Application {
	Random random = new Random();
	@Override
	public void start(Stage primaryStage) {
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

//			this is where the points calculator should go

		});
		
		Button btPlayAgain = new Button("Play Again");
		btPlayAgain.setOnAction(e -> {
			//This is where the SlotGame scene switches back to the main screen
			
		});
		
		hBtnBox.getChildren().addAll(btSpin, btPlayAgain);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(hBox);
		pane.setBottom(hBtnBox);
		BorderPane.setAlignment(btSpin, Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene2 = new Scene(pane, 600, 400);
		primaryStage.setTitle("Slot Game"); // Set the stage title
		primaryStage.setScene(scene2); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
