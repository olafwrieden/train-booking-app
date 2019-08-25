package bookingApplication;

import bookingApplication.Seat.SEAT_TYPE;

/**
 * The Floor Grid, a seating arrangement in a passenger carriage.
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public abstract class FloorGrid {

	// Floor Grid Properties
	protected int numRows;
	protected int numColumns;
	protected int numFirstClassRows;
	protected Seat[][] seats;

	/**
	 * Populate a Train's Floor Grid.
	 */
	abstract void initialiseFloorGrid();

	/**
	 * @return The row number of the last row of passenger seats
	 */
	public int getLastRow() {
		return numRows;
	}

	/**
	 * @return The column letter of the last column of passenger seats
	 */
	public char getLastColumn() {
		return numColumns > 0 && numColumns < 27 ? (char) (numColumns + 64) : null;
	}

	/**
	 * @return The total number of rows in the first class compartment
	 */
	public int getNumFirstClassRows() {
		return numFirstClassRows;
	}

	/**
	 * Returns the array index of the seat (e.g. 1A = seats[0][0]).
	 * 
	 * @param row    The row number
	 * @param column The column number
	 * @return The array index which the input parameters represent
	 */
	public Seat getSeat(int row, char column) {
		return seats[row - 1][(column - 65)];
	}

	/**
	 * Returns the seat to the left of the input seat.
	 * 
	 * @param inputSeat The seat whose left neighbour should be returned
	 * @return The seat to the left of the input seat
	 */
	public Seat getLeft(Seat inputSeat) {
		return inputSeat.getSeatPosition().getColumn() == 'A' ? null
				: getSeat(inputSeat.getSeatPosition().getRow(),
						(char) ((int) inputSeat.getSeatPosition().getColumn() - 1));
	}

	/**
	 * Returns the seat to the right of the input seat.
	 * 
	 * @param inputSeat The seat whose right neighbour should be returned
	 * @return The seat to the right of the input seat
	 */
	public Seat getRight(Seat inputSeat) {
		return inputSeat.getSeatPosition().getColumn() == getLastColumn() ? null
				: getSeat(inputSeat.getSeatPosition().getRow(),
						(char) ((int) inputSeat.getSeatPosition().getColumn() + 1));
	}

	/**
	 * Gets an available first class seat that matches the requested seat type.
	 * 
	 * @param type The requested seat type
	 * @return The first available seat that matches the requested seat type
	 */
	public Seat queryAvailableFirstClassSeat(SEAT_TYPE type) {
		// Iterate through all first class seats
		for (int row = 0; row < numFirstClassRows; row++) {
			for (int column = 0; column < numColumns; column++) {
				if (seats[row][column].getType() == type && !seats[row][column].isBooked()) {
					return seats[row][column];
				}
			}
		}
		return null;
	}

	/**
	 * Gets an available economy class seat that matches the requested seat type.
	 * 
	 * @param type The requested seat type
	 * @return The first available seat that matches the requested seat type
	 */
	public Seat queryAvailableEconomySeat(SEAT_TYPE type) {
		// Iterate through all economy seats
		for (int row = numFirstClassRows; row < numRows; row++) {
			for (int column = 0; column < numColumns; column++) {
				if (seats[row][column].getType() == type && !seats[row][column].isBooked()) {
					return seats[row][column];
				}
			}
		}
		return null;
	}

	/**
	 * @return Constructed (visual) representation of a given floor grid
	 */
	@Override
	public String toString() {
		// Output string to append to
		String result = "";

		// Append column letters with correct padding
		for (int column = 1; column <= numColumns; column++) {
			result += "     " + (char) (column + 64);
		}
		result += "\n";

		// For each row of seats
		for (int row = 0; row < numRows; row++) {

			// Append row numbers with correct padding
			if (row < 9) {
				result += "  " + (row + 1) + " ";
			} else {
				result += " " + (row + 1) + " ";
			}

			// Append a representation of the seats
			for (int column = 0; column < numColumns; column++) {
				if (row < numFirstClassRows) {
					result += (seats[row][column]);
				} else {
					result += (seats[row][column]);
				}
			}
			result += ("\n");
		}

		return result;
	}
}
