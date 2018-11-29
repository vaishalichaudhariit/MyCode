/**
 * 
 */
package JavaBasics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Vaishali.Chaudhari Given a directory path, write validation script in
 *         language / script of your choice to test following: a. Check that the
 *         directory is not empty. b. Check if the file under that path has
 *         first line as below: Name, Website, Rank, Address, City, State,
 *         PinCode, Country c. Validate data in that file by checking if any
 *         Name or Website is empty
 */
public class FileOperations {

	/**
	 * @author Vaishali Chaudhari
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		File file = new File("D:\\program");
		if (file.isDirectory() && file.exists()) {
			if (file.list().length > 0) {
				System.out.println("Directory is not Empty");
				String filePath = "D:\\program\\Employee.csv";
				String firstline = "Name,Website,Rank,Address,City,State,PinCode,Country";
				String line = "";
				String cvsSplitBy = ",";

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String fileText = br.readLine();
				System.out.println("file text:- " + fileText);
				if (firstline.equalsIgnoreCase(fileText)) {
					System.out
							.println("File under that path has first line as below: "
									+ firstline);
					while ((line = br.readLine()) != null) {

						// use comma as separator
						String[] data = line.split(cvsSplitBy);
						if (data[0].length() > 0 || data[1].length() > 0) {
							System.out.println("[name= " + data[0]
									+ " , website=" + data[1] + "]");

						}
					}
				} else {
					System.out.println("First line is not matching");
				}
			} else {
				System.out.println("Directory is empty");
			}
		} else {
			System.out
					.println("Please check folder either empty or doesn't exist");
		}

	}

}
