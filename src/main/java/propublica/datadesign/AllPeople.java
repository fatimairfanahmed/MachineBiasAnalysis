package propublica.datadesign;

import java.util.ArrayList;

import prelab.StudentData;

/**
 * 
 * @author Silvia Alemany and Fatima Irfan
 * class representing entire data set/entire set of people. 
 *
 */
public class AllPeople {
	private ArrayList<Person> AllPeopleData;
	public AllPeople() {
		//initializing the first array list inside the constructor 
		this.AllPeopleData = new ArrayList<Person>();
	}
	// making a method that is adding each array into the array list 
	public void FinalArrayList(ArrayList<String[]> array) throws Exception, IllegalArgumentException {
		for (int i = 0; i < array.size(); i ++) {
			Person person = new Person(array.get(i));
			this.AllPeopleData.add(person);
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
	 * @return percentage of white defendants who were rated high and did not re-offend
	 */
	public double FalsePositiveWhite() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
			if (person.isWhite() && person.isHighRisk()) {
				totalCounter++;
				if (!person.hasReoffended()) {
					falseCounter++;
				}
			}
		}
		double percentageFalseNegative = falseCounter/totalCounter;
		return percentageFalseNegative;
	}
	
	/** 
	 * @return percentage of black defendants who were rated high and did not re-offend
	 */
	public double FalsePositiveBlack() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
			if (person.isBlack() && person.isHighRisk()) {
				totalCounter++;
				if (!person.hasReoffended()) {
					falseCounter++;
				}
			}
		}
		double percentageFalseNegative = falseCounter/totalCounter;
		return percentageFalseNegative;
	}
	
	/**
	 * @return percentage of black defendants who were rated low but recidivated
	 */
	public double FalseNegativeBlack() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
			if (person.isBlack() && person.isLowRisk()) {
				totalCounter++;
				if (person.hasReoffended()) {
					falseCounter++;
				}
			}
		}
		double percentageFalseNegative = falseCounter/totalCounter;
		return percentageFalseNegative;
	}
	
	/**
	 * @return percentage of white defendants who were rated low but recidivated
	 */
	public double FalseNegativeWhite() {
		double falseCounter = 0;
		double totalCounter = 0;
		for(Person person : AllPeopleData) {
			if (person.isWhite() && person.isLowRisk()) {
				totalCounter++;
				if (person.hasReoffended()) {
					falseCounter++;
				}
			}
		}
		double percentageFalseNegative = falseCounter/totalCounter;
		return percentageFalseNegative;
	}
	
}