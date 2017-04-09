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

public class SlotGame extends Application {
	Random rand = new Random();
	@Override
	public void start(Stage primaryStage) {
		int i;
		ArrayList<Integer> list = new ArrayList<>();
		for (i = 1; i <= 6; i++) {
			list.add(i);
			
		}
		
//		int value = rand.nextInt(list);
		
//		int n = new rand.nextInt(6)+1;
//		int random0 = (int) (Math.random() * 6 + 1);
//		int random1 = (int) (Math.random() * 7 + 1);
//		int random2 = (int) (Math.random() * 5 + 1);
		
		
		// Use the static shuffle method in the java.util.Collections class.
		java.util.Collections.shuffle(list);

		HBox hBox = new HBox(50);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(0,0,0,0));
		/*
		hBox.getChildren().add(new ImageView("image/" + list.get(10) + ".png"));
		hBox.getChildren().add(new ImageView("image/" + list.get(11) + ".png"));
		hBox.getChildren().add(new ImageView("image/" + list.get(1) + ".png"));
		*/
		hBox.getChildren().add(new ImageView("image/1.png"));
		hBox.getChildren().add(new ImageView("image/11.png"));
		hBox.getChildren().add(new ImageView("image/1.png"));
		
		
		// Create buttons
		HBox hBtnBox = new HBox(10);
		hBtnBox.setAlignment(Pos.CENTER);
		hBtnBox.setPadding(new Insets(5,0,5,0));

		
		Button btSpin = new Button("Spin");
		btSpin.setOnAction(e -> {
			java.util.Collections.shuffle(list);
			
			hBox.getChildren().clear();
			
			/*
			hBox.getChildren().add(new ImageView("image/" + list.get(13) + ".png"));
			hBox.getChildren().add(new ImageView("image/" + list.get(12) + ".png"));
			hBox.getChildren().add(new ImageView("image/" + list.get(2) + ".png"));
			
			hBox.getChildren().add(new ImageView("image/" + list.get(10) + ".png"));
			hBox.getChildren().add(new ImageView("image/" + list.get(11) + ".png"));
			hBox.getChildren().add(new ImageView("image/" + list.get(1) + ".png"));
			*/
			
			
//			this is where the points calculator should go

		});
		
		Button btAddMoney = new Button("Play Again");
		
		hBtnBox.getChildren().addAll(btSpin, btAddMoney);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(hBox);
		pane.setBottom(hBtnBox);
		BorderPane.setAlignment(btSpin, Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("Slot Game"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support.
	 * Not needed for running from the command line.
	 */
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
