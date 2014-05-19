package dale.highlow;

import dale.highlow.cards.CardTest;
import dale.highlow.cards.HighLowCardTest;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * A TestSuite which will carry out all JUnit 3.x tests
 * out in sequence.
 * 
 * @author dale
 *
 */
public class AllTestsV3 extends TestSuite {
	
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(CardTest.class);
		//suite.addTestSuite(HighLowCardTest.class); - it's a v4 test!!
		//suite.addTestSuite(/*testClass*/);
		
		return suite;  // TODO - I was accidentally returning suite() which was legal and recursed indefinitely
	}

}
