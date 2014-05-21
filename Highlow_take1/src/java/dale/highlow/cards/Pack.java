package dale.highlow.cards;

/**
 * An interface which represents a general purpose pack of playing card. 
 * 
 * @author Dale Macdonald
 * @version 1.0
 */
public interface Pack {
	
	/**
	 * Sort the pack according to the sort-order of the supplied
	 * cards.
	 * 
	 * <B> Ensure that you don't make a pack of cards which have different 
	 * sort types, or sorting will be erratic</B>
	 */
	public abstract void sortPack();
	
	/**
	 * Shuffle the pack into a nice random order.
	 * 
	 */
	public abstract void shufflePack();
	
	/**
	 * Cut the pack randomly and return the card
	 * 
	 * @return The card that is cut.
	 */
	public abstract PlayingCard cutPack();
	
	/**
	 * Cut the pack at the point specified and return the card
	 * 
	 * @param the point within the pack at which to cut.
	 * @return The card that is cut.
	 */
	public abstract PlayingCard cutPack(int cutpoint);
	

	/**
	 * Deal a single card from the top of the pack.
	 * 
	 * @return The dealt card
	 */
	public abstract PlayingCard dealCard();
	
	/**
	 * Deal a card to each player.
	 * 
	 * @param players
	 * @return
	 */
	/// - We need a player class public abstract PlayingCard dealHand(int players);
	
	/**
	 * Deal
	 * @param players
	 * @param cards
	 * @return
	 */
	///public abstract PlayingCard dealHand(int players, int cards);
	
	
	
}
