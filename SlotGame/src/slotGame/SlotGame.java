package slotGame;

import java.util.ArrayList;

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

	@Override
	public void start(Stage primaryStage) {
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 13; i++) {
			list.add(i);
		}
		
		// Use the static shuffle method in the java.util.Collections class.
		java.util.Collections.shuffle(list);

		HBox hBox = new HBox(50);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(0,0,0,0));
		hBox.getChildren().add(new ImageView("image/" + list.get(0) + ".png"));
		hBox.getChildren().add(new ImageView("image/" + list.get(1) + ".png"));
		hBox.getChildren().add(new ImageView("image/" + list.get(2) + ".png"));
		
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

		});
		
		Button btAddMoney = new Button("Play Again");
		
//		
//		Button btSort = new Button("Sort");
//		btSort.setOnAction(e -> {
//			java.util.Collections.sort(list.subList(0, 5));
			
//			hBox.getChildren().clear();
//			hBox.getChildren().add(new ImageView("image/card/" + list.get(0) + ".png"));
//			hBox.getChildren().add(new ImageView("image/card/" + list.get(1) + ".png"));
//			hBox.getChildren().add(new ImageView("image/card/" + list.get(2) + ".png"));
//			hBox.getChildren().add(new ImageView("image/card/" + list.get(3) + ".png"));
//			hBox.getChildren().add(new ImageView("image/card/" + list.get(4) + ".png"));
//		});
		
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
