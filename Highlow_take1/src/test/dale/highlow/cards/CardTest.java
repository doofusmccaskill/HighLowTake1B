package dale.highlow.cards;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import junit.framework.TestCase;

/**
 * A Unit test to check out that Card objects behave as they should.
 * 
 * This is based on version 3 of JUnit
 * 
 * @author dale
 *
 */
public class CardTest extends TestCase {

	private Card c1;
	private Card c2;
	private Card c3;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		c1 = new Card("AC");
		c2 = new Card("JD");
		c3 = new Card("6S");
	}
	
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		c1 = null;
		c2 = null;
		c3 = null;
	}
	
	public void testNames() {
		assertEquals("AC", c1.getName());
		assertEquals("JD", c2.getName());
		assertEquals("6S", c3.getName());
	}
	
	public void testSuits() {
		assertEquals("Clubs", c1.getSuit());
		assertEquals("Diamonds", c2.getSuit());
		assertEquals("Spades", c3.getSuit());
	}
	
	public void testValues() {
		assertEquals(14, c1.getValue());
		assertEquals(11, c2.getValue());
		assertEquals(6, c3.getValue());
	}
	
	public void testGraphics() {
		assertNotNull(c1.getGraphic());
		assertNotNull(c2.getGraphic());
		assertNotNull(c3.getGraphic());
	}
	
	public void testLogicalSortOrder() {
		c1 = new Card("AS");
		c2 = new Card("KS");
		c3 = new Card("AH");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		
		c1 = new Card("10S");
		c2 = new Card("KH");
		c3 = new Card("AC");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		
		c1 = new Card("8D");
		c2 = new Card("KC");
		c3 = new Card("2C");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		
	}
	
	public void testSimpleSortOrder() {
		Card.setSortMode(Card.SortMode.SORT_SIMPLE_ORDER);
		c1 = new Card("AS");
		c2 = new Card("KS");
		c3 = new Card("AH");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) == 0);
		assertTrue(c2.compareTo(c3) < 0);
		
		c1 = new Card("10S");
		c2 = new Card("KH");
		c3 = new Card("AC");
		
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c1.compareTo(c3) < 0);
		assertTrue(c2.compareTo(c3) < 0);
		
		c1 = new Card("8D");
		c2 = new Card("KC");
		c3 = new Card("2C");
		
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		Card.setSortMode(Card.SortMode.SORT_LOGICAL_ORDER);
	}
	
	public void testPokerSortOrder() {
		Card.setSortMode(Card.SortMode.SORT_POKER_ORDER);
		c1 = new Card("AS");
		c2 = new Card("KS");
		c3 = new Card("AH");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) < 0);
		
		c1 = new Card("10S");
		c2 = new Card("KH");
		c3 = new Card("AC");
		
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c1.compareTo(c3) < 0);
		assertTrue(c2.compareTo(c3) < 0);
		
		c1 = new Card("8D");
		c2 = new Card("KC");
		c3 = new Card("2C");
		
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		Card.setSortMode(Card.SortMode.SORT_LOGICAL_ORDER);
	}
	
	public void testIcon() {
		try {
			displayGraphics();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void displayGraphics() throws InterruptedException {
		JDialog dialog = new JDialog((new JFrame()), "Card Viewer", false);
		dialog.getContentPane().add(new JLabel(c1.getName(), c1.getGraphic(), SwingConstants.LEFT));
		dialog.pack();
		dialog.setVisible(true);
		Thread.sleep(2000);
		
		dialog.getContentPane().removeAll();
		dialog.getContentPane().add(new JLabel(c2.getName(), c2.getGraphic(), SwingConstants.LEFT));
		//dialog.repaint();
		dialog.revalidate();
		Thread.sleep(2000);
		
		dialog.getContentPane().removeAll();
		dialog.getContentPane().add(new JLabel(c3.getName(), c3.getGraphic(), SwingConstants.LEFT));
		dialog.revalidate();
		Thread.sleep(3000);
	}
	
//	private void displayGraphics() throws InterruptedException {
//		JDialog dialog = new JDialog((new JFrame()), "Card Viewer", false);
//		dialog.getContentPane().add(new JLabel(c1.getName(), c1.getGraphic(), SwingConstants.LEFT));
//		dialog.pack();
//		dialog.setVisible(true);
//		Thread.sleep(2000);
//		JPanel panel = new JPanel();
//		panel.add(new JLabel(c2.getName(), c2.getGraphic(), SwingConstants.LEFT));
////		dialog.setContentPane(panel);
////		dialog.repaint();
//		
//		JDialog dialog2 = new JDialog((new JFrame()), "Card Viewer", false);
//		dialog2.getContentPane().add(new JLabel(c2.getName(), c2.getGraphic(), SwingConstants.LEFT));
//		dialog2.pack();
//		dialog2.setVisible(true);
//		Thread.sleep(200000);
//	}
}
