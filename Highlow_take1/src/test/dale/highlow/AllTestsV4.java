package dale.highlow;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import dale.highlow.cards.CardTest;
import dale.highlow.cards.HighLowCardTest;

/**
 * A TestSuite which will carry out all JUnit 4.x tests
 * out in sequence.
 * 
 * Note that v3 test will happily run under this
 * 
 * @author dale
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CardTest.class,
	HighLowCardTest.class
	
	
	//XTestv4.class,
	//yTestv3.class
})
public class AllTestsV4 {

}
