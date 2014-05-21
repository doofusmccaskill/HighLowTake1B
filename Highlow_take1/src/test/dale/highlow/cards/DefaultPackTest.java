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
		pack.sortPack();
		PlayingCard c1 = pack.dealCard();
		assertEquals("2C", c1.getName());
		
		c1 = pack.dealCard();
		assertEquals("3C", c1.getName());
		
		c1 = pack.dealCard();
		assertEquals("4C", c1.getName());
	}
	
	/**
	 * Test method for {@link DefaultPack#reversePack()}.
	 */
	@Test
	public void testReversePack() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link DefaultPack#shufflePack()}.
	 */
	@Test
	public void testShufflePack() {
		pack.sortPack();
		PlayingCard c1 = pack.cutPack(5);
		assertEquals("6C", c1.getName());
		pack.shufflePack();
		c1 = pack.cutPack(5);
		assertFalse(c1.getName().equals("6C"));
	}

	/**
	 * Test method for {@link DefaultPack#cutPack()}.
	 */
	@Test
	public void testCutPack() {
		pack.shufflePack();
		PlayingCard c1 = pack.cutPack();
		PlayingCard c2 = pack.cutPack();
		assertFalse(c1.equals(c2));
	}

	/**
	 * Test method for {@link DefaultPack#cutPack(int)}.
	 */
	@Test
	public void testCutPackInt() {
		PlayingCard c1 = pack.cutPack(14);
		assertEquals("2D", c1.getName());
		c1 = pack.cutPack(51);
		assertEquals("KS", c1.getName());
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
		assertEquals("2C", c1.getName());
		assertEquals("QC", c2.getName());
		
		//fail("Not yet implemented");
	}

}
