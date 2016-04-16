/**
 * 
 */
package game.cards.deck;

import java.util.Stack;

import game.cards.Card;

/**
 * @author Sparksmith
 *
 */
public abstract class Deck {
	protected Stack<Card> deck;
	private int initialSize;
	
	public Deck(){
		deck = new Stack<Card>();
	}
	
	public int getInitialSize(){
		return this.initialSize;
	}
	
	public int currentSize(){
		return this.deck.size();
	}
}
