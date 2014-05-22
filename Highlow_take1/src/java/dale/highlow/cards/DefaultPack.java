package dale.highlow.cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import dale.highlow.cards.GeneralPlayingCard;
import dale.highlow.cards.GeneralPlayingCard.SortMode;
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

	public String [] cardNameArray ={"AS","2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", 
 			"10S", "JS", "QS", "KS" , "AH","2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H",
			"10H", "JH", "QH", "KH" , "AD","2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D",
			"10D", "JD", "QD", "KD" , "AC","2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C",
			"10C", "JC", "QC", "KC" };
	
	//TODO - try to go to PlayingCard, using wild-cards / bounds etc
	private List<GeneralPlayingCard> pack = new ArrayList<GeneralPlayingCard>();
	
	private	int numOfCards;
	
	//private Random random = new Random(System.currentTimeMillis());
	
	public DefaultPack() {
		numOfCards = cardNameArray.length;
		getSortedPack();
	}
	
	@Override
	public synchronized void  sortPack() {
		Collections.sort(pack);
	}

	@Override
	public synchronized void  reversePack() {
		Collections.reverse(pack);		
	}

	@Override
	public synchronized void  shufflePack() {
		Collections.shuffle(pack);
	}

	@Override
	public synchronized PlayingCard cutPack() {
		Random random = new Random(System.currentTimeMillis());
		return cutPack(random.nextInt(52) + 1);
	}

	@Override
	public synchronized PlayingCard cutPack(int cutpoint) {
		///System.out.println(cutpoint);
		return pack.get(cutpoint - 1); //TODO is this best based at 1?
	}

	@Override
	public PlayingCard dealCard() {
		return pack.remove(0);
	}
	
	/**
	 * This method refreshes the internal pack holding list, and builds
	 * a new one, sorted according to the Sort Type of the cards.
	 * 
	 * 
	 * @return A fresh, sorted pack
	 */
	public synchronized List<GeneralPlayingCard> getSortedPack() {
		pack.clear(); // A fresh pack
		for (String s : cardNameArray) {
			GeneralPlayingCard c = new GeneralPlayingCard(s);
			pack.add(c);
		}
		sortPack();
		numOfCards = pack.size();
		return pack;
	}
	
	@Override
	public String toString() {
		
		String str = "";
		str += ("[ ");
		for (PlayingCard card : pack) {
			str += (card.getName() + ",");
		}
		str = str.substring(0, str.length() - 1);
		str += (" ]");
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pack pack = new DefaultPack();
		System.out.println(pack.toString());
		pack.shufflePack();
		System.out.println(pack.toString());
		((DefaultPack)pack).getSortedPack();
		System.out.println(pack.toString());
		pack.reversePack();
		System.out.println(pack.toString());
		pack.shufflePack();
		System.out.println(pack.toString());
		GeneralPlayingCard.setSortMode(SortMode.SORT_POKER_ORDER);
		((DefaultPack)pack).getSortedPack();
		System.out.println(pack.toString());
	}
}
