/**
 * 
 */
package game.cards.deck;

import java.util.ArrayList;
import java.util.Stack;

import game.cards.Card;

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
	
	public ArrayList<Card> getCard(int count){
		ArrayList<Card> result =  new ArrayList<Card>();
		
		for(int i=0;i<count;i++){
			result.add(this.getCard());
			if( result.get(result.size()-1) == null ){
				result.remove(result.size());
				return result;
			}
		}
		return result;
	}
}
