package dokumente;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class DateiController implements Initializable{

	@FXML
	Text dateiName;
	@FXML
	ImageView icon;

	File file;

	DateiCallback callback;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void setzeLeerenOrdner(String name)
	{
		dateiName.setText(name);

		File iconFile = new File("src/application/img/tumbleweed.jpg");
		Image imageIcon = new Image(iconFile.toURI().toString());
		icon.setImage(imageIcon);
	}

	public void setzeDatei(File file)
	{
		dateiName.setText(file.getName());

		File iconFile = (file.isDirectory())? new File("src/application/img/verzeichnis.jpg") : new File("src/application/img/datei.gif");
		Image imageIcon = new Image(iconFile.toURI().toString());
		icon.setImage(imageIcon);

		this.file = file;
	}

	public void setCallback(DateiCallback zuSetzenderCallback)
	{
		callback = zuSetzenderCallback;
	}

	@FXML
	protected void geheInOrdner()
	{
		if(file != null)
		{
			if(file.isDirectory())
			{
				callback.geheInVerzeichnis(dateiName.getText());
			}
			else
			{
				callback.klickAufDatei(file);
			}
		}
	}
}
