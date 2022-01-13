
package gradecalc;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * this class the json file gets parsed to the other classes.
 */
public class Roster {

    private ArrayList<Student> studentsList = new ArrayList<Student>();
    private final int three = 3;
    private final int ten = 10;
    private ChallengeStudent cCourse;
    private ProjectStudent pCourse;
    private AssignmentStudent aCourse;
    private double[] milestoneGradesArr = new double[three];
    private double[] quizGradesArr = new double[three];
    private double[] assignmentGradesArr = new double[ten];
    
    
    /**
     * the constructor has a JSON filename as a string that is going to get parsed.
     * @param jSONFilename is the file stream of the JSON file.
     */
    public Roster(String jSONFilename){

        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        try(Reader reader = new FileReader(jSONFilename)){
            jsonObject= (JSONObject) parser.parse(reader);
        }catch(Exception e){
            System.out.println("File is not found.");
            jsonObject = null;
        }
        readObject(jsonObject);
    }

    /**
     * takes the keys from the JSON object.
     * @param obj the JSON object.
     */
    public void readObject(JSONObject obj){
        JSONArray numStudents = (JSONArray) obj.get("students");
        
        for(Object student : numStudents){
            JSONObject studentMarks = (JSONObject) student;
            String name = (String) studentMarks.get("name");
            String courseType = (String) studentMarks.get("stream");
            if(courseType.equals("challenge")){
                challengeStream(name, courseType, studentMarks);
            } else if(courseType.equals("project")){
                projectStream(name, courseType, studentMarks);
            } else if(courseType.equals("assignment")){
                assignmentStream(name, courseType, studentMarks);
            }
            
        }
    }

    /**
     * represents the student who is in the challenge stream.
     * @param name name of student.
     * @param courseType name of stream.
     * @param studentMarks JSON object that is needed to be parsed.
     */
    public void challengeStream(String name, String courseType, JSONObject studentMarks){
        cCourse = new ChallengeStudent();
        cCourse.setName(name);
        cCourse.setStream(courseType);
        Number projectGradeTemp = (Number)studentMarks.get("projectGrade");
        double projectGrade = projectGradeTemp.doubleValue();
        Number examGradeTemp = (Number) studentMarks.get("examGrade");
        double examGrade = examGradeTemp.doubleValue();
        cCourse.setProjectGrade(projectGrade);
        cCourse.setExamGrade(examGrade);
        studentsList.add(cCourse);
    } 

    /**
     * represents the student who is in the project stream.
     * @param name name of student.
     * @param courseType name of stream.
     * @param studentMarks JSON object that is needed to be parsed.
     */
    public void projectStream(String name, String courseType, JSONObject studentMarks){
        pCourse = new ProjectStudent();
        pCourse.setName(name);
        pCourse.setStream(courseType);
        JSONArray milestoneArr = (JSONArray) studentMarks.get("milestoneGrades");
        Iterator<Number> iterator = milestoneArr.iterator();
        milestoneGradesArr = iteratorCheck(iterator);
        Number examGradeTemp = (Number) studentMarks.get("examGrade");
        double examGrade = examGradeTemp.doubleValue();
        Number midtermGradeTemp = (Number) studentMarks.get("midtermGrade");
        double midtermGrade = midtermGradeTemp.doubleValue();
        if(studentMarks.containsKey("participating")){
            boolean participatingChoice = (boolean) studentMarks.get("participating");
            pCourse.setParticipating(participatingChoice);
        }
        pCourse.setMilestoneGrade(milestoneGradesArr);
        pCourse.setExamGrade(examGrade);
        pCourse.setMidtermGrade(midtermGrade);
        studentsList.add(pCourse);
    }

    /**
     * represents the student who is in the assignment stream.
     * @param name name of student.
     * @param courseType name of stream.
     * @param studentMarks JSON object that is needed to be parsed.
     */
    public void assignmentStream(String name, String courseType, JSONObject studentMarks){
        aCourse = new AssignmentStudent();
        aCourse.setName(name);
        aCourse.setStream(courseType);
        JSONArray quizArr = (JSONArray) studentMarks.get("quizGrades");
        Iterator<Number> iterator2 = quizArr.iterator();
        quizGradesArr = iteratorCheck(iterator2);
        JSONArray assignmentArr = (JSONArray) studentMarks.get("assignmentGrades");
        Iterator<Number> iterator3 = assignmentArr.iterator();
        assignmentGradesArr = iteratorCheck2(iterator3);
        Number examGradeTemp = (Number) studentMarks.get("examGrade");
        double examGrade = examGradeTemp.doubleValue();
        boolean participatingChoice = choice(studentMarks);
        aCourse.setParticipating(participatingChoice);
        aCourse.setQuizGrade(quizGradesArr);
        aCourse.setAssignmentGrade(assignmentGradesArr);
        aCourse.setExamGrade(examGrade);
        studentsList.add(aCourse);
    }

    /**
     * checks if student is participating in the research.
     * @param studentMarks the JSON object where participating is retrieved.
     * @return the participating choice.
     */
    public boolean choice(JSONObject studentMarks){
        if(studentMarks.containsKey("participating")){
            boolean participatingChoice = (boolean) studentMarks.get("participating");
            return participatingChoice;
        }
        return false;
        
    }

    /**
     * converts JSON array to array.
     * @param iterator iterates through the JSON array.
     * @return the array with grades
     */
    public double[] iteratorCheck(Iterator<Number> iterator){
        int j = 0; 
        double[] gradeArr = new double[three];
        while(iterator.hasNext()){
            double temp = iterator.next().doubleValue();
            gradeArr[j] = temp;
            j = j + 1;
        }
        return gradeArr;
    }

    /**
     * converts JSON array to array.
     * @param iterator iterates through the JSON array.
     * @return the array with grades
     */
    public double[] iteratorCheck2(Iterator<Number> iterator){
        int j = 0; 
        double[] gradeArr = new double[ten];
        while(iterator.hasNext()){
            double temp = iterator.next().doubleValue();
            gradeArr[j] = temp;
            j = j + 1;
        }
        return gradeArr;
    }
    
    /**
     * gets the array list of the students
     * @return the student arraylist.
     */
    public ArrayList<Student> getStudents(){
        return studentsList;
    }

    public static void main(String[] args){
        Roster newRoster = new Roster("roster.json");
        for(int i = 0; i < newRoster.getStudents().size(); i++){
            System.out.println(newRoster.getStudents().get(i).toString());
        }
    }

}
