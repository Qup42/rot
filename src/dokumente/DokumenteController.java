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

public class DokumenteController implements Initializable, DateiCallback {

	@FXML
	FlowPane dokumenteFlowPane;

	private DokumenteWerkzeug werkzeug = new DokumenteWerkzeug();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public Parent erstelleDateiObjeckt(String beschriftung) {
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

	public Parent erstelleDateiObjeckt(File file) {
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

	public void displayFiles() {
		dokumenteFlowPane.getChildren().clear();

		File[] files = werkzeug.gebeAlleInVerzeichnis();

		if (files.length == 0) {
			dokumenteFlowPane.getChildren().add(erstelleDateiObjeckt("Hier sind keine Dateien"));
			return;
		}

		for(File file : files)
		{
			dokumenteFlowPane.getChildren().add(erstelleDateiObjeckt(file));
		}
	}

	@FXML
	protected void homeDir() {
		werkzeug.geheInHomeVerzeichnis();
		displayFiles();
	}

	@FXML
	protected void eineEbeneHoch() {
		werkzeug.einVerzeichnisHoch();
		displayFiles();
	}

	@Override
	public void geheInVerzeichnis(String name) {
		werkzeug.geheInUnterverzeichnis(name);
		displayFiles();
	}

	@Override
	public void klickAufDatei(File file) {
		//TODO: An die Verwaltungsklasse weitergeben
		System.out.println("Es wurde auf eine Datei geklickt.");
	}
}
