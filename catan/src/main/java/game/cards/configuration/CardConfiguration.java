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
	public enum ResourceType {
		HILL ("/this/is/the/location/hill.png"),
		FOREST ("/this/is/the/location/forest.png"),
		MOUNTAIN ("/this/is/the/location/mountain.png"),
		FIELDS ("/this/is/the/location/field.png"),
		PASTURE ("/this/is/the/location/pasture.png"),
		DESRT ("/this/is/the/location/desert.png"),
		PORT ("/this/is/the/location/port.png"),
		SEA ("/this/is/the/location/sea.png");
		
		private final String location;
		ResourceType(String location){
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
	public enum DevelopmentType{
		SOLDIER ("/this/is/the/location/soldier.png"),
		POINT ("/this/is/the/location/point.png"),
		MONOPOLY ("/this/is/the/location/monopoly.png"),
		ROAD ("/this/is/the/location/road.png"),
		PLENTY ("/this/is/the/location/plenty.png");
		
		private String location;
		DevelopmentType(String location){
			this.location = location;
		}
		
		public String getImageLocation(){
			return this.location;
		}
		
	}
}
