package com.boardgames.catan.game.cards;


public abstract class Card {
	private String name; 
	
	public Card(String name){
		this.name = name;
	}
	
	public String getCardName(){
		return this.name;
	}
}
