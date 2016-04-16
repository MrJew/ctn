package game.cards;

import game.cards.configuration.CardConfiguration.StandardResourceType;

public class ResourceCard extends Card{
	private StandardResourceType type;
	
	public ResourceCard(StandardResourceType type) {
		super(type.name());
		this.type = type;
	}

	public ResourceCard(ResourceCard card) {
		super(card.getCardName());
		this.type = card.getType();
	}
	
	public StandardResourceType getType(){
		return this.type;
	}
}
