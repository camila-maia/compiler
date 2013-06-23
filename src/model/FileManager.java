package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Camila Maia
 * @date 06.23.2013
 */
public class FileManager {

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
