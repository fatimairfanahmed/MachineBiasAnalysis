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
	 * 
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
	 * 
	 * @return percentage of defendants who were rated high and did not re-offend
	 */
	public double FalsePositiveWhite() {
		double counter = 0;
		double whitecounter = 0;
		for(int i = 0; i < AllPeopleData.size(); i++) {
			if (AllPeopleData.get(i).isHighRisk() && AllPeopleData.get(i).isWhite()
					&& !AllPeopleData.get(i).hasReoffended()) {
				counter++;
			}
			if (AllPeopleData.get(i).isWhite()) {
				whitecounter++;
			}
		}
		double percentageFalsePositive = counter/whitecounter;
		return percentageFalsePositive;
	}
	
	public double FalsePositiveBlack() {
		double counter = 0;
		for(int i = 0; i < AllPeopleData.size(); i++) {
			if (AllPeopleData.get(i).isHighRisk() && AllPeopleData.get(i).isBlack()
					&& !AllPeopleData.get(i).hasReoffended()) {
				counter++;
			}
		}
		double percentageFalsePositive = counter/(AllPeopleData.size());
		return percentageFalsePositive;
	}
	
	/**
	 * 
	 * @return percentage of defendants who were rated low but recidivated
	 */
	public double FalseNegativeBlack() {
		double counter = 0;
		for(int i = 0; i < AllPeopleData.size(); i++) {
			if (AllPeopleData.get(i).isLowRisk() && AllPeopleData.get(i).isBlack()
					&& AllPeopleData.get(i).hasReoffended()) {
				counter++;
			}
		}
		double percentageFalseNegative = counter/(AllPeopleData.size());
		return percentageFalseNegative;
	}
	
	public double FalseNegativeWhite() {
		double counter = 0;
		double whitecounter = 0;
		for(int i = 0; i < AllPeopleData.size(); i++) {
			if (AllPeopleData.get(i).isLowRisk() && AllPeopleData.get(i).isWhite()
					&& AllPeopleData.get(i).hasReoffended()) {
				counter++;
			}
			if (AllPeopleData.get(i).isWhite()) {
				whitecounter++;
			}
		}
		double percentageFalseNegative = counter/whitecounter;
		return percentageFalseNegative;
	}
	
}
