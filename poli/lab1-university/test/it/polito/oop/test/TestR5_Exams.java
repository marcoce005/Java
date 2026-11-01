package it.polito.oop.test;

import static it.polito.oop.utils.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;
import it.polito.oop.utils.Requirement;

import university.University;

@Requirement(5)
public class TestR5_Exams {

	private University poli;
	
	@BeforeEach
	void setUp() {

		Logger ul = Logger.getLogger("University");		
		ul.setLevel(Level.OFF);
		
		poli = new University("Politecnico di Torino");
		poli.setRector("Guido", "Saracco");
		
		poli.enroll("Mario","Rossi");
		poli.enroll("Francesca","Verdi");
		poli.enroll("Filippo","Neri");
		poli.enroll("Laura","Bianchi");
		
		
		poli.activate("Macro Economics", "Paul Krugman");
		poli.activate("Object Oriented Programming", "James Gosling");
		poli.activate("Virology", "Roberto Burioni");
		poli.activate("Social media management", "Elon Musk");
		
		poli.register(10000, 10);
		poli.register(10001, 10);
		poli.register(10001, 11);
		poli.register(10001, 12);
		poli.register(10002, 11);
		poli.register(10003, 10);
		poli.register(10003, 11);
		
	}

	@Test
	void testStudentAverageOne() {
		final int studentId = 10000;
		poli.exam(studentId, 10, 27);
		
		String avg = poli.studentAvg(studentId);
		
		assertContained(String.valueOf(studentId), avg, "Missing student id in average");
		assertContained(":", avg, "Missing average");
		assertContained("27", avg, "Wrong average");
	}

	@Test
	void testStudentAverageMany() {
		final int studentId = 10001;
		poli.exam(studentId, 10, 27);
		poli.exam(studentId, 11, 28);
		poli.exam(studentId, 12, 29);
		
		String avg = poli.studentAvg(studentId);
		
		assertContained(String.valueOf(studentId), avg, "Missing student id in average");
		assertContained(":", avg, "Missing average");
		assertContained("28", avg, "Wrong average");
	}

	@Test
	void testStudentAverageNone() {
		final int studentId = 10001;
		
		String avg = poli.studentAvg(studentId);
		
		assertContained(String.valueOf(studentId), avg, "Missing student id in average");
		assertContained("hasn't taken any exams", avg, "Wrong average");
	}


	@Test
	void testCourseAverageOne() {
		final int studentId = 10000;
		int courseId = 10;
		poli.exam(studentId, courseId, 27);
		
		String avg = poli.courseAvg(courseId);
		
		assertContained("Macro Economics", avg, "Missing course name in average" );
		assertContained(":", avg, "Missing average");
		assertContained("27", avg, "Wrong average");
	}
	
	@Test
	void testCourseAverageMany() {
		final int studentId = 10001;
		int courseId = 10;
		poli.exam(studentId, courseId, 27);
		poli.exam(studentId, courseId+1, 27);
		poli.exam(studentId+1, courseId+1, 28);
		poli.exam(studentId+2, courseId, 29);
		
		String avg = poli.courseAvg(courseId);
		
		assertContained("Macro Economics", avg, "Missing course name in average");
		assertContained(":", avg, "Missing average");
		assertContained("28", avg, "Wrong average");
	}

	@Test
	void testCourseAverageNone() {
		int courseId = 10;

		String avg = poli.courseAvg(courseId);
		
		assertContained("Macro Economics", avg, "Missing course id in average");
		assertContained("No student has taken", avg, "Wrong message");
	}
}
