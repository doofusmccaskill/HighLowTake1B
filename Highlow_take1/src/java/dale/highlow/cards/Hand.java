package dale.highlow.cards;

import java.util.List;

/**
 * A holder for cards, which can be subclassed for the particular game in question.
 * 
 * @author dale.macdonald
 *
 */
public interface Hand {

	public PlayingCard playCard(int cardnum);
	
	public int howManyCards();
}
