package propublica.datadesign;
import propublica.datadesign.Person.C_Degree;
import propublica.datadesign.Person.Race;
import propublica.datadesign.Person.ScoreText;
import propublica.datadesign.Person.Sex;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class holds information about a single row in the .csv file we are using. 
 * Since a single row holds data for 1 person, the name of the class is Person.
 * @authors: Fatima Irfan, Silvia Alemany
 * @version: March 2, 2021
 */
public class Person {
    /**
     * fields
     * each field represents a column in the .csv file
     */
	// enum Sex for all possible sexes person could be
	public enum Sex {
		MALE,
		FEMALE,
		OTHER
	}
	// constant sex representing person's charge sex
	private Sex sex;
	// enum Sex to for possible races person could be
	public enum Race {
		AFRICAN_AMERICAN,
		CAUCASIAN,
		HISPANIC,
		NATIVE_AMERICAN,
		ASIAN,
		OTHER
	}
	// constant race representing person's race
	private Race race;
	// enum C_Degree to represent c_charge_degree types
	public enum C_Degree {
		M,
		F
	}
	// constant c_Degree representing person's charge degree
	private C_Degree c_Degree;
	// string variable to represent c_charge_description
	private String c_Desc;
	// integer variable to represent person's decile score
	private int decileScore;
	// enum ScoreText represent types of risk scores that can be assigned
	public enum ScoreText {
		LOW,
		MEDIUM,
		HIGH
	}
	// constant scoreText to represent person's score 
	private ScoreText scoreText;
	// boolean variable that represents whether person has
	// (cont.) re-offended (true = yes, false = no)
	private boolean twoYearRecid;
	// string variable representing r_charge_description
	private String r_Desc;
	// string variable representing r_charge_degree
	private String r_Degree;
	
    // constructors
	/**
	 * @param inputSex: constant representing person's sex 
	 * @param inputRace: constant representing person's race 
	 * @param inputC_Degree: constant representing type of charge degree 
	 * @param inputC_Desc: string variable representing charge description
	 * @param inputDecileScore: int variable representing person's decile score
	 * @param inputScoreText: constant representing person's risk score
	 * @param inputTwoYearRecid: boolean variable that represents whether person has
	 * (cont.) recividated (true = yes, false = no)
	 * @param inputR_Desc: string variable representing recividated charge description
	 * @param inputR_Degree: string variable representing recividated charge degree
	 */
	public Person(Person.Sex inputSex, Person.Race inputRace, Person.C_Degree inputC_Degree, 
			String inputC_Desc, int inputDecileScore, Person.ScoreText inputScoreText, 
			boolean inputTwoYearRecid, String inputR_Desc, String inputR_Degree) throws IllegalArgumentException {		
		this.sex = inputSex;
		this.race = inputRace;
		this.c_Degree = inputC_Degree;
		this.c_Desc = inputC_Desc;
		this.decileScore = inputDecileScore;
		this.scoreText = inputScoreText;
		this.twoYearRecid = inputTwoYearRecid;
		this.r_Desc = inputR_Desc;
		this.r_Degree = inputR_Degree; 		
	}	
	/**
	 *  ANSWERS to 2.2.1:
	 * in order for the field to be valid, it must be a string array with 9 elements
	 * the elements of the array must be ordered the same way as they are in the constructor
	 * the valid values for sex are "male" and "female"
	 * the valid values for race  "african_american", "african-american", "caucasian", "hispanic", and "other"
	 * the valid values for c_Degree are "m" and "f"
	 * the valid values for scoreText are "low", "medium" and "high"
	 * for the enum types above, capitalization should not matter because we used toUpperCase()
	 * the valid values for decileScore are any integer within quotations
	 * the valid values for twoYearRecid are "0" and "1"
	 * c_Desc, r_Desc and r_Degree should be able to take any string
	 */	
	
