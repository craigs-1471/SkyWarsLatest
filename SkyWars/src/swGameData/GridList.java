package swGameData;

import java.util.ArrayList;
import java.util.Random;

import swInterfaces.Observable;
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
		int newLocation = getNewLocation();
		getGridList().get(newLocation).addShipToTile(player);
		player.updateLocation(newLocation);
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
		for(Spaceship ship : enemies) {
			moveSpaceship(ship);
		}
	}
	
	@Override
	public void moveSpaceship(Spaceship ship) {
		int newLocation = getNewLocation();
		int currentLocation = ship.getCurrentLocation();
		getGridList().get(currentLocation).removeShipFromTile(ship);
		getGridList().get(newLocation).addShipToTile(ship);
		ship.updateLocation(newLocation);
	}
	
	public int getNewLocation() {
		Random numGenerator = new Random();
		int newLocation = numGenerator.nextInt(GRID_LENGTH);
		return newLocation;
	}

	@Override
	public void addSpaceship() {
		Spaceship newShip = createNewSpaceship();
		gridList.get(ENEMY_START_LOCATION).getTileList().add(newShip);	
		enemies.add(newShip);
	}
	
	public Spaceship createNewSpaceship() {
		return new Spaceship();
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
