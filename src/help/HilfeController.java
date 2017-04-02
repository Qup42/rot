package help;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class HilfeController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

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

	public static ArrayList<HBox> startHilfe() {
		ArrayList<HBox> hboxen = new ArrayList<>();
		standard(hboxen);
		hboxen.add(labeln(stift, Hilfe.STIFT));
		hboxen.add(labeln(marker, Hilfe.MARKER));
		hboxen.add(labeln(radierer, Hilfe.RADIERER));
		hboxen.add(labeln(farbe, Hilfe.FARBE));
		hboxen.add(labeln(hintergrund, Hilfe.HINTERGRUND));
		hboxen.add(labeln(geometrie, Hilfe.GEOMETRIE));
		return hboxen;
	}

	public static ArrayList<HBox> dokumentenHilfe() {
		ArrayList<HBox> hboxen = new ArrayList<>();
		standard(hboxen);

		return hboxen;
	}

	public static ArrayList<HBox> schulbuchHilfe() {
		ArrayList<HBox> hboxen = new ArrayList<>();
		standard(hboxen);
		return hboxen;
	}

	public static ArrayList<HBox> standard(ArrayList<HBox> temp) {
		temp.add(labeln(menu, Hilfe.MENU));
		temp.add(labeln(suche, Hilfe.SUCHE));
		temp.add(labeln(hilfe, Hilfe.HILFE));
		temp.add(labeln(cloud_upload, Hilfe.CLOUD_UPLOAD));
		return temp;
	}

	public static HBox labeln(ImageView image, String hilfestellung) {
		Label label = new Label(hilfestellung);
		label.setStyle("-fx-background-color: coral; -fx-padding: 10px;");
		label.setWrapText(true);
		HBox hbox = new HBox();
		hbox.getChildren().add(label);
		hbox.setMaxWidth(75);
		hbox.setMaxHeight(100);
		hbox.setOpacity(0.2);
		hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (hbox.getMaxHeight() == 200) {
					hbox.setOpacity(0.2);
					hbox.setMaxWidth(75);
					hbox.setMaxHeight(100);
				} else {
					hbox.setMaxHeight(200);
					hbox.setMaxWidth(150);
					hbox.setOpacity(1);
				}
			}
		});
		hbox.setLayoutX(image.getLayoutX());
		hbox.setLayoutY(image.getLayoutY()+ 20);
		return hbox;
	}
}
