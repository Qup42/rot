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

	public static ArrayList<HBox> startHilfe(ImageView menu, String text) {
		ArrayList<HBox> hboxen = new ArrayList<>();
		hboxen.add(labeln(menu, text));
		return hboxen;
	}

	public static ArrayList<HBox> dokumentenHilfe() {
		ArrayList<HBox> hboxen = new ArrayList<>();
		return hboxen;
	}

	public static ArrayList<HBox> schulbuchHilfe() {
		ArrayList<HBox> hboxen = new ArrayList<>();
		return hboxen;
	}


	public static HBox labeln(ImageView image, String hilfestellung) {
		Label label = new Label(hilfestellung);
		label.setStyle("-fx-background-color: linen; -fx-padding: 10px;");
		label.setWrapText(true);
		HBox hbox = new HBox();
		hbox.getChildren().add(label);
		hbox.setMaxWidth(75);
		hbox.setMaxHeight(100);
		hbox.setOpacity(0.5);
		hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (hbox.getMaxHeight() == 200) {
					hbox.setOpacity(0.5);
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
		hbox.setLayoutY(image.getLayoutY());
		return hbox;
	}
}
