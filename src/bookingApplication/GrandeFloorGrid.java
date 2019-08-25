package bookingApplication;

import bookingApplication.Seat.SEAT_TYPE;

/**
 * Information relating to a Grande Floor Grid
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public class GrandeFloorGrid extends FloorGrid {

	/**
	 * Initialize a Grande Floor Grid.
	 */
	public GrandeFloorGrid() {
		this.numRows = 12;
		this.numColumns = 9;
		this.numFirstClassRows = 6;
		this.seats = new Seat[numRows][numColumns];

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
			// Arrange Seats for Grande Floor Grid
			for (int column = 0; column < numColumns; column++) {
				if (column == 0 || column == numColumns - 1) {
					seats[row][column] = new Seat(SEAT_TYPE.WINDOW, isFirstClass, new SeatPosition(row, (char) column));
				} else {
					if (column == 2 || column == 3 || column == 5 || column == 6) {
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
