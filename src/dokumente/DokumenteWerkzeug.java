package dokumente;
import java.io.File;
import java.util.Arrays;

public class DokumenteWerkzeug implements DokumentWerkzeugSpecification{

	File aktuellesVerzeichnis;
	String rootDir = "C:\\Users\\Mint2017.Rot\\Desktop";
	//String rootDir = System.getProperty("user.home");
	//String rootDir = "C:\\Users\\Mint2017.Rot\\Desktop\\eclipse\\features";

	public DokumenteWerkzeug()
	{
		geheInHomeVerzeichnis();
	}

	public void einVerzeichnisHoch()
	{
		if(Arrays.asList(aktuellesVerzeichnis.listRoots()).contains(aktuellesVerzeichnis))
			return;

		aktuellesVerzeichnis = aktuellesVerzeichnis.getParentFile();
	}

	@Override
	public void geheInHomeVerzeichnis() {
		aktuellesVerzeichnis = new File(rootDir);
	}

	@Override
	public void geheInRootVerzeichnis() {
		throw new UnsupportedOperationException("Diese Methode ist noch nicht implementiert");
	}


	@Override
	public String[] gebeAllesInVerzeichnis() {
		return aktuellesVerzeichnis.list();
	}

	@Override
	public void geheInVerzeichnis(File verzeichnis) throws IllegalArgumentException {
		if(verzeichnis.isFile())
		{
			aktuellesVerzeichnis = verzeichnis;
		}
		else
		{
			throw new IllegalArgumentException("Das File ist keine Verzeichnis");
		}
	}

	@Override
	public void geheInUnterverzeichnis(String verzeichnisName) throws IllegalArgumentException {
		File neuesFile = new File(aktuellesVerzeichnis.getPath() + File.separator + verzeichnisName);
		if(neuesFile.isDirectory())
		{
			aktuellesVerzeichnis = neuesFile;
		}
		else
		{
			throw new IllegalArgumentException("Der angegebene Pfad ist keine Verzeichnis");
		}
	}

}
