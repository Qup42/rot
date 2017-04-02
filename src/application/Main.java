package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {

	 private Stage primaryStage;
	 MainController controller = null;

	    @Override
		public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("SpeedBoard");
	        try {
	            // Load layout from fxml file.
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));

	            AnchorPane layout  = (AnchorPane) loader.load();
	        	MainController controller = loader.getController();
	        	controller.makeDrawable(MainController.Tool.Stift);
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(layout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

		public static void main(String[] args) {
			launch(args);
		}
		

}
