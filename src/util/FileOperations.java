package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOperations {
	private String filename;

	public FileOperations(String filename) {
		this.filename = filename;
	}

	public List<List<String>> read() {
		List<List<String>> lines = new ArrayList<List<String>>();

		try {
			Scanner scanner = new Scanner(new File(this.filename));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				lines.add(Arrays.asList(line.split(";")));
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lines;
	}

	public void write(List<List<String>> lines) {
		try {
			FileWriter fstream = new FileWriter(this.filename);
			BufferedWriter out = new BufferedWriter(fstream);
			for (List<String> line : lines) {
				StringBuilder builder = new StringBuilder();
				
				for (String item : line) {
					builder.append(item);
					builder.append(";");
				}

				out.write(builder.toString() + "\n");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
