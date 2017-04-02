package dokumente;
import java.io.File;

public interface DokumentWerkzeugSpecification {

	public void einVerzeichnisHoch();
	public void geheInHomeVerzeichnis();
	public void geheInRootVerzeichnis();

	public void geheInVerzeichnis(File verzeichnis) throws IllegalArgumentException;
	public void geheInUnterverzeichnis(String verzeichnisName) throws IllegalArgumentException;

	public String[] gebeAllesInVerzeichnis();
	public File[] gebeAlleDateienInVerzeichnis();
}
