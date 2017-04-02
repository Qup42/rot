package application;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController implements Initializable{

	@FXML
	public Canvas canvas;

	public GraphicsContext graphicsContext;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	//Ich bin ein KOmmentar und damit eine Aenderung!!!
	public void makeDrawable()
	{
		graphicsContext = canvas.getGraphicsContext2D();
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
	                new EventHandler<MouseEvent>(){

	            @Override
	            public void handle(MouseEvent event) {
	                graphicsContext.beginPath();
	                graphicsContext.moveTo(event.getX(), event.getY());
	                graphicsContext.stroke();
	            }
	        });

	        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
	                new EventHandler<MouseEvent>(){

	            @Override
	            public void handle(MouseEvent event) {
	                graphicsContext.lineTo(event.getX(), event.getY());
	                graphicsContext.stroke();
	            }
	        });
	}

	public void save(Stage primaryStage)
	{
		FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(primaryStage);

        if(file != null){
            try {
                WritableImage writableImage = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight());
                canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {

            }
        }
	}
}
