package studentexercise;

import java.util.Map.Entry;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Course English = new Course("English", "E232");
		School.addCourse(English);
		Course French = new Course("French", "FRN191");
		School.addCourse(French);
		
		Student Josh = new Student("Josh");
		School.addStudent(Josh);
		Student Mary = new Student("Mary");
		School.addStudent(Mary);
		Student Herbert = new Student("Herbert");
		School.addStudent(Herbert);

		English.enrolStudent(Josh);
		English.giveGrade(Josh, "B");
		English.enrolStudent(Mary);
		English.giveGrade(Mary, "F");
		French.enrolStudent(Josh);
		
		System.out.println("Which Courses would you like to create?");
		String answer2 = "";
		while (!answer2.equals("stop")) {
			answer2 = scan.next();
			if (!answer2.equals("stop")) {
				String answer3 = scan.next();
				Course b = new Course(answer2, answer3);
				School.addCourse(b);
			}
		}

		/** generating students */
		System.out.println(
				"Which students would you like to enrol? Enter a student name, followed by an existing course on the next line. Finish your list with 'stop'");
		String answer1 = "";
		while (!answer1.equals("stop")) {
			answer1 = scan.next();
			if (!answer1.equals("stop")) {
				String answerB = scan.next();
				Student c = new Student(answer1);
				School.addStudent(c);
				School.getCourseByName(answerB).enrolStudent(c);
			}
		}

		System.out.println("The courses in the school system are:");
		for (Course v : School.getCourseList()) {
			System.out.println(v.getCourseName());
		}
		System.out.println();

		for (Course b : School.getCourseList()) {
			System.out.println("There are this many students are enrolled in " + b.getCourseName() + ":");
			if (b.getStudents().isEmpty()) {
				System.out.println("None");
			} else {
				System.out.println(b.getStudents().size() + ",");

				for (Student s : b.getStudents()) {
					System.out.println(s.getName());
				}
			}
		}

		System.out.println(
				"Would you like to give a student a grade? Input a student name, their grade, and the course.");

		String answer4 = "";
		String answer5 = "";
		String answer6 = "";
		while (!answer4.equals("stop")) {
			answer4 = scan.next(); // student
			if (!answer4.equals("stop")) {
				answer5 = scan.next(); // grade
				answer6 = scan.next(); // course

				School.getCourseByName(answer6).giveGrade(School.getStudentByName(answer4), answer5);
			}
		}
		for (Student s : School.getStudentList()) {
			System.out.println(s.getName() + " has the following grades:");
			if (s.getCourses().isEmpty())
				System.out.println("None");
			for (Course d : s.getCourses()) {
				System.out.println("Course " + d.getCourseName() + ", Grade:" + s.getGrade(d));
			}
			System.out.println();
		}

		System.out.println("The students who took the English course received the following grades:");
		for (Student k : English.getCompletedStuList()) {
			System.out.println(k.getName() + ", " + English.getGrade(k));
		}

	}

}
