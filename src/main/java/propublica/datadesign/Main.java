package propublica.datadesign;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReaderHeaderAware;

/**
 * This program calls/tests methods from the Person and AllPeople classes in lab 2. 
 * It also replicates the analysis ProPublica shows in “Prediction Fails Differently for Black Defendants” 
 * using these two classes and PropublicaDataTable.
 * 
 * @authors Silvia Alemany and Fatima Irfan
 * @version March 9, 2021
 */

public class Main {
	// this should become the "Prediction Fails Differently for Black Defendants" table
	public static PropublicaDataTable racialBiasTable = null;
	// newRacialBiasTable for additional analysis in part 5. Feel free to uncomment this and run it
	 public static PropublicaDataTable newRacialBiasTable = null;
	
    public static void main( String[] args ) {
    	 /**
    	  * Uses openCSV to read compas-scores and store in a String ArrayList dataReadRows
    	  * Populate data structure using dataReadRows
    	  * Sets racialBiasTable to a new PropublicaDataTable with correct values
    	  * Prints racialBiasTable
    	  */
    	try {
    		// This calls the tesAdding() method defined below. Feel free to uncomment this and run it
    		// testAdding();
    		AllPeople allDefendantsData = new AllPeople();
        	CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(new FileReader("compas-scores.csv"));
        	ArrayList<String[]> dataReadRows = new ArrayList<String[]>(csvReader.readAll());
        	csvReader.close();	
    		allDefendantsData.finalArrayList(dataReadRows);
    		racialBiasTable = new PropublicaDataTable(allDefendantsData.whiteHighNoReoffendRate(), 
    												  allDefendantsData.blackHighNoReoffendRate(), 
    												  allDefendantsData.whiteLowReoffendRate(), 
    												  allDefendantsData.blackLowReoffendRate());
    		System.out.println(racialBiasTable.toString());
    		// Below is the code that sets and prints the table with the values from our custom analysis
    		// Feel free to uncomment this and run it
    		// newRacialBiasTable = new PropublicaDataTable(allDefendantsData.newWhiteHighNoReoffend(), 
    													// allDefendantsData.newBlackHighNoReoffend(),
    													// allDefendantsData.newWhiteLowReoffend(), 
    													// allDefendantsData.newBlackLowReoffend());
    		// System.out.println(newRacialBiasTable.toString());
    	} catch (FileNotFoundException exception) {
            // Catch expected FileNotFoundException.
    		exception.printStackTrace();
        } catch (IllegalArgumentException exception) {
            // Catch expected IllegalArgumentExceptions.
            exception.printStackTrace();
        }  catch (IOException exception) {
            // Catch expected IOExceptions.
            exception.printStackTrace();
        } catch (Exception exception) {
            // Catch unexpected Exceptions.
        	exception.printStackTrace();
        }
    }   
    
    /**
     * Tests whether finalArrayList works with just two string arrays (rows) instead of full .csv file
     */
    public static void testAdding() {
    	try {
        	String[] row1 = new String[] {"Male", "Other", "F", 
        								  "Aggravated Assault w/Firearm", "1", "Low", "0", "", ""};
        	String[] row2 = new String[] {"Female", "Caucasian", "M", "Battery",
        								  "1", "Low", "0", "", ""};
        	ArrayList<String[]> twoRows = new ArrayList<String[]>();
        	twoRows.add(row1);
        	twoRows.add(row2);
        	AllPeople twoDefendantsData = new AllPeople();
        	twoDefendantsData.finalArrayList(twoRows);
        	System.out.println(twoDefendantsData.toString());
        } catch (IllegalArgumentException exception) {
            // Catch expected IllegalArgumentExceptions.
            exception.printStackTrace();
        }  catch (IOException exception) {
            // Catch expected IOExceptions.
            exception.printStackTrace();
        } catch (Exception exception) {
            // Catch unexpected Exceptions.
        	exception.printStackTrace();
        }
    }
}