	/**
	 * @param row: takes string array with fields that will be in row
	 * @throws Exception, Exception, IndexOutOfBoundsException, IllegalArgumentException
	 */
    public Person(String[] row) throws Exception, IndexOutOfBoundsException, IllegalArgumentException {

    		// use toUpperCase() to find value of enum constant
    		this.sex = Sex.valueOf(row[0].toUpperCase());
    		// put underscore in place of hyphens and spaces
    		this.race = Race.valueOf(((row[1].replace('-', '_')).replace(' ', '_')).toUpperCase());
    		this.c_Degree = C_Degree.valueOf(row[2].toUpperCase());
    		this.c_Desc = row[3];
    		this.decileScore = Integer.parseInt(row[4]);
    		this.scoreText = ScoreText.valueOf(row[5].toUpperCase());
    		this.twoYearRecid = (Integer.parseInt(row[6]) == 1);
    		this.r_Desc = row[7];
    		this.r_Degree = row[8];   
    }
      
    // getters
    /** @return sex
     */
    public Sex getSex() {
		return sex;
	}
    /** @return race
     */
	public Race getRace() {
		return race;
	}
    /** @return c_charge_degree
     */
	public C_Degree getC_Degree() {
		return c_Degree;
	}
    /** @return risk score
     */
	public ScoreText getScoreText() {
		return scoreText;
	}
    /** @return c_charge_desc
     */
	public String getC_Desc() {
		return  c_Desc;
	}
    /** @return decile score
     */
	public int getDecileScore() {
		return  decileScore;
	}
    /** @return twoyearrecid 
     */
	public boolean getTwoYearRecid() {
		return  twoYearRecid;
	}
    /** @return r_charge_desc
     */
	public String getR_Desc() {
		return  r_Desc;
	}
    /** @return r_charge_degree
     */
	public String getR_Degree() {
		return  r_Degree;
	}
	
	// setters
	/**
	 * assigns new value to instance variable using parameter
	 * note that we only made setter for variables that we thought we would possibly want to change
	 * @param inputTwoYearRecid new value for twoYearRecid, 
	 * @param inputC_Desc new value for c_Desc
	 * @param inputR_Desc new value for r_Desc, and
	 * @param inputR_Degree new value for r_Degree, respectively.
	 */
	public void setTwoYearRecid(boolean inputTwoYearRecid) {
		twoYearRecid = inputTwoYearRecid;
	}
	public void setC_Desc(String inputC_Desc) {
		c_Desc = inputC_Desc;
	}
	public void setR_Desc(String inputR_Desc) {
		r_Desc = inputR_Desc;
	}
	public void setR_Degree(String inputR_Degree) {
		r_Degree = inputR_Degree;
	}
		
	// part 1.3 of lab 1
	/**
	 * indicates whether or not person is white
	 * @return true if person is white
	 */
    public boolean isWhite(){
    	
    	if (getRace().equals(Person.Race.CAUCASIAN)) {
    		return true;
    	} else {
      		return false;
    	}   	
    }
   
	/**
	 * indicates whether or not person is Black
	 * @return true if person is Black
	 */
    public boolean isBlack() {
    	if (getRace().equals(Person.Race.AFRICAN_AMERICAN)) {
    		return true;
    	} else {
    		return false;
    	}
    }
	/**
	 * indicates whether or not person has re-offended
	 * @return true if person has re-offended in the past 2 years
	 */
    public boolean hasReoffended() {
    	return getTwoYearRecid();
    }
	/**
	 * indicates whether or not person is low risk 
	 * @return true if person's risk score is low
	 */
    public boolean isLowRisk() {
    	if (getScoreText().equals(Person.ScoreText.LOW)) {
    		return true;
    	} else {
    		return false;
    	}
    }
	/**
	 * indicates whether or not person is high risk
	 * @return true if person's risk score is high or medium
	 */
    public boolean isHighRisk() {
    	if ((getScoreText()).equals(Person.ScoreText.HIGH) || (getScoreText()).equals(Person.ScoreText.MEDIUM)) {
    		return true;
    	} else {
    		return false;
    	}	    	
    } 
    
    /**
     * overrides string method and returns fields of Person class
     * in the order they appear in the row, separated by a space
     */
    public String toString() {
    	return sex + ", " + race + ", " + c_Degree + ", " + c_Desc
    			+ ", " + decileScore + ", " + scoreText + ", " + twoYearRecid
    			+ ", " + r_Desc + ", " + r_Degree;
    }
}


