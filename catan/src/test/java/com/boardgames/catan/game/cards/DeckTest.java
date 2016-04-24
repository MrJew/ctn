/**
 * 
 */
package com.boardgames.catan.game.cards;

import java.util.ArrayList;

import com.boardgames.catan.game.cards.Card;
import com.boardgames.catan.game.cards.configuration.CardConfiguration.Expansion;
import com.boardgames.catan.game.cards.configuration.CardConfiguration.StandardCatanCardQuantities;
import com.boardgames.catan.game.cards.configuration.CardConfiguration.StandardResourceType;
import com.boardgames.catan.game.cards.deck.DevelopmentDeck;
import com.boardgames.catan.game.cards.deck.ResourceDeck;
import junit.framework.TestCase;

/**
 * @author Sparksmith
 *
 */
public class DeckTest extends TestCase {
	private ResourceDeck resourceDeck;
	private DevelopmentDeck developmentDeck;
	
	protected void setUp(){
		resourceDeck = new ResourceDeck(StandardResourceType.FIELDS, Expansion.STANDARD_CATAN);
		developmentDeck = new DevelopmentDeck(Expansion.STANDARD_CATAN);
	}
	
	public void testResourceCreate(){
		assertNotNull(resourceDeck);
		assertEquals(StandardCatanCardQuantities.RESOURCE_COUNT.getCardCount(), resourceDeck.getCurrentSize());
	}
	
	public void testDevelopmentCreate(){
		assertNotNull(developmentDeck);
		assertEquals(25, developmentDeck.getCurrentSize());
	}
	
	public void testDevelopmentGetCard(){
		Card testCard = developmentDeck.getCard();
		assertNotNull(testCard);
	}

	public void testDevelopmentGetRandomCard(){
		DevelopmentDeck secondDeck = new DevelopmentDeck(Expansion.STANDARD_CATAN);
		ArrayList<Card> firstDraw = new ArrayList<Card>();
		ArrayList<Card> secondDraw = new ArrayList<Card>();
		for(int i=0;i<5;i++){
			firstDraw.add(developmentDeck.getCard());
			secondDraw.add(secondDeck.getCard());
		}

		// works fine with collections so fuck you !
		assertNotSame(firstDraw, secondDraw);
	}
	
	public void testResourceGetCard(){
		Card testCard = resourceDeck.getCard();
		assertEquals(testCard.getCardName(), "FIELDS");
	}
	
	public void testResourceGet20Cards(){
		for(int i =0;i<19;i++){
			Card testCard = resourceDeck.getCard();
			if(i==20){
				assertNull(testCard);
			}else{
				assertNotNull(testCard);
			}
		}
	}
	
	public void testResourceGetXCards(){
		ArrayList<Card> deck = new ArrayList<>();
		deck = resourceDeck.getCard(17);
		assertEquals(2, resourceDeck.getCurrentSize());
		assertEquals(17, deck.size());
		assertNotSame(deck.get(1), deck.get(0));
	}
	
	public void testDevelopmentGetXCards(){
		ArrayList<Card> deck = new ArrayList<>();
		deck = developmentDeck.getCard(17);
		assertEquals(8, developmentDeck.getCurrentSize());
		assertEquals(17, deck.size());
		assertNotSame(deck.get(1), deck.get(0));
	}
	
	public void testResourceReturnXCards(){
		int size1 = resourceDeck.getCurrentSize();
		resourceDeck.getCard(2);
		resourceDeck.returnCards(2);
		int size2 = resourceDeck.getCurrentSize();
		assertEquals(size1, size2);
	}
	
	public void testDevelopmentGet20Cards(){
		for(int i =0;i<19;i++){
			Card testCard = developmentDeck.getCard();
			if(i==20){
				assertNull(testCard);
			}else{
				assertNotNull(testCard);
			}
		}
	}
	
	public void testResourceReturnCards(){
		// pull all cards
		for(int i =0;i<19;i++){
			resourceDeck.getCard();
		}
		resourceDeck.returnCard();
		assertEquals(1, resourceDeck.getCurrentSize());
	}
	
	public void testResourcePull18Return1Cards(){
		// pull 18 cards out of 19
		for(int i =0;i<18;i++){
			resourceDeck.getCard();
		}
		resourceDeck.returnCard();
		assertEquals(2, resourceDeck.getCurrentSize());
	}
}
