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
	public void FinalArrayList(ArrayList<String[]> array) throws Exception {
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
	
	

}
