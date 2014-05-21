/**
 * 
 */
package dale.highlow.cards;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test to check out the behaviour of A default pack
 * 
 * @author dale.macdonald
 *
 */
public class DefaultPackTest {

	private Pack pack;
	


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pack = new DefaultPack();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link DefaultPack#sortPack()}.
	 */
	@Test
	public void testSortPack() {
//		pack.sortPack();
//		PlayingCard c1 = pack.dealCard();
//		PlayingCard c2 = pack.dealCard();
//		assertEquals(c1.getName(),"AS");
//		assertEquals(c2.getName(),"JS");
	}

	/**
	 * Test method for {@link DefaultPack#shufflePack()}.
	 */
	@Test
	public void testShufflePack() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link DefaultPack#cutPack()}.
	 */
	@Test
	public void testCutPack() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link DefaultPack#cutPack(int)}.
	 */
	@Test
	public void testCutPackInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link DefaultPack#dealCard()}.
	 */
	@Test
	public void testDealCard() {
		PlayingCard c1 = pack.dealCard();
		PlayingCard c2 = pack.dealCard();
		assertEquals(c1.getName(),"AS");
		assertEquals(c2.getName(),"JS");
	}

	/**
	 * Test method for {@link DefaultPack#getSortedPack()}.
	 */
	@Test
	public void testGetSortedPack() {
		List<GeneralPlayingCard> list = ((DefaultPack)pack).getSortedPack();
		PlayingCard c1 = list.get(0);
		PlayingCard c2 = list.get(10);
		assertEquals(c1.getName(),"AS");
		assertEquals(c2.getName(),"JS");
		
		//fail("Not yet implemented");
	}

}
