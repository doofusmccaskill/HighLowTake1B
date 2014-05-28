package dale.highlow.cards;
import dale.highlow.cards.PlayingCard;

/**
 * General Interface representing a Card Player. Subclasses could represent High Low players,
 * Rummy players etc
 * 
 * @author dale.macdonald
 *
 */
public interface Player {

	/** Cut a single card view it, but don't remove it from the pack */
	public PlayingCard cut();
	
	/** Deal out one card from the pack */
	public PlayingCard dealOne();
	
	/** Return the player's name */
	public String getName();
}
