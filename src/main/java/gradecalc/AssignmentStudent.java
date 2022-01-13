package gradecalc;

/**
 * This class calculates the student mark that is in the assignment stream.
 * The class extends from the student class.
 */
public class AssignmentStudent extends Student{
    private double[] quizarr;
    private double[] assignmentArr;
    private final double tenPercent = 0.1;
    private final double fivePercent = 0.05;
    private final int zero = 0;
    private final int one = 1;
    private final int two = 2;
    private final int three = 3;
    private final int four = 4;
    private final int five = 5;
    private final int six = 6;
    private final int seven = 7;
    private final int eight = 8;
    private final int nine = 9;


    
    private int i = 0;

    /**
     * The constructor initializes the instance variables.
     */
    public AssignmentStudent(){
        quizarr = null;
        assignmentArr = null;
    }

    /**
     * sets the array of quiz grades.
     * @param arr the quiz grades.
     */
    public void setQuizGrade(double[] arr){
        quizarr = arr;
    }

    /**
     * gets and calcualtes the quiz grade.
     * @return the final calculated quiz grade.
     */
    @Override
    public double getQuizGrade(){
        return (quizarr[0] * tenPercent + quizarr[1] * tenPercent + quizarr[2] * tenPercent);
    }

    /**
     * sets the array of assignment grades.
     * @param arr the assignment grades.
     */
    public void setAssignmentGrade(double[] arr){
        assignmentArr = arr;
    }

    /**
     * gets and calculates the assignment grade.
     * @return the final calculated assignment grade.
     */
    @Override
    public double getAssignmentGrade(){
        double grade;
        grade = assignmentArr[zero] * fivePercent + assignmentArr[one] * fivePercent;
        grade = grade + assignmentArr[two] * fivePercent + assignmentArr[three] * fivePercent;
        grade = grade + assignmentArr[four] * fivePercent + assignmentArr[five] * fivePercent;
        grade = grade + assignmentArr[six] * fivePercent + assignmentArr[seven] * fivePercent;
        grade = grade + assignmentArr[eight] * fivePercent + assignmentArr[nine] * fivePercent;
        return grade;
    }

}
