package dale.highlow.game;

import dale.highlow.cards.PlayingCard;



public class HighLowPlayer implements Player {

	private String name;
	
	public HighLowPlayer(String name) {
		this.name = name;
	}
	
	@Override
	public PlayingCard cut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayingCard dealOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
}
