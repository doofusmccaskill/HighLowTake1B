package dale.highlow.cards;

import javax.swing.*;
import java.util.Vector;
import java.util.Collections;

/**
 *	A class which represents a general purpose HAND of playing cards.
 *	Fields stored include number of cards in a hand.
 *	public accessor methods are provided to make these values available
 *
 *	@author Dale Macdonald
 *	@version 1.0
 */
 
public class Hand
{
	private int numOfCards;
	private Vector handVect ;	//	This vector actually holds the number of cards

/**
 *	Constructs an empty hand object capable of holding any number of Card objects
 *
 */	
	public Hand ()
	{
		numOfCards = 0;
		handVect= new Vector();
	}

/**
 *	Adds a card to the hand
 * 	@param whichCard - a Card object to be added
 */	
	public void addCard (PlayingCard whichCard)
	{
		handVect.addElement(whichCard);
		numOfCards++;	
	}

/**
 *	Adds a number of cards to the hand
 * 	@param cardArray - a Card array to be added
 */	
	public void addCards (PlayingCard [] cardArray)
	{
		for(int j = 0; j < cardArray.length; j++)
		{
			if (cardArray [j] != null)
			{
				handVect.add(cardArray [j]);
				numOfCards++;	
			}
			else
				break;
		}
	}

/**
 *	Drops all cards from the hand, ie returns the hand to an empty state
 */
 	public void foldHand()
 	{
		handVect.removeAllElements(); 		
 		numOfCards = 0;
 	}

/**
 *	Returns the current number of cards in the hand
 */	
	public int getNumOfCards()
	{
		return numOfCards;	
	}
	
/**
 *	Returns (a clone of) the current handVector of the hand
 */	
	public Vector getHand()
	{
		Vector handCopyVect = (Vector)(handVect.clone() ); //To prevent access to the internals
		return handCopyVect;	
	}

/**
 *	Returns an array containing(a clone of) the current handVector Cards of the hand
 */	
	public PlayingCard[] getHandArray()
	{
		Vector handCopyVect = getHand();
		PlayingCard [] handArray = new PlayingCard [numOfCards];
		for (int j = 0; j < numOfCards; j++)
		{
			handArray[j] = (PlayingCard)handCopyVect.elementAt(j);	
		}
		return handArray;	
	}

/**
 *	Sorts the hand into logical order (AS, 10S, KH, KD... etc)
 */
	public void logicalSort()
	{	
		int sm = GeneralPlayingCard.getSortMode();
		GeneralPlayingCard.setSortMode(PlayingCard.SORT_LOGICAL_ORDER);
		Collections.sort(handVect);
		GeneralPlayingCard.setSortMode(sm);
	}

/**
 *	Sorts the hand into simple order (aces then kings etc, suit is not considered)
 */	
	public void simpleSort()
	{	
		int sm = GeneralPlayingCard.getSortMode();
		GeneralPlayingCard.setSortMode(PlayingCard.SORT_SIMPLE_ORDER);
		Collections.sort(handVect);
		GeneralPlayingCard.setSortMode(sm);
	}

/**
 *	Sorts the hand into single order (aces then kings etc, suit IS considered ... SHDC)
 */	
	public void singleSort()
	{	
		int sm = GeneralPlayingCard.getSortMode();
		GeneralPlayingCard.setSortMode(PlayingCard.SORT_SINGLE_ORDER);
		Collections.sort(handVect);
		GeneralPlayingCard.setSortMode(sm);
	}

/**
 *	Plays a card out of the hand, accordingly reducing card numOfCards and handVect
 *	@param whichCard -  is the integer index of the card in the hand
 */	
	public PlayingCard playCard(int whichCard)
	{
		PlayingCard card = (PlayingCard)handVect.elementAt(whichCard);
		handVect.removeElementAt(whichCard);
		numOfCards--;
		return card;
	}

/**
 *	Plays a card out of the hand, accordingly reducing card numOfCards and handVect
 *	@param whichCard -  is a card object referring to a card in the hand
 */	
	public void playCard(PlayingCard whichCard)
	{
		handVect.removeElement(whichCard);
		numOfCards--;
		return;
	}
		
}// end of Hand class
