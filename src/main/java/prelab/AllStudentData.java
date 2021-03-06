package prelab;
import java.util.ArrayList;
public class AllStudentData 
{
	// Second array list
	private ArrayList<StudentData> FinalStudentData;
	// making a constructor that takes no input and initializes the first array
	public AllStudentData() {
		//initializing the first array list inside the constructor 
		this.FinalStudentData = new ArrayList<StudentData>();
	}
	// making a method that is adding each array into the array list 
	public void FinalArrayList(ArrayList<String[]> array) {
		for (int i = 0; i < array.size(); i ++) {
			StudentData student = new StudentData(array.get(i));
			this.FinalStudentData.add(student);
		}
	
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String result;
		for(int i = 0; i < FinalStudentData.size(); i ++) {
			String line = (FinalStudentData.get(i)).toString() + "\n";
			sb.append(line);
		}
		result = sb.toString();
		return result;
		
	}
	
}