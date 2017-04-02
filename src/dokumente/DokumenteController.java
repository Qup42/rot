package dokumente;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;

public class DokumenteController implements Initializable, ZyklischeAbhängigkeiten{

	@FXML
	FlowPane dokumenteFlowPane;

	private DokumenteWerkzeug werkzeug = new DokumenteWerkzeug();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public Parent erstelleDateiObjeckt(String beschriftung)
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
	    controller.setzeDatei(beschriftung);
	    return root;
	}

	public Parent erstelleDateiObjeckt(File file)
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
	    controller.setzeDatei(file);
	    return root;
	}

	public void displayFiles()
	{
		dokumenteFlowPane.getChildren().clear();

		File[] files = werkzeug.gebeAlleDateienInVerzeichnis();

		int zähler = 0;
		int länge = files.length;

		if(länge == 0)
		{
			dokumenteFlowPane.getChildren().add(erstelleDateiObjeckt("Hier sind keine Dateien"));
		    return;
		}

		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 8; x++)
			{
				dokumenteFlowPane.getChildren().add(erstelleDateiObjeckt(files[zähler]));

				zähler++;
				if(zähler == länge)
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

