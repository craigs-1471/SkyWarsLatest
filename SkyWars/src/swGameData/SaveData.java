package swGameData;

import java.io.Serializable;
import java.util.ArrayList;

import swSpaceships.Spaceship;

public class SaveData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Spaceship player;
	private ArrayList<Spaceship> enemies;
	private int shipsDestroyed;
	private int goesTaken;
	private boolean masterShipOffensive;
	private boolean hardMode;
	private String usersName;
	
	public SaveData(Spaceship player, ArrayList<Spaceship> enemies, int shipsDestroyed, int goesTaken, boolean masterShipOffensive, boolean hardMode, String usersName) {
		setPlayer(player);
		setEnemies(enemies);
		setShipsDestroyed(shipsDestroyed);
		setGoesTaken(goesTaken);
		setMasterShipOffensive(masterShipOffensive);
		setHardMode(hardMode);
		setUsersName(usersName);
	}
	
	public Spaceship getPlayer() {
		return player;
	}
	public void setPlayer(Spaceship player) {
		this.player = player;
	}
	public ArrayList<Spaceship> getEnemies() {
		return enemies;
	}
	public void setEnemies(ArrayList<Spaceship> enemies) {
		this.enemies = enemies;
	}
	public int getShipsDestroyed() {
		return shipsDestroyed;
	}
	public void setShipsDestroyed(int shipsDestroyed) {
		this.shipsDestroyed = shipsDestroyed;
	}
	public int getGoesTaken() {
		return goesTaken;
	}
	public void setGoesTaken(int goesTaken) {
		this.goesTaken = goesTaken;
	}
	public boolean isMasterShipOffensive() {
		return masterShipOffensive;
	}
	public void setMasterShipOffensive(boolean masterShipOffensive) {
		this.masterShipOffensive = masterShipOffensive;
	}
	public boolean isHardMode() {
		return hardMode;
	}
	public void setHardMode(boolean hardMode) {
		this.hardMode = hardMode;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
}
