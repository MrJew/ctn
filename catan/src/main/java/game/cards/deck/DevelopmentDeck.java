/**
 * 
 */
package game.cards.deck;

import java.util.Collections;
import java.util.Stack;

import game.cards.Card;
import game.cards.DevelopmentCard;
import game.cards.configuration.CardConfiguration.StandardDevelopmentType;
import game.cards.configuration.CardConfiguration.Expansion;
import game.cards.configuration.CardConfiguration.StandardCatanCardQuantities;

/**
 * @author Sparksmith
 *
 */
public class DevelopmentDeck extends Deck {
	private Expansion expansion;
	
	public DevelopmentDeck(Expansion exp) {		
		super();
		this.expansion = exp;
		
		this.setMaxCards();
		this.deck = this.setStandardDeck();
		this.juggleTheDeck();
	}
	/**
	 * make sure - make 99% sure its shuffled
	 */
	private void juggleTheDeck(){
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		Collections.shuffle(deck);
	}
	/**
	 * set the max number in the deck
	 */
	private void setMaxCards(){
		switch (this.expansion){
			case STANDARD_CATAN:
				this.initialSize = StandardCatanCardQuantities.MONOPOLY_COUNT.getCardCount()+
				StandardCatanCardQuantities.ROAD_BUILDING_COUNT.getCardCount()+
				StandardCatanCardQuantities.SOLDIER_COUNT.getCardCount()+
				StandardCatanCardQuantities.VICTORY_POINTS_COUNT.getCardCount()+
				StandardCatanCardQuantities.YEAR_OF_PLENTY_COUNT.getCardCount();
				break;
		}
	}
	/**
	 * set the deck based on the cards in the expansion
	 * @return
	 */
	private Stack<Card> setStandardDeck(){
		for(int i=0;i<StandardCatanCardQuantities.MONOPOLY_COUNT.getCardCount();i++){
			deck.add(new DevelopmentCard(StandardDevelopmentType.MONOPOLY));
		}
		for(int i=0;i<StandardCatanCardQuantities.ROAD_BUILDING_COUNT.getCardCount();i++){
			deck.add(new DevelopmentCard(StandardDevelopmentType.ROAD));
		}
		for(int i=0;i<StandardCatanCardQuantities.SOLDIER_COUNT.getCardCount();i++){
			deck.add(new DevelopmentCard(StandardDevelopmentType.SOLDIER));
		}
		for(int i=0;i<StandardCatanCardQuantities.VICTORY_POINTS_COUNT.getCardCount();i++){
			deck.add(new DevelopmentCard(StandardDevelopmentType.POINT));
		}
		for(int i=0;i<StandardCatanCardQuantities.YEAR_OF_PLENTY_COUNT.getCardCount();i++){
			deck.add(new DevelopmentCard(StandardDevelopmentType.PLENTY));
		}
		return deck;
	}
	/**
	 * get the remaining cards in the deck
	 * @return
	 */
	public int getCurrentSize(){
		return this.deck.size();
	}
}
