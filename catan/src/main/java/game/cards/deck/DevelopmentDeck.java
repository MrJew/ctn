/**
 * 
 */
package game.cards.deck;

import java.util.Stack;

import game.cards.DevelopmentCard;
import game.cards.ResourceCard;
import game.cards.configuration.CardConfiguration.Expansion;
import game.cards.configuration.CardConfiguration.ResourceType;
import game.cards.configuration.CardConfiguration.StandardCatanCardQuantities;

/**
 * @author Sparksmith
 *
 */
public class DevelopmentDeck extends Deck {
	private DevelopmentCard card;
	private int maxNumberOfCards;
	private Stack<DevelopmentCard> deck;
	
	public DevelopmentDeck(Expansion exp) {
		this.card = card;
		
		switch (exp){
		case STANDARD_CATAN:
			this.maxNumberOfCards = StandardCatanCardQuantities.MONOPOLY_COUNT.getCardCount()+
			StandardCatanCardQuantities.ROAD_BUILDING_COUNT.getCardCount()+
			StandardCatanCardQuantities.SOLDIER_COUNT.getCardCount()+
			StandardCatanCardQuantities.VICTORY_POINTS_COUNT.getCardCount()+
			StandardCatanCardQuantities.YEAR_OF_PLENTY_COUNT.getCardCount();
			break;
		}
		
		deck = new Stack<DevelopmentCard>();
	}
	
	public DevelopmentCard getCard(){
		return this.deck.pop();
	}
}
