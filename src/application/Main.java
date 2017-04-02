package application;

import java.io.IOException;

import dokumente.DokumenteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import login.LoginCallback;
import login.LoginController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application implements LoginCallback, ChooseDocumentCallback{

	 private Stage primaryStage;

	    @Override
		public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("SpeedBoard");

	        showLogin();

		}

		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void login(String klasse, String fach, String lehrkörper) {
			showMain();
		}
		@Override
		public void onDocumentClicked() {
			showDocuments();
		}

		private void showLogin()
		{
			try {
	            // Load layout from fxml file.
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../login/Login.fxml"));

	            AnchorPane layout  = (AnchorPane) loader.load();
	        	LoginController controller = loader.getController();
	        	controller.setCallback(this);
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(layout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		private void showMain()
		{
			try {
	            // Load layout from fxml file.
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));

	            AnchorPane layout  = (AnchorPane) loader.load();
	        	MainController controller = loader.getController();
	        	controller.makeDrawable();
	        	controller.setListener(this);
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(layout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

		private void showDocuments()
		{
			try {
	            // Load layout from fxml file.
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../dokumente/Dokumentenseite.fxml"));

	            AnchorPane layout  = (AnchorPane) loader.load();
	        	DokumenteController controller = loader.getController();
	        	controller.displayFiles();
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(layout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}


}
