package application;

import help.HilfeController;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import help.Hilfe;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController implements Initializable {

	Seiten aktuelleSeite = Seiten.STARTSEITE;

	@FXML
	public Canvas canvas;
	@FXML
	public ImageView pencilb;
	public ImageView markerb;
	public ImageView rubberb;
	public ImageView backgroundb;
	public ImageView farbeb;
	

	public GraphicsContext graphicsContext;
	public Color color = Color.DARKBLUE;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public enum Tool {
		Stift, Marker, Radierer
	}

	public void makeDrawable(Tool tool) {
		graphicsContext = canvas.getGraphicsContext2D();
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				graphicsContext.beginPath();
				graphicsContext.moveTo(event.getX(), event.getY());
				setParameters(tool);
			}
		});

		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				graphicsContext.lineTo(event.getX(), event.getY());
				graphicsContext.stroke();
				setParameters(tool);
			}
		});

	}

	private void setParameters(Tool tool) {
		double alpha = 1;
		double lineWidth = 1;
		Color tempStroke = this.color;
		Color tempFill = this.color;
		switch (tool) {
		case Stift:
			alpha = 1;
			lineWidth = 1;
			break;
		case Marker:
			alpha = 0.1;
			lineWidth = 10;
			break;
		case Radierer:
			alpha = 1;
			lineWidth = 5;
			tempStroke = Color.WHITE;
			tempFill = Color.WHITE;
			break;
		}
		graphicsContext.setGlobalAlpha(alpha);
		graphicsContext.setLineWidth(lineWidth);
		graphicsContext.setStroke(tempStroke);
		graphicsContext.setFill(tempFill);
		graphicsContext.stroke();
	}

	public void save(Stage primaryStage) {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(primaryStage);

		if (file != null) {
			try {
				WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
				canvas.snapshot(null, writableImage);
				RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
				ImageIO.write(renderedImage, "png", file);
			} catch (IOException ex) {

			}
		}
	}

	public void hilfe() {
		switch (aktuelleSeite) {
		case STARTSEITE:
			HilfeController.startHilfe();
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
	ImageView stift;

	public void onPenClick(){
		rubberb.setVisible(false);
		backgroundb.setVisible(false);
		farbeb.setVisible(false);
		markerb.setVisible(false);
		makeDrawable(MainController.Tool.Stift);
		pencilb.setVisible(true);
		/*stift.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e){
				makeDrawable(MainController.Tool.Stift);
				pencilb.setVisible(true);
			}
			//makeDrawable(MainController.Tool.Stift);



	});pencilb.setVisible(true);
	*/	}



	public void onMarkerClick() {
		pencilb.setVisible(false);
		rubberb.setVisible(false);
		backgroundb.setVisible(false);
		farbeb.setVisible(false);
		markerb.setVisible(true);
		makeDrawable(MainController.Tool.Marker);
	}
// Die Unterlegungen unter allen anderen Feldern werden entfernt und 
	//unter dem ausgewählten hinzugefügt
	public void onEraserClick() {
		pencilb.setVisible(false);
		rubberb.setVisible(true);
		backgroundb.setVisible(false);
		farbeb.setVisible(false);
		markerb.setVisible(false);
		
		makeDrawable(MainController.Tool.Radierer);
	}
	
}