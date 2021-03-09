package propublica.datadesign;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import prelab.StudentData;

/**
 * 
 * @author Silvia Alemany and Fatima Irfan
 * class representing entire data set/ of defendants
 *
 */
public class AllPeople {
	private ArrayList<Person> AllPeopleData;
	public AllPeople() {
		//initializing the first array list inside the constructor 
		this.AllPeopleData = new ArrayList<Person>();
	}
	/**
	 * @param arrayList: ArrayList comprised of String arrays where each array represents attributes of a person object
	 * @throws Exception
	 * @throws IllegalArgumentException
	 */
	public void finalArrayList(ArrayList<String[]> arrayList) throws Exception, IllegalArgumentException, 
	IndexOutOfBoundsException, IOException, FileNotFoundException  {	
		for (int i = 0; i < arrayList.size(); i ++) {
			try {
				Person person = new Person(arrayList.get(i));
				this.AllPeopleData.add(person);
			} catch (IllegalArgumentException exception) {
				continue;
			} catch (IndexOutOfBoundsException exception) {
				continue;
			}
		}
	}
		

	/**
	 * method that overrides toString method to convert objects in 
	 * ArrayList to a string
	 * @return string where each row is on a different line and the fields are comma-separated
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		String resultString;
		for(int i = 0; i < AllPeopleData.size(); i ++) {
			String line = (AllPeopleData.get(i)).toString() + "\n";
			stringBuilder.append(line);
		}
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
	
}