package propublica.datadesign;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


/**
 * AllPeople class representing entire set of defendant data (data from entire .csv file)
 * @authors Silvia Alemany and Fatima Irfan
 * @version March 9, 2021
 *
 */
public class AllPeople {
	private ArrayList<Person> AllPeopleData;
	public AllPeople() {
		//initializing the first array list inside the constructor 
		this.AllPeopleData = new ArrayList<Person>();
	}
	/**
	 * @param arrayList: ArrayList comprised of String arrays where each array contains the attributes of an 
	 * (cont.) object from the Person class
	 * @throws Exception, IllegalArgumentException, IOException, FileNotFoundException
	 */
	public void finalArrayList(ArrayList<String[]> arrayList) throws Exception, IllegalArgumentException,
		IOException, FileNotFoundException  {	
		for (int i = 0; i < arrayList.size(); i ++) {
			try {
				Person person = new Person(arrayList.get(i));
				this.AllPeopleData.add(person);
			} catch (IllegalArgumentException exception) {
				// catches IllegalArgumentException exceptions thrown from Person class and skips row in .csv file
				continue;
			} catch (IndexOutOfBoundsException exception) {
				// catches IndexOutOfBoundsException exceptions thrown from Person class and skips row in .csv file
				continue;
			}
		}
	}
		

	/**
	 * method that overrides toString method to return objects in 
	 * ArrayList as a string
	 * @return string where each person (row) is on a different line and the fields are comma-separated
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		String resultString;
		for(int i = 0; i < AllPeopleData.size(); i ++) {
			//calls on .toString() method from Person class
			String line = (AllPeopleData.get(i)).toString() + "\n";
			// use StringBuilder to add lines/people
			stringBuilder.append(line);
		}
		// convert StringBuilder object to String and store in resultString to return
		resultString = stringBuilder.toString();
		return resultString;	
	}
	
	/**
	 * @return percentage of white defendants who didn't re-offend that were rated high
	 */
	public double falsePositiveWhite() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
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
	 * @return percentage of black defendants who didn't re-offend that were rated high
	 */
	public double falsePositiveBlack() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
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
	 * @return percentage of black defendants who recidivated that were rated low
	 */
	public double falseNegativeBlack() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
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
	 * @return percentage of black defendants who recidivated that were rated low
	 */
	public double falseNegativeWhite() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
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
	 * @return percentage of white defendants who didn't re-offend (w/ updated definition of recidivism) 
	 * (cont.) that were rated high
	 */
	public double newFalsePWhite() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
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
	 * @return percentage of black defendants who didn't re-offend (w/ updated definition of recidivism) 
	 * (cont.) that were rated high
	 */
	public double newFalsePBlack() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
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
	 * @return percentage of black defendants who recidivated (w/ updated definition of recidivism) 
	 * (cont.) that were rated low
	 */
	public double newFalseNBlack() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
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
	 * @return percentage of black defendants who recidivated (w/ updated definition of recidivism)
	 *  (cont.) that were rated low
	 */
	public double newFalseNWhite() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
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