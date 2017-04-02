package werkzeug;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class PaintController implements Initializable{

	@FXML
	public Canvas canvas;

	public GraphicsContext graphicsContext;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void init()
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

	public void draw(ActionEvent e)
	{
		//TODO: Machen
	}
}
