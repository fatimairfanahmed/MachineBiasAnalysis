package propublica.datadesign;
/**
 * This class holds information about a single row in the .csv file we are using. 
 * Since a single row holds data for 1 person/defendant, the name of the class is Person.
 * 
 * @authors: Fatima Irfan, Silvia Alemany
 * @version: March 9, 2021
 */
public class Person {
    /**
     * fields
     * each field represents a column in the .csv file
     */
	// enum Sex for all possible sexes person could be
	public enum Sex {
		MALE,
		FEMALE
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
	// enum C_Degree to represent original charge degree types
	public enum C_Degree {
		M,
		F
	}
	// constant c_Degree representing person's original charge degree
	private C_Degree c_Degree;
	// string variable to represent original charge description
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
	// boolean variable that represents whether person has recidivated (true = yes, false = no)
	private boolean twoYearRecid;
	// string variable representing recidivated charge description
	private String r_Desc;
	// string variable representing recidivated charge degree
	private String r_Degree;
	
	/**
	 * First Constructor for Person Class
	 * @param inputSex: constant representing person's sex 
	 * @param inputRace: constant representing person's race 
	 * @param inputC_Degree: constant representing type of charge degree 
	 * @param inputC_Desc: string variable representing charge description
	 * @param inputDecileScore: int variable representing person's decile score
	 * @param inputScoreText: constant representing person's risk score
	 * @param inputTwoYearRecid: boolean variable that represents whether person has
	 *  recidivated (true = yes, false = no)
	 * @param inputR_Desc: string variable representing recidivated charge description
	 * @param inputR_Degree: string variable representing recidivated charge degree
	 * @throws Exception, IllegalArgumentException
	 */
	public Person(Person.Sex inputSex, Person.Race inputRace, Person.C_Degree inputC_Degree, 
				  String inputC_Desc, int inputDecileScore, Person.ScoreText inputScoreText, 
				  boolean inputTwoYearRecid, String inputR_Desc, String inputR_Degree) 
				  throws Exception, IllegalArgumentException {		
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
	 * Second constructor for Person class
	 * @param row: takes string array with fields that will be in row, in the same order as previous constructor
	 * @throws Exception, IndexOutOfBoundsException, IllegalArgumentException
	 * Preconditions: array must have 9 elements or IndexOutOfBoundsException is thrown.
	 * The valid values for sex are "male" and "female".
	 * The valid values for race  "Asian", "Caucasian", "Hispanic",  "Other", "Native American", and "African-American".
	 * "Native American" and "African-American" can have a hyphen, space or underscore between the 2 words.
	 * The valid values for c_Degree are "m" and "f".
	 * The valid values for scoreText are "low", "medium" and "high".
	 * For the enum types above, capitalization should not matter because we used toUpperCase().
	 * The valid values for decileScore are any integer within quotations.
	 * The valid values for twoYearRecid are "0" and "1".
	 * ^If any of the preconditions other than the first one is violated, an IllegalArgumentException is thrown.
	 */
    public Person(String[] row) throws Exception, IndexOutOfBoundsException, IllegalArgumentException {
    		// ensures that twoYearRecid is 0 or 1; throws IllegalArgumentException if not
    		if (Integer.parseInt(row[6]) != 1 && Integer.parseInt(row[6]) != 0) {
    			throw new IllegalArgumentException(); 
    		}
    		// use .toUpperCase() to find appropriate enum constant for field
    		this.sex = Sex.valueOf(row[0].toUpperCase());
    		// put underscore in place of hyphens and spaces
    		this.race = Race.valueOf(((row[1].replace('-', '_')).replace(' ', '_')).toUpperCase());
    		this.c_Degree = C_Degree.valueOf(row[2].toUpperCase());
    		this.c_Desc = row[3];
    		this.decileScore = Integer.parseInt(row[4]);
    		this.scoreText = ScoreText.valueOf(row[5].toUpperCase());
    		// twoYearRecid assigned true if row[6] is "1" and false if row[6] is "0"
    		this.twoYearRecid = (Integer.parseInt(row[6]) == 1);
    		this.r_Desc = row[7];
    		this.r_Degree = row[8];   
    }
      
    // getter methods for each field
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
    /** @return original charge degree
     */
	public C_Degree getC_Degree() {
		return c_Degree;
	}
    /** @return risk score
     */
	public ScoreText getScoreText() {
		return scoreText;
	}
    /** @return original charge description
     */
	public String getC_Desc() {
		return  c_Desc;
	}
    /** @return decile score
     */
	public int getDecileScore() {
		return  decileScore;
	}
    /** @return whether or no person recidivated 
     */
	public boolean getTwoYearRecid() {
		return  twoYearRecid;
	}
    /** @return recidivated charge description
     */
	public String getR_Desc() {
		return  r_Desc;
	}
    /** @return recidivated charge degree
     */
	public String getR_Degree() {
		return  r_Degree;
	}
	
	// setters
	/**
	 * assigns new value to twoYearRecid using parameter
	 * note that we only made setter for variables that we thought we would possibly want to change
	 * @param inputTwoYearRecid new value for twoYearRecid
	 */
	public void setTwoYearRecid(boolean inputTwoYearRecid) {
		twoYearRecid = inputTwoYearRecid;
	}
	/**
	 * assigns new value to c_Desc using parameter
	 * @param inputC_Desc new value for c_Desc
	 */
	public void setC_Desc(String inputC_Desc) {
		c_Desc = inputC_Desc;
	}	
	/**
	 * assigns new value to r_Desc using parameter
	 * @param inputR_Desc new value for r_Desc
	 */
	public void setR_Desc(String inputR_Desc) {
		r_Desc = inputR_Desc;
	}
	/**
	 * assigns new value to r_Degree using parameter
	* @param inputR_Degree new value for r_Degree
	*/
	public void setR_Degree(String inputR_Degree) {
		r_Degree = inputR_Degree;
	}
		
	// part 1.3 of lab 1
	/**
	 * indicates whether or not person is white
	 * @return true if person is white, false if person is not white
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
	 * @return true if person is Black, false if person is not Black
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
	 * @return true if person has re-offended in the past 2 years, and false if not
	 */
    public boolean hasReoffended() {
    	return getTwoYearRecid();
    }
	/**
	 * indicates whether or not person is low risk 
	 * @return true if person's risk score is low, and false if it's high or medium
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
	 * @return true if person's risk score is high or medium, and false if it's low
	 */
    public boolean isHighRisk() {
    	if ((getScoreText()).equals(Person.ScoreText.HIGH) || (getScoreText()).equals(Person.ScoreText.MEDIUM)) {
    		return true;
    	} else {
    		return false;
    	}	    	
    } 
    
    /**
     * overrides toString method
     * @return attributes of Person object in the order they appear in the row, separated by a space 
     */
    public String toString() {
    	return sex + ", " + race + ", " + c_Degree + ", " + c_Desc
    			+ ", " + decileScore + ", " + scoreText + ", " + twoYearRecid
    			+ ", " + r_Desc + ", " + r_Degree;
    }
    
	/**
	 * this is a different version of the "hasReoffended" method for analysis in part 5
	 * @return true if person has recidivated in the past 2 years,
	 * except for if the crime is considered minor and common
	 * @return false if person hasn't re-offended, or if person re-offended with a crime minor and common enough 
	 * that we did not consider the offense "recidivism" 
	 */
    public boolean newHasReoffended() {
    	if (getTwoYearRecid()) {
    		if ((getR_Desc()).contains("Susp Drivers Lic 1st Offense") ||
    			(getR_Desc()).contains("Possess Cannabis/20 Grams Or Less") ||
    			(getR_Desc()).contains("Resist/Obstruct W/O Violence") ||
    			(getR_Desc()).contains("Operating W/O Valid License") || 
				(getR_Desc()).contains("Petit Theft")) {
    			return false;
    		} else {
    			return true;
    		}
    	} else {
    		return false;
    	}
    }
}


