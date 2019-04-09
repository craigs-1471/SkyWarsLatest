package swGameLogic;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JRadioButton;

import swGameData.DataHandling;
import swGameData.GridList;
import swGameData.SaveData;
import swSpaceships.MasterShip;
import swSpaceships.Spaceship;
import swUserInterface.MainGui;
import swUserInterface.RenderButtons;

public class PlayGame {
	
	private static final int GRID_LENGTH = 16;
	private static GridList gridList = new GridList();
	private static Spaceship player;
	private static boolean gameOver;
	private static boolean usersGo;
	private static int shipsDestroyed;
	private static int goesTaken;
	private static boolean masterShipOffensive;
	private static boolean hardMode;
	private static String usersName;
	
	public static void playGame() {
		initialiseVariables();
		gridList.addPlayer(player);
		RenderButtons.mapButtonGrid();
	}
	
	public static void computersGo() {
		if(!gameOver) {
			gridList.moveAllSpaceships();
			spawnEnemy();
			gridList.checkForEngagement(player);
			RenderButtons.mapButtonGrid();
			setUsersGo(true);
		}
	}
	
	public static void spawnEnemy() {
		int oddsOfEnemySpawn = 3;
		Random numGenerator = new Random();
		int randomNumber = numGenerator.nextInt(oddsOfEnemySpawn);
		if(randomNumber == 0) {
			gridList.createNewSpaceship();
		}
	}
	
	public static void initialiseVariables() {
		//gridList = new GridList();
		player = new MasterShip();
		gameOver = false;
		usersGo = true;
		masterShipOffensive = false;
		hardMode = false;
		JRadioButton rdbtnDefensive = MainGui.getRdbtnDefensive();
		rdbtnDefensive.setSelected(!isMasterShipOffensive());
		JRadioButton rdbtnOffensive = MainGui.getRdbtnOffensive();
		rdbtnOffensive.setSelected(isMasterShipOffensive());
		JRadioButton rdbtnEasyMode = MainGui.getRdbtnEasyMode();
		rdbtnEasyMode.setSelected(!isHardMode());
		JRadioButton rdbtnHardMode = MainGui.getRdbtnHardMode();
		rdbtnHardMode.setSelected(isHardMode());
		shipsDestroyed = 0;
		goesTaken = 0;
	}
	
	public static void loadGameData(SaveData save) {
		System.out.println("pre load gridlist");
		gridList = DataHandling.loadGridList(save);
		System.out.println("pre loadplayer");
		player = save.getPlayer();
		gameOver = false;
		usersGo = true;
		masterShipOffensive = save.isMasterShipOffensive();
		hardMode = save.isHardMode();
		shipsDestroyed = save.getShipsDestroyed();
		goesTaken = save.getGoesTaken();
		RenderButtons.mapButtonGrid();
	}
	
	///////////GETTERS AND SETTERS/////////////////////////////////
	
	public static void destroyShip() {
		PlayGame.shipsDestroyed++;
		System.out.println("Ships destroyed " + shipsDestroyed);
	}
	
	public static GridList getGridList() {
		return gridList;
	}

	public static void setGridList(GridList gridList) {
		PlayGame.gridList = gridList;
	}

	public static Spaceship getPlayer() {
		return player;
	}

	public static void setPlayer(Spaceship player) {
		PlayGame.player = player;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver(boolean gameOver) {
		PlayGame.gameOver = gameOver;
	}

	public static boolean isUsersGo() {
		return usersGo;
	}

	public static void setUsersGo(boolean usersGo) {
		PlayGame.usersGo = usersGo;
	}

	public static int getShipsDestroyed() {
		return shipsDestroyed;
	}

	public static void setShipsDestroyed(int shipsDestroyed) {
		PlayGame.shipsDestroyed = shipsDestroyed;
	}

	public static int getGoesTaken() {
		return goesTaken;
	}

	public static void setGoesTaken(int goesTaken) {
		PlayGame.goesTaken = goesTaken;
	}

	public static boolean isMasterShipOffensive() {
		return masterShipOffensive;
	}

	public static void setMasterShipOffensive(boolean masterShipOffensive) {
		PlayGame.masterShipOffensive = masterShipOffensive;
	}

	public static boolean isHardMode() {
		return hardMode;
	}

	public static void setHardMode(boolean hardMode) {
		PlayGame.hardMode = hardMode;
	}

	public static String getUsersName() {
		return usersName;
	}

	public static void setUsersName(String usersName) {
		PlayGame.usersName = usersName;
	}

	public static int getGridLength() {
		return GRID_LENGTH;
	}
}
