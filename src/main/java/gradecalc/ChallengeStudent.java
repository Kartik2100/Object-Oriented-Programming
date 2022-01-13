package gradecalc;

/**
 * This class represents the students who are taking the
 * challenge stream that extends from students.
 */
public class ChallengeStudent extends Student{
    private double studentProject;

    /**
     * the constructor initalizes the instance variables.
     */
    public ChallengeStudent(){
        studentProject = 0;
    }

    /**
     * sets the project grade recieved in the project portion.
     * @param grade the project grade given.
     */
    public void setProjectGrade(double grade){
        studentProject = grade;
    }

    /**
     * gets the project grade of the student
     * @return the project grade of the student.
     */
    @Override
    public double getProjectGrade(){
        return studentProject;
    }
}
