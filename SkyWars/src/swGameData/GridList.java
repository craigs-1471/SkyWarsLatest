package swGameData;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import swGameLogic.PlayGame;
import swGameLogic.PossibleGridMovements;
import swInterfaces.Observable;
import swSpaceships.BattleCruiser;
import swSpaceships.BattleShooter;
import swSpaceships.BattleStar;
import swSpaceships.MasterShip;
import swSpaceships.Spaceship;
import swUserInterface.RenderButtons;

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
	
	public void checkForEngagement(Spaceship player) {
		int currentPlayerLocation = player.getCurrentLocation();
		ArrayList<Spaceship> list = getGridList().get(currentPlayerLocation).getTileList();
		boolean masterShipMode = PlayGame.isMasterShipOffensive();
		int numberOfShipsToDestroyPlayer;
		if(masterShipMode) {
			numberOfShipsToDestroyPlayer = 3;
		}
		else {
			numberOfShipsToDestroyPlayer = 2;
		}
		if(list.size() == numberOfShipsToDestroyPlayer) {
			destroyAllEnemyShips(list);
		}
		else if(list.size() > numberOfShipsToDestroyPlayer) {
			destroyPlayer(player, currentPlayerLocation, list);
		}
	}
	
	public void destroyPlayer(Spaceship player, int currentPlayerLocation, ArrayList<Spaceship> list) {
		list.remove(player);
		PlayGame.setGameOver(true);
		PlayGame.setUsersGo(false);
		RenderButtons.resetGrid();
		clearGridList();
		String output = "Game over";
		JOptionPane.showMessageDialog(null, output, "Game Status", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void destroyAllEnemyShips(ArrayList<Spaceship> list) {
		ArrayList<Spaceship> shipsToBeRemoved = new ArrayList<Spaceship>();
		for(Spaceship ship : list) {
			boolean isEnemy = ship.isEnemy();
			if(isEnemy) {
				ship.setDestroyed(true);
				PlayGame.destroyShip();
				PlayGame.removeShipFromPlay();
				shipsToBeRemoved.add(ship);
				enemies.remove(ship);
			}
		}
		list.removeAll(shipsToBeRemoved);
	}
	
	public void clearGridList() {
		for(int i = 0; i < GRID_LENGTH; i++) {
			getGridList().get(i).getTileList().clear();
		}
		getEnemies().clear();
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
		if(!enemies.isEmpty()) {
			for(int i = 0; i < enemies.size(); i++) {
				Spaceship ship = enemies.get(i);
				moveSpaceship(ship);
			}
		}
	}
	
	@Override
	public void moveSpaceship(Spaceship ship) {
		int currentLocation = ship.getCurrentLocation();
		int newLocation	= getNewLocation(currentLocation);
		this.getGridList().get(currentLocation).removeShipFromTile(ship);
		this.getGridList().get(newLocation).addShipToTile(ship);
		ship.updateLocation(newLocation);
	}
	
	public int getNewLocation(int currentLocation) {
		boolean hardMode = PlayGame.isHardMode();
		ArrayList<Integer> possibleMoves = PossibleGridMovements.getPossibleMoves(currentLocation);
		Spaceship player = PlayGame.getPlayer();
		int currentPlayerLocation = player.getCurrentLocation();
		boolean playerWithinRange = possibleMoves.contains(currentPlayerLocation);
		if(hardMode && playerWithinRange) {
			return currentPlayerLocation;
		}
		else {
			int numberOfPossibleMoves = possibleMoves.size();
			Random numGenerator = new Random();
			int randomLocation = numGenerator.nextInt(numberOfPossibleMoves);
			int newLocation = possibleMoves.get(randomLocation);
			return newLocation;
		}
	}

	@Override
	public void addNewSpaceship(Spaceship newShip) {
		gridList.get(ENEMY_START_LOCATION).getTileList().add(newShip);	
		enemies.add(newShip);
	}
	
	public void addExistingSpaceship(Spaceship ship) {
		int existingLocation = ship.getCurrentLocation();
		gridList.get(existingLocation).getTileList().add(ship);	
		if(ship.isEnemy()) {
			enemies.add(ship);
		}
	}
	
	public void createNewSpaceship() {
		int typesOfShip = 3;
		Random numGenerator = new Random();
		int randomNumber = numGenerator.nextInt(typesOfShip);
		PlayGame.addShipToPlay();
		if(randomNumber == 0) {
			Spaceship newShip = new BattleStar();
			addNewSpaceship(newShip);
		}
		else if(randomNumber == 1) {
			Spaceship newShip = new BattleCruiser();
			addNewSpaceship(newShip);
		}
		else {
			Spaceship newShip = new BattleShooter();
			addNewSpaceship(newShip);
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
	public ArrayList<Spaceship> getEnemies() {
		return enemies;
	}
	public void setEnemies(ArrayList<Spaceship> enemies) {
		this.enemies = enemies;
	}
	
}
