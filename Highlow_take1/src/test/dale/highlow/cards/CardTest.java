package dale.highlow.cards;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dale.highlow.cards.GeneralPlayingCard;
import dale.highlow.cards.GeneralPlayingCard.SortMode;

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

	private GeneralPlayingCard c1;
	private GeneralPlayingCard c2;
	private GeneralPlayingCard c3;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		c1 = new GeneralPlayingCard("AC");
		c2 = new GeneralPlayingCard("JD");
		c3 = new GeneralPlayingCard("6S");
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
		c1 = new GeneralPlayingCard("AS");
		c2 = new GeneralPlayingCard("KS");
		c3 = new GeneralPlayingCard("AH");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		
		c1 = new GeneralPlayingCard("10S");
		c2 = new GeneralPlayingCard("KH");
		c3 = new GeneralPlayingCard("AC");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		
		c1 = new GeneralPlayingCard("8D");
		c2 = new GeneralPlayingCard("KC");
		c3 = new GeneralPlayingCard("2C");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		
	}
	
	public void testSimpleSortOrder() {
		GeneralPlayingCard.setSortMode(GeneralPlayingCard.SortMode.SORT_SIMPLE_ORDER);
		c1 = new GeneralPlayingCard("AS");
		c2 = new GeneralPlayingCard("KS");
		c3 = new GeneralPlayingCard("AH");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) == 0);
		assertTrue(c2.compareTo(c3) < 0);
		
		c1 = new GeneralPlayingCard("10S");
		c2 = new GeneralPlayingCard("KH");
		c3 = new GeneralPlayingCard("AC");
		
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c1.compareTo(c3) < 0);
		assertTrue(c2.compareTo(c3) < 0);
		
		c1 = new GeneralPlayingCard("8D");
		c2 = new GeneralPlayingCard("KC");
		c3 = new GeneralPlayingCard("2C");
		
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		GeneralPlayingCard.setSortMode(SortMode.SORT_LOGICAL_ORDER);
	}
	
	public void testPokerSortOrder() {
		GeneralPlayingCard.setSortMode(SortMode.SORT_POKER_ORDER);
		c1 = new GeneralPlayingCard("AS");
		c2 = new GeneralPlayingCard("KS");
		c3 = new GeneralPlayingCard("AH");
		
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) < 0);
		
		c1 = new GeneralPlayingCard("10S");
		c2 = new GeneralPlayingCard("KH");
		c3 = new GeneralPlayingCard("AC");
		
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c1.compareTo(c3) < 0);
		assertTrue(c2.compareTo(c3) < 0);
		
		c1 = new GeneralPlayingCard("8D");
		c2 = new GeneralPlayingCard("KC");
		c3 = new GeneralPlayingCard("2C");
		
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c1.compareTo(c3) > 0);
		assertTrue(c2.compareTo(c3) > 0);
		GeneralPlayingCard.setSortMode(SortMode.SORT_LOGICAL_ORDER);
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
