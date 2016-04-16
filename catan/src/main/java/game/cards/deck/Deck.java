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
	private Stack<Card> deck;
	private int initialSize;
	
	public int getInitialSize(){
		return this.initialSize;
	}
	
	public int currentSize(){
		return this.deck.size();
	}
}
