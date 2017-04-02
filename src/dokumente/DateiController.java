package dokumente;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Icon;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class DateiController implements Initializable{

	@FXML
	Text dateiName;
	ImageView icon;

	File zugehörigesFile;

	ZyklischeAbhängigkeiten zyklen;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void setzeDatei(String name)
	{
		dateiName.setText(name);
	}

	public void setzeDatei(File file)
	{
		dateiName.setText(file.getName());

		zugehörigesFile = file;
	}

	public void setCallback(ZyklischeAbhängigkeiten callback)
	{
		zyklen = callback;
	}

	@FXML
	protected void geheInOrdner()
	{
		if(zugehörigesFile.isDirectory())
		{
			zyklen.geheInVerzeichnis(dateiName.getText());
		}
		else
		{
			//TODO: Klick auf die Datei weitergeben
			System.out.println("Es wurde auf eine Datei geklickt.");
		}

	}
}
