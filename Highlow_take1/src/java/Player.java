import dale.highlow.cards.PlayingCard;

/**
 * General Interface representing a Card Player. Subclasses could represent High Low players,
 * Rummy players etc
 * 
 * @author dale.macdonald
 *
 */
public interface Player {

	public PlayingCard cut();
	
	public PlayingCard dealOne();
}
