package studentexercise;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Course {
	private String courseName;
	private String courseCode;
	private Map<Integer, Student> enrolledList = new HashMap<Integer, Student>();
	private Map<Student, String> studentGrades = new HashMap<Student, String>();

	public Course(String Name, String Code) {
		courseName = Name;
		courseCode = Code;
	}

	public void removeEnrolledStudent(Student stu) {
		enrolledList.remove(stu.getID(), stu);
	}
	public void removeEnrolledStudent(int stuID){
		enrolledList.remove(stuID);
	}

	public void enrolStudent(Student stu) {
		enrolledList.put(stu.getID(), stu);
	}

	public Collection<Student> getStudents() {
		return enrolledList.values();
	}

	public void giveGrade(Student stuName, String stuGrade) {
		studentGrades.put(stuName, stuGrade);
		stuName.putGrade(School.getCourseByName(this.courseName), stuGrade);
		if (enrolledList.containsValue(stuName)) {
			enrolledList.remove(stuName.getID(), stuName);
		}
	}

	public String getCourseName() {
		return courseName;
	}

	public Set<Student> getCompletedStuList() {
		return studentGrades.keySet();
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getGrade(Student stu) {
		return studentGrades.get(stu);
	}

	public Map<Student, String> getAllStudentgrades() {
		return studentGrades;
	}

	public void setAllStudentgrades(Map<Student, String> studentgrades) {
		this.studentGrades = studentgrades;
	}
}// class
