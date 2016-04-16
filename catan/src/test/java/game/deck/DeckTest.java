/**
 * 
 */
package game.deck;

import game.cards.configuration.CardConfiguration.Expansion;
import game.cards.configuration.CardConfiguration.StandardCatanCardQuantities;
import game.cards.configuration.CardConfiguration.StandardResourceType;
import game.cards.deck.Deck;
import game.cards.deck.ResourceDeck;
import game.cards.stacks.StandardCatanDeck;
import junit.framework.TestCase;

/**
 * @author Sparksmith
 *
 */
public class DeckTest extends TestCase {
	
	protected void setUp(){
		
	}
	
	public void testResourceCreate(){
		ResourceDeck resourceDeck = new ResourceDeck(StandardResourceType.FIELDS, Expansion.STANDARD_CATAN);
		assertNotNull(resourceDeck);
		assertEquals(StandardCatanCardQuantities.RESOURCE_COUNT.getCardCount(), resourceDeck.currentSize());
	}
}
