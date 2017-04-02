package dokumente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Diese Klasse wird nicht mehr gebraucht. Eine Verwalterklasse wird sich um die erstellung etc. kümmern.
@Deprecated
public class Dokumente extends Application{

	Stage stage;

	public static void main(String[] args) {
        launch(args);
    }


	@Override
    public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Dokumentenseite.fxml"));
	    Parent root = loader.load();

	    DokumenteController controller = loader.getController();

	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.show();

	    stage = primaryStage;

	    controller.displayFiles();
    }

	public void close()
	{
		stage.close();
	}

}
