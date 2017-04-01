package login;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class MyController implements Initializable{

	@FXML
	public ComboBox fach;
	public ComboBox klasse;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setData()
	{
		fach.getItems().clear();
		klasse.getItems().clear();

		fach.getItems().addAll("Mathematik", "Deutsch", "Geschichte");
	    klasse.getItems().addAll("9a", "9b", "9c", "10b", "10d");
	}

	public void login(ActionEvent e)
	{
		//TODO: Machen
	}
}

