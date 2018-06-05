package studentexercise;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student {
	private String name;
	private Map<Course, String> courseGrades = new HashMap<Course, String>();
	private Integer id;
	private static Integer uniqueCounter = 100000;

	public ArrayList<String> getCurrentlyEnrolled(){
		ArrayList<String> enrolledCourses= new ArrayList<String>();
		for(Course g : courseGrades.keySet()){
			if (courseGrades.get(g).equals(null)){
			enrolledCourses.add(g.getCourseName());
			}
		}
		return enrolledCourses;
	}
public Student(String stuName){
	name = stuName;
	id= uniqueCounter;
	uniqueCounter++;
}
public Set<Course> getCourses(){
	return courseGrades.keySet();
}
public void putGrade(Course d, String grade){
	courseGrades.put(d, grade);
}
public int getID(){
	return id;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public void toString(Student s){
	System.out.println("Student: " +this.name+", ID: " + this.id);
}
public Collection<String> getCourseGrades() {
	return courseGrades.values();
}
public Map<Course, String> getCourseAndGrades(){
	return this.courseGrades;
}

public String getGrade(Course f){
	return courseGrades.get(f);
}
}//class
