package login;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class LoginController implements Initializable{

	@FXML
	public ComboBox fach;
	@FXML
	public ComboBox klasse;

	private LoginCallback callback;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setupData();
	}

	@Deprecated
	public void setData()
	{
	}

	private void setupData()
	{
		fach.getItems().clear();
		klasse.getItems().clear();

		fach.getItems().addAll("Mathematik", "Deutsch", "Geschichte", "Erdkunde", "Französich", "Informatik");
	    klasse.getItems().addAll("8a", "9a", "9b", "9c", "10b", "10d", "MINT-Profil", "Geschichts-Profil");
	}

	public void login(ActionEvent e)
	{
		if(callback != null)
		{
			callback.login((String)klasse.getValue(), (String)fach.getValue(), "");
		}
	}

	public void setCallback(LoginCallback loginCallback)
	{
		callback = loginCallback;
	}
}

