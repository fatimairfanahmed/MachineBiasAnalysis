package propublica.datadesign;
//The tasks of this lab, build upon the tasks that you have completed in lab1. Please make reuse of the code that you have already written in lab1.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;

import prelab.AllStudentData;

/**
 * Hello world!
 *
 */
public class Main {
	// this should become the "Prediction Fails Differently for Black Defendants" table
	public static PropublicaDataTable racialBiasTable = null;
	
    public static void main( String[] args ) throws Exception {
    	 // TODO: eventually set racialBiasTable to a new PropublicaDataTable with correct values.
    	CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(new FileReader("compas-scores.csv"));
    	ArrayList<String[]> dataReadRows = new ArrayList<String[]>(csvReader.readAll());
    	csvReader.close();	
    	AllPeople data = new AllPeople();
    	data.FinalArrayList(dataReadRows);
    	System.out.println(data.toString());
    }   
    
    public static void testAdding() {
    	
    }
   }
