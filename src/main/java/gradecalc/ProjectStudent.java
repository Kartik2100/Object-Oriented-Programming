package gradecalc;

/**
 * This class calculates grades for students in the project stream.
 * the class extends from the student class.
 */
public class ProjectStudent extends Student{
    private double[] milestoneArr;
    private double midtermGrade;
    private final double twentyPercent = 0.2;

    /**
     * The constructor initializes the instance variables
     */
    public ProjectStudent(){
        milestoneArr = null;
        midtermGrade = 0;
    }

    /**
     * this method sets the milestone grades.
     * @param arr the array of milestone grades.
     */
    public void setMilestoneGrade(double[] arr){
        milestoneArr = arr;
    }

    /**
     * this method gets the milestone grades and returns it.
     * @return the calculated milestone grade.
     */
    @Override
    public double getMilestoneGrade(){
        return (milestoneArr[0] * twentyPercent + milestoneArr[1] * twentyPercent + milestoneArr[2] * twentyPercent);
    }

    /**
     * sets the grade received from midterm.
     * @param grade the grade on the midterm.
     */
    public void setMidtermGrade(double grade){
        midtermGrade = grade;
    }

    /**
     * gets the grade from the midterm.
     * @return the grade received in the midterm is returned
     */
    @Override
    public double getMidtermGrade(){
        return midtermGrade;
    }

}
