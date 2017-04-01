package login;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginUI extends Application{

	Stage stage;

	public static void main(String[] args) {
        launch(args);
    }


	@Override
    public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
	    Parent root = loader.load();

	    LoginController myController = loader.getController();

	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.show();

	    myController.setData();

	    stage = primaryStage;
    }

	public void close()
	{
		stage.close(); 
	}

}
