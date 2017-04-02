package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
//import werkzeug.PaintController;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
=======
>>>>>>> branch 'master' of https://mint2017.rot@gitlab.com/hpi-schuelerklub/mint2017/rot.git
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
<<<<<<< HEAD
=======

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

>>>>>>> branch 'master' of https://mint2017.rot@gitlab.com/hpi-schuelerklub/mint2017/rot.git



<<<<<<< HEAD















    //NICHT ANSCHAUEN!!!!

    private Stage primaryStage;
    private AnchorPane layout;

    @Override
	public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EmptyApp");

        initLayout();
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
     * Initializes the root layout.
     */
    private void initLayout() {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("UserInterface.fxml"));
            layout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


=======
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
>>>>>>> branch 'master' of https://mint2017.rot@gitlab.com/hpi-schuelerklub/mint2017/rot.git
}
