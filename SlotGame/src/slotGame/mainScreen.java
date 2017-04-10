package slotGame;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class mainScreen extends Application {

    Stage window;
    Scene mainMenu, gameMenu; 

    public static void main(String[] args) {
        launch(args);
    }

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
        playButton.setOnAction(e -> window.setScene(gameMenu));

        //Add everything to grid
        grid.getChildren().addAll(amountLabel, gameLabel, creditsLabel, amountInput, playButton);

        Scene scene = new Scene(grid, 552, 300);
        window.setScene(scene);
        window.show();
    }
}