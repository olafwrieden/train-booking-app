package bookingApplication;

import bookingApplication.Seat.SEAT_TYPE;

/**
 * The TrainWay Train Operator, with its own booking policies.
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public class TrainWay extends TrainOperator {

	/**
	 * Constructs a Train Operator
	 */
	public TrainWay() {
		this.setTrainOperator("TrainWay");
	}

	// Implementation of Abstract Methods
	@Override
	Seat bookFirstClass(TrainJourney journey, SEAT_TYPE seatType) {
		if (journey.getFloorGrid().queryAvailableFirstClassSeat(seatType) != null) {
			// Return requested seat
			return journey.getFloorGrid().queryAvailableFirstClassSeat(seatType);
		} else {
			for (int i = 0; i < SEAT_TYPE.values().length; i++) {
				if (journey.getFloorGrid().queryAvailableFirstClassSeat(SEAT_TYPE.values()[i]) != null) {
					// Book any seat in first class (as per policy)
					return journey.getFloorGrid().queryAvailableFirstClassSeat(SEAT_TYPE.values()[i]);
				}
			}

			if (journey.getFloorGrid().queryAvailableFirstClassSeat(SEAT_TYPE.WINDOW) != null) {
				// Book any seat in first class (as per policy)
				return journey.getFloorGrid().queryAvailableFirstClassSeat(SEAT_TYPE.WINDOW);
			} else {
				if (journey.getFloorGrid().queryAvailableEconomySeat(SEAT_TYPE.WINDOW) != null) {
					// Return window seat in economy class (as per policy)
					return journey.getFloorGrid().queryAvailableEconomySeat(SEAT_TYPE.WINDOW);
				}
				// Booking cannot be made
				return null;
			}
		}
	}

	@Override
	Seat bookEconomy(TrainJourney journey, SEAT_TYPE seatType) {
		if (journey.getFloorGrid().queryAvailableEconomySeat(seatType) != null) {
			// Return requested seat
			return journey.getFloorGrid().queryAvailableEconomySeat(seatType);
		} else {
			if (journey.getFloorGrid().queryAvailableFirstClassSeat(SEAT_TYPE.WINDOW) != null) {
				// Return window seat in first class (as per policy)
				return journey.getFloorGrid().queryAvailableFirstClassSeat(SEAT_TYPE.WINDOW);
			}
			// Booking cannot be made
			return null;
		}
	}
}
