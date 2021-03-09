package propublica.datadesign;
//The tasks of this lab, build upon the tasks that you have completed in lab1. Please make reuse of the code that you have already written in lab1.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReaderHeaderAware;

/**
 * Main class  to call/test methods from Person and AllPeople classes.
 * @authors Silvia Alemany and Fatima Irfan
 * @version March 9, 2021
 */
public class Main {
	// this should become the "Prediction Fails Differently for Black Defendants" table
	public static PropublicaDataTable racialBiasTable = null;
	// newRacialBiasTable for analysis in part 5
	public static PropublicaDataTable newRacialBiasTable = null;
	
    public static void main( String[] args ) {
    	 // TODO: eventually set racialBiasTable to a new PropublicaDataTable with correct values.
    	try {
        	AllPeople AllDefendants = new AllPeople();
        	CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(new FileReader("compas-scores.csv"));
        	ArrayList<String[]> dataReadRows = new ArrayList<String[]>(csvReader.readAll());
        	csvReader.close();	
    		AllDefendants.finalArrayList(dataReadRows);
    		racialBiasTable = new PropublicaDataTable(AllDefendants.falsePositiveWhite(), 
    				AllDefendants.falsePositiveBlack(), AllDefendants.falseNegativeWhite(), 
    				AllDefendants.falseNegativeBlack());
    		System.out.println(racialBiasTable.toString());
    		newRacialBiasTable = new PropublicaDataTable(AllDefendants.newFalseNWhite(), 
    				AllDefendants.newFalsePBlack(), AllDefendants.newFalseNWhite(), 
    				AllDefendants.newFalseNBlack());
    		System.out.println(newRacialBiasTable.toString());
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
     * tests whether FinalArrayList works with just two string arrays instead of .csv file
     * @throws Exception
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