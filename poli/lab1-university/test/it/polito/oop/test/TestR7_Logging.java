package it.polito.oop.test;

import static org.junit.jupiter.api.Assertions.*;
import static it.polito.oop.utils.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import it.polito.oop.utils.Requirement;

import university.University;

@Requirement(7)
class TestR7_Logging {
	private University poli;
	
	private String logLastMessage;
	private int logCount;

	@BeforeEach
	void setUp() {
		poli = new University("Politecnico di Torino");
		poli.setRector("Guido", "Saracco");
		
		University.logger.setFilter( rec -> {
			logLastMessage = rec.getMessage();
			logCount++;
			return true;
		});
		logLastMessage = "";
		logCount = 0;
		University.logger.setLevel(Level.ALL);
	}
	
	@AfterEach
	void tearDown() {
		University.logger.setFilter(null);
	}
	
	@Test
	void testLogging() {		
		poli.enroll("Mario","Rossi");	
		assertEquals(1,logCount, "No log record for enroll");
		assertContained("Rossi",logLastMessage, "Wrong log message");
		
		poli.activate("Object Oriented Programming", "James Gosling");
		assertEquals(2,logCount, "No log record for activate");
		assertContained("Object Oriented",logLastMessage, "Wrong log message");
		
		poli.register(10000,10);
		assertEquals(3,logCount, "No log record for register");
		assertContained("10000",logLastMessage, "Wrong log message");
	}
}
