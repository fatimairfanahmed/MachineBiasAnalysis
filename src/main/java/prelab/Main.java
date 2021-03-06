package prelab;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReaderHeaderAware;
/*
 * You should use this package for Pre-Lab 2 and Pre-Lab 3 Exercises.
 * Make sure you don't have errors in this package, since it will cause issues
 * with the autograder if there are any compilation issues.
 */
public class Main{
	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO complete your pre-labs!
		/* Header-aware reader of StudentProfile.csv
		Make sure StudentProfile.csv is accessible or provide the proper path
		Read and write to a file may throw an exception e.g., FileNotFound etc,
		make sure you handle such errors properly */
		// add code to enter input file name and path
		// add code to check file exists and is readable
		CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(new FileReader("StudentProfile2.csv"));
		ArrayList<String[]> dataReadRows = new ArrayList<String[]>(csvReader.readAll());
		csvReader.close();	
		AllStudentData data = new AllStudentData();
		data.FinalArrayList(dataReadRows);
		System.out.println(data.toString());

	}

}