package game.cards;

import game.cards.configuration.CardConfiguration.StandardDevelopmentType;

public class DevelopmentCard extends Card{
	private String action;
	private StandardDevelopmentType type;
	
	public DevelopmentCard(StandardDevelopmentType type) {
		super(type.getName());
		this.action = this.type.getDescription();
		this.type = type;
	}
	
	public String getAction(){
		return this.action;
	}
	
	public String getImageLocation(){
		return this.type.getImageLocation();
	}
	
}
