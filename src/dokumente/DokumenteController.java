package dokumente;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DokumenteController implements Initializable{

	@FXML
	GridPane dokumente;

	private DokumenteWerkzeug werkzeug = new DokumenteWerkzeug();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void addFiles()
	{
		dokumente.setHgap(10);
		dokumente.setVgap(10);
		dokumente.setPadding(new Insets(0, 10, 0, 10));

		for (String string : werkzeug.gebeAllesInVerzeichnis())
		{
			//Test
			ImageView icon = new ImageView();
			Text name = new Text(string);
			VBox datei = new VBox(8, icon, name);

			dokumente.add(datei, 2, 2);
		}
	}
}

