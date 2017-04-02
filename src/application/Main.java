package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import login.LoginCallback;
import login.LoginController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application implements LoginCallback{

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

		private void showLogin()
		{
			try {
	            // Load layout from fxml file.
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../login/Login.fxml"));

	            AnchorPane layout  = (AnchorPane) loader.load();
	        	LoginController controller = loader.getController();
	        	controller.setData();
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
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(layout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

<<<<<<< HEAD
=======
		public static void main(String[] args) {
			launch(args);
		}


		
>>>>>>> branch 'master' of https://mint2017.rot@gitlab.com/hpi-schuelerklub/mint2017/rot.git
}
