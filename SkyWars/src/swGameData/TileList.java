package swGameData;

import java.util.ArrayList;

import swInterfaces.MoveShips;
import swSpaceships.Spaceship;

public class TileList implements MoveShips {
	
	private static int numberOfTileLists = 0;
	private int id;
	private ArrayList<Spaceship> tileList;
	
	public TileList() {
		id = numberOfTileLists++;
		tileList = new ArrayList<Spaceship>();
	}

	@Override
	public void addShipToTile(Spaceship ship) {
		getTileList().add(ship);
	}

	@Override
	public void removeShipFromTile(Spaceship ship) {
		getTileList().remove(ship);
	}
	
	public int numberOfShipsHere() {
		int numberOfShipsAtThisTile = getTileList().size();
		return numberOfShipsAtThisTile;
	}
	
	//////////////GETTERS AND SETTERS///////////////////////
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Spaceship> getTileList() {
		return tileList;
	}

	public void setTileList(ArrayList<Spaceship> tileList) {
		this.tileList = tileList;
	}
}
