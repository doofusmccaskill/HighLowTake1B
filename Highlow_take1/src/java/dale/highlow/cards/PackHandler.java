package dale.highlow.cards;

import java.awt.*;
import javax.swing.*;
//import highlow.utils.DaleFrame;
import java.util.Random;
import java.util.Vector;
import java.util.Collections;
import java.util.Date;

/**
 *	This class has methods to shuffle and deal a supplied pack of cards
 *	The 'pack' of cards is supplied in a vector
 */
 
public class PackHandler
{	
	private String [] cardNameArray ={"AS","2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", 
	 			"10S", "JS", "QS", "KS" , "AH","2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H",
				"10H", "JH", "QH", "KH" , "AD","2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D",
				"10D", "JD", "QD", "KD" , "AC","2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C",
				"10C", "JC", "QC", "KC" };

	private Vector packV;
	private	int numOfCards;

	public PackHandler() 
	{
		packV = new Vector();
		numOfCards = cardNameArray.length;
		getSortedPack();
					
	}
	
	public Vector getPack()
	{
		return packV;
	}
	
	public Vector getSortedPack()
	{
		packV.removeAllElements();	// A fresh pack
		for( int j = 0; j < numOfCards; j++)
		{
			PlayingCard c = new GeneralPlayingCard(cardNameArray[j]);
			packV.add(c);
		}
		return packV;
	}
	
 	public Vector shufflePack(Vector pack)
 	{
 		Random rnd = new Random();
 		Collections.shuffle(pack, rnd);
 		return pack;
 	}
 	
 	public Vector shufflePack()
 	{
 		shufflePack(packV);
 		return packV;
 	}
 	
 	public Vector cutPack(Vector pack)
 	{
 		Random rnd = new Random ( (new Date() ).getTime() );
 		int randomNum = rnd.nextInt(pack.size() - 1); 	// generates a num tween 0 & 50 inclusive - cant cut whole pack!
 		Vector remainder = new Vector();
 		for (int j= randomNum; j<52; j++)
 			remainder.add(pack.elementAt(j) );
 		return remainder; 
 	}
 	
 	public Hand[] dealPack(int numHands, int numCards)
 	{
 		int index = 0;
 		Hand [] handArray = new Hand [numHands];
 		for (int j = 0; j < numHands; j++)
 			handArray[j] = new Hand();			// create initial hands
 			
 		for (int i = 0; i < numCards; i++)
 		{
 			for (int j = 0; j < numHands; j++)
 			{
 				handArray[j].addCard((PlayingCard)(packV.elementAt(index)));
 				index++;
 			}	
 		}
 		return handArray;
 	}
 	
 	public String getTopCard() 
 	{
 		return null;
 	}
 	
 	public void printPackCodes()
 	{
 		for( int j = 0; j < numOfCards; j++)	
 			System.out.print(packV.elementAt(j) + "  " );
 	}	
 	
 	
 	
}
