package prelab;
import java.util.ArrayList;
public class StudentData {
	//contains name, age, class year, residence, have job, dean
	private String name;
	private int age;
	private String classYear;
	private String dorm;
	private boolean job;
	private String dean;
	public StudentData(String inputname, int inputage, String inputclassYear, String inputdorm, boolean inputjob, 
			String inputdean) {
		this.name = inputname;
		this.age = inputage;
		this.classYear = inputclassYear;
		this.dorm = inputdorm;
		this.job = inputjob;
		this.dean = inputdean;
	}
	public StudentData(String[] row) {
		// check that the row has 5 items and if not, bomb
		this.name = row[0];
		this.age = Integer.parseInt(row[1]);
		this.classYear = row[2];
		this.dorm = row[3];
		this.job = Boolean.getBoolean(row[4]);
		this.dean = row[5];	
	}
	public boolean getJob() {
		return job;
	}
	public String toString() {
		return name + " " + age + " " + classYear + " " + dorm + " " + job + " " + dean;
	}
}