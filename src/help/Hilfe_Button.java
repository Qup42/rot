package help;

import java.io.IOException;

import application.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Hilfe_Button extends Application{

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
            loader.setLocation(Main.class.getResource("..\\Start.fxml"));
            layout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



	@FXML
	AnchorPane basis;

	@FXML
	Button menu;
	@FXML
	Button internet;
	@FXML
	Button dokumente;
	@FXML
	Button schulbuch;
	@FXML
	Button klasse_wechseln;
	@FXML
	Button programme;
	@FXML
	Button bildschirmuebertragung;
	@FXML
	Button abmelden;
	@FXML
	Button stift;
	@FXML
	Button marker;
	@FXML
	Button radierer;
	@FXML
	Button farbe;
	@FXML
	Button hintergrund;
	@FXML
	Button geometrie;
	@FXML
	Button hilfe;
	@FXML
	Button cloud_upload;

	@FXML
	protected void start_hilfe(){
		Label label = new Label("Sally collects seashells on the seashore");
		label.setStyle("-fx-background-color: coral; -fx-padding: 10px;");
	}

	@FXML
	protected void dokumente_hilfe(){

	}

	@FXML
	protected void schulbuch_hilfe(){

	}
}
