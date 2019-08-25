package bookingApplication;

import java.util.Scanner;
import bookingApplication.Seat.SEAT_TYPE;

/**
 * The Train Seat Booking Application.
 * 
 * @author Olaf Wrieden
 * @version 1.0
 */
public class TrainSeatBookingApp {

	static Scanner input = new Scanner(System.in);

	/**
	 * Constructs a new Seat Booking Instance.
	 * 
	 * @param trainJourneys An array of available train journeys
	 */
	private TrainSeatBookingApp(TrainJourney[] trainJourneys) {
		// Welcome Message
		welcomeBanner();
		// Prompt & Instantiate Desired Operator
		operatorSelection(trainJourneys);
		// Prompt Desired Journey, Display Floor Grid
		TrainJourney journey = journeySelection(trainJourneys);
		// Display Booking Menu Until User Exits
		menu(journey);
	}

	/**
	 * The entry point for the application.
	 * 
	 * @param args Optional start-up arguments
	 */
	public static void main(String[] args) {
		// Instantiate Available Train Journeys
		TrainJourney[] trainJourneys = {
				new TrainJourney("Britomart", "Papakura", "07:55h", 1000, new GrandeFloorGrid()),
				new TrainJourney("Papakura", "Britomart", "08:05h", 1100, new PetiteFloorGrid()),
				new TrainJourney("Britomart", "Swanson", "08:15h", 2000, new PetiteFloorGrid()),
				new TrainJourney("Swanson", "Britomart", "08:25h", 2100, new PetiteFloorGrid()),
				new TrainJourney("Britomart", "Manukau", "08:35h", 3000, new PetiteFloorGrid()),
				new TrainJourney("Manukau", "Britomart", "08:45h", 3100, new PetiteFloorGrid()),
				new TrainJourney("Britomart", "Onehunga", "08:55h", 4000, new PetiteFloorGrid()),
				new TrainJourney("Onehunga", "Britomart", "09:05h", 4100, new PetiteFloorGrid()), };

		// Feed Journeys to Booking System
		new TrainSeatBookingApp(trainJourneys);
	}

	/**
	 * Displays the Welcome Banner in the Console.
	 */
	public static void welcomeBanner() {
		System.out.println("-----------------------------------------------");
		System.out.println(" WELCOME TO THE TRAIN SEAT BOOKING APPLICATION ");
		System.out.println("-----------------------------------------------\n");
	}

	/**
	 * Prompts for Train Operator Selection.
	 * 
	 * @param trainJourneys All Train Journeys for which to set the operator
	 */
	public static void operatorSelection(TrainJourney[] trainJourneys) {
		// Display Operator Selection
		System.out.println("Which train operator would you like to travel with?");
		System.out.println("1: TrainWay");
		System.out.println("2: ChooChoo");

		// Set Operator
		switch (input.nextInt()) {
		case (1):
			// Assign all journeys to TrainWay
			for (int i = 0; i < trainJourneys.length; i++) {
				trainJourneys[i].setOperator(new TrainWay());
			}
			System.out.println(trainJourneys[0].getOperator());
			break;
		case (2):
			// Assign all journeys to ChooChoo
			for (int i = 0; i < trainJourneys.length; i++) {
				trainJourneys[i].setOperator(new ChooChoo());
			}
			System.out.println(trainJourneys[0].getOperator());
			break;
		default:
			System.out.println("No such Train Operator! Exiting.");
			System.exit(0);
		}
	}

	/**
	 * Displays a selection of Train Journeys in the console and prompts for the
	 * user's valid selection.
	 * 
	 * @param trainJourneys An array of Train Journeys to select from
	 * @return The user's valid journey selection
	 */
	public static TrainJourney journeySelection(TrainJourney[] trainJourneys) {
		int userJourneySelection = -1;

		do {
			// Display Journey Selection
			System.out.println("On which train journey would you like to book a seat?");
			for (int i = 0; i < trainJourneys.length; i++) {
				System.out.println((i + 1) + ": " + trainJourneys[i].toString());
			}
			// Get User's Selection
			userJourneySelection = input.nextInt();
		} while (userJourneySelection <= 0 || userJourneySelection > trainJourneys.length);

		// Display the Chosen Journey's Floor Grid
		System.out.println("Booking seats for Journey: " + trainJourneys[userJourneySelection - 1]);
		System.out.println(trainJourneys[userJourneySelection - 1].getFloorGrid());

		return trainJourneys[userJourneySelection - 1];
	}

	/**
	 * Prompts for a Seat Type Selection.
	 * 
	 * @return A Seat Type to Book
	 */
	public static SEAT_TYPE seatTypeSelection() {
		int userSeatTypeSelection = -1;

		do {
			// Display Seat Selection
			System.out.println("Which seat type?");
			for (int i = 0; i < SEAT_TYPE.values().length; i++) {
				System.out.println((i + 1) + ": " + SEAT_TYPE.values()[i]);
			}
			// Get User's Selection
			userSeatTypeSelection = input.nextInt();
		} while (userSeatTypeSelection <= 0 || userSeatTypeSelection > SEAT_TYPE.values().length);

		// Return Selected Seat Type
		return SEAT_TYPE.values()[userSeatTypeSelection - 1];
	}

	/**
	 * Book the input seat or (if input seat is null) inform user that the seat is
	 * not available.
	 * 
	 * @param availableSeat The seat to be booked
	 * @param journey       The journey on which to book the seat
	 */
	public static void bookSeat(Seat availableSeat, TrainJourney journey) {
		if (availableSeat != null) {
			availableSeat.setBooked(true);
			// Display FloorGrid and Booking Confirmation
			System.out.println(journey.getFloorGrid() + "\n" + availableSeat.seatDescription());
		} else { // No booking possible (inform)
			System.out.println(journey.getFloorGrid() + "\nSorry, we could not book the requested seat.\n");
		}
	}

	/**
	 * Displays the Seat Booking System.
	 * 
	 * @param journey The Train Journey to which this booking menu applies
	 */
	public static void menu(TrainJourney journey) {
		int userMenuSelection = 0;
		Seat availableSeat;

		do {
			// Display Menu Selection
			System.out.println("===== Booking Menu =====");
			System.out.println("1: Book in First Class");
			System.out.println("2: Book in Economy Class");
			System.out.println("3: Show Floor Grid");
			System.out.println("4: Quit");
			System.out.println("========================");

			// Act On User Input
			switch (input.nextInt()) {
			case (1): // Book in First Class
				availableSeat = journey.getOperator().bookFirstClass(journey, seatTypeSelection());
				bookSeat(availableSeat, journey);
				break;
			case (2): // Book in Economy Class
				availableSeat = journey.getOperator().bookEconomy(journey, seatTypeSelection());
				bookSeat(availableSeat, journey);
				break;
			case (3): // Show Floor Grid
				System.out.println(journey.getFloorGrid());
				break;
			case (4): // Exit Application
				System.out.println("\nThank you for your business.\nHave a relaxing commute.");
				System.exit(0);
			default: // Inform of Invalid Menu Selection
				System.out.println("Invalid Menu Selection! Try Again.");
			}
		} while (userMenuSelection <= 0 || userMenuSelection > 4);
	}
}