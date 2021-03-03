package prelab;
import java.util.ArrayList;
public class StudentData {
	//contains name, age, class year, residence, have job, dean
	private String name;
	private int age;
	enum ClassYear {
		FIRST_YEAR, SOPHOMORE, JUNIOR, SENIOR
	}
	private ClassYear classYear;
	private String dorm;
	private boolean job;
	enum Dean {
		ELIAS, GLANZER, TENSUAN, DENNEY, WILCOX, CUZZOLINA
	}
	private Dean dean;
	public StudentData(String inputname, int inputage, StudentData.ClassYear inputclassYear, String inputdorm, StudentData.Dean inputdean) {
		this.name = inputname;
		this.age = inputage;
		this.classYear = inputclassYear;
		this.dorm = inputdorm;
		this.dean = inputdean;
	}
	public StudentData( String[] file) {
		this.name = file[0];
		this.age = Integer.parseInt(file[1]);
		this.classYear = ClassYear.valueOf(file[2]);
		this.dorm = file[3];
		this.job = Boolean.getBoolean(file[4]);
		this.dean = Dean.valueOf(file[5]);	
	}
}