package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Camila Maia
 * @date 06.23.2013
 */
public class FileManager {

	public String openFile(File file) throws FileNotFoundException{
		String text = "";
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			text += scanner.nextLine() + "\n";
		}
		scanner.close();
		return text;
	}

	public void saveFile (File file, String[] text) throws IOException{
		BufferedWriter outFile = new BufferedWriter(new FileWriter(file));
		for (String line : text) {
			outFile.write(line);
			outFile.newLine();
		}
		outFile.flush();
		outFile.close();
	}

}
