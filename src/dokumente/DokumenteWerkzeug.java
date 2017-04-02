package dokumente;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

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

	public static class Finder extends SimpleFileVisitor<Path> {

		private final PathMatcher matcher;
		private int numMatches = 0;

		Finder(String pattern) {
			matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
		}

		// Compares the glob pattern against
		// the file or directory name.
		void find(Path file) {
			Path name = file.getFileName();
			if (name != null && matcher.matches(name)) {
				numMatches++;
				System.out.println(file);
			}
		}

		// Prints the total number of
		// matches to standard out.
		void done() {
			System.out.println("Matched: " + numMatches);
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
