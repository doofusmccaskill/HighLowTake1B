package dale.highlow.cards;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * A class which represents a general purpose playing card. Fields stored
 * include name, value, suit and a graphical representation of the card.
 * 
 * Public accessor methods are provided to make these values available.
 * 
 * Cards are immutable once constructed, though the static sort mode may be
 * changed, which will then apply to all card sorts henceforth. (Note, this
 * behaviour COULD have been implemented by preferring a Comparator<Card>, but I
 * like the closed nature)
 * 
 * This version is updated with Java 5 features.
 * 
 * TODO: Implement a DetailedName property, with ResourceBundle for I18n TODO:
 * ALso, a constructor that allows for alternative Icon settings
 * 
 * @author Dale Macdonald
 * @version 1.1
 */
public class Card implements Comparable<Card>, PlayingCard {

	/** Sort mode (Default LOGICAL) */
	private static SortMode sortMode = SortMode.SORT_LOGICAL_ORDER;

	/** Card Short name */
	private String name;

	/** Card Suit */
	private String suit;

	/** Card Value */
	private int value;

	/** Card Associated Graphic */
	private Icon graphic;
	
	/** Card Score - May differ from value, depending on the game */
	private int score;

	// Simplest possibility
	// private enum SortMode {
	//
	// 	SORT_LOGICAL_ORDER, SORT_SIMPLE_ORDER, SORT_POKER_ORDER;
	// }

	
	// With user-defined enumerated values (ordinal)
	/**
	 * 
	 * @author dale.macdonald
	 * 
	 *         <li>{@link #SORT_LOGICAL_ORDER} The standard sort mode : (AS, KS,
	 *         QS, ... 2C)</li> <li>{@link #SORT_SIMPLE_ORDER} The simple sort
	 *         mode : (All aces equal, kings</li> <li>{@link #SORT_POKER_ORDER}
	 *         The poker-value sort mode : (AS,AH,AD,AC,KS,KH,...,2C)</li>
	 * 
	 */
	public enum SortMode {

		SORT_LOGICAL_ORDER(0), // The standard sort mode : (AS, KS, QS, ... 2C)
		SORT_SIMPLE_ORDER(1), // The simple sort mode : (All aces equal, kings
								// equal etc)
		SORT_POKER_ORDER(2); // The poker-value sort mode :
								// (AS,AH,AD,AC,KS,KH,...,2C)

		private int ord;

		SortMode(int ord) {
			this.ord = ord;
		}

		public int getUserDefinedOrdinal() {
			return ord;
		}
	}

	/**
	 * Constructor which accepts a valid String name (eg "10S", "QH" etc)
	 * Exceptions are not handled, so ensure the name is valid! Incorrect names
	 * lead to spurious card values.
	 * 
	 * @param name
	 *            - the card name
	 * 
	 */
	public Card(String name) {
		name = name.toUpperCase();
		this.name = name;
		graphic = new ImageIcon("./graphics/" + name + ".gif"); // TODO - need
																// to use proper
																// method for
																// jar inclusion
																// here

		char last = name.charAt(name.length() - 1);
		suit = whatSuit(last);

		char first = name.charAt(0);
		value = whatValue(first);
	}

	/**
	 * Constructor which accepts a valid String name (eg "10S", "QH" etc) and
	 * additionally an SortMode to set up the default sort mode.
	 * 
	 * Incorrect names lead to spurious card values.
	 * 
	 * @param name
	 *            - the card name
	 * @param sort
	 *            - sets a specific sort mode to be the default
	 */
	public Card(String name, SortMode sort) {
		this(name);
		sortMode = sort;
	}

	// Accessors

	/* (non-Javadoc)
	 * @see dale.highlow.cards.PlayingCard#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see dale.highlow.cards.PlayingCard#getSuit()
	 */

	@Override
	public String getSuit() {
		return suit;
	}

	/* (non-Javadoc)
	 * @see dale.highlow.cards.PlayingCard#getGraphic()
	 */

	@Override
	public Icon getGraphic() {
		return graphic;
	}

	/* (non-Javadoc)
	 * @see dale.highlow.cards.PlayingCard#getValue()
	 */

	@Override
	public int getValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see dale.highlow.cards.PlayingCard#getScore()
	 */
	@Override
	public int getScore() {
		return score;
	}

	/**
	 * Accessor method to check current sort mode.
	 */

	public static SortMode getSortMode() {
		return Card.sortMode;
	}

	// Mutators

	/**
	 * Mutator method to change current sort mode. This mode will be the default
	 * until explicitly changed. The method returns an int corresponding to the
	 * new mode. The method is synchronised to prevent other players changing
	 * sortmode during a sort
	 * 
	 * @param mode
	 *            - The new mode
	 * @return - The new Sort Mode
	 */

	public static SortMode setSortMode(SortMode mode) // TODO synchronized?
	{
		Card.sortMode = mode;
		return sortMode;
	}

	/**
	 * Provides (natural) sort order depending on mode.
	 */
	// TODO - Check this carefully
	@Override
	public int compareTo(Card c) {

		switch (sortMode) {
		case SORT_LOGICAL_ORDER:
			// return (16 * (suit.charAt(0) - 0x42) + value) - (16 *
			// (c.suit.charAt(0) - 0x42) + c.value);
			return (16 * (suit.charAt(0) - c.suit.charAt(0)) + value - c.value); // The
																					// above,
																					// simplified
																					// mathematically
		case SORT_SIMPLE_ORDER:
			return (value - c.value);
		case SORT_POKER_ORDER:
			// System.out.println(16 * (value - c.value) + (suit.charAt(0) -
			// c.suit.charAt(0)));
			return 16 * (value - c.value) + (suit.charAt(0) - c.suit.charAt(0));
		default:
			return (16 * (suit.charAt(0) - c.suit.charAt(0)) + value - c.value); // Logical
																					// is
																					// default
																					// if
																					// nothing
																					// is
																					// set
		}
	}

	/**
	 * Overrides the standard toString method
	 */

	public String toString() {
		return ("[ Name: " + name + ", Value: " + value + ", Suit: " + suit + " ]");
	}

	/*
	 * Internal methods to produce useable characteristics of Cards
	 */

	private String whatSuit(char last) {
		switch (last) {
		case 'S':
			return "Spades";
		case 'H':
			return "Hearts";
		case 'D':
			return "Diamonds";
		case 'C':
			return "Clubs";
		default:
			return null;
		}

	}

	private int whatValue(char first) {
		switch (first) {
		case '1':
			return 10;
		case 'J':
			return 11;
		case 'Q':
			return 12;
		case 'K':
			return 13;
		case 'A':
			return 14;
		default:
			return (first - 0x30); // Crafty
		}

	}

	public static void main(String[] args) {
		for (SortMode mode : SortMode.values()) {
			System.out.println(mode + " : " + mode.ordinal() + " -->  "
					+ mode.getUserDefinedOrdinal());
		}

		Card c = new Card("8H");
		System.out.println(c.name);
		System.out.println(c.suit);
		System.out.println(c.graphic);
		System.out.println(c.value);

		System.out.println("\n\n" + c.toString());

		c = new Card("AS");
		System.out.println(c.name);
		System.out.println(c.suit);
		System.out.println(c.graphic);
		System.out.println(c.value);

		System.out.println("\n\n" + c.toString());

	}

}
