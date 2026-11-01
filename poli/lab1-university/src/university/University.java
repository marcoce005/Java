package university;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {

	private final String name;
	private String rectorFirst;
	private String rectorLast;

	private static final int OFFSET_S = 10000;
	private static final int MAX_STUDENTS = 1000;
	private final Student[] students = new Student[MAX_STUDENTS];
	private int contS = 0;

	private static final int OFFSET_C = 10;
	private static final int MAX_COURSES = 50;
	private final Course[] courses = new Course[MAX_COURSES];
	private int contC = 0;

	// R1
	/**
	 * Constructor
	 * 
	 * @param name name of the university
	 */
	public University(String name) {
		// Example of logging
		// logger.info("Creating extended university object");
		this.name = name;
	}

	/**
	 * Getter for the name of the university
	 * 
	 * @return name of university
	 */
	public String getName() {
		return name;
	}

	/**
	 * Defines the rector for the university
	 * 
	 * @param first first name of the rector
	 * @param last  last name of the rector
	 */
	public void setRector(String first, String last) {
		rectorFirst = first;
		rectorLast = last;
	}

	/**
	 * Retrieves the rector of the university with the format "First Last"
	 * 
	 * @return name of the rector
	 */
	public String getRector() {
		return rectorFirst + " " + rectorLast;
	}

	// R2
	/**
	 * Enrol a student in the university
	 * The university assigns ID numbers
	 * progressively from number 10000.
	 * 
	 * @param first first name of the student
	 * @param last  last name of the student
	 * 
	 * @return unique ID of the newly enrolled student
	 */
	public int enroll(String first, String last) {
		if (contS < MAX_STUDENTS) {
			students[contS] = new Student(contS + OFFSET_S, first, last);

			logger.info("New student enrolled: " + students[contS]);

			return contS++ + OFFSET_S;
		}
		return -1; // too many students max = 1000;
	}

	/**
	 * Retrieves the information for a given student.
	 * The university assigns IDs progressively starting from 10000
	 * 
	 * @param id the ID of the student
	 * 
	 * @return information about the student
	 */
	public String student(int id) {
		if (id >= OFFSET_S && id < OFFSET_S + MAX_STUDENTS && id - OFFSET_S < contS) {
			return students[id - OFFSET_S].toString();
		}
		return null; // invalid id
	}

	// R3
	/**
	 * Activates a new course with the given teacher
	 * Course codes are assigned progressively starting from 10.
	 * 
	 * @param title   title of the course
	 * @param teacher name of the teacher
	 * 
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher) {
		if (contC < MAX_COURSES) {
			courses[contC] = new Course(contC + OFFSET_C, title, teacher);

			logger.info("New course activated: " + courses[contC]);

			return contC++ + OFFSET_C;
		}
		return -1; // too many courses max = 50;
	}

	/**
	 * Retrieve the information for a given course.
	 * 
	 * The course information is formatted as a string containing
	 * code, title, and teacher separated by commas,
	 * e.g., {@code "10,Object Oriented Programming,James Gosling"}.
	 * 
	 * @param code unique code of the course
	 * 
	 * @return information about the course
	 */
	public String course(int code) {
		if (code >= OFFSET_C && code < OFFSET_C + MAX_COURSES) {
			return courses[code - OFFSET_C].toString();
		}
		return null; // invalid id
	}

	// R4
	/**
	 * Register a student to attend a course
	 * 
	 * @param studentID  id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode) {
		if ((studentID >= OFFSET_S && studentID < OFFSET_S + contS)
				&& (courseCode >= OFFSET_C && courseCode < OFFSET_C + contC)) {

			if (students[studentID - OFFSET_S].subCourse(courses[courseCode - OFFSET_C]) >= 0 && courses[courseCode - OFFSET_C].isAvailable()) {
				courses[courseCode - OFFSET_C].subStudent(students[studentID - OFFSET_S]);
			}

			logger.info("Student " + studentID + " signed up for course " + courseCode);
		}
	}

	/**
	 * Retrieve a list of attendees.
	 * 
	 * The students appear one per row (rows end with {@code'\n'})
	 * and each row is formatted as described in method {@link #student}
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode) {
		return courses[courseCode - OFFSET_C].allSubStudents();
	}

	/**
	 * Retrieves the study plan for a student.
	 * 
	 * The study plan is reported as a string having
	 * one course per line (i.e. separated by '\n').
	 * The courses are formatted as describe in method {@link #course}
	 * 
	 * @param studentID id of the student
	 * 
	 * @return the list of courses the student is registered for
	 */
	public String studyPlan(int studentID) {
		return students[studentID - OFFSET_S].allSubCourses();
	}

	// R5
	/**
	 * records the grade (integer 0-30) for an exam can
	 * 
	 * @param studentId the ID of the student
	 * @param courseID  course code
	 * @param grade     grade ( 0-30)
	 */
	public void exam(int studentId, int courseID, int grade) {
		if ((studentId >= OFFSET_S && studentId < OFFSET_S + contS)
				&& (courseID >= OFFSET_C && courseID < OFFSET_C + contC)
				&& (grade >= 0 && grade <= 30)) {

			students[studentId - OFFSET_S].regExam(grade);
			courses[courseID - OFFSET_C].regExam(grade);

			logger.info("Student " + studentId + " took an exam in course " + courseID + " with grade " + grade);
		}
	}

	/**
	 * Computes the average grade for a student and formats it as a string
	 * using the following format
	 * 
	 * {@code "Student STUDENT_ID : AVG_GRADE"}.
	 * 
	 * If the student has no exam recorded the method
	 * returns {@code "Student STUDENT_ID hasn't taken any exams"}.
	 * 
	 * @param studentId the ID of the student
	 * @return the average grade formatted as a string.
	 */
	public String studentAvg(int studentId) {
		return students[studentId - OFFSET_S].avgGrades();
	}

	/**
	 * Computes the average grades of all students that took the exam for a given
	 * course.
	 * 
	 * The format is the following:
	 * {@code "The average for the course COURSE_TITLE is: COURSE_AVG"}.
	 * 
	 * If no student took the exam for that course it returns
	 * {@code "No student has taken the exam in COURSE_TITLE"}.
	 * 
	 * @param courseId course code
	 * @return the course average formatted as a string
	 */
	public String courseAvg(int courseId) {
		return courses[courseId - OFFSET_C].avgGrades();
	}

	// R6
	/**
	 * Retrieve information for the best students to award a prize.
	 * 
	 * The students' score is evaluated as the average grade of the exams they've
	 * taken.
	 * To take into account the number of exams taken and not only the grades,
	 * a special bonus is assigned on top of the average grade:
	 * the number of taken exams divided by the number of courses the student is
	 * enrolled to, multiplied by 10.
	 * The bonus is added to the exam average to compute the student score.
	 * 
	 * The method returns a string with the information about the three students
	 * with the highest score.
	 * The students appear one per row (rows are terminated by a new-line character
	 * {@code '\n'})
	 * and each one of them is formatted as:
	 * {@code "STUDENT_FIRSTNAME STUDENT_LASTNAME : SCORE"}.
	 * 
	 * @return info on the best three students.
	 */
	public String topThreeStudents() {
		Student[] activeStudents = new Student[contS];
		for (int i = 0; i < contS; i++) {
			activeStudents[i] = students[i];
		}

		Arrays.sort(activeStudents, new Comparator<Object>() {
			public int compare(Object a, Object b) {
				Student x = (Student) a;
				Student y = (Student) b;
				if (x.getPoints() < y.getPoints()) {
					return 1;
				} else if (x.getPoints() > y.getPoints()) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		StringBuffer str = new StringBuffer("");
		for (int i = 0; i < 3 && i < contS && activeStudents[i].getPoints() != 0; i++) {
			str.append(activeStudents[i].getName() + " " + activeStudents[i].getSurname() + " : "
					+ "%.1f".formatted(activeStudents[i].getPoints()) + "\n");
		}
		return str.toString();
	}

	// R7
	/**
	 * This field points to the logger for the class that can be used
	 * throughout the methods to log the activities.
	 */
	public static final Logger logger = Logger.getLogger("University");

}
