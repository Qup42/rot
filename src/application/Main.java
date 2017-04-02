package application;

import java.io.File;
import java.io.IOException;

import dokumente.DokumenteCallback;
import dokumente.DokumenteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import login.LoginCallback;
import login.LoginController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application implements LoginCallback, MenuCallback, DokumenteCallback{

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
			showMain(null);
		}
		@Override
		public void onItemClicked(Menu item) {
			switch(item)
			{
			case Internet:
				 break;
			case Dokumente:
				 showDocuments(); break;
			case Schulbuch:
				 break;
			case Klasse:
				 showLogin(); break;
			case Programme:
				 break;
			case Bildschirm:
				 break;
			case Abmelden:
				showLogin(); break;
			case Zurück:
				showMain(null); break;
			}
			
		}
		@Override
		public void ausgewählteDatei(File datei) {
			showMain(datei);

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
		private void showMain(File file)
		{
			try {
	            // Load layout from fxml file.
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));

	            AnchorPane layout  = (AnchorPane) loader.load();
	        	MainController controller = loader.getController();
	        	controller.makeDrawable();
	        	controller.setListener(this);
	        	if(file != null)
	        		controller.setBackground(file);
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
	        	controller.setCallback(this,this);
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(layout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

		@Override
		public void beendeDokumente() {
			//TODO: Hartmut: mach mal!
		}

		public static enum Menu
		{
			Internet,
			Dokumente,
			Schulbuch,
			Klasse,
			Programme,
			Bildschirm,
			Abmelden,
			Zurück
		}




}
