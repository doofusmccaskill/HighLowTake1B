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
	
		String [] cardNameArray ={"AS","2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", 
	 			"10S", "JS", "QS", "KS" , "AH","2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H",
				"10H", "JH", "QH", "KH" , "AD","2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D",
				"10D", "JD", "QD", "KD" , "AC","2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C",
				"10C", "JC", "QC", "KC" };
		
		Pack comparePack = new DefaultPack();
		int[] spread = new int[pack.getNumOfCards()];
		for (int i = 0; i < 500000; i++) {
			PlayingCard pc = pack.cutPack();
			int j;
			for (j = 0; j < 52; j++) {
				if (pc.getName().equals(cardNameArray[j])) break;
			}
			spread[j]++;
		}
		for (int i : spread)
			if (i == 0) fail("Not all cards get returned from cut");
		
		int stdDev = (int)standardDeviation(spread);
		assertTrue(stdDev < 250);
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
	
	/**
	 * Test method for {@link DefaultPack#getNumOfCards()}.
	 */
	@Test
	public void testGetNumOfCards() {
		assertEquals(52, pack.getNumOfCards());
	}

	/**
	 * Method I wrote to calculate the standard deviation
	 */
	//TODO Extract this into a general utilities class
	public double standardDeviation(int [] values) {
		
		int mean = 0;
		for (int i : values) mean += i;
		mean /= values.length;
		
		double[] squares = new double[values.length];
		for (int i = 0; i < squares.length; i++) {
			squares[i] = Math.pow((values[i] - mean), 2);
		}
		
		double variance = 0.0;
		for (double d : squares) variance += d;
		variance /= squares.length;
		
		return Math.sqrt(variance);
	}
}
