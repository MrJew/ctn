package game.cards;

import game.cards.configuration.CardConfiguration.DevelopmentType;

public class DevelopmentCard extends Card{
	private String action;
	private DevelopmentType type;
	
	public DevelopmentCard(String name, DevelopmentType type, String action) {
		super(name);
		this.action = action;
		this.type = type;
	}
	
	public String getAction(){
		return this.action;
	}
	
	public String getImageLocation(){
		return this.type.getImageLocation();
	}
	
}
