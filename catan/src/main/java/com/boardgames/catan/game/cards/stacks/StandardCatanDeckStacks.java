/**
 * 
 */
package com.boardgames.catan.game.cards.stacks;

import java.util.ArrayList;
import java.util.HashMap;

import com.boardgames.catan.game.cards.Card;
import com.boardgames.catan.game.cards.configuration.CardConfiguration.Expansion;
import com.boardgames.catan.game.cards.configuration.CardConfiguration.StandardResourceType;
import com.boardgames.catan.game.cards.deck.Deck;
import com.boardgames.catan.game.cards.deck.DevelopmentDeck;
import com.boardgames.catan.game.cards.deck.ResourceDeck;

/**
 * @author Sparksmith
 *
 */
public class StandardCatanDeckStacks {
	private HashMap<StandardResourceType, Deck> resourceDecks;
	private DevelopmentDeck developmentDeck;
	
	public StandardCatanDeckStacks(){
		resourceDecks = new HashMap<StandardResourceType, Deck>();
		developmentDeck = new DevelopmentDeck(Expansion.STANDARD_CATAN);
		
		this.setupResourceDecks();
	}

	private void setupResourceDecks() {
		// card types
		this.resourceDecks.put(StandardResourceType.FIELDS, new ResourceDeck(StandardResourceType.FIELDS, Expansion.STANDARD_CATAN));
		this.resourceDecks.put(StandardResourceType.FOREST, new ResourceDeck(StandardResourceType.FOREST, Expansion.STANDARD_CATAN));
		this.resourceDecks.put(StandardResourceType.HILL, new ResourceDeck(StandardResourceType.HILL, Expansion.STANDARD_CATAN));
		this.resourceDecks.put(StandardResourceType.MOUNTAIN, new ResourceDeck(StandardResourceType.MOUNTAIN, Expansion.STANDARD_CATAN));
		this.resourceDecks.put(StandardResourceType.PASTURE, new ResourceDeck(StandardResourceType.PASTURE, Expansion.STANDARD_CATAN));
	}
	
	public Card getCardOfResourceType(StandardResourceType type){
		return this.resourceDecks.get(type).getCard();
	}
	
	public ArrayList<Card> getMultipleCardsOfResourceType(StandardResourceType type, int count){
		return this.resourceDecks.get(type).getCard(count);
	}
	
	public void returnCardOfResourceType(StandardResourceType type){
		((ResourceDeck) this.resourceDecks.get(type)).returnCard();
	}
	
	public void returnMultipleCardsOfResourceType(StandardResourceType type, int count){
		((ResourceDeck) this.resourceDecks.get(type)).returnCards(count);
	}
	
	public Card getDevelopmentCard(){
		return this.developmentDeck.getCard();
	}
	
	public ArrayList<Card> getMultipleDevelopmentCards(int count){
		return this.developmentDeck.getCard(count);
	}
	
	public int checkCardsLeftOfType(StandardResourceType type){
		return this.resourceDecks.get(type).getCurrentSize();
	}
	
}
