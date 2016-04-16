/**
 * 
 */
package game.cards.deck;

import java.util.Collections;
import java.util.Stack;

import game.cards.DevelopmentCard;
import game.cards.configuration.CardConfiguration.StandardDevelopmentType;
import game.cards.configuration.CardConfiguration.Expansion;
import game.cards.configuration.CardConfiguration.StandardCatanCardQuantities;

/**
 * @author Sparksmith
 *
 */
public class DevelopmentDeck extends Deck {
	private int maxNumberOfCards;
	private Stack<DevelopmentCard> deck;
	
	public DevelopmentDeck(Expansion exp) {		
		super();
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
		
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		Collections.shuffle(deck);
	}
	
	/**
	 * 
	 * @return card or NULL if no cards are available
	 */
	public DevelopmentCard getCard(){
		if(deck.size()>0){
			return this.deck.pop();
		}else{
			return null;
		}
	}
	
	public int getMaxNumberOfCards(){
		return this.maxNumberOfCards;
	}
	
	public int getCurrentSize(){
		return this.deck.size();
	}
}
