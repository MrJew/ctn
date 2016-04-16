package game.cards;

import game.cards.configuration.CardConfiguration.ResourceType;

public class ResourceCard extends Card{
	private ResourceType type;
	
	public ResourceCard(String name, ResourceType type) {
		super(name);
		this.type = type;
	}

	public ResourceCard(ResourceCard card) {
		super(card.getCardName());
		this.type = card.getType();
	}
	
	public ResourceType getType(){
		return this.type;
	}
}
