package application;

import help.HilfeController;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController implements Initializable{

	Seiten aktuelleSeite = Seiten.STARTSEITE;

	@FXML
	public Canvas canvas;
	@FXML
	public ColorPicker colorPicker;;

	public GraphicsContext graphicsContext;
	public Color color = Color.BLACK;
	public Tool currentTool = Tool.Stift;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}



	public enum Tool {
		Stift,Marker,Radierer
	}


	public void makeDrawable()
	{
		graphicsContext = canvas.getGraphicsContext2D();
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
	                new EventHandler<MouseEvent>(){

	            @Override
	            public void handle(MouseEvent event) {
	                graphicsContext.beginPath();
	                graphicsContext.moveTo(event.getX(), event.getY());
	                setParameters();
	            }
	        });

	        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
	                new EventHandler<MouseEvent>(){

	            @Override
	            public void handle(MouseEvent event) {
	                graphicsContext.lineTo(event.getX(), event.getY());
	                graphicsContext.stroke();
	                setParameters();
	            }
	        });

	        colorPicker.setValue(Color.BLACK);
	}

	private void setParameters()
	{
		double alpha = 1;
		double lineWidth = 1;
		Color tempColor = this.color;
		switch(currentTool)
		{
		case Stift:
			alpha = 1; lineWidth = 1;
			break;
		case Marker:
			alpha = 0.1; lineWidth = 10;
			break;
		case Radierer:
			alpha = 1; lineWidth = 10; tempColor = Color.WHITE;
			break;
		}
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setStroke(tempColor);
        graphicsContext.setFill(tempColor);
		graphicsContext.setGlobalAlpha(0.1);
        graphicsContext.stroke();
	}

	public void save(Stage primaryStage){
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

	public void hilfe(){
		switch(aktuelleSeite){
		case STARTSEITE:
	        hilfeAnzeigen(HilfeController.startHilfe());
			break;
		case DOKUMENTENSEITE:
			HilfeController.dokumentenHilfe();
			break;
		case SCHULBUCHSEITE:
			HilfeController.schulbuchHilfe();
			break;
			}
	}

	@FXML
	AnchorPane untersteEbene;

	private void hilfeAnzeigen(ArrayList<HBox> hbox){
		for(HBox aktuell : hbox)
		untersteEbene.getChildren().add(aktuell);
	}


	public void onPenClick()
	{
		currentTool = Tool.Stift;
	}
	public void onMarkerClick()
	{
		currentTool = Tool.Marker;
	}
	public void onEraserClick()
	{
		currentTool = Tool.Radierer;
	}
	public void changeColor(ActionEvent event)
	{
		ColorPicker colorPicker = (ColorPicker)event.getSource();
		color = colorPicker.getValue();
	}

}