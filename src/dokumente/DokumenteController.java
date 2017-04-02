package dokumente;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class DokumenteController implements Initializable, DateiCallback {

	@FXML
	FlowPane dokumenteFlowPane;
	@FXML
	TextField suche;

	private DokumenteWerkzeug werkzeug = new DokumenteWerkzeug();
	private DokumenteCallback callback;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		refreshDisplay();
	}

	public void setCallback(DokumenteCallback zuSetzenderCallback)
	{
		callback = zuSetzenderCallback;
	}

	private Parent erstelleLeerenOrdner(String beschriftung) {
		FXMLLoader datei = new FXMLLoader(getClass().getResource("Datei.fxml"));
		Parent root = null;
		try {
			root = datei.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DateiController controller = datei.getController();
		controller.setCallback(this);
		controller.setzeLeerenOrdner(beschriftung);
		return root;
	}

	private Parent erstelleDateiObjeckt(File file) {
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

	@Deprecated
	public void displayFiles() {}

	private void refreshDisplay() {
		dokumenteFlowPane.getChildren().clear();

		File[] files = werkzeug.gebeAlleInVerzeichnis();

		if (files.length == 0) {
			dokumenteFlowPane.getChildren().add(erstelleLeerenOrdner("Hier sind keine Dateien"));
			return;
		}

		for(File file : files)
		{
			dokumenteFlowPane.getChildren().add(erstelleDateiObjeckt(file));
		}
	}

	@FXML
	protected void zurück()
	{
		callback.beendeDokumente();
	}

	@FXML
	protected void suchen()
	{
		//System.out.println(werkzeug.searchFor(suche.getText().toString()));
	}

	@FXML
	protected void homeDir() {
		werkzeug.geheInHomeVerzeichnis();
		refreshDisplay();
	}

	@FXML
	protected void eineEbeneHoch() {
		werkzeug.einVerzeichnisHoch();
		refreshDisplay();
	}

	@Override
	public void geheInVerzeichnis(String name) {
		werkzeug.geheInUnterverzeichnis(name);
		refreshDisplay();
	}

	@Override
	public void klickAufDatei(File file) {
		if(callback != null)
		{
			callback.ausgewählteDatei(file);
		}
	}
}
