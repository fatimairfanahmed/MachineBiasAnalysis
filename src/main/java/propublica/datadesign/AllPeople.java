package propublica.datadesign;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This program defines the class AllPeople, which represents the entire set of defendant data
 * (data from entire .csv file).
 * 
 * @authors Silvia Alemany and Fatima Irfan
 * @version March 9, 2021
 */
public class AllPeople {
	private ArrayList<Person> allPeopleData;
	/**
	 * Constructor
	 * Creates a Person ArrayList called allPeopleData
	 */
	public AllPeople() {
		this.allPeopleData = new ArrayList<Person>();
	}
	/**
	 * Iterates through String ArrayList and assigns each row to a new Person object that is stored in allPeopleData
	 * @param arrayList: ArrayList comprised of String arrays where each array contains the attributes of an 
	 *  object from the Person class
	 * @throws Exception, IllegalArgumentException, IOException, FileNotFoundException
	 */
	public void finalArrayList(ArrayList<String[]> arrayList) throws Exception, IllegalArgumentException,
		IOException, FileNotFoundException  {	
		for (int i = 0; i < arrayList.size(); i ++) {
			try {
				Person person = new Person(arrayList.get(i));
				this.allPeopleData.add(person);
			} catch (IllegalArgumentException exception) {
				// catches IllegalArgumentException thrown from Person class and skips row in .csv file
				continue;
			} catch (IndexOutOfBoundsException exception) {
				// catches IndexOutOfBoundsException thrown from Person class and skips row in .csv file
				continue;
			}
		}
	}
		

	/**
	 * Overrides toString method to return each row of the data set separated by line
	 * @return string where each person (row) is on a different line and the fields are comma-separated
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		String resultString;
		for(int i = 0; i < allPeopleData.size(); i ++) {
			//calls on .toString() method from Person class
			String line = (allPeopleData.get(i)).toString() + "\n";
			// use StringBuilder to add lines/people
			stringBuilder.append(line);
		}
		// convert StringBuilder object to String and store in resultString to return
		resultString = stringBuilder.toString();
		return resultString;	
	}
	
	/**
	 * Returns the % of false positives among white defendants as a decimal.
	 * @return percentage of white defendants who didn't re-offend that were rated high/medium
	 */
	public double whiteHighNoReoffendRate() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : allPeopleData) {
			if (person.isWhite() && !person.hasReoffended()) {
				totalCounter++;
				if (person.isHighRisk()) {
					falseCounter++;
				}
			}
		}
		double percentage = falseCounter/totalCounter;
		return percentage;
	}
	
	/** 
	 * Returns the % of false positives among Black defendants as a decimal.
	 * @return percentage of black defendants who didn't re-offend that were rated high/medium
	 */
	public double blackHighNoReoffendRate() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : allPeopleData) {
			if (person.isBlack() && !person.hasReoffended()) {
				totalCounter++;
				if (person.isHighRisk()) {
					falseCounter++;
				}
			}
		}
		double percentage = falseCounter/totalCounter;
		return percentage;
	}
	
	/**
	 * Returns the % of false negatives among Black defendants as a decimal.
	 * @return percentage of black defendants who recidivated that were rated low
	 */
	public double blackLowReoffendRate() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : allPeopleData) {
			if (person.isBlack() && person.hasReoffended()) {			
				totalCounter++;
				if (person.isLowRisk()) {
					falseCounter++;
				}
			}
		}
		double percentage = falseCounter/totalCounter;
		return percentage;
	}
	
	/**
	 * Returns the % of false negatives among white defendants as a decimal.
	 * @return percentage of black defendants who recidivated that were rated low
	 */
	public double whiteLowReoffendRate() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : allPeopleData) {
			if (person.isWhite() && person.hasReoffended()) {
				totalCounter++;
				if (person.isLowRisk()) {
					falseCounter++;
				}
			}
		}
		double percentage = falseCounter/totalCounter;
		return percentage;
	}

	// BELOW: methods for additional analysis in part 5
	/**
	 * Returns the rate of false positives among white defendants in decimal format. (w/ updated definition of recidivism)
	 * @return percentage of white defendants who didn't re-offend (w/ updated definition of recidivism) 
	 * that were rated high/medium
	 */
	public double newWhiteHighNoReoffend() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : allPeopleData) {
			if (person.isWhite() && !person.newHasReoffended()) {
				totalCounter++;
				if (person.isHighRisk()) {
					falseCounter++;
				}
			}
		}
		double percentage = falseCounter/totalCounter;
		return percentage;
	}
	
	/** 
	 * Returns the rate of false positives among Black defendants in decimal format. (w/ updated definition of recidivism)
	 * @return percentage of black defendants who didn't re-offend (w/ updated definition of recidivism) 
	 * that were rated high/medium
	 */
	public double newBlackHighNoReoffend() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : allPeopleData) {
			if (person.isBlack() && !person.newHasReoffended()) {
				totalCounter++;
				if (person.isHighRisk()) {
					falseCounter++;
				}
			}
		}
		double percentage = falseCounter/totalCounter;
		return percentage;
	}
	
	/**
	 * Returns the rate of false negatives among Black defendants in decimal format. (w/ updated definition of recidivism)
	 * @return percentage of black defendants who recidivated (w/ updated definition of recidivism) 
	 * that were rated low
	 */
	public double newBlackLowReoffend() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : allPeopleData) {
			if (person.isBlack() && person.newHasReoffended()) {			
				totalCounter++;
				if (person.isLowRisk()) {
					falseCounter++;
				}
			}
		}
		double percentage = falseCounter/totalCounter;
		return percentage;
	}
	
	/**
	 * Returns the rate of false negatives among white defendants in decimal format. (w/ updated definition of recidivism)
	 * @return percentage of black defendants who recidivated (w/ updated definition of recidivism)
	 * that were rated low
	 */
	public double newWhiteLowReoffend() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : allPeopleData) {
			if (person.isWhite() && person.newHasReoffended()) {
				totalCounter++;
				if (person.isLowRisk()) {
					falseCounter++;
				}
			}
		}
		double percentage = falseCounter/totalCounter;
		return percentage;
	}
	
}