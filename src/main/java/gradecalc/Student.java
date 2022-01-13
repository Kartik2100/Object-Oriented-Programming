package gradecalc;

/**
 * This class refers to the the type of courses and marks that each student recieves.
 * it implements the ResearchSubject if the student qualifies for it.
 */
public abstract class Student implements ResearchSubject{
    private String studentName;
    private double studentExam;
    private String studentStream;
    private double studentGrade;
    private boolean particpatingTrue;
    private final double projectBonus = 5;
    private final double assignmentBonus = 3;
    private final double noValue = 0;
    private final double twentyPercent = 0.2;
    private final double fiftyPercent = 0.5;
    private final double hundred = 100;
    private final double sixty = 60;

    /**
     * constuctor intializes the instance variables.
     */
    public Student(){
        studentName = null;
        studentExam = 0;
        studentStream = null;
        studentGrade = 0;
        particpatingTrue = false;
    }

    /**
     * sets the student's name.
     * @param name is the name of the student.
     */
    public void setName(String name){
        studentName = name;
    }

    /**
     * gets the name of the student.
     * @return the student's name.
     */
    public String getName(){
        return studentName;
    }

    /**
     * sets the stream the student is in.
     * @param name is the type of stream.
     */
    public void setStream(String name){
        studentStream = name;
    }

    /**
     * gets the stream the student is in.
     * @return the stream of the student.
     */
    public String getStream(){
        return studentStream;
    }

    /**
     * set the exam grade of the student.
     * @param grade is the student exam grade.
     */
    public void setExamGrade(double grade){
        studentExam = grade;
    }

    /**
     * gets the exam grade of the student.
     * @return returns the student's exam grade.
     */
    public double getExamGrade(){
        return studentExam;
    }

    /**
     * gets the project grade for project portion.
     * @return calculated project grade.
     */
    public double getProjectGrade(){
        return 0;
    }

    /**
     * gets the milestone grade for milestone portion.
     * @return calculated milestone grade.
     */
    public double getMilestoneGrade(){
        return 0;
    }

    /**
     * gets the quiz grade for quiz portion.
     * @return calculated quiz grade.
     */
    public double getQuizGrade(){
        return 0;
    }

    /**
     * gets the assignment grade for assignment portion.
     * @return calculated assignment grade.
     */
    public double getAssignmentGrade(){
        return 0;
    }

    /**
     * gets the midterm grade for midterm portion.
     * @return calculated midterm grade.
     */
    public double getMidtermGrade(){
        return 0;
    }

    /**
     * overridden method to set if student is particpating in research. 
     */
    @Override
    public void setParticipating(boolean isParticipating){
        particpatingTrue = isParticipating;
    }

    /**
     * gets the decision of whether student is participating in research.
     * @return the boolean of research participation.
     */
    public boolean getParticipating(){
        return particpatingTrue;
    }

    /**
     * overridden method that returns the bonus mark from research. 
     */
    @Override
    public double researchPerk(){
        if(particpatingTrue){
            if(studentStream.equals("project")){
                return projectBonus;
            } else if(studentStream.equals("assignment")){
                return assignmentBonus;
            }
        }
        return noValue;
    }

    /**
     * calculates the final grade of the student depending on their stream.
     * @return the final mark of the student.
     */
    public double finalGrade(){
        if(studentStream.equals("project")){
            studentGrade = getMilestoneGrade() + (getExamGrade() * twentyPercent);
            studentGrade = studentGrade + (getMidtermGrade() * twentyPercent) + researchPerk();
            if (studentGrade > hundred){
                studentGrade = hundred;
            }
        } else if(studentStream.equals("challenge")){
            studentGrade = (getProjectGrade() * fiftyPercent) + (getExamGrade() * fiftyPercent);
            if (studentGrade > hundred){
                studentGrade = hundred;
            }
        } else if(studentStream.equals("assignment")){
            studentGrade = getQuizGrade() + getAssignmentGrade() + (getExamGrade() * twentyPercent) + researchPerk();
            if (studentGrade > sixty){
                studentGrade = sixty;
            }
        }
    return Math.round(studentGrade);
    }

    /**
     * the name and finalgrade is translated to a string with a space in between.
     * @return the string with name and mark.
     */
    public String toString(){
        int value = (int) finalGrade();
        return getName() + " " + value;
    }
}
