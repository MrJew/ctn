/**
 * 
 */
package game.cards.configuration;

/**
 * @author Sparksmith
 *
 */
public final class CardConfiguration {
	/**
	 * TODO: move to a better place
	 * @author Sparksmith
	 *
	 */
	public enum Expansion {
		STANDARD_CATAN,
	}
	/**
	 * Number of cards in play during a standard catan game
	 * @author Sparksmith
	 *
	 */
	public enum StandardCatanCardQuantities{
		SOLDIER_COUNT (14),
		VICTORY_POINTS_COUNT (5),
		MONOPOLY_COUNT (2),
		ROAD_BUILDING_COUNT (2),
		YEAR_OF_PLENTY_COUNT (2),
		RESOURCE_COUNT (19);
		
		private final int count;
		StandardCatanCardQuantities(int count){
			this.count = count;
		}
		
		public int getCardCount(){
			return this.count;
		}
	}
	
	/**
	 * Definition of a Resource Card Type and image location
	 * @author Sparksmith
	 *
	 */
	public enum StandardResourceType {
		HILL ("/this/is/the/location/hill.png"),
		FOREST ("/this/is/the/location/forest.png"),
		MOUNTAIN ("/this/is/the/location/mountain.png"),
		FIELDS ("/this/is/the/location/field.png"),
		PASTURE ("/this/is/the/location/pasture.png"),
		DESRT ("/this/is/the/location/desert.png"),
		PORT ("/this/is/the/location/port.png"),
		SEA ("/this/is/the/location/sea.png");
		
		private final String location;
		StandardResourceType(String location){
			this.location = location;
		}
		
		public String getImageLocation(){
			return this.location;
		}
	}
	/**
	 * Definition of a Development Card Type and image location
	 * @author Sparksmith
	 */
	public enum StandardDevelopmentType{
		SOLDIER ("Soldier", "/this/is/the/location/soldier.png","Move the pirate to any hex on the board (except desert). Steal 1 resrource card from the owner of a city/village adjacent to that hex." ),
		POINT ("Victory Point", "/this/is/the/location/point.png", "+1 Point. Reveal this card if with it you reach the number of points required for victory."),
		MONOPOLY ("Monopoly", "/this/is/the/location/monopoly.png", "When you play this card announce one type of resource. All other players must give you all their resource cards of that type."),
		ROAD ("Road Building", "/this/is/the/location/road.png", "Place 2 roads as if you had built them."),
		PLENTY ("Year of Plenty", "/this/is/the/location/plenty.png", "Take any 2 resource cards from the bank and add them to your hand. They can be two different resource or two of the same resource. They may immediately be used to build.");
		
		private String location;
		private String description;
		private String name;
		StandardDevelopmentType(String name, String location, String description){
			this.location = location;
			this.name = name;
			this.description = description;
		}
		public String getDescription(){
			return this.description;
		}
		public String getImageLocation(){
			return this.location;
		}
		public String getName(){
			return this.name;
		}
		
	}
}
