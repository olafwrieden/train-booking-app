package bookingApplication;

import bookingApplication.Seat.SEAT_TYPE;
import bookingApplication.TrainSeatBookingApp;

/**
 * The ChooChoo Train Operator, with its own booking policies.
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public class ChooChoo extends TrainOperator {

	/**
	 * Constructs a Train Operator
	 */
	public ChooChoo() {
		this.setTrainOperator("ChooChoo");
	}

	// Implementation of Abstract Methods
	@Override
	Seat bookFirstClass(TrainJourney journey, SEAT_TYPE seatType) {
		if (journey.getFloorGrid().queryAvailableFirstClassSeat(seatType) != null) {
			// Return requested seat
			return journey.getFloorGrid().queryAvailableFirstClassSeat(seatType);
		} else {
			// Check if entire economy class row is free (as per policy)
			boolean isRowFree = false;
			Seat firstFreeSeatInFreeRow = null;

			for (int row = journey.getFloorGrid().getNumFirstClassRows(); row < journey.getFloorGrid()
					.getLastRow(); row++) {
				for (int column = 1; column <= journey.getFloorGrid().numColumns; column++) {
					if (!journey.getFloorGrid().getSeat(row + 1, (char) (column + 64)).isBooked()) {
						firstFreeSeatInFreeRow = journey.getFloorGrid().getSeat(row + 1, (char) (column + 64));
						isRowFree = true;
					} else {
						firstFreeSeatInFreeRow = null;
						isRowFree = false;
					}
				}
				if (firstFreeSeatInFreeRow != null && isRowFree) {
					break;
				}
			}

			// Book entire row in economy class (as per policy)
			if (firstFreeSeatInFreeRow != null && isRowFree) {
				for (int i = 1; i < journey.getFloorGrid().numColumns; i++) {
					TrainSeatBookingApp.bookSeat(journey.getFloorGrid()
							.getSeat(firstFreeSeatInFreeRow.getSeatPosition().getRow(), (char) (i + 64)), journey);
				}
				return firstFreeSeatInFreeRow;
			}
			// Booking cannot be made
			return null;

		}
	}

	@Override
	Seat bookEconomy(TrainJourney journey, SEAT_TYPE seatType) {
		System.out.println(journey.getOperator());
		if (journey.getFloorGrid().queryAvailableEconomySeat(seatType) != null) {
			// Return requested seat
			return journey.getFloorGrid().queryAvailableEconomySeat(seatType);
		}
		// Booking cannot be made (as per policy)
		return null;

	}
}
