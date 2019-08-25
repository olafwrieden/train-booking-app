package bookingApplication;

/**
 * Information relating to a Train Journey.
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public class TrainJourney {

	// Train Journey Properties
	private String startCity;
	private String destinationCity;
	private String departureTime;
	private int journeyID;
	private FloorGrid floorGrid;
	private TrainOperator operator;

	/**
	 * Constructs a Train Journey with given details.
	 * 
	 * @param start         The departure city where the journey begins
	 * @param destination   The destination city where the journey ends
	 * @param departureTime The time at which the train leaves the departure city
	 * @param journeyID     The ID that identifies this journey
	 * @param floorGrid     The type (layout) of the passenger carriage
	 */
	public TrainJourney(String start, String destination, String departureTime, int journeyID, FloorGrid floorGrid) {
		this.startCity = start;
		this.destinationCity = destination;
		this.departureTime = departureTime;
		this.journeyID = journeyID;
		this.floorGrid = floorGrid;
	}

	/**
	 * @return This Train Journey's Details
	 */
	@Override
	public String toString() {
		return (journeyID + " from " + startCity + " to " + destinationCity + ", departing at " + departureTime);
	}

	/**
	 * @return The departure city of this train journey
	 */
	public String getStartCity() {
		return startCity;
	}

	/**
	 * @return The destination city of this train journey
	 */
	public String getDestinationCity() {
		return destinationCity;
	}

	/**
	 * @return The time at which this train leaves the departure city
	 */
	public String getDepartureTime() {
		return departureTime;
	}

	/**
	 * @return The unique ID that identifies a train journey
	 */
	public int getJourneyID() {
		return journeyID;
	}

	/**
	 * @return The floor grid that belongs to this train
	 */
	public FloorGrid getFloorGrid() {
		return floorGrid;
	}

	/**
	 * @return The name of the operator of this train
	 */
	public TrainOperator getOperator() {
		return operator;
	}

	/**
	 * Sets the name of this train operator.
	 * 
	 * @param operator The name of the operator to store
	 */
	public void setOperator(TrainOperator operator) {
		this.operator = operator;
	}
}
