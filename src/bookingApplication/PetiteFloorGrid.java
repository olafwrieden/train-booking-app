package bookingApplication;

import bookingApplication.Seat.SEAT_TYPE;

/**
 * Information relating to a Petite Floor Grid
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public class PetiteFloorGrid extends FloorGrid {

	/**
	 * Initialize a Petite Floor Grid
	 */
	public PetiteFloorGrid() {
		numRows = 10;
		numColumns = 7;
		numFirstClassRows = 4;
		seats = new Seat[numRows][numColumns];

		initialiseFloorGrid();
	}

	// Implementation of Abstract Method
	@Override
	void initialiseFloorGrid() {
		boolean isFirstClass;

		for (int row = 0; row < numRows; row++) {
			// Identify First Class Rows
			if (row < numFirstClassRows) {
				isFirstClass = true;
			} else {
				isFirstClass = false;
			}
			// Arrange Seats for Petite Floor Grid
			for (int column = 0; column < numColumns; column++) {
				if (column == 0 || column == numColumns - 1) {
					seats[row][column] = new Seat(SEAT_TYPE.WINDOW, isFirstClass, new SeatPosition(row, (char) column));
				} else {
					if (column == 1 || column == 2 || column == 4 || column == 5) {
						seats[row][column] = new Seat(SEAT_TYPE.AISLE, isFirstClass,
								new SeatPosition(row, (char) column));
					} else {
						seats[row][column] = new Seat(SEAT_TYPE.MIDDLE, isFirstClass,
								new SeatPosition(row, (char) column));
					}
				}
			}
		}
	}
}
