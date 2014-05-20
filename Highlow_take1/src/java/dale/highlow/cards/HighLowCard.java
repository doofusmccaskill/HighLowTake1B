package dale.highlow.cards;

/**
 * A class which represents a specialised playing card for HiLowJack.
 * 
 * Fields stored include name, value, suit and a graphical representation of the
 * card public accessor methods are provided to make these values available
 * 
 * This class extends the general Card class and adds specialised score details
 * for HiLowJack.
 * 
 * @author Dale Macdonald
 * @version 1.1
 */
public class HighLowCard extends GeneralPlayingCard {

	/** The score a card will return in the "Game" tally of high low */
	private int score;

	/**
	 * Constructor which accepts a valid String name (eg "10S", "QH" etc)
	 * Exceptions are not handled, so ensure the name is valid! Incorrect names
	 * lead to spurious card values. Note that case is not catered for, Caps
	 * only are supported. A future version may be case-insensitive
	 * 
	 * @param name A valid card name (eg "10S", "QH" etc)
	 * 
	 */

	public HighLowCard(String name) {
		super(name);
		char first = name.charAt(0);
		score = whatScore(first);
	}

	public static void main(String[] args) {
		HighLowCard c = new HighLowCard(args[0]);
		System.out.println(c.getName());
		System.out.println(c.getSuit());
		System.out.println(c.getGraphic());
		System.out.println(c.getValue());
		System.out.println(c.getScore());

		System.out.println("\n\n" + c.toString());
	}
	
	// Accessors
	
	/**
	 * Returns the int score of the card (eg ace = 4, three = 0, ten = 10 etc)
	 */
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += " + [ Score = " + score + " ]";
		return str;
	}
	
	/*
	 * Internal methods to produce useable characteristics of Cards
	 */
	private int whatScore(char first) {
		switch (first) {
		case '1':
			return 10;
		case 'J':
			return 1;
		case 'Q':
			return 2;
		case 'K':
			return 3;
		case 'A':
			return 4;
		default:
			return 0;
		}
	}	
}
