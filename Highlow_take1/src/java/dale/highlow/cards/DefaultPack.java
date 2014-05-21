package dale.highlow.cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import dale.highlow.cards.GeneralPlayingCard;
import dale.highlow.cards.Pack;
import dale.highlow.cards.PlayingCard;

/**
 * A default implementation of a pack (of cards) This is fine for highlow, 
 * but could be subclassed if necessary, 2 packs for blackjack or include jokers
 * for rummy.
 *  
 * @author dale.macdonald
 *
 */
public class DefaultPack implements Pack {

	private String [] cardNameArray ={"AS","2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", 
 			"10S", "JS", "QS", "KS" , "AH","2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H",
			"10H", "JH", "QH", "KH" , "AD","2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D",
			"10D", "JD", "QD", "KD" , "AC","2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C",
			"10C", "JC", "QC", "KC" };
	
	//TODO - try to go to PlayingCard, using wild-cards / bounds etc
	private List<GeneralPlayingCard> pack = new ArrayList<GeneralPlayingCard>();
	
	private	int numOfCards;
	
	public DefaultPack() {
		numOfCards = cardNameArray.length;
		getSortedPack();
	}
	
	@Override
	public void sortPack() {
		Collections.sort(pack);

	}

	@Override
	public void shufflePack() {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayingCard cutPack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayingCard cutPack(int cutpoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayingCard dealCard() {
		return pack.get(0);
	}
	
	/**
	 * This method refreshes the internal pack holding list, and builds
	 * a new one, sorted according to the Sort Type of the cards.
	 * 
	 * 
	 * @return A fresh, sorted pack
	 */
	public List<GeneralPlayingCard> getSortedPack() {
		pack.clear(); // A fresh pack
		for (String s : cardNameArray) {
			GeneralPlayingCard c = new GeneralPlayingCard(s);
			pack.add(c);
		}
		//TODO - sort the pack
		return pack;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
