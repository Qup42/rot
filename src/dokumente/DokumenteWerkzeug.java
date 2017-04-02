package dokumente;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DokumenteWerkzeug implements DokumentWerkzeugSpecification {

	File aktuellesVerzeichnis;
	// String rootDir = "C:\\Users\\Mint2017.Rot\\Desktop";
	String rootDir = System.getProperty("user.home");
	// String rootDir = "C:\\Users\\Mint2017.Rot\\Desktop\\eclipse\\features";

	public DokumenteWerkzeug() {
		geheInHomeVerzeichnis();
	}

	public void einVerzeichnisHoch() {
		if (Arrays.asList(File.listRoots()).contains(aktuellesVerzeichnis))
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
	public File[] gebeAlleInVerzeichnis() {
		return aktuellesVerzeichnis.listFiles();
	}

	@Override
	public void geheInVerzeichnis(File verzeichnis) throws IllegalArgumentException {
		if (verzeichnis.isDirectory()) {
			aktuellesVerzeichnis = verzeichnis;
		} else {
			throw new IllegalArgumentException("Das File ist keine Verzeichnis");
		}
	}

	@Override
	public void geheInUnterverzeichnis(String verzeichnisName) throws IllegalArgumentException {
		File neuesFile = new File(aktuellesVerzeichnis.getPath() + File.separator + verzeichnisName);
		if (neuesFile.isDirectory()) {
			aktuellesVerzeichnis = neuesFile;
		} else {
			throw new IllegalArgumentException("Der angegebene Pfad ist keine Verzeichnis");
		}
	}

	public ArrayList<String> searchFor(String name)
	//public void searchFor(String pattern)
	{
		final ArrayList<String> ergebnisse = new ArrayList<>();
		try {
			Files.walkFileTree(Paths.get("C:\\Users\\Mint2017.Rot\\Desktop"), new SimpleFileVisitor<Path>() {

				Pattern pattern = Pattern.compile(name);
				private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + name);

				// Compares the glob pattern against
				// the file or directory name.
				void find(Path file) {
					String nameStr = file.getFileName().toString();
					//Path name = file.getFileName();
					Matcher matcher = pattern.matcher(nameStr);
					if(matcher.find())
					{
						System.out.println("Hallo");
					}
					if (file.getFileName() != null && (".*"+name+".*").matches(nameStr)) {
						ergebnisse.add(file.toString());
						System.out.println(file);
					}
				}

				// Invoke the pattern matching
				// method on each file.
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
					find(file);
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ergebnisse;
	}

	public static class Finder extends SimpleFileVisitor<Path> {

		private final PathMatcher matcher;

		Finder(String pattern) {
			matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
		}

		// Compares the glob pattern against
		// the file or directory name.
		void find(Path file) {
			Path name = file.getFileName();
			if (name != null && matcher.matches(name)) {
				System.out.println(file);
			}
		}

		// Invoke the pattern matching
		// method on each file.
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			find(file);
			return FileVisitResult.CONTINUE;
		}

		// Invoke the pattern matching
		// method on each directory.
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
			find(dir);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) {
			System.err.println(exc);
			return FileVisitResult.CONTINUE;
		}
	}

}
