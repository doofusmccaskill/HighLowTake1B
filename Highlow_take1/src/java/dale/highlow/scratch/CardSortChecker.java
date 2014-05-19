package dale.highlow.scratch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dale.highlow.cards.Card;
import dale.highlow.cards.HighLowCard;
import dale.highlow.cards.Card.SortMode;

/**
 * A scratch class to build a few packs of cards, and then set sort orders and make
 * sure it's all good.
 * 
 * @author dale.macdonald
 *
 */
public class CardSortChecker {
	
	private static String [] cardNameArray ={"AS","2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", 
 			"10S", "JS", "QS", "KS" , "AH","2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H",
			"10H", "JH", "QH", "KH" , "AD","2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D",
			"10D", "JD", "QD", "KD" , "AC","2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C",
			"10C", "JC", "QC", "KC" };
	
	public static void main(String[] args) {
		
		List<Card> pack = new ArrayList<Card>();
		
		for (String s : cardNameArray) {
			pack.add(new HighLowCard(s));
		}
		
		printPack(pack);
		Collections.sort(pack);
		printPack(pack);
		
		Card.setSortMode(SortMode.SORT_SIMPLE_ORDER);
		Collections.sort(pack);
		printPack(pack);
		
		Card.setSortMode(SortMode.SORT_POKER_ORDER);
		Collections.sort(pack);
		printPack(pack);
		
		Card.setSortMode(SortMode.SORT_LOGICAL_ORDER);
		Collections.sort(pack);
		printPack(pack);
		
		Card.setSortMode(SortMode.SORT_LOGICAL_ORDER);
		Collections.reverse(pack);
		printPack(pack);
		
	}
	
	static void printPack(List<Card> aPack) {
		System.out.print("[ ");
		for (Card card : aPack) {
			System.out.print(card.getName() + ", ");
		}
		System.out.println("\b\b ]");
	}
}
