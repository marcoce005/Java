package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.polito.oop.utils.Requirement;

import university.University;

class SimpleBaseTest {
	
	private static final int FIRST_ID = 10000;
	private static final int FIRST_CODE = 10;
	private static final String UNIVERSITY_NAME = "Politecnico di Torino";
	private University poli;

	@BeforeEach
	void setUp(){
		poli = new University(UNIVERSITY_NAME);
	}
	
	@Test @Requirement(1)
	void testR1() {
		poli.setRector("Stefano", "Corgnati");
		
		assertEquals(UNIVERSITY_NAME, poli.getName(), "Wrong university name");
		assertEquals("Stefano Corgnati", poli.getRector(), "Wrong rector");
	}
		
	@Test @Requirement(2)
	void testR2() {
		int s1 = poli.enroll("Mario","Rossi");
		int s2 = poli.enroll("Giuseppe","Verdi");
		
		assertEquals(FIRST_ID, s1, "First student id should be "+ FIRST_ID);
		assertEquals((FIRST_ID+1), s2, "Second student id should be "+ (FIRST_ID+1));
	}
		
	@Test @Requirement(3)
	void testR3() {
		int macro = poli.activate("Macro Economics", "Paul Krugman");
		int oop = poli.activate("Object Oriented Programming", "James Gosling");
		
		assertEquals(FIRST_CODE, macro, "First course id should be "+ FIRST_CODE);
		assertEquals((FIRST_CODE+1), oop, "Second course id should be "+ (FIRST_CODE+1));
	}
		
	@Test @Requirement(4)
	void testR4() {
		int s1 = poli.enroll("Mario","Rossi");
		int s2 = poli.enroll("Giuseppe","Verdi");
		int macro = poli.activate("Macro Economics", "Paul Krugman");
		int oop = poli.activate("Object Oriented Programming", "James Gosling");

		poli.register(s1, macro);
		poli.register(s2, macro);
		poli.register(s2, oop);
		
		String attendees = poli.listAttendees(macro);
		assertNotNull(attendees, "Missing attendees list");
		assertTrue(attendees.contains("Rossi"));
		assertTrue(attendees.contains("Verdi"), "Missing student Verdi");
		
		String plan = poli.studyPlan(s2);
		assertNotNull(plan, "Missing study plan");
		assertTrue(plan.contains("Object"), "Missing OOP course");
	}
}
