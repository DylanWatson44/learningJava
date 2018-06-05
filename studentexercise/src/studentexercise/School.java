package studentexercise;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class School {
	private static Map<String, Course> courseList = new HashMap<String, Course>();
	private static Map<Integer, Student> students = new HashMap<Integer, Student>();
	private static Map<String, Student> studentnames = new HashMap<String, Student>();

	public static void addStudent(Student s) {
		students.put(s.getID(), s);
		studentnames.put(s.getName(), s);
	}

	public static Student getStudent(Integer stuID) {
		return students.get(stuID);
	}

	public static Student getStudentByName(String stuName) {
		return studentnames.get(stuName);
	}
	public static Course getCourseByName(String r){
		return courseList.get(r);
		
	}
	public static Collection<Student> getStudentList(){
		return students.values();
	}
	public static void addCourse(Course e) {
		courseList.put(e.getCourseName(), e);
	}
	public static String getCourseCode(String f){
		return courseList.get(f).getCourseCode();
	}
	public static Collection<Course> getCourseList() {
		return courseList.values();
	}
	//
	// public static Course getCourse(String coursecode) {
	// return courseList.get(coursecode);
	// }
}// class