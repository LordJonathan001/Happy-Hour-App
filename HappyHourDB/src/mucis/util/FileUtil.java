package mucis.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * File utilities
 * 
 * @author Reid Parker
 * @version 0.10, 2/25/2016
 * 
 */
public class FileUtil {
	/**
	 * Reads a text file into a list of lines. Uses Java7 try with resources
	 * feature, Paths, and newBufferedReader.
	 * 
	 * @param fileNamePath
	 * @return list
	 */
	public static List<String> readF2L(String fileNamePath) {
		Path path = Paths.get(fileNamePath);
		List<String> list = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(path,
				StandardCharsets.UTF_8)) {
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			System.out.println("Error with " + e.getMessage());
		}
		return list;
	}

	/**
	 * Reads a text file into a list of lines using readAll.
	 * 
	 * @param fileNamePath
	 * @return list
	 */
	public static List<String> readAllF2L(String fileNamePath) {
		Path path = Paths.get(fileNamePath);
		List<String> list = null;
		try {
			list = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Error with " + e.getMessage());
		}
		return list;
	}

	/**
	 * Reads a file into a single string. Lines from the file are joined using
	 * the separator string.
	 * 
	 * @param fileNamePath
	 * @param separator
	 * @return string
	 */
	public static String readF2S(String fileNamePath, String separator) {
		Path path = Paths.get(fileNamePath);
		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = Files.newBufferedReader(path,
				StandardCharsets.UTF_8)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + separator);
			}
		} catch (IOException e) {
			System.out.println("Error with " + e.getMessage());
		}
		return sb.toString();
	}

	public static String listToString(List<String> list, String separator) {
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
			sb.append(separator);
		}
		return sb.toString();
	}

	public static List<String> stringToList(String s, String separator) {
		String[] sa = s.split(separator);
		List<String> list = new ArrayList<>(Arrays.asList(sa));
		return list;
	}

	/**
	 * a static method to retrieve the filenames for a given path and glob
	 * filter
	 * 
	 * @param dir
	 *            - the directory where the data is; i.e. "data" or "c:/tmp"
	 * @param glob
	 *            - filter by this; i.e. "*.txt" or "*.*"
	 * @return list - contains the filenames
	 */
	public static List<String> getFileNames(String dir, String glob) {
		List<String> list = new ArrayList<>();
		Path myPath = FileSystems.getDefault().getPath(dir);
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(myPath, glob)) {
			for (Path p : ds) {
				list.add(p.getFileName().toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void writeS2F(String outFilename, String myData) {
		Path myFile = Paths.get(outFilename);
		try (BufferedWriter writer = Files.newBufferedWriter(myFile,
				StandardCharsets.UTF_8)) {
			writer.write(myData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
