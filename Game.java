public class Game {
    int numOfGuesses = 0;

    public static void main(String[] args) {
    prepareTheFleet();
    }

    //This keeps our main clean by allowing us to intilize our ships(fleet) by just using a prepareTheFleet Function

    public static void prepareTheFleet()
    {
    Board drakeCircus = new Board(); // Create a new board object 
    Player Player = new Player(); // Setup a new player for the game 
    drakeCircus.DisplayBoardSpaces(); // Display our board spaces

    System.out.println();
	System.out.println("Parked Ships");
	System.out.println();

    Ship Destroyer = new Destroyer();
    Destroyer.size = 5;
    Destroyer.name = "Destroyer";
    Destroyer.isAlive = true;
    Ship Battleship = new Battleship();
    Battleship.size = 5;
    Battleship.name = "Battleship";
    Ship Cruiser = new Cruiser();
    Cruiser.size = 3;
    Cruiser.name = "Cruiser";
    Ship AircraftCarrier = new AircraftCarrier();
    AircraftCarrier.size = 5;
    AircraftCarrier.name = "Aircraft Carrier";
    Ship Hovercraft = new Hovercraft();
    Hovercraft.size = 2;
    Hovercraft.name = "Hovercraft";

	drakeCircus.PlaceShip(Destroyer.getSize());
        System.out.println("Parked Ships 1");
        drakeCircus.DisplayBoardSpaces();
        System.out.println();
        System.out.println(Destroyer.getSize());
        System.out.println(Destroyer.getName());

	drakeCircus.PlaceShip(Battleship.getSize());
        System.out.println("Parked Ships 2");
        drakeCircus.DisplayBoardSpaces();
        System.out.println();

	drakeCircus.PlaceShip(Cruiser.getSize());
        System.out.println("Parked Ships 3");
        drakeCircus.DisplayBoardSpaces();
        System.out.println();

    drakeCircus.PlaceShip(AircraftCarrier.getSize());
        System.out.println("Parked Ship 4");
        drakeCircus.DisplayBoardSpaces();
        System.out.println();

        drakeCircus.PlaceShip(Hovercraft.getSize());
        System.out.println("Parked Ship 5");
        drakeCircus.DisplayBoardSpaces();
        System.out.println();
    }
}