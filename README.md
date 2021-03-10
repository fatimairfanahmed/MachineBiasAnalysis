## CS 106 Lab 2: Data Structure Design

Name: Silvia Alemany and Fatima Irfan

---

### Read about pair programming and how to navigate through it

I recommend you to read the pair ["Pair Programming Guide - Please read this before you start working on the assignment.pdf"](https://drive.google.com/file/d/1tmSYwfKKXeMVDXvT6q5fPHPbF_vMF9Z4/view?usp=sharing). Make sure you fill the log provided in **pair-programming folder** as accurately as possible. The log shall be graded. 

### Work on pre-lab

Pre-labs are to prepare you for the actual lab. Please take a look at pre-lab2-tasks.pdf in cs106-lab2/tasks/ to read the pre-lab2 tasks. 

### Work on the lab tasks
Tasks that you have to complete are listed in lab2_tasks.pdf provided in cs106-lab2/tasks/. Please spend time reading the tasks and planning how you would complete them with your partner before implementing them.  

### Reuse of what you have already completed
The tasks of this lab, build upon the tasks that you have completed in lab1. Please make reuse of the code that you have already written in lab1. 


### Lab resources are also available in the Google Drive folder shared with you, which has lectures and slides. 

[Google Drive Links for lecture, lab, and assignment](https://drive.google.com/drive/folders/1EuAYlyaFLN97TI7PzW0b8PfPxxaD5Zsk?usp=sharing)

### Additional Lab Questionnaire

(None of your answers below will affect your grade; this is to help refine lab
assignments in the future)

1. Approximately how many hours did you take to complete this lab? (provide your answer as a single integer on the line below)

8

2. How difficult did you find this lab? (1-5, with 5 being very difficult and 1 being very easy)
5

3. Describe the biggest challenge you faced in this lab: Part 4.1 was difficult to do correctly.

###Part 3.2
1. None of our validation methods indicated that our precondition assumptions weren't met.

2. A person that would not pass the preconditions would be someone who is defined as "White" in the Race column. Another example
is someone whose decile score is not an integer, like 3.3.

###Analysis- part 5
We were originally going to find common keywords for less serious re-offenses to find descriptions that  had these keywords, 
but we realized that a lot of the language used to describe minor re-offenses is also used to describe serious re-offenses.
So instead, we used terminal to show only the unique entries for r_charge_desc in the.csv file, and then we sorted to see the most
common unique entries. From the ten most common entries, we found 5 descriptions that we didn't think counted as recidivism because 
they were relatively minor or subjective. These were "Susp Drivers Lic 1st Offense", "Possess Cannabis/20 Grams Or Less", "Resist/Obstruct W/O Violence",
"Operating W/O Valid License", and "Petit Theft". We then wrote a new hasReoffended method called newHasReoffended in the Person class,
and used this method to create new methods that found frequency of false positives/negatives in AllPeople.
Since each of these 5 descriptions we chose show up 100-300 times in the .csv, we thought that the difference in the original analysis
and this one would show a general trend in how false positives and negatives change when we consider the weight of the re-offense.
Our results showed that for both White and Black Defendants, there was a less than 1% increase in the rate of false negatives,
but the rate of false positives rose to 27.6% for white defendants and to over 50% (52.2%) for Black defendants. This shows that the false positive
rates for both Black and White defendants is even higher when we stop counting very common and less serious re-offenses as recidivism.
