package bookingApplication;

/**
 * An individual Seat in the Floor Grid.
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public class Seat {

	// The type of available seats
	public enum SEAT_TYPE {
		WINDOW, MIDDLE, AISLE
	};

	// Seat Properties
	private boolean isBooked;
	private boolean isFirstClass;
	private SEAT_TYPE type;
	private SeatPosition seatPosition;

	/**
	 * Constructs a Seat with its properties.
	 * 
	 * @param type         The type of this Seat
	 * @param isFirstClass Whether this Seat is in first class or not
	 * @param position     This Seat's position in the Floor Grid
	 */
	public Seat(SEAT_TYPE type, boolean isFirstClass, SeatPosition position) {
		this.type = type;
		this.isFirstClass = isFirstClass;
		this.seatPosition = position;
	}

	/**
	 * @return The visual representation of a seat in its floor grid position
	 */
	@Override
	public String toString() {
		if (isFirstClass) {
			return ("[" + type.toString().charAt(0) + (isBooked ? " X " : " _ ") + "]");
		}
		return ("[" + Character.toLowerCase(type.toString().charAt(0)) + (isBooked ? " X " : " _ ") + "]");
	}

	/**
	 * @return The seat's text description (used for booking confirmation)
	 */
	public String seatDescription() {
		String output = "---------------- SEAT RESERVATION ----------------\n";
		output += (isFirstClass ? "First" : "Economy") + " class " + type.toString() + " seat at: " + seatPosition
				+ (isBooked ? " has " : " has not ") + "been reserved.\n";
		return output;
	}

	/**
	 * @return True if seat is booked, else False
	 */
	public boolean isBooked() {
		return isBooked;
	}

	/**
	 * Books / Reserves the seat.
	 * 
	 * @param booked Whether the seat is booked or not (if True book the seat, if
	 *               false then cancel seat's existing booking to free it up)
	 */
	public void setBooked(boolean booked) {
		this.isBooked = booked;
	}

	/**
	 * @return True if seat is in first class, False if in economy class
	 */
	public boolean isFirstClass() {
		return isFirstClass;
	}

	/**
	 * Assigns the seat to first class
	 * 
	 * @param firstClass Whether the seat is in first class or not (if True seat is
	 *                   in first class, if false seat is in economy class)
	 */
	public void setFirstClass(boolean firstClass) {
		this.isFirstClass = firstClass;
	}

	/**
	 * @return The type of seat (e.g. WINDOW)
	 */
	public SEAT_TYPE getType() {
		return type;
	}

	/**
	 * Assigns a seat type to the seat, based on SEAT_TYPE enumeration.
	 * 
	 * @param type
	 */
	public void setType(SEAT_TYPE type) {
		this.type = type;
	}

	/**
	 * @return The position of the seat
	 */
	public SeatPosition getSeatPosition() {
		return seatPosition;
	}
}
