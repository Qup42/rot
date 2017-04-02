package help;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class HilfeController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	AnchorPane basis;

	@FXML
	static ImageView menu;
	@FXML
	static ImageView suche;
	@FXML
	static ImageView internet;
	@FXML
	static ImageView dokumente;
	@FXML
	static ImageView schulbuch;
	@FXML
	static ImageView klasse_wechseln;
	@FXML
	static ImageView programme;
	@FXML
	static ImageView bildschirmuebertragung;
	@FXML
	static ImageView abmelden;
	@FXML
	static ImageView stift;
	@FXML
	static ImageView marker;
	@FXML
	static ImageView radierer;
	@FXML
	static ImageView farbe;
	@FXML
	static ImageView hintergrund;
	@FXML
	static ImageView geometrie;
	@FXML
	static ImageView hilfe;
	@FXML
	static ImageView cloud_upload;

	public static ArrayList<HBox> startHilfe(){
		ArrayList<HBox> hboxen = new ArrayList<>();
		return hboxen;
	}

	public static ArrayList<HBox> dokumentenHilfe(){
		return standard();
	}

	public static ArrayList<HBox> schulbuchHilfe(){
		return standard();
	}

	public static ArrayList<HBox> standard(){
		ArrayList<HBox> temp = new ArrayList<>();
		temp.add(labeln(menu, Hilfe.MENU));
		temp.add(labeln(suche, Hilfe.SUCHE));
		temp.add(labeln(menu, Hilfe.MENU));
		temp.add(labeln(menu, Hilfe.MENU));
		return temp;
	}

	public static HBox labeln(ImageView button, String hilfestellung){
		Label label = new Label(hilfestellung);
		label.setStyle("-fx-background-color: coral; -fx-padding: 10px; -fx-opacity: 0.5;");
		HBox hbox = new HBox();
		hbox.getChildren().add(label);
		return hbox;
	}
}
