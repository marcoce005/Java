package it.polito.oop.test;

import static org.junit.jupiter.api.Assertions.*;
import static it.polito.oop.utils.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;
import it.polito.oop.utils.Requirement;

import university.University;

@Requirement(6)
class TestR6_Awards {
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
		
		poli.register(10000, 10);
		poli.register(10001, 10);
		poli.register(10001, 11);
		poli.register(10001, 12);
		poli.register(10002, 11);
		poli.register(10003, 10);
		poli.register(10003, 11);
		
		//			10		11		12
		// 10000     X
		// 10001	X		X		X
		// 10002			X
		// 10003	X		X
		
	}
	

	@Test
	void testTopSimilar() {
		final int studentId = 10001;
		int courseId = 10;
		poli.exam(studentId, courseId, 27);
		poli.exam(studentId, courseId+1, 27);
		poli.exam(studentId+1, courseId+1, 28);
		poli.exam(studentId+2, courseId, 29);
		poli.exam(studentId+2, courseId+1, 20);	

		String top = poli.topThreeStudents();
		
		assertNotNull(top, "Missing top three students");
		
		String[] rank = top.split("\n");
		
		assertEquals(3,rank.length, "Expected three students");
		
		assertContained("Neri",rank[0], "Wrong top student");
		assertContained("38",rank[0], "Wrong top student score");
	}

	@Test
	void testTopBonus() {
		poli.exam(10000, 10, 25);
		poli.exam(10001, 10, 26);
		poli.exam(10001, 11, 28);
		poli.exam(10003, 10, 26);
		poli.exam(10003, 11, 26);

		String top = poli.topThreeStudents();
		
		assertNotNull(top, "Missing top three students");
		
		String[] rank = top.split("\n");
		
		assertEquals(3, rank.length, "Expected three students");
		
		assertContained("Bianchi",rank[0], "Wrong top student");
		assertContained("36",rank[0], "Wrong top student score");
	}

	@Test
	void testTopTwo() {
		poli.exam(10000, 10, 27);
		poli.exam(10002, 11, 26);

		String top = poli.topThreeStudents();
		
		assertNotNull(top, "Missing top three students");
		
		String[] rank = top.split("\n");
		
		assertEquals(2,rank.length, "Expected just two students");
		
		assertContained("Rossi",rank[0], "Wrong top student");
		assertContained("37",rank[0], "Wrong top student score");
	}
}
