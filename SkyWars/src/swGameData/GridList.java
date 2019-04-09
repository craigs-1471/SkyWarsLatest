package swGameData;

import java.util.ArrayList;
import java.util.Random;

import swGameLogic.PossibleGridMovements;
import swInterfaces.Observable;
import swSpaceships.BattleCruiser;
import swSpaceships.BattleShooter;
import swSpaceships.BattleStar;
import swSpaceships.MasterShip;
import swSpaceships.Spaceship;

public class GridList implements Observable {
	
	private static final int GRID_LENGTH = 16;
	private static final int ENEMY_START_LOCATION = 0;
	private ArrayList<TileList> gridList;
	private ArrayList<Spaceship> enemies;
	
	public GridList() {
		gridList = new ArrayList<TileList>(GRID_LENGTH);
		enemies = new ArrayList<Spaceship>();
		for(int i = 0; i < GRID_LENGTH; i++) {
			gridList.add(new TileList());
		}
	}
	
	@Override
	public void addPlayer(Spaceship player) {
		int newLocation = getRandomLocation();
		getGridList().get(newLocation).addShipToTile(player);
		player.updateLocation(newLocation);
	}
	
	public int getRandomLocation() {
		Random numGenerator = new Random();
		int randomLocation = numGenerator.nextInt(GRID_LENGTH);
		return randomLocation;
	}
	
	@Override
	public void movePlayer(Spaceship player, int btnIndex) {
		int currentLocation = player.getCurrentLocation();
		getGridList().get(currentLocation).removeShipFromTile(player);		
		getGridList().get(btnIndex).addShipToTile(player);
		player.updateLocation(btnIndex);
	}
	
	@Override
	public void moveAllSpaceships() {
		System.out.println("Move all ships start");
		if(!enemies.isEmpty()) {
			for(Spaceship ship : enemies) {
				moveSpaceship(ship);
			}
		}
	}
	
	@Override
	public void moveSpaceship(Spaceship ship) {
		System.out.println("Move single ship start");
		int currentLocation = ship.getCurrentLocation();
		int newLocation = getNewLocation(currentLocation);
		getGridList().get(currentLocation).removeShipFromTile(ship);
		getGridList().get(newLocation).addShipToTile(ship);
		ship.updateLocation(newLocation);
	}
	
	public int getNewLocation(int currentLocation) {
		ArrayList<Integer> possibleMoves = PossibleGridMovements.getPossibleMoves(currentLocation);
		int numberOfPossibleMoves = possibleMoves.size();
		Random numGenerator = new Random();
		int randomLocation = numGenerator.nextInt(numberOfPossibleMoves);
		int newLocation = possibleMoves.get(randomLocation);
		return newLocation;
	}

	@Override
	public void addSpaceship(Spaceship newShip) {
		System.out.println("Add ship start");
		gridList.get(ENEMY_START_LOCATION).getTileList().add(newShip);	
		enemies.add(newShip);
	}
	
	public void createNewSpaceship() {
		System.out.println("Create ship start");
		int typesOfShip = 3;
		Random numGenerator = new Random();
		int randomNumber = numGenerator.nextInt(typesOfShip);
		if(randomNumber == 0) {
			Spaceship newShip = new BattleStar();
			addSpaceship(newShip);
		}
		else if(randomNumber == 1) {
			Spaceship newShip = new BattleCruiser();
			addSpaceship(newShip);
		}
		else {
			Spaceship newShip = new BattleShooter();
			addSpaceship(newShip);
		}
	}
	
	public void displayNumberOfShipsOnEachTile() {
		String output = "Number of ships on each tile:\n";
		for(int i = 0; i < GRID_LENGTH; i++) {
			output += getGridList().get(i).numberOfShipsHere() + "  ";
		}
		System.out.println(output);
	}
	
	//////////////GETTERS AND SETTERS///////////////////////
	public ArrayList<TileList> getGridList() {
		return gridList;
	}
	public void setGridList(ArrayList<TileList> gridList) {
		this.gridList = gridList;
	}
	public static int getGridLength() {
		return GRID_LENGTH;
	}
}
