/**
 * 
 */
package game.cards.deck;

import java.util.Stack;

import game.cards.ResourceCard;
import game.cards.configuration.CardConfiguration.Expansion;
import game.cards.configuration.CardConfiguration.ResourceType;
import game.cards.configuration.CardConfiguration.StandardCatanCardQuantities;

/**
 * Create a deck filled with the same type of cards, with the amount based on the current edition of catan
 * @author Sparksmith
 *
 */
public class ResourceDeck extends Deck {
	private ResourceCard card;
	private int maxNumberOfCards;
	private Stack<ResourceCard> deck;
	
	public ResourceDeck(ResourceCard card, ResourceType type, Expansion exp) {
		this.card = card;
		
		switch (exp){
		case STANDARD_CATAN:
			this.maxNumberOfCards = StandardCatanCardQuantities.RESOURCE_COUNT.getCardCount();
			break;
		}
		
		deck = new Stack<ResourceCard>();
		for(int i=0;i<this.maxNumberOfCards;i++){
			deck.push(new ResourceCard(this.card));
		}
	}
	
	public void returnCard(){
		if(this.deck.size()+1 > this.maxNumberOfCards){
			//error
		}else{
			this.deck.push(new ResourceCard(this.card));
		}
	}
	
	public ResourceCard getCard(){
		return this.deck.pop();
	}
	
}
