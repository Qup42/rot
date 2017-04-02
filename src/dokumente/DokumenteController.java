package dokumente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

public class DokumenteController implements Initializable, ZyklischeAbh�ngigkeiten{

	@FXML
	GridPane dokumente;

	private DokumenteWerkzeug werkzeug = new DokumenteWerkzeug();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void displayFiles()
	{
		dokumente.getChildren().clear();

		String[] dateien = werkzeug.gebeAllesInVerzeichnis();

		int z�hler = 0;
		int l�nge = dateien.length;

		if(l�nge == 0)
		{
			FXMLLoader datei = new FXMLLoader(getClass().getResource("Datei.fxml"));
		    Parent root = null;
			try {
				root = datei.load();
			} catch (IOException e) {
				e.printStackTrace();
			}

		    DateiController controller = datei.getController();
		    controller.setCallback(this);
		    controller.setzeDatei("Hier sind keine Dateien");
		    dokumente.add(root, 0, 0);
		    return;
		}

		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 8; x++)
			{
				FXMLLoader datei = new FXMLLoader(getClass().getResource("Datei.fxml"));
			    Parent root = null;
				try {
					root = datei.load();
				} catch (IOException e) {
					e.printStackTrace();
				}

			    DateiController controller = datei.getController();
			    controller.setCallback(this);
			    controller.setzeDatei(dateien[z�hler]);
			    dokumente.add(root, x, y);

				z�hler++;
				if(z�hler == l�nge)
				{
					return;
				}
			}
		}
	}

	@FXML
	protected void homeDir()
	{
		werkzeug.geheInHomeVerzeichnis();
		displayFiles();
	}

	@FXML
	protected void eineEbeneHoch()
	{
		werkzeug.einVerzeichnisHoch();
		displayFiles();
	}

	@Override
	public void geheInVerzeichnis(String name) {
		werkzeug.geheInUnterverzeichnis(name);
		displayFiles();
	}
}

