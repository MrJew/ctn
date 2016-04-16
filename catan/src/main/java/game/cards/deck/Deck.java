/**
 * 
 */
package game.cards.deck;

import java.util.Stack;

import game.cards.Card;
import game.cards.ResourceCard;

/**
 * @author Sparksmith
 *
 */
public abstract class Deck {
	protected Stack<Card> deck;
	protected int initialSize;
	
	public Deck(){
		deck = new Stack<Card>();
	}

	public int getInitialSize(){
		return this.initialSize;
	}
	
	public int getCurrentSize(){
		return this.deck.size();
	}
	
	public Card getCard(){
		if(deck.size()>0){
			return this.deck.pop();
		}else{
			return null;
		}
	}
}
