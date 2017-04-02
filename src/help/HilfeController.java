package help;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HilfeController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
	public static void startHilfe(){
		Label label = new Label("Sally collects seashells on the seashore");
		label.setStyle("-fx-background-color: coral; -fx-padding: 10px;");
	
	}

	@FXML
	public static void dokumentenHilfe(){

	}

	@FXML
	public static void schulbuchHilfe(){

	}
}
