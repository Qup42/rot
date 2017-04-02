package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
//import werkzeug.PaintController;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {

	 private Stage primaryStage;

	    @Override
		public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("SpeedBoard");
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

		public static void main(String[] args) {
			launch(args);

		}


//    Image Farbwahl = new Image("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\cmyk.png");
//    Image Stift    = new Image("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\pencil.png");
//    Image Hilfe    = new Image("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\question.png");
//    Image Menü     = new Image("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\img\\menu");
//    Image CloudUp  = new Image("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\cloud-computing");
//    Image Schulbücher = new Image ("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\books.png");
//    Image Suche = new Image ("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\lupe.png");
//    Image Radierer = new Image ("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\eraser.png");
//    Image Geometrie = new Image ("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\Geometrie.png");
//    Image Hintergrundstruktur = new Image ("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\background.png");
//    Image Textmarker = new Image ("C:\\Users\\Mint2017.Rot\\Documents\\workspace\\Speedboard\\src\\img\\marker.png");
}
