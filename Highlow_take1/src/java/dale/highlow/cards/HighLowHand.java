package dale.highlow.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighLowHand implements Hand {

	List<PlayingCard> cardsL = new ArrayList<PlayingCard>(7);
	
	public HighLowHand() {
		
	}
	
	@Override
	public PlayingCard playCard(int cardnum) {
		return cardsL.remove(cardnum);
	}

	@Override
	public int howManyCards() {
		return cardsL.size();
	}
	
	public String toString() {
		String str = "[ ";
		for (PlayingCard pc : cardsL) {
			str += pc.getName() + ", ";
		}
		str += " ]";
		return str;
	}

	public static void main(String[] args) {
		HighLowHand hand = new HighLowHand();
		Pack pack = DefaultPack.getInstance();
		pack.shufflePack();
		for (int i = 0; i< 7; i++)
			hand.cardsL.add(pack.dealCard());
		Collections.sort(hand.cardsL);
		Collections.reverse(hand.cardsL);
		System.out.println(hand.toString());
		hand.playCard(0);
		System.out.println(hand.toString());
		hand.playCard(0);
		System.out.println(hand.toString());
	}
}
