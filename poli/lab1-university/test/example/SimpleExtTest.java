package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.logging.Level;
import it.polito.oop.utils.Requirement;

import university.University;

/**
 * Test for extended requirements
 */
class SimpleExtTest {	
	private static final String VERDI = "Verdi";
    private static final String OBJECT_ORIENTED_PROGRAMMING = "Object Oriented Programming";
    private static final String MACRO_ECONOMICS = "Macro Economics";

    private University poli;
    private int s2;
    private int macro;

    @BeforeEach
    void setUp(){
        poli = new University("PoliTo");
		int s1 = poli.enroll("Mario","Rossi");
		s2 = poli.enroll("Giuseppe",VERDI);
		macro = poli.activate(MACRO_ECONOMICS, "Paul Krugman");
		int oop = poli.activate(OBJECT_ORIENTED_PROGRAMMING, "James Gosling");
		poli.register(s1, macro);
		poli.register(s2, macro);
		poli.register(s2, oop);

		poli.exam(s1, macro, 27);
		poli.exam(s2, macro, 30);
		poli.exam(s2, oop, 28);
    }

    @Test @Requirement(5)
	void testR5() {
		assertEquals("Student %d : %.1f".formatted(s2, 29.0), poli.studentAvg(s2), "Wrong student average");		
		assertEquals("The average for the course %s is: %.1f".formatted(MACRO_ECONOMICS, 28.5), poli.courseAvg(macro), "Wrong course average");		
	}

    @Test @Requirement(6)
    void testR6() {
        String best = poli.topThreeStudents();

        assertNotNull(best, "Missing top students");
        assertTrue(best.contains("%s : %.1f".formatted(VERDI, 39.0)), "Missing best student Verdi");
    }

    private String lastMessage;
    private int logCount;
    @Test  @Requirement(7)
    void testR7() {
        try{
            University.logger.setFilter( r -> {
                lastMessage = r.getMessage();
                logCount++;
                return true;
            });
            lastMessage = "";
            logCount = 0;
            University.logger.setLevel(Level.ALL);

            poli.enroll("Jane","White");

            assertEquals(1, logCount, "No log message was generated for new enrollment");
            assertTrue(lastMessage.contains("White"), "Message does not include student name");
            
            poli.activate("Software Engineering", "Grady Booch");

            assertEquals(2, logCount, "No log message was generated for new course activation");
            assertTrue(lastMessage.contains("Engineering"), "Message does not include course title");
        }finally{
            University.logger.setFilter(null);
        }
    }
}

