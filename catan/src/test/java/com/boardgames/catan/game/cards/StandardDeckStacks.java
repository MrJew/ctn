/**
 * 
 */
package com.boardgames.catan.game.cards;

import java.util.ArrayList;

import com.boardgames.catan.game.cards.configuration.CardConfiguration.StandardResourceType;
import com.boardgames.catan.game.cards.stacks.StandardCatanDeckStacks;
import junit.framework.TestCase;

/**
 * @author Sparksmith
 *
 */
public class StandardDeckStacks extends TestCase {
	private StandardCatanDeckStacks decks;
	
	protected void setUp(){
		decks = new StandardCatanDeckStacks();
	}
	
	public void testInit(){
		assertNotNull(decks);
	}
	
	public void testGetResourceCard(){
		Card fieldCard = decks.getCardOfResourceType(StandardResourceType.FIELDS);
		Card forestCard = decks.getCardOfResourceType(StandardResourceType.FOREST);
		Card hillCard = decks.getCardOfResourceType(StandardResourceType.HILL);
		Card mountainCard = decks.getCardOfResourceType(StandardResourceType.MOUNTAIN);
		Card pastureCard = decks.getCardOfResourceType(StandardResourceType.PASTURE);
		
		assertEquals(StandardResourceType.FIELDS.name(), fieldCard.getCardName());
		assertEquals(StandardResourceType.FOREST.name(), forestCard.getCardName());
		assertEquals(StandardResourceType.HILL.name(), hillCard.getCardName());
		assertEquals(StandardResourceType.MOUNTAIN.name(), mountainCard.getCardName());
		assertEquals(StandardResourceType.PASTURE.name(), pastureCard.getCardName());
	}
	
	public void testGettingMultipleResourceCards(){
		ArrayList<Card> fieldCard = decks.getMultipleCardsOfResourceType(StandardResourceType.FIELDS, 2);
		ArrayList<Card> forestCard = decks.getMultipleCardsOfResourceType(StandardResourceType.FOREST, 2);
		ArrayList<Card> hillCard = decks.getMultipleCardsOfResourceType(StandardResourceType.HILL, 2);
		ArrayList<Card> mountainCard = decks.getMultipleCardsOfResourceType(StandardResourceType.MOUNTAIN, 2);
		ArrayList<Card> pastureCard = decks.getMultipleCardsOfResourceType(StandardResourceType.PASTURE, 2);
		
		assertEquals(2, fieldCard.size());
		assertEquals(2, forestCard.size());
		assertEquals(2, hillCard.size());
		assertEquals(2, mountainCard.size());
		assertEquals(2, pastureCard.size());
	}
	
	public void testReturningMultipleResourceCards(){
		decks.getMultipleCardsOfResourceType(StandardResourceType.FIELDS, 2);
		decks.getMultipleCardsOfResourceType(StandardResourceType.FOREST, 2);
		decks.getMultipleCardsOfResourceType(StandardResourceType.HILL, 2);
		decks.getMultipleCardsOfResourceType(StandardResourceType.MOUNTAIN, 2);
		decks.getMultipleCardsOfResourceType(StandardResourceType.PASTURE, 2);
		
		decks.returnMultipleCardsOfResourceType(StandardResourceType.FIELDS, 2);
		decks.returnMultipleCardsOfResourceType(StandardResourceType.FOREST, 2);
		decks.returnMultipleCardsOfResourceType(StandardResourceType.HILL, 2);
		decks.returnMultipleCardsOfResourceType(StandardResourceType.MOUNTAIN, 2);
		decks.returnMultipleCardsOfResourceType(StandardResourceType.PASTURE, 2);
		
		assertEquals(19, decks.checkCardsLeftOfType(StandardResourceType.FIELDS));
		assertEquals(19, decks.checkCardsLeftOfType(StandardResourceType.FOREST));
		assertEquals(19, decks.checkCardsLeftOfType(StandardResourceType.HILL));
		assertEquals(19, decks.checkCardsLeftOfType(StandardResourceType.MOUNTAIN));
		assertEquals(19, decks.checkCardsLeftOfType(StandardResourceType.PASTURE));
	}
}
