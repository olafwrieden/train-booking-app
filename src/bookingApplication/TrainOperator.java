package bookingApplication;

import bookingApplication.Seat.SEAT_TYPE;

/**
 * A Train Operator (company).
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public abstract class TrainOperator {

	// Train Operator Name
	private String companyName;

	/**
	 * Method to book a seat in first class.
	 * 
	 * @param journey  The selected journey on which to book a seat
	 * @param seatType The selected type of seat to book.
	 * @return A seat based on operator's booking policies, or null if booking
	 *         cannot be made.
	 */
	abstract Seat bookFirstClass(TrainJourney journey, SEAT_TYPE seatType);

	/**
	 * Method to book a seat in economy class.
	 * 
	 * @param journey  The selected journey on which to book a seat
	 * @param seatType The selected type of seat to book.
	 * @return A seat based on operator's booking policies, or null if booking
	 *         cannot be made.
	 */
	abstract Seat bookEconomy(TrainJourney journey, SEAT_TYPE seatType);

	/**
	 * @return The name of the Train Operator
	 */
	public String getTrainOperator() {
		return companyName;
	}

	/**
	 * Sets the company name of the Train Operator.
	 * 
	 * @param name The name of the train operator
	 */
	public void setTrainOperator(String name) {
		this.companyName = name;
	}

	/**
	 * @return A welcome message for the Train Operator's Booking System
	 */
	@Override
	public String toString() {
		String operatorWelcomeBanner = "\n---------------------------------------\n";
		operatorWelcomeBanner += "Welcome to the " + this.getTrainOperator() + " booking system!";
		operatorWelcomeBanner += "\n---------------------------------------";
		return operatorWelcomeBanner;
	}
}
