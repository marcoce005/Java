package it.polito.oop.test;

import static org.junit.jupiter.api.Assertions.*;
import static it.polito.oop.utils.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.polito.oop.utils.Requirement;

import university.University;

class TestR1_4 {
	
	static final String UNIVERSITY_NAME = "Politecnico di Torino";
	private University poli;

	@BeforeEach
    void setUp() { // FIXTURE, it is executed before every test to
				   // the name 'setUp' is convention deriving from JUnit 3
		poli = new University(UNIVERSITY_NAME);
		poli.setRector("Guido", "Saracco");
	}

	@Test @Requirement(1)
	void testNameRector(){
		String name = poli.getName();
		String rector = poli.getRector();
		
		assertNotNull(name, "Missing university name");
		
		assertEquals(UNIVERSITY_NAME,		  // expected value
					 name,	  // actual value
					 "Wrong university name"); // msg in case of failure

		assertNotNull(rector, "Missing rector name");
		
		assertContained("Saracco",rector, "Wrong rector name");
	}
	
	@Test @Requirement(2)
	void testEnroll(){
		int s1 = poli.enroll("Mario","Rossi");
		int s2 = poli.enroll("Francesca","Verdi");
		
		assertEquals(10000,s1,"Wrong id number for first enrolled student");
		assertEquals(10001,s2,"Wrong id number for second enrolled student");
	}

	@Test @Requirement(2)
	void testStudents(){				
		int s1 = poli.enroll("Vilfredo","Pareto");
		int s2 = poli.enroll("Galileo","Ferraris");
		int s3 = poli.enroll("Leo", "Da Vinci");
	
		String ss1 = poli.student(s1);
		assertNotNull(ss1, "Missing student info");
		assertContained("Pareto",ss1);

		String ss2 = poli.student(s2);
		assertNotNull(ss2, "Missing student info");
		assertContained("Galileo",ss2);

		String ss3 = poli.student(s3);
		assertNotNull( ss3, "Missing student info");
		assertContained("Vinci",ss3);
	}

	@Test @Requirement(3)
	void testCourseActivation(){
		int macro = poli.activate("Macro Economics", "Paul Krugman");
		int oop = poli.activate("Object Oriented Programming", "James Gosling");
		
		assertEquals(10,macro, "Wrong id number for first activated course");
		assertEquals(11,oop, "Wrong id number for second activated course");		
	}
	
	@Test @Requirement(3)
	void testCourses(){
		int macro = poli.activate("Macro Economics", "Paul Krugman");
		int oop = poli.activate("Object Oriented Programming", "James Gosling");
		
		assertNotNull(poli.course(macro), "Missing course description");
		assertContained("Macro Economics", poli.course(macro), "Wrong description of course");
		assertContained("Oriented", poli.course(oop), "Wrong description of course");
		assertContained("James", poli.course(oop), "Wrong description of course");
	}

	@Test @Requirement(4)
	void testAttendees(){
		poli.enroll("Mario","Rossi");
		poli.enroll("Francesca","Verdi");
		
		poli.activate("Macro Economics", "Paul Krugman");
		poli.activate("Object Oriented Programming", "James Gosling");
		
		poli.register(10000, 10);
		poli.register(10001, 10);
		poli.register(10001, 11);
		
		String attendees = poli.listAttendees(10);
		assertNotNull(attendees, "Missing attendees list");
		assertCountLines(attendees, 2, "Wrong number of attendees for course 10");

		attendees = poli.listAttendees(11);
		assertCountLines(attendees, 1, "Wrong number of attendees for course 11");
	}

	@Test @Requirement(4)
	void testStudyPlan(){
		poli.enroll("Mario","Rossi");
		poli.enroll("Francesca","Verdi");
		
		poli.activate("Macro Economics", "Paul Krugman");
		poli.activate("Object Oriented Programming", "James Gosling");
		
		poli.register(10000, 10);
		poli.register(10001, 10);
		poli.register(10001, 11);
		
		String plan = poli.studyPlan(10001);
		assertNotNull(plan, "Missing study plan");
		assertCountLines(plan, 2, "Wrong number of courses for student 10001");

		plan = poli.studyPlan(10000);
		assertCountLines(plan, 1, "Wrong number of courses for student 10000");
	}
}
