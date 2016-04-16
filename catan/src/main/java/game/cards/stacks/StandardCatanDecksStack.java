/**
 * 
 */
package game.cards.stacks;

import java.util.HashMap;

import game.cards.configuration.CardConfiguration.Expansion;
import game.cards.deck.Deck;
import game.cards.deck.DevelopmentDeck;

/**
 * @author Sparksmith
 *
 */
public class StandardCatanDecksStack {
	private HashMap<String, Deck> resourceDecks;
	private DevelopmentDeck developmentDeck;
	
	public StandardCatanDecksStack(){
		resourceDecks = new HashMap<String, Deck>();
		developmentDeck = new DevelopmentDeck(Expansion.STANDARD_CATAN);
	}
}
