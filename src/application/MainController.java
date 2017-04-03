package application;

import help.Hilfe;
import help.HilfeController;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class MainController implements Initializable {

	Seiten aktuelleSeite = Seiten.STARTSEITE;

	@FXML
	public Canvas canvas;
	@FXML
	private ColorPicker colorPicker;
	@FXML
	AnchorPane untersteEbene;


	@FXML
	public ImageView pencilb;
	public ImageView markerb;
	public ImageView rubberb;

	@FXML
	Slider slider;


	public GraphicsContext graphicsContext;
	public Color color = Color.BLACK;
	public Tool currentTool = Tool.Stift;
	private MenuCallback listener;
	private HilfeController hilfeCon;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setListener(MenuCallback listener)
	{
		this.listener = listener;
	}
	public void setBackground(File file)
	{
		//TODO: set File as Backround
		//Image image = SwingUtils.toFXImage(ImageIO.read(file));
	}

	@FXML
	TextField suche_feld;

	public void suche_klick() {
		suche_feld.clear();
	}

	@FXML
	public void suche() {
		suche_feld.getText();
		Alert attention = new Alert(AlertType.WARNING);
		attention.setContentText("Konnte nicht gefunden werden");
	}

	public enum Tool {
		Stift, Marker, Radierer
	}

	public void makeDrawable() {
		pencilb.setVisible(true);
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

		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				graphicsContext.lineTo(event.getX(), event.getY());
				graphicsContext.stroke();
				setParameters();
			}
		});

		colorPicker.setValue(Color.BLACK);
	}

	private void setParameters() {
		double alpha = 1;
		double lineWidth = 1;
		Color tempColor = this.color;
		switch (currentTool) {
		case Stift:
			alpha = 1; lineWidth = 1*slider.getValue();
			break;
		case Marker:
			alpha = 0.1; lineWidth = 10*slider.getValue();
			break;
		case Radierer:
			alpha = 1; lineWidth = 10*slider.getValue(); tempColor = Color.WHITE;
			break;
		}
		graphicsContext.setGlobalAlpha(alpha);
		graphicsContext.setLineWidth(lineWidth);
		graphicsContext.setStroke(tempColor);
		graphicsContext.setFill(tempColor);
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

	@FXML
	ImageView menu;
	@FXML
	ImageView suche;
	@FXML
	ImageView stift;
	@FXML
	ImageView marker;
	@FXML
	ImageView radierer;
	@FXML
	ImageView hintergrund;
	@FXML
	ImageView farbe;
	@FXML
	ImageView rubbish;
	@FXML
	ImageView geometrie;
	@FXML
	ImageView hilfe;
	@FXML
	ImageView cloud_upload;

	private int counter_hilfe = 0;

	public void hilfe() {
		counter_hilfe++;
		if (counter_hilfe % 2 == 0) {
			switch (aktuelleSeite) {
			case STARTSEITE:
				hilfeAnzeigen(hilfeCon.startHilfe(menu, Hilfe.MENU));
				hilfeAnzeigen(hilfeCon.startHilfe(suche, Hilfe.SUCHE));
				hilfeAnzeigen(hilfeCon.startHilfe(stift, Hilfe.STIFT));
				hilfeAnzeigen(hilfeCon.startHilfe(marker, Hilfe.MARKER));
				hilfeAnzeigen(hilfeCon.startHilfe(radierer, Hilfe.RADIERER));
				hilfeAnzeigen(hilfeCon.startHilfe(hintergrund, Hilfe.HINTERGRUND));
				hilfeAnzeigen(hilfeCon.startHilfe(farbe, Hilfe.MENU));
				hilfeAnzeigen(hilfeCon.startHilfe(rubbish, Hilfe.DELETE));
				hilfeAnzeigen(hilfeCon.startHilfe(geometrie, Hilfe.GEOMETRIE));
				hilfeAnzeigen(hilfeCon.startHilfe(hilfe, Hilfe.HILFE));
				hilfeAnzeigen(hilfeCon.startHilfe(cloud_upload, Hilfe.CLOUD_UPLOAD));
				break;
			case DOKUMENTENSEITE:
				hilfeAnzeigen(hilfeCon.dokumentenHilfe());
				break;
			case SCHULBUCHSEITE:
				hilfeAnzeigen(hilfeCon.schulbuchHilfe());
				break;
			}
		} //else hilfeLoeschen();
	}


	private void hilfeAnzeigen(ArrayList<HBox> hbox) {
		for (HBox aktuell : hbox)
			untersteEbene.getChildren().add(aktuell);
	}

//	private void hilfeLoeschen(ActionEvent event)
//		{
//
//		}

	@FXML
	public void nichtVerfuegbar(){
		Alert nichtVerf = new Alert(AlertType.WARNING);
		nichtVerf.setContentText("Diese Funktion ist momentan nicht verfügbar.");
		nichtVerf.setHeaderText("Achtung");
		nichtVerf.show();
	}

	public void onPenClick() {
		currentTool = Tool.Stift;
		pencilb.setVisible(true);
		rubberb.setVisible(false);
		markerb.setVisible(false);
	}


	public void onMarkerClick() {
		currentTool = Tool.Marker;
		pencilb.setVisible(false);
		rubberb.setVisible(false);
		markerb.setVisible(true);
	}

	public void onEraserClick() {
		currentTool = Tool.Radierer;
		pencilb.setVisible(false);
		rubberb.setVisible(true);
		markerb.setVisible(false);
	}

	public void changeColor() {
		color = colorPicker.getValue();
	}

	public void onDocumentClick(ActionEvent event)
	{
		MenuItem item = (MenuItem) event.getSource();
		switch(item.getText())
		{
		case "Internet":
			listener.onItemClicked(Main.Menu.Internet); break;
		case "Dokumente":
			listener.onItemClicked(Main.Menu.Dokumente); break;
		case "Schulbuch":
			listener.onItemClicked(Main.Menu.Schulbuch); break;
		case "Klasse wechseln":
			listener.onItemClicked(Main.Menu.Klasse); break;
		case "Programme":
			listener.onItemClicked(Main.Menu.Programme); break;
		case "Bildschirmübertragung":
			listener.onItemClicked(Main.Menu.Bildschirm); break;
		case "Abmelden":
			listener.onItemClicked(Main.Menu.Abmelden); break;
		case "Zurück":
			listener.onItemClicked(Main.Menu.Zurück); break;
		}

	}

	public void onrubbishClick()
	{

		graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());


	}
}