package bookingApplication;

/**
 * Information for a single Seat Position in the Floor Grid.
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public class SeatPosition {
	private int row;
	private char column;

	/**
	 * Constructs a Seat Position for a given row and column.
	 * 
	 * @param row    The row of the seat
	 * @param column The column of the seat
	 */
	public SeatPosition(int row, char column) {
		this.setRow(row);
		this.setColumn(column);
	}

	/**
	 * @return A formatted seat position (e.g. 1A)
	 */
	@Override
	public String toString() {
		return "" + getRow() + getColumn();
	}

	/**
	 * @return The row as it appears to the user
	 */
	public int getRow() {
		return row + 1;
	}

	/**
	 * Sets the row number based in input
	 * 
	 * @param The row number
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return The column as it appears to the user
	 */
	public char getColumn() {
		return column;
	}

	/**
	 * Sets the column letter.
	 * 
	 * @param column The column letter
	 */
	public void setColumn(char column) {
		this.column = (char) (column + 65);
	}
}
